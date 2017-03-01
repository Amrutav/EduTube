package com.fw.domain.entity;

import java.util.Map;

public class UserJsonResponse{

    private String status;
    private Map<String,String> errorsMap;
    private User user;
    private Tutor tutor;
    private Contact contact;
    private Subject subject;
    private TutorStudentSubject tutorStudentSubject;
    private TutorTimeSchedule tutorTimeSchedule;
    public TutorTimeSchedule getTutorTimeSchedule() {
		return tutorTimeSchedule;
	}
	public void setTutorTimeSchedule(TutorTimeSchedule tutorTimeSchedule) {
		this.tutorTimeSchedule = tutorTimeSchedule;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public TutorStudentSubject getTutorStudentSubject() {
		return tutorStudentSubject;
	}
	public void setTutorStudentSubject(TutorStudentSubject tutorStudentSubject) {
		this.tutorStudentSubject = tutorStudentSubject;
	}
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	public Tutor getTutor() {
		return tutor;
	}
	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}
	public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Map<String,String> getErrorsMap() {
        return errorsMap;
    }
    public void setErrorsMap(Map<String,String> errorsMap) {
        this.errorsMap = errorsMap;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
}
