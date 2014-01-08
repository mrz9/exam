package com.exam.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.exam.dao.UserDao;
import com.exam.model.Paper;
import com.exam.model.User;
import com.exam.util.DBHelper;

public class UserDaoImpl implements UserDao{

	@Override
	public boolean addUser(User user) {
		if(user != null){
			String sql = "insert into _user(userid,pass,state) values(?,?,?)";
			PreparedStatement pstmt = DBHelper.getPstmt(sql);
			try {
				pstmt.setString(1, user.getUserid());
				pstmt.setString(2, user.getPass());
				pstmt.setInt(3, user.getState());
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
	public User getUserByUserId(String userid) {
		// TODO Auto-generated method stub
		User user = null;
		String sql = "select * from _user where userid = ?";
		PreparedStatement pstmt = DBHelper.getPstmt(sql);
		try {
			pstmt.setString(1, userid);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUserid(rs.getString("userid"));
				user.setPass(rs.getString("pass"));
				user.setState(rs.getInt("state"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public boolean delete(String uid) {
		// TODO Auto-generated method stub
		if(!"".equals(uid) && uid!=null){
			String sql ="delete from _user where userid=?";
			PreparedStatement pstmt = DBHelper.getPstmt(sql);
			try {
				pstmt.setString(1, uid);
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
