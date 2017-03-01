package com.fw.domain.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="user_sent_box")
public class UserOutbox {
	
	@Id
	@GenericGenerator(name="edutube", strategy="increment")
	@GeneratedValue(generator = "edutube")
	@Column(name="sent_message_id")
	private int sent_message_id;
	@Column(name="sent_message_subject")
	private String sent_message_subject;
	@Column(name="sent_message_descripption")
	private String sent_message_description;
	@Column(name="to_email")
	private String to_email;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="inbox_id")
	private UserInbox userInbox;
	@Column(name="send_time")
	private Date send_time;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;
	
	public int getSent_message_id() {
		return sent_message_id;
	}
	public void setSent_message_id(int sent_message_id) {
		this.sent_message_id = sent_message_id;
	}
	public String getSent_message_subject() {
		return sent_message_subject;
	}
	public void setSent_message_subject(String sent_message_subject) {
		this.sent_message_subject = sent_message_subject;
	}
	public String getSent_message_description() {
		return sent_message_description;
	}
	public void setSent_message_description(String sent_message_description) {
		this.sent_message_description = sent_message_description;
	}
	public String getTo_email() {
		return to_email;
	}
	public void setTo_email(String to_email) {
		this.to_email = to_email;
	}
	public UserInbox getUserInbox() {
		return userInbox;
	}
	public void setUserInbox(UserInbox userInbox) {
		this.userInbox = userInbox;
	}
	public Date getSend_time() {
		return send_time;
	}
	public void setSend_time(Date send_time) {
		this.send_time = send_time;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
