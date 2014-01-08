package com.exam.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.exam.dao.UserDao;
import com.exam.model.Question;
import com.exam.model.Student;
import com.exam.model.User;
import com.exam.util.DBHelper;

public class StudentDaoImpl extends UserDaoImpl{

	
	public boolean addStudent(Student student){
		if(student != null){
			try {
			DBHelper.getConnection().setAutoCommit(false);
			if(this.addUser(student)){
				String sql = "insert into _student(uid,name,birthday,grade,sex) values(?,?,?,?,?)";
				PreparedStatement pstmt = DBHelper.getPstmt(sql);
				
					pstmt.setString(1,student.getUserid());
					pstmt.setString(2, student.getName());
					pstmt.setString(3, student.getBirthday());
					pstmt.setString(4, student.getGrade());
					pstmt.setString(5, student.getSex());
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
	
	public boolean deleteStudent(String uid){
		if(uid != null && !"".equals(uid)){
			try {
			
			DBHelper.getConnection().setAutoCommit(false);
			String sql = "delete from _student where uid = ?";
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
	
	public boolean updateStudent(Student student){
		if(student != null){
			String sql = "update _student set name = ?,sex = ?,birthday = ?,grade = ? where uid = ?";
			PreparedStatement pstmt = DBHelper.getPstmt(sql);
			try {
				pstmt.setString(1, student.getName());
				pstmt.setString(2, student.getSex());
				pstmt.setString(3, student.getBirthday());
				pstmt.setString(4, student.getGrade());
				pstmt.setString(5, student.getUserid());
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
	
	public Student getStudentByUid(int uid){
		Student student = new Student();
		String sql = "select * from _student where uid=?";
		PreparedStatement pstmt = DBHelper.getPstmt(sql);
		try {
			pstmt.setInt(1, uid);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				student = new Student();
				student.setId(rs.getInt("uid"));
				student.setName(rs.getString("name"));
				student.setSex(rs.getString("sex"));
				student.setGrade(rs.getString("grade"));
				student.setBirthday(rs.getString("birthday"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student;
	}
	
	public List<Student> getLists() {
		// TODO Auto-generated method stub
		List<Student> list = null;
		//UserDao dao = new UserDaoImpl();
		String sql = "select * from _student order by uid*1";
		PreparedStatement pstmt = DBHelper.getPstmt(sql);
		try {
			ResultSet rs = pstmt.executeQuery();
			list = new ArrayList<Student>();
			while(rs.next()){
				Student student = new Student();
				User user = this.getUserByUserId(rs.getString("uid"));
				System.out.println("user: "+user);
				student.setId(user.getId());
				student.setUserid(user.getUserid());
				student.setState(user.getState());
				student.setName(rs.getString("name"));
				student.setSex(rs.getString("sex"));
				student.setGrade(rs.getString("grade"));
				student.setBirthday(rs.getString("birthday"));
				System.out.println("student: "+student);
				list.add(student);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
