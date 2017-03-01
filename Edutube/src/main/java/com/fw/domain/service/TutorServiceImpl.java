package com.fw.domain.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;

import com.fw.dao.TutorDao;
import com.fw.domain.entity.Tag_Tutor;
import com.fw.domain.entity.Tutor;
import com.fw.domain.entity.TutorTimeSchedule;
import com.fw.domain.entity.TutorTransaction;

public class TutorServiceImpl implements TutorService {
	
	@Autowired
	TutorDao tutorDao;
	
	final Logger logger = Logger.getLogger(getClass());

	@Override
	public Tutor getTutorDetailsByTutorid(Tutor tutor) throws Exception {
		return tutorDao.getTutorDetailsByTutorid(tutor);
	}
	/**
	 * @author Sushanta Barik
	 * @param string value userid
	 * @return Tutor object
	 * @exception Exception
	 */
	@Override
	public Tutor getTutorDetailsByUserid(int userId){
		try {
			return tutorDao.getTutorDetailsByUserid(userId);
		} catch (Exception e) {
			logger.error("Exception occurs in : ", e);
		}
		return new Tutor();
	}
	/**
	 * @author Sushanta Barik
	 * @param Tutor object
	 * @return true/false boolean value
	 * @exception Exception
	 */
	@Override
	public boolean updateTutorBasicProfile(Tutor tutor) {
		try {
			return tutorDao.updateTutorBasicProfile(tutor);
		} catch (Exception e) {
			logger.error("Exception occurs in : ", e);
		}
		return false;
	}
	/**
	 * @author Sushanta Barik
	 * @param Tutor object
	 * @return true/false boolean value
	 * @exception Exception
	 */
	@Override
	public boolean updateTutorAboutMe(Tutor tutor) {
		try {
			return tutorDao.updateTutorAboutMe(tutor);
		} catch (Exception e) {
			logger.error("Exception occurs in", e);
		}
		return false;
	}
	/**
	 * @author Sushanta Barik
	 * @param tutorId as integer value
	 * @return List<Tag_Tutor> object
	 * @exception Exception
	 */
	@Override
	public List<Tag_Tutor> getTutorSubjectTagList(int tutorId) {
		List<Tag_Tutor> tutorSubTagList = new ArrayList<Tag_Tutor>();
		try {
			return tutorDao.getTutorSubjectTagList(tutorId);
		} catch (Exception e) {
			logger.error("Exception occurs in : ", e);
		}
		return tutorSubTagList;
	}
	/**
	 * @author Sushanta Barik
	 * @param List<Tag_Tutor> object
	 * @return true/false boolean value
	 * @exception Exception
	 */
	@Override
	public boolean updateTutorSubMapping(List<Tag_Tutor> tutorSubjectList) {
		try {
			return tutorDao.updateTutorSubMapping(tutorSubjectList);
		} catch (Exception e) {
			logger.error("Exception occurs in : ", e);
		}
		return false;
	}
	/**
	 * @author Sushanta Barik
	 * @param List<TutorTimeSchedule> object
	 * @return true/false boolean value
	 * @exception Exception
	 */
	@Override
	public boolean saveTutorSchedule(List<TutorTimeSchedule> tutorTimeSchedules) {
		try {
			return tutorDao.saveTutorSchedule(tutorTimeSchedules);
		} catch (Exception e) {
			logger.error("Exception occurs in : ", e);
		}
		return false;
	}
	/**
	 * @author Sushanta Barik
	 * @param tutorId integer value
	 * @return List<TutorTimeSchedule> object
	 * @exception Exception
	 */
	@Override
	public List<TutorTimeSchedule> getTutorScheduleList(int tutorId){
		List<TutorTimeSchedule> tutorScheduleList = new ArrayList<TutorTimeSchedule>();
		try {
			tutorScheduleList = tutorDao.getTutorScheduleList(tutorId);
		} catch (Exception e) {
			logger.error("Exception occurs in : ", e);
		}
		return tutorScheduleList;
	}
	/**
	 * @author Sushanta Barik
	 * @param tutorId integer value
	 * @param scheduleCount integer value
	 * @return List<TutorTimeSchedule> object
	 * @exception Exception
	 */
	@Override
	public List<TutorTimeSchedule> getTutorUpcomingScheduleList(int tutorId, int scheduleCount){
		List<TutorTimeSchedule> tutorScheduleList = new ArrayList<TutorTimeSchedule>();
		try {
			tutorScheduleList = tutorDao.getTutorUpcomingScheduleList(tutorId, scheduleCount);
		} catch (Exception e) {
			logger.error("Exception occurs in : ", e);
		}
		return tutorScheduleList;
	}
	/**
	 * @author Sushanta Barik
	 * @param tutorTimeScheduleId integer value
	 * @return TutorTimeSchedule object
	 * @exception Exception
	 */
	@Override
	public TutorTimeSchedule singleScheduleOfTutor(int tutorTimeScheduleId){
		TutorTimeSchedule tutorSchedule = new TutorTimeSchedule();
		try {
			tutorSchedule = tutorDao.singleScheduleOfTutor(tutorTimeScheduleId);
		} catch (Exception e) {
			logger.error("Exception occurs in : ", e);
		}
		return tutorSchedule;
	}
	/**
	 * @author Sushanta Barik
	 * @param tutorTimeScheduleId integer value
	 * @return true/false boolean value
	 * @exception Exception
	 */
	@Override
	public boolean cancelSingleScheduleOfTutor(TutorTimeSchedule timeSchedule){
		try {
			return tutorDao.cancelSingleScheduleOfTutor(timeSchedule);
		} catch (Exception e) {
			logger.error("Exception occurs in : ", e);
		}
		return false;
	}

	@Override
	public List<Tutor> searchBySubject(String keyword) throws Exception {
		// TODO Auto-generated method stub
		return tutorDao.searchBySubject(keyword);
	}

	@Override
	public List<Tutor> advanceSearch(String board, String course, String subject)
			throws Exception {
		// TODO Auto-generated method stub
		return tutorDao.advanceSearch(board, course, subject);
	}
	@Override
	public List<TutorTransaction> getTransactionList(Date startDate,
			Date endDate) throws HibernateException, Exception {
		// TODO Auto-generated method stub
		return tutorDao.getTransactionList(startDate, endDate);
	}
	
	
	
	
	
	
	
	
	

}
