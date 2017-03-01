package com.fw.domain.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="tag_tutor")
public class Tag_Tutor {
	@Id
	@GenericGenerator(name = "eduetube", strategy = "increment")
	@GeneratedValue(generator = "eduetube")
	@Column(name="tag_tutor_id")
	private int tag_tutor_id;

	public int getTag_tutor_id() {
		return tag_tutor_id;
	}
	public void setTag_tutor_id(int tag_tutor_id) {
		this.tag_tutor_id = tag_tutor_id;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="board_master_id")
	private Board board;
	public Board getBoard() {
		return board;
	}
	public void setBoard(Board board) {
		this.board = board;
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="course_master_id")
	private Course_Master course;
	public Course_Master getCourse() {
		return course;
	}
	public void setCourse(Course_Master course) {
		this.course = course;
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="subject_master_id")
	private Subject subject;
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="tutor_id")
	private Tutor tutor;
	public Tutor getTutor() {
		return tutor;
	}
	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}
	
}