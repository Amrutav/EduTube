package com.fw.domain.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="tutor_student_subject")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class TutorStudentSubject implements Serializable {
	
	@Id
	@GenericGenerator(name = "eduetube", strategy = "increment")
	@GeneratedValue(generator = "eduetube")
	@Column(name = "tutor_student_subject_id")
	private int tutorStudentSubjectId;	
	
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "subject_id")
	private int subjectId;

	public int getTutorStudentSubjectId() {
		return tutorStudentSubjectId;
	}
	public void setTutorStudentSubjectId(int tutorStudentSubjectId) {
		this.tutorStudentSubjectId = tutorStudentSubjectId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	private int[] subjects;
	
	public int[] getSubjects() {
		return subjects;
	}
	public void setSubjects(int[] subjects) {
		this.subjects = subjects;
	}


}
