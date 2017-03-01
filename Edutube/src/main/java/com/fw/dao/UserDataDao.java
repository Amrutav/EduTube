package com.fw.dao;

import java.util.List;

import org.hibernate.HibernateException;

import com.fw.domain.entity.Contact;
import com.fw.domain.entity.EducationWorkProfile;
import com.fw.domain.entity.TutorStudentSubject;
import com.fw.domain.entity.User;

public interface UserDataDao {

	public boolean addUserEntity(User user)throws Exception;

	public User getUserDetails(User user)throws HibernateException , Exception;

	public User getUserDetailsByUserid(User user);

	public boolean updateUserContact(Contact contact)throws Exception;

	public boolean updateLoginDetails(User user)throws Exception;

	public boolean updateUserType(User user)throws HibernateException , Exception;

	public boolean updateUserLogoutDetails(User user)throws HibernateException , Exception;

	public User getUserDetailsByUsername(String username)throws HibernateException , Exception;

	public Contact getUserContact(int userId)throws HibernateException , Exception;

	public List<EducationWorkProfile> getUserEducationWorkProfile(int userId)throws HibernateException , Exception;

	public boolean updateUserEducation(List<EducationWorkProfile> educationList)throws HibernateException , Exception;

	public boolean updateUserWorkExpProfile(List<EducationWorkProfile> workExpList)throws HibernateException , Exception;
	
	public User getUserByEmailId(String email)throws HibernateException , Exception;
	
	public void updateUserSocialPlugin(User user)throws Exception;
	
	public User getUserDetailsByEmail(String email)throws HibernateException , Exception;

	public boolean updateTermsConditions(User user) throws Exception;

	public String createToken(User user) throws Exception;

	public User activateAccount(String token)throws Exception;
	
}
