package com.exam.model;

import java.sql.Date;

public class Paper {
	
	private int id;
	private int ptype; //试卷类型  人工选题or自动选题    0 1
	private int score; //试卷分值ֵ
	private int ptime;  //考试用时
	private String title; //试卷标题
	private String note ; //试卷试卷说明
	private int state; //审核状态 0未审核 1审核通过 2审核不通过
	private String questions;//试卷题目集合
	private String begin_time; //考试开始时间
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPtype() {
		return ptype;
	}
	public void setPtype(int ptype) {
		this.ptype = ptype;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getPtime() {
		return ptime;
	}
	public void setPtime(int ptime) {
		this.ptime = ptime;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getQuestions() {
		return questions;
	}
	public void setQuestions(String questions) {
		this.questions = questions;
	}
	public String getBegin_time() {
		return begin_time;
	}
	public void setBegin_time(String begin_time) {
		this.begin_time = begin_time;
	}
	
	
}

