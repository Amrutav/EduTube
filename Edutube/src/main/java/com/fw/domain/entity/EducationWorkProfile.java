package com.fw.domain.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="edu_wrk_profile")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class EducationWorkProfile implements Serializable {
	
	@Id
	@GenericGenerator(name = "eduetube", strategy = "increment")
	@GeneratedValue(generator = "eduetube")
	@Column(name = "edu_wrk_profile_id")
	private int eduWrkProfileId;
	
	@Column(name = "edu_st_dt")
	private Date eduStartDate;
	
	@Column(name = "edu_end_dt")
	private Date eduEndDate;
	
	@Column(name = "work_st_dt")
	private Date workStartDate;
	
	@Column(name = "work_end_dt")
	private Date workEndDate;
	
	@Column(name = "edu_crt_dt")
	private Date eduCreateDate;
	
	@Column(name = "work_crt_dt")
	private Date workCreateDate;
	
	@Column(name = "education_course")
	private String educationCourse;
	
	@Column(name = "work_position")
	private String workPosition;
	
	@Transient
	private String startDateInput;
	
	@Transient
	private String endDateInput;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="EDUCATION_MST_education_mst_id")
	private Education education;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="WORK_EXP_MST_work_mst_id")
	private WorkExperience workExperience;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="user_id")
	private User user; 
	
	public int getEduWrkProfileId() {
		return eduWrkProfileId;
	}

	public void setEduWrkProfileId(int eduWrkProfileId) {
		this.eduWrkProfileId = eduWrkProfileId;
	}

	public Date getEduStartDate() {
		return eduStartDate;
	}

	public void setEduStartDate(Date eduStartDate) {
		this.eduStartDate = eduStartDate;
	}

	public Date getEduEndDate() {
		return eduEndDate;
	}

	public void setEduEndDate(Date eduEndDate) {
		this.eduEndDate = eduEndDate;
	}

	public Date getWorkStartDate() {
		return workStartDate;
	}

	public void setWorkStartDate(Date workStartDate) {
		this.workStartDate = workStartDate;
	}

	public Date getWorkEndDate() {
		return workEndDate;
	}

	public void setWorkEndDate(Date workEndDate) {
		this.workEndDate = workEndDate;
	}

	public Date getEduCreateDate() {
		return eduCreateDate;
	}

	public void setEduCreateDate(Date eduCreateDate) {
		this.eduCreateDate = eduCreateDate;
	}

	public Date getWorkCreateDate() {
		return workCreateDate;
	}

	public void setWorkCreateDate(Date workCreateDate) {
		this.workCreateDate = workCreateDate;
	}
	
	public String getEducationCourse() {
		return educationCourse;
	}

	public void setEducationCourse(String educationCourse) {
		this.educationCourse = educationCourse;
	}

	public String getWorkPosition() {
		return workPosition;
	}

	public void setWorkPosition(String workPosition) {
		this.workPosition = workPosition;
	}

	public String getStartDateInput() {
		return startDateInput;
	}

	public void setStartDateInput(String startDateInput) {
		this.startDateInput = startDateInput;
	}

	public String getEndDateInput() {
		return endDateInput;
	}

	public void setEndDateInput(String endDateInput) {
		this.endDateInput = endDateInput;
	}

	public Education getEducation() {
		return education;
	}

	public void setEducation(Education education) {
		this.education = education;
	}

	public WorkExperience getWorkExperience() {
		return workExperience;
	}

	public void setWorkExperience(WorkExperience workExperience) {
		this.workExperience = workExperience;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	

}
