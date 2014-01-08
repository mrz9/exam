package com.exam.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.exam.model.Master;
import com.exam.model.Student;
import com.exam.model.User;
import com.exam.util.DBHelper;

public class MasterDaoImpl extends UserDaoImpl{

	
	public boolean addMaster(Master master){
		if(master != null){
			try {
			DBHelper.getConnection().setAutoCommit(false);
			if(this.addUser(master)){
				String sql = "insert into _admin(uid,name,birthday,department,sex) values(?,?,?,?,?)";
				PreparedStatement pstmt = DBHelper.getPstmt(sql);
				
					pstmt.setString(1,master.getUserid());
					pstmt.setString(2, master.getName());
					pstmt.setString(3, master.getBirthday());
					pstmt.setString(4, master.getDepartment());
					pstmt.setString(5, master.getSex());
					if(pstmt.executeUpdate()>0){
						DBHelper.getConnection().commit();
						DBHelper.getConnection().setAutoCommit(true);
						return true;
					}
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				try {
					DBHelper.getConnection().rollback();
					DBHelper.getConnection().setAutoCommit(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				e.printStackTrace();
		}
			
	}
	return false;
	}
	
	public boolean deleteMaster(String uid){
		if(uid != null && !"".equals(uid)){
			try {
			
			DBHelper.getConnection().setAutoCommit(false);
			String sql = "delete from _admin where uid = ?";
			PreparedStatement pstmt = DBHelper.getPstmt(sql);
				pstmt.setString(1, uid);
				if(pstmt.executeUpdate()>0){
					if(this.delete(uid)){
						DBHelper.getConnection().commit();
						DBHelper.getConnection().setAutoCommit(true);
						return true;
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				try {
					DBHelper.getConnection().rollback();
					DBHelper.getConnection().setAutoCommit(true);
					e.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}
	}
		return false;
	}
	
	public boolean updateMaster(Master master){
		if(master != null){
			String sql = "update _admin set name = ?,sex = ?,birthday = ?,department = ? where uid = ?";
			PreparedStatement pstmt = DBHelper.getPstmt(sql);
			try {
				pstmt.setString(1, master.getName());
				pstmt.setString(2, master.getSex());
				pstmt.setString(3, master.getBirthday());
				pstmt.setString(4, master.getDepartment());
				pstmt.setString(5, master.getUserid());
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
	
	public Master getMasterByUid(int uid){
		Master master = new Master();
		String sql = "select * from _admin where uid=?";
		PreparedStatement pstmt = DBHelper.getPstmt(sql);
		try {
			pstmt.setInt(1, uid);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				master = new Master();
				master.setId(rs.getInt("uid"));
				master.setName(rs.getString("name"));
				master.setSex(rs.getString("sex"));
				master.setDepartment(rs.getString("department"));
				master.setBirthday(rs.getString("birthday"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return master;
	}
	
	public List<Master> getLists() {
		// TODO Auto-generated method stub
		List<Master> list = null;
		//UserDao dao = new UserDaoImpl();
		String sql = "select * from _admin order by uid*1";
		PreparedStatement pstmt = DBHelper.getPstmt(sql);
		try {
			ResultSet rs = pstmt.executeQuery();
			list = new ArrayList<Master>();
			while(rs.next()){
				Master master = new Master();
				User user = this.getUserByUserId(rs.getString("uid"));
				System.out.println("user: "+user);
				master.setId(user.getId());
				master.setUserid(user.getUserid());
				master.setState(user.getState());
				master.setName(rs.getString("name"));
				master.setSex(rs.getString("sex"));
				master.setDepartment(rs.getString("department"));
				master.setBirthday(rs.getString("birthday"));
				
				System.out.println("Master: "+master);
				list.add(master);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
