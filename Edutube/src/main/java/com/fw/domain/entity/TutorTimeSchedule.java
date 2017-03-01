package com.fw.domain.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "tutor_time_schedule")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class TutorTimeSchedule implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GenericGenerator(name = "fwd", strategy = "increment")
	@GeneratedValue(generator = "fwd")
	@Column(name = "tutor_time_schedule_id")
	private int tutorTimeScheduleId;
	
	@Column(name = "schedule_status")
	private String scheduleStatus;
	
	@Column(name = "schedule_start_time")
	private Date scheduleStartTime;
	
	@Transient
	private String scheduleStartTimeInput;
	
	@Column(name = "schedule_end_time")
	private Date scheduleEndTime;
	
	@Transient
	private String scheduleEndTimeInput;
	
	@Column(name = "schedule_date")
	private Date scheduleDate;
	
	@Transient
	private String scheduleDateInput;
	
	@Column(name = "schedule_end_date")
	private Date scheduleEndDate;
	
	@Transient
	private String scheduleEndDateInput;
	
	@Transient
	private String[] weekDaysRecurrence;
	
	@Transient
	private String dailyRecurrence;
	
	public String[] getWeekDaysRecurrence() {
		return weekDaysRecurrence;
	}

	public void setWeekDaysRecurrence(String[] weekDaysRecurrence) {
		this.weekDaysRecurrence = weekDaysRecurrence;
	}

	public String getDailyRecurrence() {
		return dailyRecurrence;
	}

	public void setDailyRecurrence(String dailyRecurrence) {
		this.dailyRecurrence = dailyRecurrence;
	}

	@ManyToOne()
	@JoinColumn(name="tag_tutor_id")
	private Tag_Tutor tagTutor;

	public int getTutorTimeScheduleId() {
		return tutorTimeScheduleId;
	}

	public void setTutorTimeScheduleId(int tutorTimeScheduleId) {
		this.tutorTimeScheduleId = tutorTimeScheduleId;
	}

	public String getScheduleStatus() {
		return scheduleStatus;
	}

	public void setScheduleStatus(String scheduleStatus) {
		this.scheduleStatus = scheduleStatus;
	}

	public Date getScheduleStartTime() {
		return scheduleStartTime;
	}

	public void setScheduleStartTime(Date scheduleStartTime) {
		this.scheduleStartTime = scheduleStartTime;
	}

	public String getScheduleStartTimeInput() {
		return scheduleStartTimeInput;
	}

	public void setScheduleStartTimeInput(String scheduleStartTimeInput) {
		this.scheduleStartTimeInput = scheduleStartTimeInput;
	}

	public Date getScheduleEndTime() {
		return scheduleEndTime;
	}

	public void setScheduleEndTime(Date scheduleEndTime) {
		this.scheduleEndTime = scheduleEndTime;
	}

	public String getScheduleEndTimeInput() {
		return scheduleEndTimeInput;
	}

	public void setScheduleEndTimeInput(String scheduleEndTimeInput) {
		this.scheduleEndTimeInput = scheduleEndTimeInput;
	}

	public Date getScheduleDate() {
		return scheduleDate;
	}

	public void setScheduleDate(Date scheduleDate) {
		this.scheduleDate = scheduleDate;
	}

	public String getScheduleDateInput() {
		return scheduleDateInput;
	}

	public void setScheduleDateInput(String scheduleDateInput) {
		this.scheduleDateInput = scheduleDateInput;
	}

	public Date getScheduleEndDate() {
		return scheduleEndDate;
	}

	public void setScheduleEndDate(Date scheduleEndDate) {
		this.scheduleEndDate = scheduleEndDate;
	}

	public String getScheduleEndDateInput() {
		return scheduleEndDateInput;
	}

	public void setScheduleEndDateInput(String scheduleEndDateInput) {
		this.scheduleEndDateInput = scheduleEndDateInput;
	}

	public Tag_Tutor getTagTutor() {
		return tagTutor;
	}

	public void setTagTutor(Tag_Tutor tagTutor) {
		this.tagTutor = tagTutor;
	} 
	
	

}
