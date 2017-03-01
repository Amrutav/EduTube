package com.fw.domain.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;

import com.fw.dao.BoardDao;
import com.fw.domain.entity.Board;

public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardDao boarddao;
	@Override
	public List<Board> getBoardList() throws Exception {
		// TODO Auto-generated method stub
		return boarddao.getBoardList();
	}
	@Override
	public List<Board> getBoardListByUserId(int userId) throws Exception {
		// TODO Auto-generated method stub
		return boarddao.getBoardListByUserId(userId);
	}
	@Override
	public boolean addNewBoard(Board board) throws HibernateException, Exception {
		// TODO Auto-generated method stub
		return boarddao.addnewBoard(board);
	}
	@Override
	public Board validateBoardName(String board_name) throws Exception {
		// TODO Auto-generated method stub
		try {
			return boarddao.validateBoardName(board_name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Board();
	}
	@Override
	public boolean updateBoardDetails(Board board) throws Exception {
		// TODO Auto-generated method stub
		return boarddao.updateBoardDetails(board);
	}
	@Override
	public boolean deleteBoard(Board board) throws Exception {
		// TODO Auto-generated method stub
		return boarddao.deleteBoard(board);
	}
	@Override
	public List<Board> getBoardListByName(String boardName) throws Exception {
		// TODO Auto-generated method stub
		return boarddao.getBoardListByName(boardName);
	}

}
