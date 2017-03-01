package com.fw.domain.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.fw.dao.MailboxDao;
import com.fw.domain.entity.UserInbox;
import com.fw.domain.entity.UserOutbox;

public class MailboxServiceImpl implements MailboxService {
	
	@Autowired
	MailboxDao mailboxDao;
	
	static final Logger logger = Logger.getLogger(MailboxServiceImpl.class);

	@Override
	public boolean newMailInInbox(UserInbox userInbox) throws Exception {
		// TODO Auto-generated method stub
		try{
			return mailboxDao.newMailInInbox(userInbox);
		}catch(Exception e){
			logger.error("Exception occurs in ", e);
		}
		return false;
	}

	@Override
	public List<UserInbox> getInboxMessages(int user_id) throws Exception {
		// TODO Auto-generated method stub
		try {
			return mailboxDao.getInboxMessages(user_id);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("Exception Occours In",e);
		}
		return new ArrayList<UserInbox>();
	}

	@Override
	public boolean updateMessageStatus(int inbox_id) throws Exception {
		// TODO Auto-generated method stub
		try{
			return mailboxDao.updateMessageStatus(inbox_id);
		} catch(Exception e){
			logger.error("Exception Occours In",e);
		}
		return false;
	}

	@Override
	public boolean newMailInOutbox(UserOutbox userOutbox) throws Exception {
		// TODO Auto-generated method stub
		try{
			return mailboxDao.newMailInOutbox(userOutbox);
		}catch(Exception e){
			logger.error("Exception occurs in ", e);
		}
		return false;
	}

	@Override
	public List<UserOutbox> getOutboxMessages(int user_id) {
		// TODO Auto-generated method stub
		try {
			return mailboxDao.getOutboxMessages(user_id);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("Exception Occours In",e);
		}
		return new ArrayList<UserOutbox>();
	}
	
}