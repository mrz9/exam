package com.exam.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.exam.dao.PaperDao;
import com.exam.dao.QuestionDao;
import com.exam.dao.impl.PaperDaoImpl;
import com.exam.dao.impl.QuestionDaoImpl;
import com.exam.model.Paper;
import com.exam.model.Question;

public class PaperManager extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public PaperManager() {
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
		
		if("add1".equals(method)){
			String title = request.getParameter("title");
			int ptime = Integer.parseInt(request.getParameter("ptime"));
			int score = Integer.parseInt(request.getParameter("score"));
			String note = request.getParameter("note");
			String begin_time = request.getParameter("begin_time");
			
			String[] que1 = request.getParameterValues("_1");
			float score1 = Float.parseFloat(request.getParameter("score1"));
			String[] que2 = request.getParameterValues("_2");
			float score2 = Float.parseFloat(request.getParameter("score2"));
			String[] que3 = request.getParameterValues("_3");
			float score3 = Float.parseFloat(request.getParameter("score3"));
			String[] que4 = request.getParameterValues("_4");
			float score4 = Float.parseFloat(request.getParameter("score4"));
			String[] que5 = request.getParameterValues("_5");
			float score5 = Float.parseFloat(request.getParameter("score5"));
			
			JSONArray jq1 = JSONArray.fromObject(que1);
			JSONArray jq2 = JSONArray.fromObject(que2);
			JSONArray jq3 = JSONArray.fromObject(que3);
			JSONArray jq4 = JSONArray.fromObject(que4);
			JSONArray jq5 = JSONArray.fromObject(que5);
			
			JSONObject jo = new JSONObject();
			jo.put("que1", jq1);
			jo.put("score1", score1);
			jo.put("que2", jq2);
			jo.put("score2", score2);
			jo.put("que3", jq3);
			jo.put("score3", score3);
			jo.put("que4", jq4);
			jo.put("score4", score4);
			jo.put("que5", jq5);
			jo.put("score5", score5);
			
			Paper paper = new Paper();
			paper.setTitle(title);
			paper.setBegin_time(begin_time);
			paper.setNote(note);
			paper.setPtime(ptime);
			paper.setScore(score);
			paper.setPtype(1);
			paper.setQuestions(jo.toString());
			paper.setState(0);
			
			PaperDao dao = new PaperDaoImpl();
			if(dao.addPaper(paper)){
				System.out.println("add success");
			}else{
				System.out.println("add faild");
			}
			
		}else if("add2".equals(method)){
			int score1 = Integer.parseInt(request.getParameter("score1"));
			int que1num = Integer.parseInt(request.getParameter("que1num"));
			int que1point = Integer.parseInt(request.getParameter("que1point"));

			int score2 = Integer.parseInt(request.getParameter("score2"));
			int que2num = Integer.parseInt(request.getParameter("que2num"));
			int que2point = Integer.parseInt(request.getParameter("que2point"));
			
			int score3 = Integer.parseInt(request.getParameter("score3"));
			int que3num = Integer.parseInt(request.getParameter("que3num"));
			int que3point = Integer.parseInt(request.getParameter("que3point"));
			
			int score4 = Integer.parseInt(request.getParameter("score4"));
			int que4num = Integer.parseInt(request.getParameter("que4num"));
			int que4point = Integer.parseInt(request.getParameter("que4point"));
			
			int score5 = Integer.parseInt(request.getParameter("score5"));
			int que5num = Integer.parseInt(request.getParameter("que5num"));
			int que5point = Integer.parseInt(request.getParameter("que5point"));
			
			
		}else if("update".equals(method)){
			
		}else if("delete".equals(method)){
			
		}else if("get".equals(method)){
			System.out.println(PaperManager.class + "  :    get");
			//Integer type =Integer.parseInt(request.getParameter("type"));
			PaperDao dao = new PaperDaoImpl();
			List<Paper> list = null;
			
				list = dao.getLists();
				if(list!=null){
					request.setAttribute("list", list);
					request.getRequestDispatcher("admin/paperManager/getpaper.jsp").forward(request, response);
			}
		}else if("join".equals(method)){
			System.out.println(PaperManager.class +":  join");
			int paperid = Integer.parseInt(request.getParameter("paperid"));
			
			PaperDao dao =new PaperDaoImpl();
			Paper paper = dao.getPaperById(paperid);
			
			List<Question> que1 =null;	//单选题		
			List<Question> que2 = null; //多选题
			List<Question> que3 = null; //判断题
			List<Question> que4 = null; //问答题
			List<Question> que5 = null; //填空题
			
			if(paper != null){
				request.setAttribute("title",paper.getTitle());
				request.setAttribute("note", paper.getNote());
				request.setAttribute("ptime", paper.getPtime());
				
				request.setAttribute("paperid",paper.getId());
				
				QuestionDao dao1 = new QuestionDaoImpl();
				JSONObject jo = JSONObject.fromObject(paper.getQuestions());
				
				String score1 = jo.get("score1").toString(); //单选题分值
				String score2 = jo.get("score2").toString(); //多选题分值
				String score3 = jo.get("score3").toString();  //判断题分值
				String score4 = jo.get("score4").toString();  //问答题分值
				String score5 = jo.get("score5").toString();   //填空题分值
				
				request.setAttribute("score1", score1);
				request.setAttribute("score2", score2);
				request.setAttribute("score3", score3);
				request.setAttribute("score4", score4);
				request.setAttribute("score5", score5);
				
				Object[] select01 = JSONArray.fromObject(jo.get("que1")).toArray();  //获取试卷中的单选题
				que1 = dao1.getListByID(select01);
				
				Object[] select02 = JSONArray.fromObject(jo.get("que2")).toArray();  //获取试卷中的多选题
				que2 = dao1.getListByID(select02);
				
				Object[] panduan = JSONArray.fromObject(jo.get("que3")).toArray();  //获取试卷中的判断题
				que3 = dao1.getListByID(panduan);
				
				Object[] wenda = JSONArray.fromObject(jo.get("que4")).toArray();  //获取试卷中的问答题
				que4 = dao1.getListByID(wenda);
				
				Object[] tiankong = JSONArray.fromObject(jo.get("que5")).toArray();  //获取试卷中的填空题
				que5 = dao1.getListByID(tiankong);
				
				request.setAttribute("que1", que1);
				request.setAttribute("que2", que2);
				request.setAttribute("que3", que3);
				request.setAttribute("que4", que4);
				request.setAttribute("que5", que5);
				
				request.getRequestDispatcher("exam.jsp").forward(request, response);
				}
		}else if("answer".equals(method)){
			System.out.println(PaperManager.class +":  answer");
			//Integer userid = request.getSession().getAttribute("userid");
			Integer paperid = Integer.parseInt(request.getParameter("paperid"));
			Integer userid = new Integer(1);
			//Integer paperid = new Integer(11);
			
			PaperDao dao = new PaperDaoImpl();
			
			Map map = request.getParameterMap();
			
			JSONObject jo = JSONObject.fromObject(map);
			
			if(dao.saveAnwser(userid, paperid, jo.toString()))
				System.out.println("添加成功");
			else
				System.out.println("添加失败");
			
			/*System.out.println("JSONObject ===>" + jo.toString());
			Set keys = map.keySet();
			
			System.out.println();
			System.out.println();
			System.out.println(map);
			System.out.println(map.toString());
			
			Object[] o = keys.toArray();
			for(int i=0;i<o.length;i++){
				System.out.println(o[i].toString() +" ==> " + JSONArray.fromObject(map.get(o[i])).toString());
			}
			*/
			//System.out.println(request.getParameterMap());
			
			/*System.out.println(
					"select01 ===> " +JSONArray.fromObject(select01).toString() +
					"\n panduan ===> " +JSONArray.fromObject(panduan).toString()+
					"\n wenda ===> " +JSONArray.fromObject(wenda).toString() +
					"\n tiankong ===> " +JSONArray.fromObject(tiankong) 
					);*/
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
