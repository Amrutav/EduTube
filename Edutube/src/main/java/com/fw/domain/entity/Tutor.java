package com.fw.domain.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "tutor")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Tutor implements Serializable {
	
	@Id
	@GenericGenerator(name = "fwd", strategy = "increment")
	@GeneratedValue(generator = "fwd")
	@Column(name = "tutor_id")
	private int tutorId;
	
//	@Column(name = "user_id")
//	private int userId;
	
	//@Size(min = 2, max = 45)
	@Column(name = "tutor_first_name")
	private String tutorFirstName;
	
	//@Size(min = 2, max = 45)
	@Column(name = "tutor_last_name")
	private String tutorLastName;
	
	//@Past (message="Date of Birth cannot be future date")
	@Column(name = "tutor_dob")
	private Date tutorDateOfBirth;
	
	//@Size(min = 4, max = 6)
	@Column(name = "tutor_gender")
	private String tutorGender;

	@Column(name = "tutor_profile_pic")
	private byte[] tutorProfilePicture;

	@Column(name = "tutor_edu_qua")
	private String tutorEducation;
	
	@Column(name = "tutor_work_exp")
	private String tutorExperience;
	
	@Column(name = "tutor_status_up")
	private String tutorStatusUpdate;
	
	@Column(name = "tutor_abt_me")
	private String tutorAboutMe;
	
	@Column(name = "tutor_avail_st_dt")
	private Date tutorAvailStartDate;
	
	@Column(name = "tutor_avail_end_dt")
	private Date tutorAvailEndDate;
	
	@Column(name = "tutor_certs")
	private String tutorCerts;
	
	@Transient
	private String dobInput;

	public String getDobInput() {
		return dobInput;
	}

	public void setDobInput(String dobInput) {
		this.dobInput = dobInput;
	}

	public int getTutorId() {
		return tutorId;
	}

	public void setTutorId(int tutorId) {
		this.tutorId = tutorId;
	}

//	public int getUserId() {
//		return userId;
//	}
//
//	public void setUserId(int userId) {
//		this.userId = userId;
//	}

	public String getTutorFirstName() {
		return tutorFirstName;
	}

	public void setTutorFirstName(String tutorFirstName) {
		this.tutorFirstName = tutorFirstName;
	}

	public String getTutorLastName() {
		return tutorLastName;
	}

	public void setTutorLastName(String tutorLastName) {
		this.tutorLastName = tutorLastName;
	}

	public Date getTutorDateOfBirth() {
		return tutorDateOfBirth;
	}

	public void setTutorDateOfBirth(Date tutorDateOfBirth) {
		this.tutorDateOfBirth = tutorDateOfBirth;
	}

	public String getTutorGender() {
		return tutorGender;
	}

	public void setTutorGender(String tutorGender) {
		this.tutorGender = tutorGender;
	}
	
	public byte[] getTutorProfilePicture() {
		return tutorProfilePicture;
	}

	public void setTutorProfilePicture(byte[] tutorProfilePicture) {
		this.tutorProfilePicture = tutorProfilePicture;
	}

	public String getTutorEducation() {
		return tutorEducation;
	}

	public void setTutorEducation(String tutorEducation) {
		this.tutorEducation = tutorEducation;
	}

	public String getTutorExperience() {
		return tutorExperience;
	}

	public void setTutorExperience(String tutorExperience) {
		this.tutorExperience = tutorExperience;
	}

	public String getTutorStatusUpdate() {
		return tutorStatusUpdate;
	}

	public void setTutorStatusUpdate(String tutorStatusUpdate) {
		this.tutorStatusUpdate = tutorStatusUpdate;
	}

	public String getTutorAboutMe() {
		return tutorAboutMe;
	}

	public void setTutorAboutMe(String tutorAboutMe) {
		this.tutorAboutMe = tutorAboutMe;
	}

	public Date getTutorAvailStartDate() {
		return tutorAvailStartDate;
	}

	public void setTutorAvailStartDate(Date tutorAvailStartDate) {
		this.tutorAvailStartDate = tutorAvailStartDate;
	}

	public Date getTutorAvailEndDate() {
		return tutorAvailEndDate;
	}

	public void setTutorAvailEndDate(Date tutorAvailEndDate) {
		this.tutorAvailEndDate = tutorAvailEndDate;
	}

	public String getTutorCerts() {
		return tutorCerts;
	}

	public void setTutorCerts(String tutorCerts) {
		this.tutorCerts = tutorCerts;
	}
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="user_id")
	private User user; 

	
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
}
