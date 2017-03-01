package com.fw.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.fw.domain.entity.Education;
import com.fw.domain.entity.WorkExperience;

public class EducationDaoImpl implements EducationDao {
	
	@Autowired
	SessionFactory sessionFactory;

	Session session = null;


	@Override
	public List<Education> geteducationList() {
		List<Education> educationList = new ArrayList<Education>();
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Education.class);
			educationList = criteria.list();
			session.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return educationList;
	}

}
