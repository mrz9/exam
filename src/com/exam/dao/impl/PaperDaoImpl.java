package com.exam.dao.impl;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.exam.dao.PaperDao;
import com.exam.model.Paper;
import com.exam.model.Question;
import com.exam.util.DBHelper;

public class PaperDaoImpl implements PaperDao{

	@Override
	public boolean addPaper(Paper paper) {
		// TODO Auto-generated method stub
		if(paper != null){
			String sql = "insert into _paper(ptype,score,ptime,title,note,state,questions,begin_time) values(?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt = DBHelper.getPstmt(sql);
			try {
				pstmt.setInt(1, paper.getPtype());
				pstmt.setInt(2, paper.getScore());
				pstmt.setInt(3, paper.getPtime());
				pstmt.setString(4, paper.getTitle());
				pstmt.setString(5, paper.getNote());
				pstmt.setInt(6, paper.getState());
				pstmt.setString(7, paper.getQuestions());
				pstmt.setString(8, paper.getBegin_time());
				if(pstmt.executeUpdate()>0){
					return true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}
		return false;
	}

	@Override
	public boolean updatePaper(Paper paper) {
		// TODO Auto-generated method stub
		if(paper != null){
			String sql = "update _paper set ptype = ?,score = ?,ptime = ?,title = ?,note = ?,state = ?,questions = ?,begin_time = ? where id = ?";
			PreparedStatement pstmt = DBHelper.getPstmt(sql);
			try {
				pstmt.setInt(1, paper.getPtype());
				pstmt.setInt(2, paper.getScore());
				pstmt.setInt(3, paper.getPtime());
				pstmt.setString(4, paper.getTitle());
				pstmt.setString(5, paper.getNote());
				pstmt.setInt(6, paper.getState());
				pstmt.setString(7, paper.getQuestions());
				pstmt.setString(8, paper.getBegin_time());
				pstmt.setInt(9, paper.getId());
				if(pstmt.executeUpdate()>0){
					return true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}
		return false;
	}

	@Override
	public boolean deletePaper(Paper paper) {
		// TODO Auto-generated method stub
		if(paper != null){
			String sql = "delete from _paper where id = ?";
			PreparedStatement pstmt = DBHelper.getPstmt(sql);
			try {
				pstmt.setInt(1, paper.getId());
				if(pstmt.executeUpdate()>0){
					return true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}
		return false;
	}

	@Override
	public List<Paper> getLists() {
		// TODO Auto-generated method stub
		List<Paper> list = null;
		String sql = "select * from _paper";
		PreparedStatement pstmt = DBHelper.getPstmt(sql);
		try {
			ResultSet rs = pstmt.executeQuery();
			list = new ArrayList<Paper>();
			while(rs.next()){
				Paper paper = new Paper();
				paper.setId(rs.getInt("id"));
				paper.setPtype(rs.getInt("ptype"));
				paper.setScore(rs.getInt("score"));
				paper.setPtime(rs.getInt("ptime"));
				paper.setTitle(rs.getString("title"));
				paper.setNote(rs.getString("note"));
				paper.setState(rs.getInt("state"));
				paper.setQuestions(rs.getString("questions"));
				paper.setBegin_time(rs.getString("begin_time"));
				list.add(paper);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Paper> getListsByType(int type) {
		// TODO Auto-generated method stub
		List<Paper> list = null;
		String sql = "select * from _paper where ptype=?";
		PreparedStatement pstmt = DBHelper.getPstmt(sql);
		try {
			pstmt.setInt(1, type);
			ResultSet rs = pstmt.executeQuery();
			list = new ArrayList<Paper>();
			while(rs.next()){
				Paper paper = new Paper();
				paper.setId(rs.getInt("id"));
				paper.setPtype(rs.getInt("ptype"));
				paper.setScore(rs.getInt("score"));
				paper.setPtime(rs.getInt("ptime"));
				paper.setTitle(rs.getString("title"));
				paper.setNote(rs.getString("note"));
				paper.setState(rs.getInt("state"));
				paper.setQuestions(rs.getString("questions"));
				paper.setBegin_time(rs.getString("begin_time"));
				list.add(paper);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Paper> getListByState(int state) {
		// TODO Auto-generated method stub
		List<Paper> list = null;
		String sql = "select * from _paper where state=?";
		PreparedStatement pstmt = DBHelper.getPstmt(sql);
		try {
			pstmt.setInt(1, state);
			ResultSet rs = pstmt.executeQuery();
			list = new ArrayList<Paper>();
			while(rs.next()){
				Paper paper = new Paper();
				paper.setId(rs.getInt("id"));
				paper.setPtype(rs.getInt("ptype"));
				paper.setScore(rs.getInt("score"));
				paper.setPtime(rs.getInt("ptime"));
				paper.setTitle(rs.getString("title"));
				paper.setNote(rs.getString("note"));
				paper.setState(rs.getInt("state"));
				paper.setQuestions(rs.getString("questions"));
				paper.setBegin_time(rs.getString("begin_time"));
				list.add(paper);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Paper getPaperById(int id) {
		Paper paper = null;
		String sql = "select * from _paper where id=?";
		PreparedStatement pstmt = DBHelper.getPstmt(sql);
		try {
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				paper = new Paper();
				paper.setId(rs.getInt("id"));
				paper.setPtype(rs.getInt("ptype"));
				paper.setScore(rs.getInt("score"));
				paper.setPtime(rs.getInt("ptime"));
				paper.setTitle(rs.getString("title"));
				paper.setNote(rs.getString("note"));
				paper.setState(rs.getInt("state"));
				paper.setQuestions(rs.getString("questions"));
				paper.setBegin_time(rs.getString("begin_time"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return paper;
	}

	@Override
	public boolean saveAnwser(int uid, int paperid, String answer) {
		// TODO Auto-generated method stub
		if(uid != 0 && paperid != 0){
			String sql = "insert into _answer(uid,paperid,answer) values(?,?,?)";
			PreparedStatement pstmt = DBHelper.getPstmt(sql);
			try {
				pstmt.setInt(1, uid);
				pstmt.setInt(2, paperid);
				pstmt.setString(3, answer);
				if(pstmt.executeUpdate()>0){
					return true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}
		return false;
	}

}
