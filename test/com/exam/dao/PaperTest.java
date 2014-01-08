package com.exam.dao;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.exam.dao.impl.PaperDaoImpl;
import com.exam.dao.impl.QuestionDaoImpl;
import com.exam.model.Paper;
import com.exam.model.Question;
import com.exam.model.Student;

public class PaperTest {

	@Test
	public void test() {
		PaperDao dao =new PaperDaoImpl();
		Paper paper = dao.getPaperById(9);
		List<Question> lselect01 =null;
		
		String question = paper.getQuestions();
		System.out.println(question);
		
		JSONObject jo = JSONObject.fromObject(question);
		System.out.println("JSONObject ==> "+jo.toString());
		String select01_score = jo.get("select01_score").toString();
		System.out.println(select01_score);
		JSONArray ja = JSONArray.fromObject(jo.get("单选题"));
		Object[] select01 =  ja.toArray();
		QuestionDao dao1 = new QuestionDaoImpl();
		lselect01 = dao1.getListByID(select01);
		for(Question que : lselect01){
			System.out.println(que.getOptions());
		}
		//System.out.println(dao1.getListByID(select01));
	}
}
