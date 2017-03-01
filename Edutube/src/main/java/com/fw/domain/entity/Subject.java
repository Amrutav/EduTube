package com.fw.domain.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Email;



@Entity
@Table(name = "subject_master")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Subject implements Serializable {

		@Id
		@GenericGenerator(name = "eduetube", strategy = "increment")
		@GeneratedValue(generator = "eduetube")
		@Column(name = "subject_id")
		private int subjectId;
		@Column(name = "subject_name")
		private String subjectname;
		@Column(name = "subject_description")
		private String subjectdescription;
		@ManyToOne
		@JoinColumn(name="created_by_user_id")
		private User user;
		
		public int getSubjectId() {
			return subjectId;
		}
		public void setSubjectId(int subjectId) {
			this.subjectId = subjectId;
		}
		public String getSubjectname() {
			return subjectname;
		}
		public void setSubjectname(String subjectname) {
			this.subjectname = subjectname;
		}
		public String getSubjectdescription() {
			return subjectdescription;
		}
		public void setSubjectdescription(String subjectdescription) {
			this.subjectdescription = subjectdescription;
		}
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
		
		
}
