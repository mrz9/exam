package com.exam.model;

import com.exam.dao.PointDao;
import com.exam.dao.QuestionDao;
import com.exam.dao.impl.PointDaoImpl;
import com.exam.dao.impl.QuestionDaoImpl;

public class Question {

	private int id;
	private int type;
	private String title;
	private String options; //用json数组方式存放
	private String answer; //用json数组方式存放
	private String note;
	private int pointID;//对应的知识点
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getOptions() {
		return options;
	}
	public void setOptions(String options) {
		this.options = options;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public int getPointID() {
		return pointID;
	}
	public void setPointID(int pointID) {
		this.pointID = pointID;
	}
	
	public String getTypeName(){
		QuestionDao dao = new QuestionDaoImpl();
		if(this.type != 0){
			return dao.getTypeById(this.type);
		}
		return null;
	}
	
	public String getPointName(){
		PointDao dao = new PointDaoImpl();
		if(this.pointID != 0){
			return dao.getPointNameById(this.pointID );
		}
		return null;
	}
	@Override
	public String toString() {
		return "Question [id=" + id + ", type=" + type + ", title=" + title
				+ ", options=" + options + ", answer=" + answer + ", note="
				+ note + "]";
	}
	
	
}
