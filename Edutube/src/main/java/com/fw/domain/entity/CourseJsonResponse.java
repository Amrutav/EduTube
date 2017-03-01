package com.fw.domain.entity;

import java.util.Map;

public class CourseJsonResponse {
	private String status;
	private Map<String, String> errorsMap;
	private User user;
	private Course_Master course;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Map<String, String> getErrorsMap() {
		return errorsMap;
	}
	public void setErrorsMap(Map<String, String> errorsMap) {
		this.errorsMap = errorsMap;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Course_Master getCourse() {
		return course;
	}
	public void setCourse(Course_Master course) {
		this.course = course;
	}
}
