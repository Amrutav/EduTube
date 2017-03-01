package com.fw.domain.service;

import java.util.List;

import org.hibernate.HibernateException;

import com.fw.domain.entity.UserInbox;
import com.fw.domain.entity.UserOutbox;

public interface MailboxService {
	
	public boolean newMailInInbox(UserInbox userInbox)throws Exception;

	public List<UserInbox> getInboxMessages(int user_id) throws HibernateException,Exception;

	public boolean updateMessageStatus(int inbox_id) throws Exception;

	public boolean newMailInOutbox(UserOutbox userOutbox)throws Exception;

	public List<UserOutbox> getOutboxMessages(int user_id) throws Exception;
}
