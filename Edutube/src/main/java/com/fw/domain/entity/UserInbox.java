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
@Table(name="user_inbox")
public class UserInbox {

	@Id
	@GenericGenerator(name="edutube", strategy="increment")
	@GeneratedValue(generator="edutube")
	@Column(name="inbox_id")
	private int inbox_id;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="user_id")
	private User user;
	@Column(name="inbox_message_subject")
	private String inbox_message_subject;
	@Column(name="inbox_message_description")
	private String inbox_message_description;
	@Column(name="from_email")
	private String from_email;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="sent_message_id")
	private UserOutbox userOutBox;
	@Column(name="receive_time")
	private Date receive_time;
	@Column(name="reply_status")
	private int reply_status;
	@Column(name="view_status")
	private int view_status;
	
	public int getInbox_id() {
		return inbox_id;
	}
	public void setInbox_id(int inbox_id) {
		this.inbox_id = inbox_id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getInbox_message_subject() {
		return inbox_message_subject;
	}
	public void setInbox_message_subject(String inbox_message_subject) {
		this.inbox_message_subject = inbox_message_subject;
	}
	public String getInbox_message_description() {
		return inbox_message_description;
	}
	public void setInbox_message_description(String inbox_message_description) {
		this.inbox_message_description = inbox_message_description;
	}
	public String getFrom_email() {
		return from_email;
	}
	public void setFrom_email(String from_email) {
		this.from_email = from_email;
	}
	public UserOutbox getUserOutBox() {
		return userOutBox;
	}
	public void setUserOutBox(UserOutbox userOutBox) {
		this.userOutBox = userOutBox;
	}
	public Date getReceive_time() {
		return receive_time;
	}
	public void setReceive_time(Date receive_time) {
		this.receive_time = receive_time;
	}
	public int getReply_status() {
		return reply_status;
	}
	public void setReply_status(int reply_status) {
		this.reply_status = reply_status;
	}
	public int getView_status() {
		return view_status;
	}
	public void setView_status(int view_status) {
		this.view_status = view_status;
	}
	
}
