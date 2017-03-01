package com.fw.domain.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;

import com.fw.dao.StudentDao;
import com.fw.domain.entity.Student;
import com.fw.domain.entity.TagStudent;
import com.fw.domain.entity.Tag_Tutor;
import com.fw.domain.entity.TutorTimeSchedule;

public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDao studentdao;
	
	final Logger logger = Logger.getLogger(getClass());
	
	@Override
	public Student editStudentPersonalData(Student student) throws Exception {
		
		student=studentdao.editStudentPersonalData(student);
		
		return student;
	}

	@Override
	public void deleteStudent(Student student) throws Exception {
		
		studentdao.deleteStudent(student);
	}


	@Override
	public Student showStudentData(int userId) throws Exception {
		// TODO Auto-generated method stub
		try{
			return studentdao.showStudentDataByUserid(userId);
		}catch (Exception e) {
			logger.error("Exception occurs in : ", e);
		}
		return new Student();
	}
	/**
	 * @author Sushanta Barik
	 * @param List<TagStudent> object
	 * @return true/false boolean value
	 * @exception Exception
	 */
	@Override
	public boolean updateStudTutSubMapping(List<TagStudent> studentSubjectList){
		try {
			return studentdao.updateStudTutSubMapping(studentSubjectList);
		} catch (Exception e) {
			logger.error("Exception occurs in", e);
		}
		return false;
	}

	@Override
	public boolean updateStudentAboutMe(Student student)
			throws HibernateException, Exception {
		// TODO Auto-generated method stub
		try {
			return studentdao.updateStudentAboutMe(student);
		} catch (Exception e) {
			logger.error("Exception occurs in", e);
		}
		return false;
	}

	@Override
	public List<TagStudent> studentSubjectTagList(int studentId)
			throws HibernateException, Exception {
		// TODO Auto-generated method stub
		List<TagStudent> studentSubjectList = new ArrayList<TagStudent>();
		try {
			return studentdao.studentSubjectTagList(studentId);
		} catch (Exception e) {
			logger.error("Exception occurs in : ", e);
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
			scheduledClasses = studentdao.getscheduledClassesForStudent(student_id);
		} catch (Exception e) {
			logger.error("Exception occurs in : ", e);
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
	public List<TutorTimeSchedule> getstudentUpcomingClasses(int student_id, int scheduleCount){
		List<TutorTimeSchedule> upcomingClasses = new ArrayList<TutorTimeSchedule>();
		try {
			upcomingClasses = studentdao.getstudentUpcomingClasses(student_id, scheduleCount);
		} catch (Exception e) {
			logger.error("Exception occurs in : ", e);
		}
		return upcomingClasses;
	}

}
