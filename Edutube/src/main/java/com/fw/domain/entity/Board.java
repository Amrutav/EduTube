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
@Table(name="board_master")
public class Board {

	@Id
	@GenericGenerator(name = "eduetube", strategy = "increment")
	@GeneratedValue(generator = "eduetube")
	@Column(name="board_id")
	private int board_id;
	@Column(name="board_name")
	private String board_name;
	@Column(name="board_logo")
	private byte[] board_logo;
	@Column(name="board_desc")
	private String board_desc;
	@ManyToOne
	@JoinColumn(name="created_by_user_id")
	private User user;
	public int getBoard_id() {
		return board_id;
	}
	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}
	public String getBoard_name() {
		return board_name;
	}
	public void setBoard_name(String board_name) {
		this.board_name = board_name;
	}
	public byte[] getBoard_logo() {
		return board_logo;
	}
	public void setBoard_logo(byte[] board_logo) {
		this.board_logo = board_logo;
	}
	public String getBoard_desc() {
		return board_desc;
	}
	public void setBoard_desc(String board_desc) {
		this.board_desc = board_desc;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
