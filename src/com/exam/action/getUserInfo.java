package com.exam.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.dao.UserDao;
import com.exam.dao.impl.StudentDaoImpl;
import com.exam.model.Student;
import com.exam.model.User;

public class getUserInfo extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public getUserInfo() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		User user = (User)request.getSession().getAttribute("User");
		System.out.println(user);
		StudentDaoImpl su = new StudentDaoImpl();
		Student student = su.getStudentByUid(user.getId());
		System.out.println(student.getName());
		
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.println("<p>");
		out.println("<a href=''>");
		out.println(student.getName());
		out.println("</a>");
		out.println("</p>");
		out.println("<p>");
		out.println(student.getGrade());
		out.println("</p>");
		out.flush();
		out.close();
		
	}
	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
