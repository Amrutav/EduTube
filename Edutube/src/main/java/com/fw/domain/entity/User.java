package com.fw.domain.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Email;

@Entity
@Table(name = "user")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class User implements Serializable {

	@Id
	@GenericGenerator(name = "fwd", strategy = "increment")
	@GeneratedValue(generator = "fwd")
	@Column(name = "user_id")
	private int userId;

	//@Size(min = 2 , max = 45)
	@Column(name = "user_name")
	private String username;
	//@Size(min = 6, max = 15)
	@Column(name = "user_password")
	private String password;
	
	//@Size(min = 2, max = 12)
	@Column(name = "user_type")
	private String userType;
	
	@Column(name = "user_seq_question")
	private String userSeqQuestion;
	
	@Column(name = "user_seq_ans")
	private String userSeqAns;
	
	//@Size(min = 2, max = 45)
	@Column(name = "user_role")
	private String userRole;
	
	@Past (message="Account created date cannot be future date")
	@Column(name = "user_acct_created_dt")
	private Date userAccountCreatedDate;
	
	@Past (message="Account modified date cannot be future date")
	@Column(name = "user_acc_modified_dt")
	private Date userAccountModifiedDate;
	
	//@Size(min = 2, max = 45)
	@Email
	@Column(name = "user_email_id")
	private String email;
	
	//@Size(min = 2, max = 4)
	@Column(name = "user_regn_type")
	private String registrationType;
	
	//@Past (message="Login time cannot be future time")
	@Column(name = "user__last_login_time")
	private Date LastLoginTime;
	
	//@Past (message="Logout time cannot be future time")
	@Column(name = "user_last_logout_time")
	private Date LastLogoutTime;
	
	//@Size(min = 2, max = 45)
	@Column(name = "user_first_name")
	private String userFirstName;
		
	//@Size(min = 2, max = 45)
	@Column(name = "user_last_name")
	private String userLastName;
	
	@Column(name = "user_account_flag")
	private int userAccountFlag;

	public int getUserAccountFlag() {
		return userAccountFlag;
	}

	public void setUserAccountFlag(int userAccountFlag) {
		this.userAccountFlag = userAccountFlag;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserSeqQuestion() {
		return userSeqQuestion;
	}

	public void setUserSeqQuestion(String userSeqQuestion) {
		this.userSeqQuestion = userSeqQuestion;
	}

	public String getUserSeqAns() {
		return userSeqAns;
	}

	public void setUserSeqAns(String userSeqAns) {
		this.userSeqAns = userSeqAns;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public Date getUserAccountCreatedDate() {
		return userAccountCreatedDate;
	}

	public void setUserAccountCreatedDate(Date userAccountCreatedDate) {
		this.userAccountCreatedDate = userAccountCreatedDate;
	}

	public Date getUserAccountModifiedDate() {
		return userAccountModifiedDate;
	}

	public void setUserAccountModifiedDate(Date userAccountModifiedDate) {
		this.userAccountModifiedDate = userAccountModifiedDate;
	}

	public String getRegistrationType() {
		return registrationType;
	}

	public void setRegistrationType(String registrationType) {
		this.registrationType = registrationType;
	}

	public Date getLastLoginTime() {
		return LastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		LastLoginTime = lastLoginTime;
	}

	public Date getLastLogoutTime() {
		return LastLogoutTime;
	}

	public void setLastLogoutTime(Date lastLogoutTime) {
		LastLogoutTime = lastLogoutTime;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private static final long serialVersionUID = 1L;
	
	@Column(name="facebook_id")
	private String facebookId;
	
	@Column(name="google_id")
	private String googleId;
	
	@Column(name="twitter_id")
	private String twitterId;

	public String getFacebookId() {
		return facebookId;
	}

	public void setFacebookId(String facebookId) {
		this.facebookId = facebookId;
	}

	public String getGoogleId() {
		return googleId;
	}

	public void setGoogleId(String googleId) {
		this.googleId = googleId;
	}

	public String getTwitterId() {
		return twitterId;
	}

	public void setTwitterId(String twitterId) {
		this.twitterId = twitterId;
	}
	
	@Column(name="user_terms_condn")
	private int userTermsCondn;

	public int getUserTermsCondn() {
		return userTermsCondn;
	}

	public void setUserTermsCondn(int userTermsCondn) {
		this.userTermsCondn = userTermsCondn;
	}
}