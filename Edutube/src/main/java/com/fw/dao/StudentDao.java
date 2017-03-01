package com.fw.dao;

import java.util.List;

import org.hibernate.HibernateException;

import com.fw.domain.entity.Student;
import com.fw.domain.entity.TagStudent;
import com.fw.domain.entity.Tag_Tutor;
import com.fw.domain.entity.Tutor;
import com.fw.domain.entity.TutorTimeSchedule;

public interface StudentDao {
	
	public Student editStudentPersonalData(Student student)throws Exception;
	
	public void deleteStudent(Student student)throws Exception;
	
	public Student showStudentDataByUserid(int userId)throws HibernateException, Exception;

	public boolean updateStudTutSubMapping(List<TagStudent> studentSubjectList)throws HibernateException , Exception;
	
	public boolean updateStudentAboutMe(Student student)throws HibernateException , Exception;
	
	public List<TagStudent> studentSubjectTagList(int studentId)throws HibernateException , Exception;

	public List<TutorTimeSchedule> getscheduledClassesForStudent(int student_id)throws HibernateException , Exception;

	public List<TutorTimeSchedule> getstudentUpcomingClasses(int student_id,int scheduleCount)throws HibernateException , Exception;

}
