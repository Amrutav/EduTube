package com.fw.domain.service;

import java.util.List;

import com.fw.domain.entity.Course_Master;
import com.fw.domain.entity.Subject;

public interface SubjectService {

	public List<Subject> getSubjectList() throws Exception;

	public List<Subject> getSubjectListByUserId(int userId) throws Exception;

	public boolean addNewSubject(Subject subject) throws Exception;

	public Subject validateSubjectName(String subject_name) throws Exception;

	public boolean updateSubjectDetails(Subject subject) throws Exception;

	public boolean deleteSubject(Subject subject) throws Exception;

	public List<Subject> getSubjectListByName(String subjectName) throws Exception;


}
