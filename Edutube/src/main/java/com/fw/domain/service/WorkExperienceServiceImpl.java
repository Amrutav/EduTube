package com.fw.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fw.dao.WorkExperienceDao;
import com.fw.domain.entity.WorkExperience;

public class WorkExperienceServiceImpl implements WorkExperienceService {
	
	@Autowired
	WorkExperienceDao workExperienceDao;

	@Override
	public List<WorkExperience> getworkExperienceList() throws Exception {
		// TODO Auto-generated method stub
		return workExperienceDao.getworkExperienceList();
	}

}
