package com.exam.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.exam.dao.impl.MasterDaoImpl;
import com.exam.dao.impl.StudentDaoImpl;
import com.exam.model.Master;
import com.exam.model.Student;

public class getUserList extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public getUserList() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

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

		Integer tag = Integer.parseInt(request.getParameter("tag"));
		/*List list = null;*/
		System.out.println("TAG : "+ tag);
		if(tag==1){
			StudentDaoImpl dao = new StudentDaoImpl();
			List<Student> list = dao.getLists();
			request.setAttribute("tag", 1);
			request.setAttribute("list", list);
			System.out.println(JSONArray.fromObject(list));
			request.getRequestDispatcher("admin/userManager/getuserlist.jsp").forward(request, response);
		}else if(tag ==2 ){
			MasterDaoImpl mdao = new MasterDaoImpl();
			List<Master> list = mdao.getLists();
			request.setAttribute("tag", 2);
			request.setAttribute("list", list);
			System.out.println(JSONArray.fromObject(list));
			request.getRequestDispatcher("admin/userManager/getuserlist.jsp").forward(request, response);
		
		}
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
