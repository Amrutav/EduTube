package com.fw.domain.service;

import java.util.List;

import com.fw.domain.entity.Course_Master;

public interface CourseMasterService {
	
	public List<Course_Master> getCourseList() throws Exception;

	public List<Course_Master> getCourseListByUserId(int userId) throws Exception;

	public boolean addNewCourse(Course_Master course) throws Exception;

	public Course_Master validateCourseName(String course_name) throws Exception;

	public boolean updateCourseDetails(Course_Master course) throws Exception;

	public boolean deleteCourse(Course_Master course) throws Exception;

	public List<Course_Master> getCourseListByName(String courseName) throws Exception;
}
