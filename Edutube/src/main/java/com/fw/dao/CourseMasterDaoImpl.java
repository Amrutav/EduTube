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

import com.fw.domain.entity.Board;
import com.fw.domain.entity.Course_Master;
import com.fw.domain.entity.User;

public class CourseMasterDaoImpl implements CourseMasterDao {
	
	@Autowired
	SessionFactory sessionfactory;
	Session session=null;
	Transaction transaction = null;
	
	@Override
	public List<Course_Master> getCourseList() throws Exception {
		List<Course_Master> courseList = new ArrayList<Course_Master>();
		try {
			session=sessionfactory.openSession();
			Criteria criteria=session.createCriteria(Course_Master.class);
			courseList=criteria.list();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return courseList;
	}

	@Override
	public List<Course_Master> getCourseListByUserId(int userId)
			throws Exception {
		// TODO Auto-generated method stub
		List<Course_Master> getCourseListbyuserId = new ArrayList<Course_Master>();
		try {
			session = sessionfactory.openSession();
			transaction = session.beginTransaction();
			String sql = "SELECT * FROM course_master WHERE created_by_user_id = "+userId;
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(Course_Master.class);
			getCourseListbyuserId = query.list();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getCourseListbyuserId;
	}

	@Override
	public boolean addNewCourse(Course_Master course) throws Exception {
		// TODO Auto-generated method stub
		boolean b = false;
		try {
			session = sessionfactory.openSession();
			transaction = session.beginTransaction();
			session.save(course);
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
	public Course_Master validateCourseName(String course_name)
			throws Exception {
		// TODO Auto-generated method stub
		Course_Master course = new Course_Master();
		try {
			session = sessionfactory.openSession();
			Criteria criteria = session.createCriteria(course.getClass());
			criteria.add(Restrictions.eq("course_name", course_name));
			course = (Course_Master) criteria.uniqueResult();
			return course;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return course;
	}

	@Override
	public boolean updateCourseDetails(Course_Master course) throws Exception {
		// TODO Auto-generated method stub
		boolean b = false;
		try {
			session = sessionfactory.openSession();
			transaction = session.beginTransaction();
			session.update(course);
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
	public boolean deleteCourse(Course_Master course) throws Exception {
		// TODO Auto-generated method stub
		boolean b = false;
		try {
			session = sessionfactory.openSession();
			transaction = session.beginTransaction();
			session.delete(course);
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
	public List<Course_Master> getCourseListByName(String courseName)
			throws Exception {
		// TODO Auto-generated method stub
		List<Course_Master> getCourseListByname = new ArrayList<Course_Master>();
		try {
			session = sessionfactory.openSession();
			transaction = session.beginTransaction();
			String sql = "SELECT * FROM course_master WHERE course_name like '%"+courseName+"%'";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(Course_Master.class);
			getCourseListByname = query.list();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getCourseListByname;
	}

}