package com.fw.domain.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "education_mst")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Education implements Serializable {
	
	@Id
	@GenericGenerator(name = "fwd", strategy = "increment")
	@GeneratedValue(generator = "fwd")
	@Column(name = "education_mst_id")
	private int educationMasterId;

	@Size(min = 1 , max = 3)
	@Column(name = "education_mst_cd")
	private String educationMasterCode;
	
	@Size(min = 2, max = 100)
	@Column(name = "education_mst_desc")
	private String educationMasterDesc;
	
	@Size(min = 2, max = 45)
	@Column(name = "education_mst_loc")
	private String educationMasterLocation;
	
	@Column(name = "education_mst_logo")
	private byte[] educationMasterLogo;
	
	@Past (message="Education Master Created date cannot be future date")
	@Column(name = "education_created_dt")
	private Date educationMasterCreatedDate;
	
	public int getEducationMasterId() {
		return educationMasterId;
	}

	public void setEducationMasterId(int educationMasterId) {
		this.educationMasterId = educationMasterId;
	}

	public String getEducationMasterCode() {
		return educationMasterCode;
	}

	public void setEducationMasterCode(String educationMasterCode) {
		this.educationMasterCode = educationMasterCode;
	}

	public String getEducationMasterDesc() {
		return educationMasterDesc;
	}

	public void setEducationMasterDesc(String educationMasterDesc) {
		this.educationMasterDesc = educationMasterDesc;
	}

	public String getEducationMasterLocation() {
		return educationMasterLocation;
	}

	public void setEducationMasterLocation(String educationMasterLocation) {
		this.educationMasterLocation = educationMasterLocation;
	}

	public byte[] getEducationMasterLogo() {
		return educationMasterLogo;
	}

	public void setEducationMasterLogo(byte[] educationMasterLogo) {
		this.educationMasterLogo = educationMasterLogo;
	}

	public Date getEducationMasterCreatedDate() {
		return educationMasterCreatedDate;
	}

	public void setEducationMasterCreatedDate(Date educationMasterCreatedDate) {
		this.educationMasterCreatedDate = educationMasterCreatedDate;
	}

}
