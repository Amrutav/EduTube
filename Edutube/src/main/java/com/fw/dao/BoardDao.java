package com.fw.dao;

import java.util.List;

import org.hibernate.HibernateException;

import com.fw.domain.entity.Board;

public interface BoardDao {

		public List<Board> getBoardList() throws Exception;

		public List<Board> getBoardListByUserId(int userId) throws Exception;

		public boolean addnewBoard(Board board) throws HibernateException, Exception;

		public Board validateBoardName(String board_name) throws Exception;

		public boolean updateBoardDetails(Board board) throws Exception;

		public boolean deleteBoard(Board board) throws Exception;

		public List<Board> getBoardListByName(String boardName) throws Exception;
}
