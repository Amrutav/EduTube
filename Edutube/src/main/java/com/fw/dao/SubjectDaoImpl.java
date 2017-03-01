package com.fw.dao;

import java.util.ArrayList;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.fw.domain.entity.Subject;

public class SubjectDaoImpl implements SubjectDao {
	
	@Autowired
	SessionFactory sessionFactory;
	Transaction transaction = null;
	Session session = null;
	
	@Override
	public List<Subject> getSubjectList() throws Exception {
		List<Subject> subjictList = new ArrayList<Subject>();
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Subject.class);
			subjictList = criteria.list();
			session.close();
			System.out.println("dddddddddddddddddddd"+subjictList.size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return subjictList;
	}

	@Override
	public List<Subject> getSubjectListByUserId(int userId) throws Exception {
		// TODO Auto-generated method stub
		List<Subject> getSubjectListbyuserId = new ArrayList<Subject>();
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			String sql = "SELECT * FROM subject_master WHERE created_by_user_id = "+userId;
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(Subject.class);
			getSubjectListbyuserId = query.list();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getSubjectListbyuserId;
	}

	@Override
	public boolean addNewSubject(Subject subject) throws Exception {
		// TODO Auto-generated method stub
		boolean b = false;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(subject);
			transaction.commit();
			session.close();
			b = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public Subject validateSubjectName(String subject_name) throws Exception {
		// TODO Auto-generated method stub
		Subject subject = new Subject();
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(subject.getClass());
			criteria.add(Restrictions.eq("subjectname", subject_name));
			subject = (Subject) criteria.uniqueResult();
			return subject;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return subject;
	}

	@Override
	public boolean updateSubjectDetails(Subject subject) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(subject);
		boolean b = false;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.update(subject);
			transaction.commit();
			session.close();
			b = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public boolean deleteSubject(Subject subject) throws Exception {
		// TODO Auto-generated method stub
		boolean b = false;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.delete(subject);
			transaction.commit();
			session.close();
			b = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public List<Subject> getSubjectListByName(String subjectName)
			throws Exception {
		List<Subject> getSubjectListByname = new ArrayList<Subject>();
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			String sql = "SELECT * FROM subject_master WHERE subject_name like '%"+subjectName+"%'";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(Subject.class);
			getSubjectListByname = query.list();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getSubjectListByname;
	}

}