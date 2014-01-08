package com.exam.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exam.dao.UserDao;
import com.exam.dao.impl.UserDaoImpl;
import com.exam.model.User;
import com.exam.util.MD5Tool;

public class loginServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public loginServlet() {
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
		
		String userid = request.getParameter("userid");
		String pass = request.getParameter("pass");
		
		System.out.println(userid +"   " + pass);
		
		if(!"".equals(userid) && !"".equals(pass)){
			UserDao dao = new UserDaoImpl();
			User user = dao.getUserByUserId(userid);
			if(user != null){
				System.out.println("User: " +user);
				System.out.println("boolean: "+MD5Tool.checkPassword(pass, user.getPass()));
				if(MD5Tool.checkPassword(pass, user.getPass())){
					HttpSession session = request.getSession();
					session.setAttribute("User", user);
					switch (user.getState()){
					case 0:
						PrintWriter out = response.getWriter();
						out.print("用户冻结");
						System.out.println("用户冻结");
						out.flush();
						out.close();
						break;
					case 1:
						System.out.println("登陆成功");
						request.getRequestDispatcher("index.html").forward(request, response);
						break;
					case 2:
						request.getRequestDispatcher("admin/index.html").forward(request, response);
						break;
					}
				}else{
					response.setCharacterEncoding("utf-8");
					PrintWriter out = response.getWriter();
					out.print("密码错误");
					System.out.println("密码错误");
				}
			}else{
				response.setCharacterEncoding("utf-8");
				PrintWriter out = response.getWriter();
				out.print("用户不存在");
				out.flush();
				out.close();
				System.out.println("用户不存在");
			}
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
