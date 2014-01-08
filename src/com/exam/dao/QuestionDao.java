package com.exam.dao;

import java.util.List;

import com.exam.model.Question;

public interface QuestionDao {

	//添加试题
	public boolean addQuestion(Question que);
	//修改试题
	public boolean updateQuestion(Question que);
	//删除试题
	public boolean deleteQuestion(Integer queid);
	
	//根据id返回试题
	public Question getQuestionById(int id);
	//根据id集合返回问题列表
	public List<Question> getListByID(Object[] id);
	//返回所有试题列表
	public List<Question> getLists();
	//按类型返回列表
	public List<Question> getListsByType(int type);
	
	//根据id返回体型的名字
	public String getTypeById(int id);
	
	
	
}
