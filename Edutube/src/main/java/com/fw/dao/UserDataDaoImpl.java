package com.fw.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;

import com.fw.domain.entity.Contact;
import com.fw.domain.entity.Education;
import com.fw.domain.entity.EducationWorkProfile;
import com.fw.domain.entity.Student;
import com.fw.domain.entity.Token;
import com.fw.domain.entity.Tutor;
import com.fw.domain.entity.TutorStudentSubject;
import com.fw.domain.entity.User;
import com.fw.domain.entity.WorkExperience;
import com.fw.domain.service.UserServicesImpl;

public class UserDataDaoImpl implements UserDataDao {

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction txn = null;
	static final Logger logger = Logger.getLogger(UserServicesImpl.class);

	@Override
	public boolean addUserEntity(User user) throws Exception {

		session = sessionFactory.openSession();
		txn = session.beginTransaction();
		session.save(user);
		txn.commit();
		session.close();

		return false;
	}
	/**
	 * @author Sushanta Barik
	 * @param user
	 * @return user
	 * @exception HibernateException,Exception 
	 */
	@Override
	public User getUserDetails(User user) {
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(user.getClass());
			criteria.add(Restrictions.eq("username", user.getUsername()));
			criteria.add(Restrictions.eq("password", user.getPassword()));
			criteria.add(Restrictions.eq("userAccountFlag", 1));
			List<User> list = criteria.list();
			user = (User)list.get(0);
			return user;
		} catch (HibernateException e) {
			logger.error("Exception occurs in ", e);
		}catch(Exception ex){
			logger.error("Exception occurs in ", ex);
		}finally{
			try {
				session.close();
			} catch (HibernateException e) {
				logger.error("Exception occurs in ", e);
			}
		}
		return user;
	}
	/**
	 * @author Sushanta Barik
	 * @param string value username
	 * @return user
	 * @exception HibernateException,Exception 
	 */
	@Override
	public User getUserDetailsByUsername(String username) {
		System.out.println("username"+username);
		User user = new User();
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(user.getClass());
			criteria.add(Restrictions.eq("username", username));
			List<User> list = criteria.list();
		    user = (User)list.get(0);
			return user;
		} catch (HibernateException e) {
			logger.error("Exception occurs in ", e);
		}catch(Exception ex){
			logger.error("Exception occurs in ", ex);
		}finally{
			try {
				session.close();
			} catch (HibernateException e) {
				logger.error("Exception occurs in ", e);
			}
		}
		return user;
	}
	/**
	 * @author Sushanta Barik
	 * @param user
	 * @return true/false
	 * @exception HibernateException,Exception
	 */
	@Override
	public boolean updateLoginDetails(User user) {
		boolean b = false;
		try {
			session = sessionFactory.openSession();
			txn = session.beginTransaction();
			User existingUser = (User)session.get(user.getClass(), user.getUserId());
			existingUser.setLastLoginTime(user.getLastLoginTime());
			session.update(existingUser);
			txn.commit();
			b = true;
		} catch (HibernateException e) {
			txn.rollback();
			logger.error("Exception occurs in ", e);
		} catch (Exception ex) {
			txn.rollback();
			logger.error("Exception occurs in ", ex);
		}finally{
			try {
				session.close();
			} catch (HibernateException exn) {
				logger.error("Exception occurs in ", exn);
			}
		}
		return b;
	}
	/**
	 * @author Sushanta Barik
	 * @param user
	 * @return user
	 * @exception HibernateException,Exception
	 */
	@Override
	public boolean updateUserType(User user) {
		boolean b = false;
		try {
			session = sessionFactory.openSession();
			txn = session.beginTransaction();
			User existingUser = (User)session.get(user.getClass(), user.getUserId());
			existingUser.setUserType(user.getUserType());
			if(user.getUserType().equalsIgnoreCase("TUTOR")){
				Tutor tutor = new Tutor();
				tutor.setTutorFirstName(existingUser.getUserFirstName());
				tutor.setTutorLastName(existingUser.getUserLastName());
				tutor.setUser(existingUser);
				session.save(tutor);
			}else{
				Student student = new Student();
				student.setStudent_first_name(existingUser.getUserFirstName());
				student.setStudent_last_name(existingUser.getUserLastName());
				student.setUser(existingUser);
				session.save(student);
			}
			txn.commit();
			b = true;
		} catch (HibernateException e) {
			txn.rollback();
			logger.error("Exception occurs in ", e);
		} catch (Exception ex) {
			txn.rollback();
			logger.error("Exception occurs in ", ex);
		}finally{
			try {
				session.close();
			} catch (HibernateException exn) {
				logger.error("Exception occurs in ", exn);
			}
		}
		return b;
	}
	/**
	 * @author Sushanta Barik
	 * @param user
	 * @return user
	 * @exception HibernateException,Exception
	 */
	@Override
	public boolean updateUserLogoutDetails(User user) {
		boolean b = false;
		try {
			session = sessionFactory.openSession();
			txn = session.beginTransaction();
			User existingUser = (User)session.get(user.getClass(), user.getUserId());
			existingUser.setLastLoginTime(user.getLastLogoutTime());
			session.update(existingUser);
			txn.commit();
			b = true;
		} catch (HibernateException e) {
			txn.rollback();
			logger.error("Exception occurs in ", e);
		} catch (Exception ex) {
			txn.rollback();
			logger.error("Exception occurs in ", ex);
		}finally{
			try {
				session.close();
			} catch (HibernateException exn) {
				logger.error("Exception occurs in ", exn);
			}
		}
		return b;
	}

	@Override
	public User getUserDetailsByUserid(User user) {
		session = sessionFactory.openSession();
		user = (User)session.get(user.getClass(), user.getUserId());
		session.close();
		return user;
	}
	/**
	 * @author Sushanta Barik
	 * @param userId as integer value
	 * @return Contact object
	 * @exception HibernateException,Exception
	 */
	@Override
	public Contact getUserContact(int userId) {
		Contact contact = new Contact();
		try {
			session = sessionFactory.openSession();
			SQLQuery query = session.createSQLQuery("SELECT * FROM contact WHERE user_id = "+userId);
			query.addEntity(contact.getClass());
			contact = (Contact)query.uniqueResult();
			return contact;
		} catch (HibernateException e) {
			logger.error("Exception occurs in : ", e);
		} catch (Exception ex) {
			logger.error("Exception occurs in : ", ex);
		}finally{
			session.close();
		}
		return contact;
	}
	/**
	 * @author Sushanta Barik
	 * @param Contact object
	 * @return true/false boolean value
	 * @exception HibernateException,Exception
	 */
	@Override
	public boolean updateUserContact(Contact contact) throws Exception {
		boolean b = false;
		try {
			session = sessionFactory.openSession();
			txn = session.beginTransaction();
			Contact contactExisting = (Contact)session.get(contact.getClass(), contact.getContactId());
			if(contactExisting == null) {
				contactExisting = new Contact();
				User user = (User)session.get(contact.getUser().getClass(), contact.getUser().getUserId());
				user.setEmail(contact.getEmail());
				contactExisting.setUser(user);
			}else{
				contactExisting.setContactId(contact.getContactId());
				contactExisting.getUser().setUserId(contact.getUser().getUserId());
				contactExisting.getUser().setEmail(contact.getUser().getEmail());
			}
			contactExisting.setAddressLine1(contact.getAddressLine1());
			contactExisting.setAddressLine2(contact.getAddressLine2());
			contactExisting.setAddressLine3(contact.getAddressLine3());
			contactExisting.setCity(contact.getCity());
			contactExisting.setContactAddress(contact.getContactAddress());
			contactExisting.setContactType(contact.getContactType());
			contactExisting.setCountry(contact.getCountry());
			contactExisting.setEmail(contact.getEmail());
			contactExisting.setMobileNumber(contact.getMobileNumber());
			contactExisting.setPinCode(contact.getPinCode());
			contactExisting.setState(contact.getState());
			contactExisting.setTelephoneNumber(contact.getTelephoneNumber());
			session.saveOrUpdate(contactExisting);
			txn.commit();
			b = true;
		} catch (Exception e) {
			txn.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return b;
	}
	/**
	 * @author Sushanta Barik
	 * @param integer value userId
	 * @return List<EducationWorkProfile> object
	 * @exception HibernateException,Exception
	 */
	@Override
	public List<EducationWorkProfile> getUserEducationWorkProfile(int userId) {
		List<EducationWorkProfile> userEducationWorkProfileList = new ArrayList<EducationWorkProfile>();
		try {
			session = sessionFactory.openSession();
			SQLQuery query = session.createSQLQuery("SELECT * FROM edu_wrk_profile WHERE user_id = "+userId);
			query.addEntity(EducationWorkProfile.class);
			userEducationWorkProfileList = query.list();
			return userEducationWorkProfileList;
		} catch (HibernateException e) {
			logger.error("Exception occurs in : ", e);
		} catch (Exception ex) {
			logger.error("Exception occurs in : ", ex);
		}finally{
			session.close();
		}
		return userEducationWorkProfileList;
	}
	/**
	 * @author Sushanta Barik
	 * @param List<EducationWorkProfile> object
	 * @return true/false boolean value
	 * @exception HibernateException,Exception
	 */
	@Override
	public boolean updateUserEducation(List<EducationWorkProfile> educationList) {
		boolean b = false;
		try {
			session = sessionFactory.openSession();
			txn = session.beginTransaction();
			for(EducationWorkProfile educationProfile : educationList){
				EducationWorkProfile existingEduProfile = (EducationWorkProfile)session.get(educationProfile.getClass(), educationProfile.getEduWrkProfileId());
				if(existingEduProfile == null){
					existingEduProfile = new EducationWorkProfile();
					User user = (User)session.get(educationProfile.getUser().getClass(), educationProfile.getUser().getUserId());
					existingEduProfile.setUser(user);
				}else{
					//existingEduProfile.setUser(educationProfile.getUser());
				}
				existingEduProfile.setEduCreateDate(educationProfile.getEduCreateDate());
				existingEduProfile.setEduStartDate(educationProfile.getEduStartDate());
				existingEduProfile.setEduEndDate(educationProfile.getEduEndDate());
				existingEduProfile.setEducationCourse(educationProfile.getEducationCourse());
				Education education = new Education();
				if(educationProfile.getEducation().getEducationMasterId() > 0){
					education = (Education)session.get(Education.class, educationProfile.getEducation().getEducationMasterId());
				}else{
					education = educationProfile.getEducation();
				}
				existingEduProfile.setEducation(education);
				session.saveOrUpdate(existingEduProfile);
			}
			txn.commit();
			b = true;
		} catch (Exception e) {
			txn.rollback();
			logger.error("Exception occurs in : ", e);
		}finally{
			session.close();
		}
		return b;
	}
	/**
	 * @author Sushanta Barik
	 * @param List<EducationWorkProfile> object
	 * @return true/false boolean value
	 * @exception HibernateException,Exception
	 */
	@Override
	public boolean updateUserWorkExpProfile(List<EducationWorkProfile> workExpList) {
		boolean b = false;
		try {
			session = sessionFactory.openSession();
			txn = session.beginTransaction();
			for(EducationWorkProfile workExpProfile : workExpList){
				EducationWorkProfile existingworkExpProfile = (EducationWorkProfile)session.get(workExpProfile.getClass(), workExpProfile.getEduWrkProfileId());
				if(existingworkExpProfile == null){
					existingworkExpProfile = new EducationWorkProfile();
					User user = (User)session.get(workExpProfile.getUser().getClass(), workExpProfile.getUser().getUserId());
					existingworkExpProfile.setUser(user);
				}else{
					//existingEduProfile.setUser(educationProfile.getUser());
				}
				existingworkExpProfile.setWorkCreateDate(workExpProfile.getWorkCreateDate());
				existingworkExpProfile.setWorkStartDate(workExpProfile.getWorkStartDate());
				existingworkExpProfile.setWorkEndDate(workExpProfile.getWorkEndDate());
				existingworkExpProfile.setEducationCourse(workExpProfile.getWorkPosition());
				WorkExperience workExp = new WorkExperience();
				if(workExpProfile.getWorkExperience().getWorkMasterId() > 0){
					workExp = (WorkExperience)session.get(WorkExperience.class, workExpProfile.getWorkExperience().getWorkMasterId());
				}else{
					workExp = workExpProfile.getWorkExperience();
				}
				existingworkExpProfile.setWorkExperience(workExp);
				session.saveOrUpdate(existingworkExpProfile);
			}
			txn.commit();
			b = true;
		} catch (Exception e) {
			txn.rollback();
			logger.error("Exception occurs in : ", e);
		}finally{
			session.close();
		}
		return b;
	}
	@Override
	public User getUserByEmailId(String email) throws HibernateException,
			Exception {
		// TODO Auto-generated method stub
		User user = new User();
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(user.getClass());
			criteria.add(Restrictions.eq("email", email));
		    user = (User) criteria.uniqueResult();
			return user;
		} catch (HibernateException e) {
			logger.error("Exception occurs in ", e);
		}catch(Exception ex){
			logger.error("Exception occurs in ", ex);
		}finally{
			try {
				session.close();
			} catch (HibernateException e) {
				logger.error("Exception occurs in ", e);
			}
		}
		return user;
	}
	@Override
	public void updateUserSocialPlugin(User user) throws Exception {
		// TODO Auto-generated method stub
		session = sessionFactory.openSession();
		txn = session.beginTransaction();
		session.update(user);
		txn.commit();
		session.close();
	}
	@Override
	public User getUserDetailsByEmail(String email) throws HibernateException,
			Exception {
		// TODO Auto-generated method stub
		User user = new User();
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(user.getClass());
			criteria.add(Restrictions.eq("email", email));
		    user = (User) criteria.uniqueResult();
			return user;
		} catch (HibernateException e) {
			logger.error("Exception occurs in ", e);
		}catch(Exception ex){
			logger.error("Exception occurs in ", ex);
		}finally{
			try {
				session.close();
			} catch (HibernateException e) {
				logger.error("Exception occurs in ", e);
			}
		}
		return user;
	}
	@Override
	public boolean updateTermsConditions(User user) throws Exception {
		boolean b = false;
		try {
			session = sessionFactory.openSession();
			txn = session.beginTransaction();
			User existingUser = (User)session.get(user.getClass(), user.getUserId());
			existingUser.setUserTermsCondn(1);
			session.update(existingUser);
			txn.commit();
			b = true;
		} catch (HibernateException e) {
			txn.rollback();
			logger.error("Exception occurs in ", e);
		} catch (Exception ex) {
			txn.rollback();
			logger.error("Exception occurs in ", ex);
		}finally{
			try {
				session.close();
			} catch (HibernateException exn) {
				logger.error("Exception occurs in ", exn);
			}
		}
		return b;
	}
	@SuppressWarnings("finally")
	@Override
	public String createToken(User user) throws Exception {
		// TODO Auto-generated method stub
		String uuid=null;
		try{
		session = sessionFactory.openSession();
		txn = session.beginTransaction();
		User existingUser = (User)session.get(user.getClass(), user.getUserId());
		uuid = UUID.randomUUID().toString().replaceAll("-", "");
		System.out.println(uuid);
		Token token= new Token();
		token.setToken(uuid);
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, 1);
		date=cal.getTime();
		token.setExpiry_date(date);
		token.setUser(existingUser);
		session.saveOrUpdate(token);
		txn.commit();
		}catch (Exception ex) {
			txn.rollback();
			logger.error("Exception occurs in ", ex);
		}finally{
			try {
				session.close();
			} catch (Exception exn) {
				logger.error("Exception occurs in ", exn);
			}
		return uuid;
	}
	}
	@Override
	public User activateAccount(String token) throws Exception {
		System.out.println("token"+token);
		User user = new User();
		Token tkn=new Token();
		try {
			System.out.println("hi");
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(tkn.getClass());
			criteria.add(Restrictions.eq("token", token));
			criteria.setProjection(Property.forName("expiry_date"));
			Date exp_dt=(Date) criteria.uniqueResult();
			System.out.println("ok");
			System.out.println(exp_dt);
			Date today_dt=new Date();
			int date_compare=today_dt.compareTo(exp_dt);
			System.out.println(date_compare);
			if(date_compare<=0){
				String sql="UPDATE user SET user_account_flag=1 WHERE user_id= ( SELECT user_id FROM token WHERE token = '"+token+"')";
				SQLQuery query=session.createSQLQuery(sql);
				query.executeUpdate();
				int uId=getUserIdByToken(token);
				System.out.println(uId);
				user=getUser(uId);
				System.out.println("hi");
			}
			return user;
		} catch (HibernateException e) {
			logger.error("Exception occurs in ", e);
		}catch(Exception ex){
			logger.error("Exception occurs in ", ex);
		}finally{
			try {
				session.close();
			} catch (HibernateException e) {
				logger.error("Exception occurs in ", e);
			}
		}
		return user;
	}
	
	public User getUser(int userId) {
		User user = new  User();
		try {
			session = sessionFactory.openSession();
			SQLQuery query = session.createSQLQuery("SELECT * FROM user WHERE user_id = '"+userId+"'");
			query.addEntity(user.getClass());
			user = (User)query.uniqueResult();
			return user;
		} catch (HibernateException e) {
			logger.error("Exception occurs in : ", e);
		} catch (Exception ex) {
			logger.error("Exception occurs in : ", ex);
		}
		return user;
	}
	
	public int getUserIdByToken(String token) {
		Token tkn= new Token();
		int userId=0;
		try {
			session = sessionFactory.openSession();
			SQLQuery query = session.createSQLQuery("SELECT * FROM token WHERE token = '"+token+"'");
			query.addEntity(tkn.getClass());
			
			tkn = (Token)query.uniqueResult();
			int id=tkn.getToken_id();
			System.out.println(id);
			userId=tkn.getUser().getUserId();
			System.out.println(userId);
			return userId;
		} catch (HibernateException e) {
			logger.error("Exception occurs in : ", e);
		} catch (Exception ex) {
			logger.error("Exception occurs in : ", ex);
		}
		return userId;
	}

}
