package com.exam.dao.impl;

import java.lang.reflect.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

import com.exam.dao.QuestionDao;
import com.exam.model.Point;
import com.exam.model.Question;
import com.exam.util.DBHelper;

public class QuestionDaoImpl implements QuestionDao{

	@Override
	public boolean addQuestion(Question que) {
		// TODO Auto-generated method stub
		if(que != null){
				String sql = "insert into _question(type,title,options,answer,note,pointid) values(?,?,?,?,?,?)";
				PreparedStatement pstmt = DBHelper.getPstmt(sql);
				try {
					pstmt.setInt(1, que.getType());
					pstmt.setString(2, que.getTitle());
					pstmt.setString(3, que.getOptions());
					pstmt.setString(4, que.getAnswer());
					pstmt.setString(5, que.getNote());
					pstmt.setInt(6, que.getPointID());
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
	public boolean updateQuestion(Question que) {
		// TODO Auto-generated method stub
		if(que != null){
			String sql = "update _question set type = ?,title = ?,options = ?,answer = ?,note = ? ,pointid = ? where id=?";
			PreparedStatement pstmt = DBHelper.getPstmt(sql);
			try {
				pstmt.setInt(1, que.getType());
				pstmt.setString(2, que.getTitle());
				pstmt.setString(3, que.getOptions());
				pstmt.setString(4, que.getAnswer());
				pstmt.setString(5, que.getNote());
				pstmt.setInt(6, que.getPointID());
				pstmt.setInt(7, que.getId());
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
	public boolean deleteQuestion(Integer queid) {
		// TODO Auto-generated method stub
		if(queid != null){
			String sql = "delete from _question where id=?";
			PreparedStatement pstmt = DBHelper.getPstmt(sql);
			try {
				pstmt.setInt(1, queid);
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
	public List<Question> getLists() {
		// TODO Auto-generated method stub
		List<Question> list = null;
		String sql = "select * from _question";
		PreparedStatement pstmt = DBHelper.getPstmt(sql);
		try {
			ResultSet rs = pstmt.executeQuery();
			list = new ArrayList<Question>();
			while(rs.next()){
				Question que = new Question();
				que.setId(rs.getInt("id"));
				que.setType(rs.getInt("type"));
				que.setTitle(rs.getString("title"));
				que.setOptions(rs.getString("options"));
				que.setAnswer(rs.getString("answer"));
				que.setNote(rs.getString("note"));
				que.setPointID(rs.getInt("pointid"));
				list.add(que);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Question> getListsByType(int type) {
		// TODO Auto-generated method stub
		List<Question> list = null;
		String sql = "select * from _question where type=?";
		PreparedStatement pstmt = DBHelper.getPstmt(sql);
		try {
			pstmt.setInt(1, type);
			ResultSet rs = pstmt.executeQuery();
			list = new ArrayList<Question>();
			while(rs.next()){
				Question que = new Question();
				que.setId(rs.getInt("id"));
				que.setType(rs.getInt("type"));
				que.setTitle(rs.getString("title"));
				que.setOptions(rs.getString("options"));
				que.setAnswer(rs.getString("answer"));
				que.setNote(rs.getString("note"));
				que.setPointID(rs.getInt("pointid"));
				list.add(que);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String getTypeById(int id) {
		String typename = "";
		String sql = "select name from _type where id=?";
		PreparedStatement pstmt = DBHelper.getPstmt(sql);
		try {
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				typename =rs.getString("name");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return typename;
	}

	@Override
	public Question getQuestionById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Question> getListByID(Object[] id) {
		// TODO Auto-generated method stub
			
				List<Question> list = null;
				JSONArray ids = JSONArray.fromObject(id);
				String sql = "select * from _question where id in (";
				for(int i=0;i<ids.size();i++){
					if( i == ids.size()-1)
						sql += ids.get(i) +")";
					else
						sql += ids.getString(i) +", ";
				}

				System.out.println(sql);
				
				PreparedStatement pstmt = DBHelper.getPstmt(sql);
				try {
					ResultSet rs = pstmt.executeQuery();
					list = new ArrayList<Question>();
					while(rs.next()){
						Question que = new Question();
						que.setId(rs.getInt("id"));
						que.setType(rs.getInt("type"));
						que.setTitle(rs.getString("title"));
						que.setOptions(rs.getString("options"));
						que.setAnswer(rs.getString("answer"));
						que.setNote(rs.getString("note"));
						que.setPointID(rs.getInt("pointid"));
						list.add(que);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return list;
	}

}
