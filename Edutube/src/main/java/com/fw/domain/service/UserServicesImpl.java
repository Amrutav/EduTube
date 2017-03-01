package com.fw.domain.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;

import com.fw.controller.UserController;
import com.fw.dao.UserDataDao;
import com.fw.domain.entity.Contact;
import com.fw.domain.entity.EducationWorkProfile;
import com.fw.domain.entity.TutorStudentSubject;
import com.fw.domain.entity.User;

public class UserServicesImpl implements UserServices {

	@Autowired
	UserDataDao dataDao;
	
	static final Logger logger = Logger.getLogger(UserServicesImpl.class);
	
	@Override
	public boolean addUser(User user) throws Exception {
		return dataDao.addUserEntity(user);
	}
	
	@Override
	public String createToken(User user) throws Exception {
		// TODO Auto-generated method stub
		return dataDao.createToken(user);
	}
	
	/**
	 * @author Sushanta Barik
	 * @param user
	 * @exception Exception
	 * @return user
	 */
	@Override
	public User getAuthenticateUser(User user){
		try {
			user = dataDao.getUserDetails(user);
			return user;
		} catch (Exception e) {
			logger.error("Exception occurs in ", e);
		}
		return user;
	}
	/**
	 * @author Sushanta Barik
	 * @param user
	 * @exception Exception
	 * @return true/false
	 */
	@Override
	public boolean updateLoginDetails(User user) {
		try {
			return dataDao.updateLoginDetails(user);
		} catch (Exception e) {
			logger.error("Exception occurs in ", e);
		}
		return false;
	}
	/**
	 * @author Sushanta Barik
	 * @param user
	 * @exception Exception
	 * @return true/false
	 */
	@Override
	public boolean updateUserType(User user) throws Exception {
		try {
			return dataDao.updateUserType(user);
		} catch (Exception e) {
			logger.error("Exception occurs in ", e);
		}
		return false;
	}
	/**
	 * @author Sushanta Barik
	 * @param user
	 * @exception Exception
	 * @return true/false
	 */
	@Override
	public boolean updateUserLogoutDetails(User user) throws Exception {
		try {
			return dataDao.updateUserLogoutDetails(user);
		} catch (Exception e) {
			logger.error("Exception occurs in ", e);
		}
		return false;
	}
	/**
	 * @author Sushanta Barik
	 * @param user
	 * @exception Exception
	 * @return user
	 */
	@Override
	public User getUserDetails(User user) {
		try {
			return dataDao.getUserDetails(user);
		} catch (Exception e) {
			logger.error("Exception occurs in ", e);
		}
		return new User();
	}
	/**
	 * @author Sushanta Barik
	 * @param user
	 * @exception Exception
	 * @return user
	 */
	@Override
	public User getUserDetailsByUserid(User user) {
		try {
			return dataDao.getUserDetailsByUserid(user);
		} catch (Exception e) {
			logger.error("Exception Occurs in ", e);
		}
		return new User();
	}
	/**
	 * @author Sushanta Barik
	 * @param string value username
	 * @exception Exception
	 * @return user
	 */
	@Override
	public User getUserDetailsByUsername(String username) {
		try {
			return dataDao.getUserDetailsByUsername(username);
		} catch (Exception e) {
			logger.error("Exception occurs in ", e);
		}
		return new User();
	}
	/**
	 * @author Sushanta Barik
	 * @param userId as integer value
	 * @exception Exception
	 * @return Contact object
	 */
	@Override
	public Contact getUserContact(int userId) {
		try {
			return dataDao.getUserContact(userId);
		} catch (Exception e) {
			logger.error("Exception occurs in : ", e);
		}
		return new Contact();
	}
	/**
	 * @author Sushanta Barik
	 * @param Contact object
	 * @exception Exception
	 * @return true/false
	 */
	@Override
	public boolean updateUserContact(Contact contact) throws Exception {
		try {
			return dataDao.updateUserContact(contact);
		} catch (Exception e) {
			logger.error("Exception occurs in ", e);
		}
		return false;
	}
	/**
	 * @author Sushanta Barik
	 * @param integer value userId
	 * @exception Exception
	 * @return List<EducationWorkProfile> object
	 */
	@Override
	public List<EducationWorkProfile> getUserEducationWorkProfile(int userId) {
		try {
			return dataDao.getUserEducationWorkProfile(userId);
		} catch (Exception e) {
			logger.error("Exception occurs in : ", e);
		}
		return new ArrayList<EducationWorkProfile>();
	}
	/**
	 * @author Sushanta Barik
	 * @param List<EducationWorkProfile> object
	 * @exception Exception
	 * @return true/false boolean value
	 */
	@Override
	public boolean updateUserEducation(List<EducationWorkProfile> educationList) {
		try {
			return dataDao.updateUserEducation(educationList);
		} catch (Exception e) {
			logger.error("Exception occurs in : ", e);
		}
		return false;
	}
	/**
	 * @author Sushanta Barik
	 * @param List<EducationWorkProfile> object
	 * @exception Exception
	 * @return true/false boolean value
	 */
	@Override
	public boolean updateUserWorkExpProfile(List<EducationWorkProfile> workExpList) {
		try {
			return dataDao.updateUserWorkExpProfile(workExpList);
		} catch (Exception e) {
			logger.error("Exception occurs in : ", e);
		}
		return false;
	}
	@Override
	public User getUserByEmailId(String email) throws HibernateException,
			Exception {
		// TODO Auto-generated method stub
		try {
			return dataDao.getUserByEmailId(email);
		} catch (Exception e) {
			logger.error("Exception occurs in ", e);
		}
		return new User();
	}
	@Override
	public void updateUserSocialPlugin(User user) throws Exception {
		// TODO Auto-generated method stub
		try {
			dataDao.updateUserSocialPlugin(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("Exception occurs in ", e);
		}
	}
	@Override
	public User getUserDetailsByEmail(String email) throws HibernateException,
			Exception {
		// TODO Auto-generated method stub
		try {
			return dataDao.getUserDetailsByEmail(email);
		} catch (Exception e) {
			logger.error("Exception occurs in ", e);
		}
		return new User();
	}
	@Override
	public boolean updateTermsConditions(User user) throws Exception {
		try {
			return dataDao.updateTermsConditions(user);
		} catch (Exception e) {
			logger.error("Exception occurs in ", e);
		}
		return false;
	}

	@Override
	public User activateAccount(String token) throws Exception {
		try {
			return dataDao.activateAccount(token);
		} catch (Exception e) {
			logger.error("Exception occurs in ", e);
		}
		return new User();
	}
		
}
