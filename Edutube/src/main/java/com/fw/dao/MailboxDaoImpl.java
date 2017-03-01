package com.fw.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.fw.domain.entity.EducationWorkProfile;
import com.fw.domain.entity.User;
import com.fw.domain.entity.UserInbox;
import com.fw.domain.entity.UserOutbox;
import com.fw.domain.service.MailboxServiceImpl;

public class MailboxDaoImpl implements MailboxDao {
	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction txn = null;
	static final Logger logger = Logger.getLogger(MailboxServiceImpl.class);
	
	@Override
	public boolean newMailInInbox(UserInbox userInbox) throws Exception {
		// TODO Auto-generated method stub
		session = sessionFactory.openSession();
		txn = session.beginTransaction();
		session.save(userInbox);
		txn.commit();
		session.close();

		return false;
	}

	@Override
	public List<UserInbox> getInboxMessages(int user_id) throws Exception {
		// TODO Auto-generated method stub
		List<UserInbox> messageList = new ArrayList<UserInbox>();
		try {
			session = sessionFactory.openSession();
			SQLQuery query = session.createSQLQuery("SELECT * FROM user_inbox WHERE user_id = "+user_id);
			query.addEntity(UserInbox.class);
			messageList = query.list();
			return messageList;
			
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("Exception Occours In",e);
		} finally{
			session.close();
		}
		return null;
	}

	@Override
	public boolean updateMessageStatus(int inbox_id) throws Exception {
		// TODO Auto-generated method stub
		boolean b = false;
		try {
			session = sessionFactory.openSession();
			txn = session.beginTransaction();
			UserInbox existingUserInbox = (UserInbox)session.get(UserInbox.class, inbox_id);
			existingUserInbox.setView_status(1);
			session.update(existingUserInbox);
			txn.commit();
			b = true;	
		} catch(Exception e){
			logger.error("Exception Occours In",e);
		}
		return b;
	}

	@Override
	public boolean newMailInOutbox(UserOutbox userOutbox) throws Exception {
		// TODO Auto-generated method stub
		session = sessionFactory.openSession();
		txn = session.beginTransaction();
		if(userOutbox.getUserInbox().getInbox_id()<1){
		session.save(userOutbox);
		}else{
			UserInbox inbox = (UserInbox)session.get(UserInbox.class,userOutbox.getUserInbox().getInbox_id());
			inbox.setReply_status(1);
			userOutbox.setUserInbox(inbox);
			session.saveOrUpdate(userOutbox);
		}
		txn.commit();
		session.close();
		return false;
	}

	@Override
	public List<UserOutbox> getOutboxMessages(int user_id) throws Exception {
		// TODO Auto-generated method stub
		List<UserOutbox> messageList = new ArrayList<UserOutbox>();
		try {
			session = sessionFactory.openSession();
			SQLQuery query = session.createSQLQuery("SELECT * FROM user_sent_box WHERE user_id = "+user_id);
			query.addEntity(UserInbox.class);
			messageList = query.list();
			return messageList;
			
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("Exception Occours In",e);
		} finally{
			session.close();
		}
		return null;
	}

}
