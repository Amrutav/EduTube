package com.fw.domain.entity;

import java.util.Map;

public class MailboxJsonResponse {
	
	private String status;
	private Map<String, String> errorsMap;
	private User user;
	private UserInbox userInbox;
	private UserOutbox userOutbox;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Map<String, String> getErrorsMap() {
		return errorsMap;
	}
	public void setErrorsMap(Map<String, String> errorsMap) {
		this.errorsMap = errorsMap;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public UserInbox getUserInbox() {
		return userInbox;
	}
	public void setUserInbox(UserInbox userInbox) {
		this.userInbox = userInbox;
	}
	public UserOutbox getUserOutbox() {
		return userOutbox;
	}
	public void setUserOutbox(UserOutbox userOutbox) {
		this.userOutbox = userOutbox;
	}
	
}
