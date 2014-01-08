package com.exam.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.dao.impl.MasterDaoImpl;
import com.exam.dao.impl.StudentDaoImpl;
import com.exam.model.Master;
import com.exam.model.Student;

public class updateUserServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public updateUserServlet() {
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
		String sex = request.getParameter("sex");
		String name = request.getParameter("name");
		String birthday = request.getParameter("birthday");
		String grade = request.getParameter("grade");
		//Integer state = Integer.parseInt(request.getParameter("state"));
		System.out.println(userid+" :: "+sex+" :: "+name+" :: "+birthday+" :: "+grade);
		
		Integer tag = Integer.parseInt(request.getParameter("tag"));
		System.out.println("UPDATE　TAG : " + tag);
		
		if(!"".equals(userid) && !"".equals(name) && !"".equals(sex) && !"".equals(grade) && tag != null){
			if(tag ==1){
				Student student = new Student();
				student.setUserid(userid);
				student.setName(name);
				student.setSex(sex);
				student.setBirthday(birthday);
				student.setGrade(grade);
				//student.setPass(MD5Tool.getMD5String("88888"));
				System.out.println(student);
				
				if(student !=null){
					StudentDaoImpl dao = new StudentDaoImpl();
					if(dao.updateStudent(student)){
						System.out.println("修改成功");
						response.sendRedirect("getUserList?tag=1");
					}else{
						//history.go(-1)
						PrintWriter out = response.getWriter();
						out.println("<javascript>history.go(-1);</javascript>");
						System.out.println("修改失败");
					}
				}
			}else if(tag ==2){
				Master master = new Master();
				master.setUserid(userid);
				master.setName(name);
				master.setSex(sex);
				master.setBirthday(birthday);
				master.setDepartment(grade);
				//student.setPass(MD5Tool.getMD5String("88888"));
				System.out.println(master);
				
				if(master !=null){
					MasterDaoImpl dao = new MasterDaoImpl();
					if(dao.updateMaster(master)){
						System.out.println("修改成功");
						response.sendRedirect("getUserList?tag=2");
					}else{
						//history.go(-1)
						PrintWriter out = response.getWriter();
						out.println("<javascript>history.go(-1);</javascript>");
						System.out.println("修改失败");
					}
				}
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
