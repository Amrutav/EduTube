package com.fw.domain.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "student")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Student {
	
	@Id
	@GenericGenerator(name = "eduetube", strategy = "increment")
	@GeneratedValue(generator = "eduetube")
	@Column(name = "student_id")
	private int student_id;
//	@Column(name = "user_id")
//	private int userId;
	@Column
	@Size(min = 2 , max = 45)
	private String student_first_name;
	@Column
	@Size(min = 2 , max = 45)
	private String student_last_name;
	@Column
	private int student_age;
	@Column
//	@Size(min = 2 , max = 45)
	private Date student_dob;
	@Transient
	private String dob;
	@Column
	private String student_gender;
	@Column
	private Byte student_profile_pic[];
	@Column
//	@Size(min = 2 , max = 50)
	private String student_institution;
	@Column
//	@Size(min = 2 , max = 10)
	private String student_qualification;
	@Column
//	@Size(min = 2 , max = 50)
	private String student_contact_adr;
	@Column
//	@Size(min = 2 , max = 45)
	private String student_testimonial;
	@Column
//	@Size(min = 2 , max = 45)
	private String student_reln_tutor;
	@Column
//	@Size(min = 2 , max = 45)
	private String student_reg_type;	
	@Column
//	@Size(min = 2 , max = 200)
	private String student_status_upd;
	@Column
	private int reln_id;
	@Column
//	@Size(min = 2 , max = 45)
	private String time_zone;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
	private User user;

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public String getStudent_first_name() {
		return student_first_name;
	}

	public void setStudent_first_name(String student_first_name) {
		this.student_first_name = student_first_name;
	}

	public String getStudent_last_name() {
		return student_last_name;
	}

	public void setStudent_last_name(String student_last_name) {
		this.student_last_name = student_last_name;
	}

	public int getStudent_age() {
		return student_age;
	}

	public void setStudent_age(int student_age) {
		this.student_age = student_age;
	}

	public Date getStudent_dob() {
		return student_dob;
	}

	public void setStudent_dob(Date student_dob) {
		this.student_dob = student_dob;
	}

	public Byte[] getStudent_profile_pic() {
		return student_profile_pic;
	}

	public void setStudent_profile_pic(Byte[] student_profile_pic) {
		this.student_profile_pic = student_profile_pic;
	}

	public String getStudent_institution() {
		return student_institution;
	}

	public void setStudent_institution(String student_institution) {
		this.student_institution = student_institution;
	}

	public String getStudent_qualification() {
		return student_qualification;
	}

	public void setStudent_qualification(String student_qualification) {
		this.student_qualification = student_qualification;
	}

	public String getStudent_contact_adr() {
		return student_contact_adr;
	}

	public void setStudent_contact_adr(String student_contact_adr) {
		this.student_contact_adr = student_contact_adr;
	}

	public String getStudent_testimonial() {
		return student_testimonial;
	}

	public void setStudent_testimonial(String student_testimonial) {
		this.student_testimonial = student_testimonial;
	}

	public String getStudent_reln_tutor() {
		return student_reln_tutor;
	}

	public void setStudent_reln_tutor(String student_reln_tutor) {
		this.student_reln_tutor = student_reln_tutor;
	}

	public String getStudent_reg_type() {
		return student_reg_type;
	}

	public void setStudent_reg_type(String student_reg_type) {
		this.student_reg_type = student_reg_type;
	}

	public String getStudent_status_upd() {
		return student_status_upd;
	}

	public void setStudent_status_upd(String student_status_upd) {
		this.student_status_upd = student_status_upd;
	}

	public int getReln_id() {
		return reln_id;
	}

	public void setReln_id(int reln_id) {
		this.reln_id = reln_id;
	}

	public String getTime_zone() {
		return time_zone;
	}

	public void setTime_zone(String time_zone) {
		this.time_zone = time_zone;
	}

//	public int getUserId() {
//		return userId;
//	}
//
//	public void setUserId(int userId) {
//		this.userId = userId;
//	}

	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
//	public static Date toDateConversion(Date dob) {
//		String pattern = "dd/MM/yyyy";
//		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
//		Date formattedDob=null;
//
//		try {
//			formattedDob = formatter.parse(dob);
//		} catch (java.text.ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return formattedDob;
//	}

	public String getStudent_gender() {
		return student_gender;
	}

	public void setStudent_gender(String student_gender) {
		this.student_gender = student_gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}
	
}
