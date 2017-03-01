package com.fw.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fw.dao.EducationDao;
import com.fw.domain.entity.Education;

public class EducationServiceImpl implements EducationService {
	
	@Autowired
	EducationDao educationDao;

	@Override
	public List<Education> geteducationList()throws Exception {
		// TODO Auto-generated method stub
		return educationDao.geteducationList();
	}

}
