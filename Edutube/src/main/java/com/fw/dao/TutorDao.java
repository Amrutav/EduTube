package com.fw.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;

import com.fw.domain.entity.Tag_Tutor;
import com.fw.domain.entity.Tutor;
import com.fw.domain.entity.TutorTimeSchedule;
import com.fw.domain.entity.TutorTransaction;

public interface TutorDao {

	public Tutor getTutorDetailsByTutorid(Tutor tutor)throws Exception;

	public boolean updateTutorBasicProfile(Tutor tutor)throws Exception;
	
	public List<Tutor> searchBySubject(String keyword) throws Exception;
	
	public List<Tutor> advanceSearch(String board, String course, String subject)throws Exception;

	public Tutor getTutorDetailsByUserid(int userId)throws HibernateException , Exception;

	public boolean updateTutorAboutMe(Tutor tutor)throws HibernateException , Exception;

	public boolean updateTutorSubMapping(List<Tag_Tutor> tutorSubjectList)throws HibernateException , Exception;

	public List<Tag_Tutor> getTutorSubjectTagList(int tutorId)throws HibernateException , Exception;
	
	public boolean saveTutorSchedule(List<TutorTimeSchedule> tutorTimeSchedules)throws HibernateException , Exception;
	
	public List<TutorTransaction> getTransactionList(Date startDate, Date endDate)throws HibernateException, Exception;

	public List<TutorTimeSchedule> getTutorScheduleList(int tutorId)throws HibernateException , Exception;

	public TutorTimeSchedule singleScheduleOfTutor(int tutorTimeScheduleId)throws HibernateException , Exception;

	public List<TutorTimeSchedule> getTutorUpcomingScheduleList(int tutorId, int scheduleCount)throws HibernateException , Exception;

	public boolean cancelSingleScheduleOfTutor(TutorTimeSchedule timeSchedule)throws HibernateException , Exception;

	
}
