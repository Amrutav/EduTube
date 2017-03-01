package com.fw.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.object.SqlQuery;

import com.fw.domain.entity.Board;
import com.fw.domain.entity.Course_Master;
import com.fw.domain.entity.Education;
import com.fw.domain.entity.EducationWorkProfile;
import com.fw.domain.entity.Subject;
import com.fw.domain.entity.Tag_Tutor;
import com.fw.domain.entity.Tutor;
import com.fw.domain.entity.TutorTimeSchedule;
import com.fw.domain.entity.TutorTransaction;
import com.fw.domain.entity.User;

public class TutorDaoImpl implements TutorDao {
	
	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction txn = null;

	final Logger logger = Logger.getLogger(getClass());

	@Override
	public Tutor getTutorDetailsByTutorid(Tutor tutor){
		try {
			session = sessionFactory.openSession();
			tutor = (Tutor)session.get(tutor.getClass(), tutor.getTutorId());
			return tutor;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			session.close();
		}
		return tutor;
	}
	/**
	 * @author Sushanta Barik
	 * @param userId integer value
	 * @return Tutor object
	 * @exception HibernateException,Exception
	 */
	@Override
	public Tutor getTutorDetailsByUserid(int userId) {
		Tutor tutor = new Tutor();
		try {
			session = sessionFactory.openSession();
			SQLQuery query = session.createSQLQuery("SELECT * FROM tutor WHERE user_id = "+userId);
			query.addEntity(tutor.getClass());
			tutor = (Tutor)query.uniqueResult();
			return tutor;
		} catch (HibernateException e) {
			logger.error("Exception occurs in : ", e);
		} catch (Exception ex) {
			logger.error("Exception occurs in : ", ex);
		}finally{
			session.close();
		}
		return tutor;
	}
	/**
	 * @author Sushanta Barik
	 * @param Tutor object
	 * @return true/false boolean value
	 * @exception HibernateException,Exception
	 */
	@Override
	public boolean updateTutorBasicProfile(Tutor tutor) throws Exception {
		boolean b = false;
		try {
			session = sessionFactory.openSession();
			txn = session.beginTransaction();
			Tutor tutorProxy = (Tutor)session.get(tutor.getClass(), tutor.getTutorId());
			tutorProxy.setTutorFirstName(tutor.getTutorFirstName());
			tutorProxy.setTutorLastName(tutor.getTutorLastName());
			tutorProxy.setTutorGender(tutor.getTutorGender());
			tutorProxy.setTutorDateOfBirth(tutor.getTutorDateOfBirth());
			tutorProxy.getUser().setUserFirstName(tutor.getUser().getUserFirstName());
			tutorProxy.getUser().setUserLastName(tutor.getUser().getUserLastName());
			session.update(tutorProxy);
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
	 * @param Tutor object
	 * @return true/false boolean value
	 * @exception HibernateException,Exception
	 */
	@Override
	public boolean updateTutorAboutMe(Tutor tutor) {
		boolean b = false;
		try {
			session = sessionFactory.openSession();
			txn = session.beginTransaction();
			Tutor tutorProxy = (Tutor)session.get(tutor.getClass(), tutor.getTutorId());
			tutorProxy.setTutorAboutMe(tutor.getTutorAboutMe());
			session.update(tutorProxy);
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
	 * @param List<Tag_Tutor> object
	 * @return true/false boolean value
	 * @exception HibernateException,Exception
	 */
	@Override
	public List<Tag_Tutor> getTutorSubjectTagList(int tutorId) {
		List<Tag_Tutor> tutorSubjectTagList = new ArrayList<Tag_Tutor>();
		try {
			session = sessionFactory.openSession();
			SQLQuery query = session.createSQLQuery("SELECT * FROM tag_tutor WHERE tutor_id = "+tutorId);
			query.addEntity(Tag_Tutor.class);
			tutorSubjectTagList = query.list();
			return tutorSubjectTagList;
		} catch (HibernateException e) {
			logger.error("Exception occurs in : ", e);
		}finally{
			session.close();
		}
		return tutorSubjectTagList;
	}
	/**
	 * @author Sushanta Barik
	 * @param List<Tag_Tutor> object
	 * @return true/false boolean value
	 * @exception HibernateException,Exception
	 */
	@Override
	public boolean updateTutorSubMapping(List<Tag_Tutor> tutorSubjectList) {
		boolean b = false;
		try {
			session = sessionFactory.openSession();
			txn = session.beginTransaction();
			for(Tag_Tutor tutorSubjectTag : tutorSubjectList){
				Tag_Tutor existingTutorSubTag = (Tag_Tutor)session.get(tutorSubjectTag.getClass(), tutorSubjectTag.getTag_tutor_id());
				if(existingTutorSubTag == null){
					existingTutorSubTag = new Tag_Tutor();
					Tutor tutor = (Tutor)session.get(tutorSubjectTag.getTutor().getClass(), tutorSubjectTag.getTutor().getTutorId());
					existingTutorSubTag.setTutor(tutor);
				}else{
					//existingEduProfile.setUser(educationProfile.getUser());
				}
				Board board = new Board();
				if(tutorSubjectTag.getBoard().getBoard_id() > 0){
					board = (Board)session.get(Board.class, tutorSubjectTag.getBoard().getBoard_id());
				}else{
					board = saveAndgetBoardByName(tutorSubjectTag.getBoard() , session);
				}
				existingTutorSubTag.setBoard(board);
				Course_Master course = new Course_Master();
				if(tutorSubjectTag.getCourse().getCourse_id() > 0){
					course = (Course_Master)session.get(Course_Master.class, tutorSubjectTag.getCourse().getCourse_id());
				}else{
					course = saveAndgetCourseByName(tutorSubjectTag.getCourse() , session);
				}
				existingTutorSubTag.setCourse(course);
				Subject subject = new Subject();
				if(tutorSubjectTag.getSubject().getSubjectId() > 0){
					subject = (Subject)session.get(Subject.class, tutorSubjectTag.getSubject().getSubjectId());
				}else{
					subject = saveAndGetSubjectByName(tutorSubjectTag.getSubject() , session);
//					if(subject == null){
//						subject = tutorSubjectTag.getSubject();
//					}
				}
				existingTutorSubTag.setSubject(subject);
				session.saveOrUpdate(existingTutorSubTag);
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
	 * @param Board object , Session object
	 * @return Board object
	 * @exception HibernateException
	 */
	private Board saveAndgetBoardByName(Board board, Session localSession) {
		try {
			Criteria criteria = localSession.createCriteria(board.getClass());
			criteria.add(Restrictions.eq("board_name", board.getBoard_name()));
			Board localBoard = (Board)criteria.uniqueResult();
			if(localBoard == null){
				localSession.save(board);
				localBoard = (Board)criteria.uniqueResult();
			}
			return localBoard;
		} catch (HibernateException e) {
			logger.error("Exception occurs in : ", e);
		}
		return new Board();
	}
	/**
	 * @author Sushanta Barik
	 * @param Course_Master object , Session object
	 * @return Course_Master object
	 * @exception HibernateException
	 */
	private Course_Master saveAndgetCourseByName(Course_Master course,Session localSession) {
		try {
			Criteria criteria = localSession.createCriteria(course.getClass());
			criteria.add(Restrictions.eq("course_name", course.getCourse_name()));
			Course_Master localcourse = (Course_Master)criteria.uniqueResult();
			if(localcourse == null){
				localSession.save(course);
				localcourse = (Course_Master)criteria.uniqueResult();
			}
			return localcourse;
		} catch (HibernateException e) {
			logger.error("Exception occurs in : ", e);
		}
		return new Course_Master();
	}
	/**
	 * @author Sushanta Barik
	 * @param Subject object , Session object
	 * @return Subject object
	 * @exception HibernateException
	 */
	private Subject saveAndGetSubjectByName(Subject subject , Session localSession) {
		try {
			Criteria criteria = localSession.createCriteria(subject.getClass());
			criteria.add(Restrictions.eq("subjectname", subject.getSubjectname()));
			Subject localSubject = (Subject)criteria.uniqueResult();
			if(localSubject == null){
				localSession.save(subject);
				localSubject = (Subject)criteria.uniqueResult();
			}
			return localSubject;
		} catch (HibernateException e) {
			logger.error("Exception occurs in : ", e);
		}
		return new Subject();
	}
	/**
	 * @author Sushanta Barik
	 * @param List<TutorTimeSchedule> object
	 * @return true/false boolean value
	 * @exception HibernateException , Exception
	 */
	@Override
	public boolean saveTutorSchedule(List<TutorTimeSchedule> tutorTimeSchedules) {
		boolean b = false;
		try {
			session = sessionFactory.openSession();
			txn = session.beginTransaction();
			for(int i = 0; i<tutorTimeSchedules.size(); i++){
				session.save(tutorTimeSchedules.get(i));
				if(i % 20 == 0){
					session.flush();
					session.clear();
				}
			}
			txn.commit();
			b = true;
		} catch (HibernateException e) {
			txn.rollback();
			logger.error("Exception occurs in : ", e);
		} catch (Exception ex) {
			txn.rollback();
			logger.error("Exception occurs in : ", ex);
		} finally{
			session.close();
		}
		return b;
	}
	/**
	 * @author Sushanta Barik
	 * @param tutorId integer value
	 * @return List<TutorTimeSchedule> object
	 * @exception HibernateException , Exception
	 */
	@Override
	public List<TutorTimeSchedule> getTutorScheduleList(int tutorId){
		List<TutorTimeSchedule> tutorTimeScheduleList = new ArrayList<TutorTimeSchedule>();
		try {
			session = sessionFactory.openSession();
			DetachedCriteria ttCriteria = DetachedCriteria.forClass(Tag_Tutor.class, "tt");
	        ttCriteria.add(Restrictions.eq("tt.tutor.tutorId", tutorId));
	        ttCriteria.setProjection(Projections.projectionList().add(Projections.property("tt.tag_tutor_id")));
	        Criteria criteria =session.createCriteria(TutorTimeSchedule.class, "tts");
	        criteria.add(Subqueries.propertyIn("tts.tagTutor.tag_tutor_id", ttCriteria));
	        tutorTimeScheduleList = criteria.list();
		} catch (HibernateException e) {
			logger.error("Exception occurs in : ", e);
		} catch (Exception ex) {
			logger.error("Exception occurs in : ", ex);
		} finally {
			session.close();
		}
		return tutorTimeScheduleList;
	}
	/**
	 * @author Sushanta Barik
	 * @param tutorId integer value
	 * @param scheduleCount integer value
	 * @return List<TutorTimeSchedule> object
	 * @exception HibernateException , Exception
	 */
	@Override
	public List<TutorTimeSchedule> getTutorUpcomingScheduleList(int tutorId, int scheduleCount){
		List<TutorTimeSchedule> tutorTimeScheduleList = new ArrayList<TutorTimeSchedule>();
		try {
			session = sessionFactory.openSession();
			DetachedCriteria ttCriteria = DetachedCriteria.forClass(Tag_Tutor.class, "tt");
	        ttCriteria.add(Restrictions.eq("tt.tutor.tutorId", tutorId));
	        ttCriteria.setProjection(Projections.projectionList().add(Projections.property("tt.tag_tutor_id")));
	        Criteria criteria =session.createCriteria(TutorTimeSchedule.class, "tts");
	        criteria.add(Subqueries.propertyIn("tts.tagTutor.tag_tutor_id", ttCriteria));
	        criteria.add(Restrictions.gt("tts.scheduleStartTime", new Date()));
	        criteria.addOrder(Order.asc("tts.scheduleStartTime"));
	        criteria.setMaxResults(scheduleCount);
	        tutorTimeScheduleList = criteria.list();
		} catch (HibernateException e) {
			logger.error("Exception occurs in : ", e);
		} catch (Exception ex) {
			logger.error("Exception occurs in : ", ex);
		} finally {
			session.close();
		}
		return tutorTimeScheduleList;
	}
	/**
	 * @author Sushanta Barik
	 * @param tutorTimeScheduleId integer value
	 * @return TutorTimeSchedule object
	 * @exception HibernateException , Exception
	 */
	@Override
	public TutorTimeSchedule singleScheduleOfTutor(int tutorTimeScheduleId){
		TutorTimeSchedule tutorTimeSchedule = new TutorTimeSchedule();
		try {
			session = sessionFactory.openSession();
			tutorTimeSchedule = (TutorTimeSchedule)session.get(tutorTimeSchedule.getClass(), tutorTimeScheduleId);
		} catch (HibernateException e) {
			logger.error("Exception occurs in : ", e);
		} catch (Exception ex) {
			logger.error("Exception occurs in : ", ex);
		} finally {
			session.close();
		}
		return tutorTimeSchedule;
	}
	/**
	 * @author Sushanta Barik
	 * @param tutorTimeScheduleId integer value
	 * @return UserJsonResponse object
	 * @exception HibernateException , Exception
	 */
	@Override
	public boolean cancelSingleScheduleOfTutor(TutorTimeSchedule timeSchedule){
		boolean b = false;
		try {
			session = sessionFactory.openSession();
			txn = session.beginTransaction();
			timeSchedule = (TutorTimeSchedule)session.get(timeSchedule.getClass(), timeSchedule.getTutorTimeScheduleId());
			timeSchedule.setScheduleStatus("Cancelled");
			session.update(timeSchedule);
			txn.commit();
			b = true;
		} catch (HibernateException e) {
			logger.error("Exception occurs in : ", e);
		} catch (Exception ex) {
			logger.error("Exception occurs in : ", ex);
		} finally {
			session.close();
		}
		return b;
	}
	
	
	@Override
	public List<Tutor> searchBySubject(String keyword) throws Exception {
		
		List<Tutor> list=new ArrayList<Tutor>();
		try{
		session=sessionFactory.openSession();
		txn = session.beginTransaction();
		String sql="SELECT * FROM tutor WHERE tutor_id IN (SELECT tutor_id FROM tag_tutor WHERE subject_master_id IN(SELECT subject_id FROM subject_master WHERE subject_name LIKE '%"+keyword+"%'))";
		SQLQuery query=session.createSQLQuery(sql);
		query.addEntity(Tutor.class);
		list=query.list();
		System.out.println(list.size());
		} catch (Exception e) {
			txn.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return list;
	}



	@Override
	public List<Tutor> advanceSearch(String board, String course, String subject){
		List<Tutor> list= new ArrayList<Tutor>();
		String sql="";
		System.out.println(board.length()+"++++++++++"+subject.concat(subject)+"+++++++"+course.trim());
		try{
			session=sessionFactory.openSession();
			txn=session.beginTransaction();
			if((board.equals("null") || board.equals("")) && (course.equals("null") || course.equals("")) && (subject.equals("null") || subject.equals(""))){
				System.out.println("a");
				sql="SELECT * FROM tutor";
			}
			else if ((!board.equals("null") || !board.equals("")) && (!course.equals("null") || !course.equals("")) && (subject.equals("null") || subject.equals(""))) {
				System.out.println("b");
				sql="SELECT * FROM tutor WHERE tutor_id IN (SELECT tutor_id FROM tag_tutor WHERE board_master_id IN(SELECT board_id FROM board_master WHERE board_name LIKE '%"+board+"%')) AND tutor_id IN (SELECT tutor_id FROM tag_tutor WHERE course_master_id IN(SELECT course_id FROM course_master WHERE course_name LIKE '%"+course+"%'))";
			}else if ((!board.equals("null") || !board.equals("")) && (course.equals("null") || course.equals("")) && (!subject.equals("null") || !subject.equals("null"))) {
				System.out.println("c");
				sql="SELECT * FROM tutor WHERE tutor_id IN (SELECT tutor_id FROM tag_tutor WHERE board_master_id IN(SELECT board_id FROM board_master WHERE board_name LIKE '%"+board+"%')) AND tutor_id IN (SELECT tutor_id FROM tag_tutor WHERE subject_master_id IN(SELECT subject_id FROM subject_master WHERE subject_name LIKE '%"+subject+"%'))";
			}else if ((board.equals("null") || board.equals("")) && (!course.equals("null") || !course.equals("")) && (!subject.equals("null") || !subject.equals("null"))) {
				System.out.println("d");
				sql="SELECT * FROM tutor WHERE tutor_id IN (SELECT tutor_id FROM tag_tutor WHERE course_master_id IN(SELECT course_id FROM course_master WHERE course_name LIKE '%"+course+"%')) AND tutor_id IN (SELECT tutor_id FROM tag_tutor WHERE subject_master_id IN(SELECT subject_id FROM subject_master WHERE subject_name LIKE '%"+subject+"%'))";
			}else if ((board.equals("null") || board.equals("")) && (course.equals("null") || course.equals("")) && (!subject.equals("null") || !subject.equals("null"))) {
				System.out.println("e");
				sql="SELECT * FROM tutor WHERE tutor_id IN (SELECT tutor_id FROM tag_tutor WHERE subject_master_id IN(SELECT subject_id FROM subject_master WHERE subject_name LIKE '%"+subject+"%'))";
			}else if ((board.equals("null") || board.equals("")) && (!course.equals("null") || !course.equals("")) && (subject.equals("null") || subject.equals(""))) {
				System.out.println("f");
				sql="SELECT * FROM tutor WHERE tutor_id IN (SELECT tutor_id FROM tag_tutor WHERE course_master_id IN(SELECT course_id FROM course_master WHERE course_name LIKE '%"+course+"%'))";
			}else if ((!board.equals("null") || !board.equals("")) && (course.equals("null") || course.equals("")) && (subject.equals("null") || subject.equals(""))) {
				System.out.println("g");
				sql="SELECT * FROM tutor WHERE tutor_id IN (SELECT tutor_id FROM tag_tutor WHERE board_master_id IN(SELECT board_id FROM board_master WHERE board_name LIKE '%"+board+"%'))";
			}else{
				System.out.println("h");
				sql="SELECT * FROM tutor WHERE tutor_id IN (SELECT tutor_id FROM tag_tutor WHERE board_master_id IN(SELECT board_id FROM board_master WHERE board_name LIKE '%"+board+"%')) AND tutor_id IN (SELECT tutor_id FROM tag_tutor WHERE course_master_id IN(SELECT course_id FROM course_master WHERE course_name LIKE '%"+course+"%')) AND tutor_id IN (SELECT tutor_id FROM tag_tutor WHERE subject_master_id IN(SELECT subject_id FROM subject_master WHERE subject_name LIKE '%"+subject+"%'))";
			}
			SQLQuery query=session.createSQLQuery(sql);
			query.addEntity(Tutor.class);
			list=query.list();
		}catch (Exception e) {
			txn.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return list;
	}
	@Override
	public List<TutorTransaction> getTransactionList(Date startDate,
			Date endDate) throws HibernateException, Exception {
		// TODO Auto-generated method stub
		List<TutorTransaction> transactionList = new ArrayList<TutorTransaction>();
	    SimpleDateFormat ft =   new SimpleDateFormat ("YYYY-MM-dd HH:mm:ss");
	    String a = ft.format(startDate);
	    String b = ft.format(endDate);
		try{
			session=sessionFactory.openSession();
			txn=session.beginTransaction();
			System.out.println("OK");
			String sql="SELECT * FROM tutor_transaction WHERE transaction_date >= '"+a+"' AND transaction_date <= '"+b+"'";
			System.out.println(sql);
			SQLQuery query=session.createSQLQuery(sql);
			query.addEntity(TutorTransaction.class);
			transactionList=query.list();
		}catch (Exception e) {
			txn.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return transactionList;
	}
	
	
	
	
	
	
	



	

}
