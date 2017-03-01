package com.fw.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.fw.domain.entity.Subject;
import com.fw.domain.entity.WorkExperience;

public class WorkExperienceDaoImpl implements WorkExperienceDao {
	
	@Autowired
	SessionFactory sessionFactory;

	Session session = null;

	@Override
	public List<WorkExperience> getworkExperienceList() throws Exception {
		List<WorkExperience> workExperienceList = new ArrayList<WorkExperience>();
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(WorkExperience.class);
			workExperienceList = criteria.list();
			session.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return workExperienceList;
	}

}
