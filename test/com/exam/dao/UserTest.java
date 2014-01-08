package com.exam.dao;

import java.util.List;

import net.sf.json.JSONArray;

import org.junit.Test;

import com.exam.dao.impl.StudentDaoImpl;
import com.exam.model.Student;

public class UserTest {

	@Test
	public void test() {
		StudentDaoImpl dao = new StudentDaoImpl();
		List<Student> list = dao.getLists();
		System.out.println(JSONArray.fromObject(list).toString());
	}

}
