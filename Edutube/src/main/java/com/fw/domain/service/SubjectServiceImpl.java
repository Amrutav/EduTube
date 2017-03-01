package com.fw.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fw.dao.SubjectDao;
import com.fw.domain.entity.Course_Master;
import com.fw.domain.entity.Subject;

public class SubjectServiceImpl implements SubjectService {
	
	@Autowired
	SubjectDao subjectDao;

	@Override
	public List<Subject> getSubjectList()throws Exception {
		// TODO Auto-generated method stub
		return subjectDao.getSubjectList();
	}

	@Override
	public List<Subject> getSubjectListByUserId(int userId) throws Exception {
		// TODO Auto-generated method stub
		return subjectDao.getSubjectListByUserId(userId);
	}

	@Override
	public boolean addNewSubject(Subject subject) throws Exception {
		// TODO Auto-generated method stub
		return subjectDao.addNewSubject(subject);
	}

	@Override
	public Subject validateSubjectName(String subject_name) throws Exception {
		// TODO Auto-generated method stub
		try {
			return subjectDao.validateSubjectName(subject_name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Subject();
	}

	@Override
	public boolean updateSubjectDetails(Subject subject) throws Exception {
		// TODO Auto-generated method stub
		return subjectDao.updateSubjectDetails(subject);
	}

	@Override
	public boolean deleteSubject(Subject subject) throws Exception {
		// TODO Auto-generated method stub
		return subjectDao.deleteSubject(subject);
	}

	@Override
	public List<Subject> getSubjectListByName(String subjectName)
			throws Exception {
		return subjectDao.getSubjectListByName(subjectName);
	}

}
