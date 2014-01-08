package com.exam.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.exam.dao.QuestionDao;
import com.exam.dao.impl.QuestionDaoImpl;
import com.exam.model.Question;

public class QueManager extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public QueManager() {
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

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String method = request.getParameter("method");
		System.out.println("QueManager : " + method);
		
		if("add".equals(method)){
			int type = Integer.parseInt(request.getParameter("type"));
			int pointID = Integer.parseInt(request.getParameter("pointid"));
			String title = request.getParameter("title");
			System.out.println("title : " + title);
			String note = request.getParameter("note");
			System.out.println("note : " + note);
			String[] option = request.getParameterValues("option");
			String[] answer = request.getParameterValues("answer");
			String[] answers = answer;
			if(option !=null && answer != null){
				for(int i=0;i<answer.length;i++){
					int temp = Integer.parseInt(answer[i]);
					answers[i] = option[temp-1];
				}
			}
			
			JSONArray janswer = JSONArray.fromObject(answers);
			JSONArray joption = JSONArray.fromObject(option);
			Question que = new Question();
			que.setTitle(title);
			que.setAnswer(janswer.toString());
			que.setOptions(joption.toString());
			que.setNote(note);
			que.setType(type);
			que.setPointID(pointID);

			QuestionDao dao = new QuestionDaoImpl();
			if(dao.addQuestion(que)){
				System.out.println("add succes");
				response.sendRedirect("QueManager?method=get&type="+type);
			}else{
				System.out.println("add faild");
			}
			
		}else if("update".equals(method)){
			
			System.out.println(QueManager.class + ": update");
			
			int queid = Integer.parseInt(request.getParameter("queid"));
			
			int type = Integer.parseInt(request.getParameter("type"));
			int pointID = Integer.parseInt(request.getParameter("pointid"));
			String title = request.getParameter("title");
			String note = request.getParameter("note");
			String[] option = request.getParameterValues("option");
			String[] answer = request.getParameterValues("answer");
			
			String[] answers = answer;
			if(option !=null && answer != null){
				for(int i=0;i<answer.length;i++){
					int temp = Integer.parseInt(answer[i]);
					answers[i] = option[temp-1];
				}
			}
			
			JSONArray janswer = JSONArray.fromObject(answers);
			JSONArray joption = JSONArray.fromObject(option);
			
			Question que = new Question();
			que.setId(queid);
			que.setTitle(title);
			que.setAnswer(janswer.toString());
			que.setOptions(joption.toString());
			que.setNote(note);
			que.setType(type);
			que.setPointID(pointID);

			System.out.println(que.toString());
			
			QuestionDao dao = new QuestionDaoImpl();
			if(dao.updateQuestion(que)){
				System.out.println("update succes");
				response.sendRedirect("QueManager?method=get&type="+type);
			}else{
				System.out.println("update faild");
			}
			
		}else if("delete".equals(method)){
			Integer type =Integer.parseInt(request.getParameter("type"));
			Integer queid = Integer.parseInt(request.getParameter("queid"));
			if(queid != null){
				QuestionDao dao = new QuestionDaoImpl();
				if(dao.deleteQuestion(queid)){
					System.out.println("add succes");
					response.sendRedirect("QueManager?method=get&type="+type);
				}else{
					System.out.println("add faild");
				}
			}
			
		}else if("get".equals(method)){
			Integer type =Integer.parseInt(request.getParameter("type"));
			QuestionDao dao = null;
			List<Question> list = null;
			
			if(type!=null){
				dao = new QuestionDaoImpl();
				list = dao.getListsByType(type);
				
				if(list!=null){
					request.setAttribute("list", list);
					request.setAttribute("type", dao.getTypeById(type));
					request.getRequestDispatcher("admin/queManager/getquestion.jsp").forward(request, response);
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
