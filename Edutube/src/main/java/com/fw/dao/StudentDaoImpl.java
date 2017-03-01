package com.fw.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.springframework.beans.factory.annotation.Autowired;

import com.fw.domain.entity.Board;
import com.fw.domain.entity.Course_Master;
import com.fw.domain.entity.Student;
import com.fw.domain.entity.Subject;
import com.fw.domain.entity.TagStudent;
import com.fw.domain.entity.Tag_Tutor;
import com.fw.domain.entity.Tutor;
import com.fw.domain.entity.TutorTimeSchedule;
import com.fw.domain.entity.User;


public class StudentDaoImpl implements StudentDao {

	@Autowired
	SessionFactory sessionFactory;
	Session session=null;
	Transaction transaction=null;
	final Logger logger = Logger.getLogger(getClass());
	
	@Override
	public Student editStudentPersonalData(Student student) throws Exception {

		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
//		System.out.println("hhhhhhhhhhh"+student.getUserId());
//		System.out.println(student.getStudent_first_name());
		Student student1=(Student) session.get(Student.class, student.getStudent_id());
//		System.out.println(student.getStudent_first_name());
		student1.setStudent_first_name(student.getStudent_first_name());
		student1.setStudent_last_name(student.getStudent_last_name());
		student1.setStudent_age(student.getStudent_age());
		student1.setStudent_dob(student.getStudent_dob());
		student1.setStudent_gender(student.getStudent_gender());
		//student1.setUserId(student.getUserId());
		//student1.setReln_id(student.getReln_id());
		session.update(student1);
		System.out.println(student.getStudent_first_name());
		transaction.commit();
		session.close();
		return student;
	}

	@Override
	public void deleteStudent(Student student) throws Exception {
		
		
		//sessionfactory.getCurrentSession().createQuery("DELETE FROM student WHERE user_id = "+student.getUserId()).executeUpdate();
	}

	@Override
	public Student showStudentDataByUserid(int userId) throws Exception {
		Student student = new Student();
		try{
		session = sessionFactory.openSession();
		SQLQuery query = session.createSQLQuery("SELECT * FROM student WHERE user_id = "+userId);
		query.addEntity(student.getClass());
		student = (Student)query.uniqueResult();
		return student;
//		student = (Student) session.get(student.getClass(), student.getStudent_id());
		}catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		
		
		return student;
	}
	/**
	 * @author Sushanta Barik
	 * @param List<TagStudent> object
	 * @return true/false boolean value
	 * @exception HibernateException,Exception
	 */
	@Override
	public boolean updateStudTutSubMapping(List<TagStudent> studentSubjectList) {
		boolean b = false;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			for(TagStudent studentSubjectTag : studentSubjectList){
				TagStudent existingStudentSubTag = (TagStudent)session.get(studentSubjectTag.getClass(), studentSubjectTag.getTagStudentId());
				if(existingStudentSubTag == null){
					existingStudentSubTag = new TagStudent();
					Student student = (Student)session.get(studentSubjectTag.getStudent().getClass(), studentSubjectTag.getStudent().getStudent_id());
					existingStudentSubTag.setStudent(student);
				}else{
					//existingEduProfile.setUser(educationProfile.getUser());
				}
				Tutor tutor = new Tutor();
				if(studentSubjectTag.getTutor().getTutorId() > 0){
					tutor = (Tutor)session.get(Tutor.class, studentSubjectTag.getTutor().getTutorId());
				}
				existingStudentSubTag.setTutor(tutor);
				Board board = new Board();
				if(studentSubjectTag.getBoard().getBoard_id() > 0){
					board = (Board)session.get(Board.class, studentSubjectTag.getBoard().getBoard_id());
				}else{
					board = saveAndgetBoardByName(studentSubjectTag.getBoard() , session);
				}
				existingStudentSubTag.setBoard(board);
				Course_Master course = new Course_Master();
				if(studentSubjectTag.getCourse().getCourse_id() > 0){
					course = (Course_Master)session.get(Course_Master.class, studentSubjectTag.getCourse().getCourse_id());
				}else{
					course = saveAndgetCourseByName(studentSubjectTag.getCourse() , session);
				}
				existingStudentSubTag.setCourse(course);
				Subject subject = new Subject();
				if(studentSubjectTag.getSubject().getSubjectId() > 0){
					subject = (Subject)session.get(Subject.class, studentSubjectTag.getSubject().getSubjectId());
				}else{
					subject = saveAndGetSubjectByName(studentSubjectTag.getSubject() , session);
//					if(subject == null){
//						subject = tutorSubjectTag.getSubject();
//					}
				}
				existingStudentSubTag.setSubject(subject);
				session.saveOrUpdate(existingStudentSubTag);
			}
			transaction.commit();
			b = true;
		} catch (Exception e) {
			transaction.rollback();
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

	@Override
	public boolean updateStudentAboutMe(Student student)
			throws HibernateException, Exception {
		// TODO Auto-generated method stub
		boolean b = false;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Student studentProxy = (Student)session.get(student.getClass(), student.getStudent_id());
			studentProxy.setStudent_testimonial(student.getStudent_testimonial());
			session.update(studentProxy);
			transaction.commit();
			b = true;
		} catch (Exception e) {
			transaction.rollback();
			logger.error("Exception occurs in : ", e);
		}finally{
			session.close();
		}
		return b;
	}

