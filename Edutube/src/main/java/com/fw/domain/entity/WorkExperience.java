package com.fw.domain.entity;

import java.io.File;
import java.io.Serializable;
import java.text.SimpleDateFormat;
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
import org.hibernate.validator.constraints.Email;

@Entity
@Table(name = "work_exp_mst")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class WorkExperience implements Serializable {
	
	@Id
	@GenericGenerator(name = "fwd", strategy = "increment")
	@GeneratedValue(generator = "fwd")
	@Column(name = "work_mst_id")
	private int workMasterId;

	@Size(min = 2 , max = 45)
	@Column(name = "work_mst_cd")
	private String workMasterCode;
	
	@Size(min = 2, max = 100)
	@Column(name = "work_mst_name")
	private String workMasterName;
	
	@Size(min = 2, max = 200)
	@Column(name = "work_mst_loc")
	private String workMasterLocation;
	
	@Column(name = "work_mst_logo")
	private byte[] workMasterLogo;
	
	@Past (message="Work Master Created date cannot be future date")
	@Column(name = "work_mst_created_dt")
	private Date workMasterCreatedDate;
	
	public int getWorkMasterId() {
		return workMasterId;
	}

	public void setWorkMasterId(int workMasterId) {
		this.workMasterId = workMasterId;
	}

	public String getWorkMasterCode() {
		return workMasterCode;
	}

	public void setWorkMasterCode(String workMasterCode) {
		this.workMasterCode = workMasterCode;
	}

	public String getWorkMasterName() {
		return workMasterName;
	}

	public void setWorkMasterName(String workMasterName) {
		this.workMasterName = workMasterName;
	}

	public String getWorkMasterLocation() {
		return workMasterLocation;
	}

	public void setWorkMasterLocation(String workMasterLocation) {
		this.workMasterLocation = workMasterLocation;
	}

//	public File getWorkMasterLogo() {
//		return workMasterLogo;
//	}
//
//	public void setWorkMasterLogo(File workMasterLogo) {
//		this.workMasterLogo = workMasterLogo;
//	}

	public Date getWorkMasterCreatedDate() {
		return workMasterCreatedDate;
	}

	public byte[] getWorkMasterLogo() {
		return workMasterLogo;
	}

	public void setWorkMasterLogo(byte[] workMasterLogo) {
		this.workMasterLogo = workMasterLogo;
	}

	public void setWorkMasterCreatedDate(Date workMasterCreatedDate) {
		this.workMasterCreatedDate = workMasterCreatedDate;
	}

	public static Date toDateConversion(String dob) {
		String pattern = "dd/MM/yyyy";
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		Date formattedDob=null;

		try {
			formattedDob = formatter.parse(dob);
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return formattedDob;
	}


}
