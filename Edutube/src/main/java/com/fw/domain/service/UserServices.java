package com.fw.domain.service;

import java.util.List;

import org.hibernate.HibernateException;

import com.fw.domain.entity.Contact;
import com.fw.domain.entity.EducationWorkProfile;
import com.fw.domain.entity.TutorStudentSubject;
import com.fw.domain.entity.User;

public interface UserServices {
	public boolean addUser(User user) throws Exception;

	public User getAuthenticateUser(User user) throws Exception;

	public User getUserDetails(User user) throws Exception;

	public User getUserDetailsByUserid(User user);

	public boolean updateUserContact(Contact contact) throws Exception;

	public boolean updateLoginDetails(User user) throws Exception;

	public boolean updateUserType(User user) throws Exception;

	public boolean updateUserLogoutDetails(User user) throws Exception;

	public User getUserDetailsByUsername(String username) throws Exception;

	public Contact getUserContact(int userId) throws Exception;

	public List<EducationWorkProfile> getUserEducationWorkProfile(int userId) throws Exception;

	public boolean updateUserEducation(List<EducationWorkProfile> educationList) throws Exception;

	public boolean updateUserWorkExpProfile(List<EducationWorkProfile> workExpList) throws Exception;
	
	public User getUserByEmailId(String email)throws HibernateException , Exception;
	
	public void updateUserSocialPlugin(User user)throws Exception;
	
	public User getUserDetailsByEmail(String email)throws HibernateException , Exception;

	public boolean updateTermsConditions(User user) throws Exception;

	public String createToken(User user) throws Exception;

	public User activateAccount(String token) throws Exception;

}