	@Override
	public List<TagStudent> studentSubjectTagList(int studentId)
			throws HibernateException, Exception {
		// TODO Auto-generated method stub
		List<TagStudent> studentSubjectList = new ArrayList<TagStudent>();
		try {
			session = sessionFactory.openSession();
			SQLQuery query = session.createSQLQuery("SELECT * FROM tag_student WHERE student_id = "+studentId);
			query.addEntity(TagStudent.class);
			studentSubjectList = query.list();
			return studentSubjectList;
		} catch (HibernateException e) {
			logger.error("Exception occurs in : ", e);
		}finally{
			session.close();
		}
		return studentSubjectList;
	}
	/**
	 * @author Sushanta Barik
	 * @param student_id integer value
	 * @return List<TutorTimeSchedule> object in json
	 * @exception Exception
	 */
	@Override
	public List<TutorTimeSchedule> getscheduledClassesForStudent(int student_id){
		List<TutorTimeSchedule> scheduledClasses = new ArrayList<TutorTimeSchedule>();
		try {
			session = sessionFactory.openSession();
			DetachedCriteria tsCriteria = DetachedCriteria.forClass(TagStudent.class, "ts");
			tsCriteria.add(Restrictions.eq("ts.student.student_id", student_id));
			tsCriteria.add(Restrictions.eqProperty("ts.board.board_id", "tt.board.board_id"));
			tsCriteria.add(Restrictions.eqProperty("ts.course.course_id", "tt.course.course_id"));
			tsCriteria.add(Restrictions.eqProperty("ts.subject.subjectId", "tt.subject.subjectId"));
			tsCriteria.setProjection(Projections.projectionList().add(Projections.property("ts.tutor.tutorId")));
			
			DetachedCriteria ttCriteria = DetachedCriteria.forClass(Tag_Tutor.class, "tt");
	        ttCriteria.add(Subqueries.propertyIn("tt.tutor.tutorId", tsCriteria));
	        ttCriteria.setProjection(Projections.projectionList().add(Projections.property("tt.tag_tutor_id")));
	        
	        Criteria criteria =session.createCriteria(TutorTimeSchedule.class, "tts");
	        criteria.add(Subqueries.propertyIn("tts.tagTutor.tag_tutor_id", ttCriteria));
	        scheduledClasses = criteria.list();
		} catch (HibernateException e) {
			logger.error("Exception occurs in : ", e);
		} catch (Exception ex) {
			logger.error("Exception occurs in : ", ex);
		} finally {
			session.close();
		}
		return scheduledClasses;
	}
	/**
	 * @author Sushanta Barik
	 * @param student_id integer value
	 * @return List<TutorTimeSchedule> object
	 * @exception Exception
	 */
	@Override
	public List<TutorTimeSchedule> getstudentUpcomingClasses(int student_id,int scheduleCount){
		List<TutorTimeSchedule> upcomingClasses = new ArrayList<TutorTimeSchedule>();
		try {
			session = sessionFactory.openSession();
			DetachedCriteria tsCriteria = DetachedCriteria.forClass(TagStudent.class, "ts");
			tsCriteria.add(Restrictions.eq("ts.student.student_id", student_id));
			tsCriteria.add(Restrictions.eqProperty("ts.board.board_id", "tt.board.board_id"));
			tsCriteria.add(Restrictions.eqProperty("ts.course.course_id", "tt.course.course_id"));
			tsCriteria.add(Restrictions.eqProperty("ts.subject.subjectId", "tt.subject.subjectId"));
			tsCriteria.setProjection(Projections.projectionList().add(Projections.property("ts.tutor.tutorId")));
			
			DetachedCriteria ttCriteria = DetachedCriteria.forClass(Tag_Tutor.class, "tt");
	        ttCriteria.add(Subqueries.propertyIn("tt.tutor.tutorId", tsCriteria));
	        ttCriteria.setProjection(Projections.projectionList().add(Projections.property("tt.tag_tutor_id")));
	        
	        Criteria criteria =session.createCriteria(TutorTimeSchedule.class, "tts");
	        criteria.add(Subqueries.propertyIn("tts.tagTutor.tag_tutor_id", ttCriteria));
	        criteria.add(Restrictions.gt("tts.scheduleStartTime", new Date()));
	        criteria.addOrder(Order.asc("tts.scheduleStartTime"));
	        criteria.setMaxResults(scheduleCount);
	        upcomingClasses = criteria.list();
		} catch (HibernateException e) {
			logger.error("Exception occurs in : ", e);
		} catch (Exception ex) {
			logger.error("Exception occurs in : ", ex);
		} finally {
			session.close();
		}
		return upcomingClasses;
	}
	
}
