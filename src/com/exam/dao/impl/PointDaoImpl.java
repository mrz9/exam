package com.exam.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.exam.dao.PointDao;
import com.exam.model.Node;
import com.exam.model.Point;
import com.exam.util.DBHelper;

public class PointDaoImpl implements PointDao{

	@Override
	public boolean addPoint(Point point) {
		// TODO Auto-generated method stub
		if(point != null){
			if(!"".equals(point.getName())){
				String sql = "insert into _point(name,fartherid) values(?,?)";
				PreparedStatement pstmt = DBHelper.getPstmt(sql);
				try {
					pstmt.setString(1, point.getName());
					pstmt.setInt(2, point.getFatherId());
					if(pstmt.executeUpdate()>0){
						return true;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	@Override
	public boolean updatePoint(Point point) {
		// TODO Auto-generated method stub
		if(point != null){
			if(!"".equals(point.getName())){
				String sql = "update _point set name = ?,fartherid = ? where id = ?";
				PreparedStatement pstmt = DBHelper.getPstmt(sql);
				try {
					pstmt.setString(1, point.getName());
					pstmt.setInt(2, point.getFatherId());
					pstmt.setInt(3, point.getId());
					if(pstmt.executeUpdate()>0){
						return true;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	@Override
	public boolean deletePoint(Integer pointid) {
		// TODO Auto-generated method stub
		if(pointid != null){
				String sql = "delete from _point where id = ?";
				PreparedStatement pstmt = DBHelper.getPstmt(sql);
				try {
					pstmt.setInt(1, pointid);
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
	public List<Point> getLists() {
		// TODO Auto-generated method stub
		List<Point> list = null;
		String sql = "select * from _point";
		PreparedStatement pstmt = DBHelper.getPstmt(sql);
		try {
			ResultSet rs = pstmt.executeQuery();
			list = new ArrayList<Point>();
			while(rs.next()){
				Point point = new Point();
				point.setId(rs.getInt("id"));
				point.setName(rs.getString("name"));
				point.setFatherId(rs.getInt("fartherid"));
				list.add(point);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String getPointNameById(int id) {
		String pointname = "";
		String sql = "select name from _point where id=?";
		PreparedStatement pstmt = DBHelper.getPstmt(sql);
		try {
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				pointname =rs.getString("name");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pointname;
	}

	@Override
	public List<Node> getNodes() {
		// TODO Auto-generated method stub
		List<Node> list = null;
		String sql = "select * from _point";
		PreparedStatement pstmt = DBHelper.getPstmt(sql);
		try {
			ResultSet rs = pstmt.executeQuery();
			list = new ArrayList<Node>();
			while(rs.next()){
				Node node = new Node();
				node.setNodeId(rs.getInt("id"));
				node.setNodeName(rs.getString("name"));
				node.s
				point.setFartherId(rs.getInt("fartherid"));
				list.add(point);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
