package com.exam.dao;

import java.util.List;

import com.exam.model.Node;
import com.exam.model.Point;

public interface PointDao {

	//添加知识点
	public boolean addPoint(Point point);
	
	//修改知识点
	public boolean updatePoint(Point point);
	
	//删除知识点
	public boolean deletePoint(Integer pointid);
	
	//返回知识点列表
	public List<Point> getLists();
	
	//根据知识点id返回知识点名字
	public String getPointNameById(int id);
	
	//生成节点集合
	public List<Node> getNodes();
}
