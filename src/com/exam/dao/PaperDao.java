package com.exam.dao;

import java.util.List;

import com.exam.model.Paper;

public interface PaperDao {

	//添加试卷
	public boolean addPaper(Paper paper);
	
	//修改试卷
	public boolean updatePaper(Paper paper);
	
	//删除试卷
	public boolean deletePaper(Paper paper);

	//返回所有试卷列表
	public List<Paper> getLists();
	//按类型返回列表
	public List<Paper> getListsByType(int type);
	//根据当前审核状态返回试卷
	public List<Paper> getListByState(int state);
	
	//根据id返回paper
	public Paper getPaperById(int id);
	
	//保存考生的答案
	public boolean saveAnwser(int uid,int paperid ,String answer);
}
