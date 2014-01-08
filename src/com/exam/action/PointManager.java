package com.exam.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.dao.PointDao;
import com.exam.dao.impl.PointDaoImpl;
import com.exam.model.Point;

public class PointManager extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public PointManager() {
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
		String method = request.getParameter("method");
		
		if("add".equals(method)){
			String name = request.getParameter("name");
			Integer fatherid = Integer.parseInt(request.getParameter("fatherid")); 
			
			Point point = new Point();
			point.setName(name);
			point.setFatherId(fatherid);
			
			PointDao dao = new PointDaoImpl();
			if(dao.addPoint(point)){
				System.out.println("添加成功");
				response.sendRedirect("PointServlet?method=get");
			}else{
				System.out.println("删除失败");
				response.sendRedirect("PointServlet?method=get");
			}
			
		}else if("update".equals(method)){
			Integer id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			Integer fatherid = Integer.parseInt(request.getParameter("fatherid")); 
			
			Point point = new Point();
			point.setId(id);
			point.setName(name);
			point.setFatherId(fatherid);
			
			PointDao dao = new PointDaoImpl();
			if(dao.updatePoint(point)){
				System.out.println("更新成功");
				response.sendRedirect("PointServlet?method=get");
			}else{
				System.out.println("更新失败");
				response.sendRedirect("PointServlet?method=get");
			}
			
		}else if("delete".equals(method)){
			Integer id = Integer.parseInt(request.getParameter("id"));
			
			PointDao dao = new PointDaoImpl();
			if(dao.deletePoint(id)){
				System.out.println("删除成功");
				response.sendRedirect("PointServlet?method=get");
			}else{
				System.out.println("删除失败");
				response.sendRedirect("PointServlet?method=get");
			}
			
		}else if("get".equals(method)){
			PointDao dao = new PointDaoImpl();
			List<Point> list = dao.getLists();
			if(list != null){
				request.setAttribute("list", list);
				request.getRequestDispatcher("admin/pointManager/getpointlist.jsp").forward(request, response);
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
