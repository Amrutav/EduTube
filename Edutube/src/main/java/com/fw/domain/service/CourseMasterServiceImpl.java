package com.fw.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fw.dao.CourseMasterDao;
import com.fw.domain.entity.Course_Master;

public class CourseMasterServiceImpl implements CourseMasterService {
	
	@Autowired
	CourseMasterDao courseMasterDao;
	@Override
	public List<Course_Master> getCourseList() throws Exception {
		// TODO Auto-generated method stub
		return courseMasterDao.getCourseList();
	}
	@Override
	public List<Course_Master> getCourseListByUserId(int userId)
			throws Exception {
		// TODO Auto-generated method stub
		return courseMasterDao.getCourseListByUserId(userId);
	}
	@Override
	public boolean addNewCourse(Course_Master course) throws Exception {
		// TODO Auto-generated method stub
		return courseMasterDao.addNewCourse(course);
	}
	@Override
	public Course_Master validateCourseName(String course_name)
			throws Exception {
		// TODO Auto-generated method stub
		try {
			return courseMasterDao.validateCourseName(course_name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Course_Master();
	}
	@Override
	public boolean updateCourseDetails(Course_Master course) throws Exception {
		// TODO Auto-generated method stub
		return courseMasterDao.updateCourseDetails(course);
	}
	@Override
	public boolean deleteCourse(Course_Master course) throws Exception {
		// TODO Auto-generated method stub
		return courseMasterDao.deleteCourse(course);
	}
	@Override
	public List<Course_Master> getCourseListByName(String courseName)
			throws Exception {
		// TODO Auto-generated method stub
		return courseMasterDao.getCourseListByName(courseName);
	}

}
