package com.fw.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.object.SqlQuery;

import com.fw.domain.entity.Board;
import com.fw.domain.entity.Course_Master;
import com.fw.domain.entity.Subject;

public class BoardDaoImpl implements BoardDao {
	
	@Autowired
	SessionFactory sessionfactory;
	Session session = null;
	Transaction transaction = null;
	
	@Override
	public List<Board> getBoardList() throws Exception {
			List<Board> boardList= new ArrayList<Board>();
			try{
				session = sessionfactory.openSession();
				Criteria criteria = session.createCriteria(Board.class);
				boardList = criteria.list();
				session.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		return boardList;
	}

	@Override
	public List<Board> getBoardListByUserId(int userId) throws Exception{
		// TODO Auto-generated method stub
		List<Board> getBoardListbyuserId = new ArrayList<Board>();
		try {
			session = sessionfactory.openSession();
			transaction = session.beginTransaction();
			String sql = "SELECT * FROM board_master WHERE created_by_user_id = "+userId;
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(Board.class);
			getBoardListbyuserId = query.list();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getBoardListbyuserId;
	}

	@Override
	public boolean addnewBoard(Board board) {
		// TODO Auto-generated method stub
		boolean b = false;
		try {
			session = sessionfactory.openSession();
			transaction = session.beginTransaction();
			session.save(board);
			transaction.commit();
			session.close();
			b = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public Board validateBoardName(String board_name) throws Exception {
		// TODO Auto-generated method stub
		Board board = new Board();
		try {
			session = sessionfactory.openSession();
			Criteria criteria = session.createCriteria(board.getClass());
			criteria.add(Restrictions.eq("board_name", board_name));
			board = (Board) criteria.uniqueResult();
			return board;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return board;
	}

	@Override
	public boolean updateBoardDetails(Board board) throws Exception {
		// TODO Auto-generated method stub
		boolean b = false;
		try {
			session = sessionfactory.openSession();
			transaction = session.beginTransaction();
			session.update(board);
			transaction.commit();
			session.close();
			b = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public boolean deleteBoard(Board board) throws Exception {
		// TODO Auto-generated method stub
		boolean b = false;
		try {
			session = sessionfactory.openSession();
			transaction = session.beginTransaction();
			session.delete(board);
			transaction.commit();
			session.close();
			b = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public List<Board> getBoardListByName(String boardName) throws Exception {
		// TODO Auto-generated method stub
		List<Board> getBoardListByname = new ArrayList<Board>();
		try {
			session = sessionfactory.openSession();
			transaction = session.beginTransaction();
			String sql = "SELECT * FROM board_master WHERE board_name like '%"+boardName+"%'";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(Board.class);
			getBoardListByname = query.list();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getBoardListByname;
	}

}
