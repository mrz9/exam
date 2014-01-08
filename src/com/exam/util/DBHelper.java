package com.exam.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;


public class DBHelper {
	
	private static Connection conn = null;
	private static Properties pros = null;
	private static PreparedStatement pstmt = null;
	
	private DBHelper(){
		try {
			pros = new Properties();
			InputStream in = DBHelper.class.getClassLoader().getResourceAsStream("com/exam/util/datebase.properties");
			pros.load(in);
			//System.out.println(pros.getProperty("driver")+"  "+pros.getProperty("url")+"  "+pros.getProperty("user")+"  "+pros.getProperty("pass"));
			Class.forName(pros.getProperty("driver"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Class.forName("");
	}
	
	public static Connection getConnection(){
		if(conn == null){
			try {
				new DBHelper();
				conn = DriverManager.getConnection(pros.getProperty("url"),pros.getProperty("user"),pros.getProperty("pass"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return conn;
	}
	
	public static PreparedStatement getPstmt(String sql){
		if(conn== null){
			getConnection();
		}
		try {
			pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pstmt;
		
	}

}
