<%@ page language="java" import="java.util.*,net.sf.json.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addselect.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <%
  String[] arr ={"单择题","多选题","判断题","问答题","填空题"};
  Integer type = Integer.parseInt(request.getParameter("type"));
   %>
  <body>
  <form method="post" action="QueManager">
  <input type="hidden" name="method" value="update"/>
  <input type="hidden" name="queid" value="<%=request.getParameter("queid") %>"/>
  <input type="hidden" name="type" value="<%=request.getParameter("type") %>"/>
   	<div id="questionBox">
   		<table width="600px">
			<thead><%=arr[type-1] %></thead>
   			<tr>
   				<td>知识点</td>
   				<td>
   				<input type="hidden" name="pointid" value="<%=request.getParameter("pointid")%>"/>
   				<input type="text" name="pointname" value="<%=new String(request.getParameter("pointname").getBytes("iso-8859-1"),"utf-8")%>"/>
   				</td>
   			</tr>
   			<tr>
   				<td>题目内容</td>
   				<td><textarea rows="5" cols="60" name="title"><%=new String(request.getParameter("title").getBytes("iso-8859-1"),"utf-8")%></textarea></td>
   			</tr>
   			
   		<%
			if(type == 1){
			String options = new String(request.getParameter("options").getBytes("iso-8859-1"),"utf-8");
			String answers = new String(request.getParameter("answer").getBytes("iso-8859-1"),"utf-8");
			JSONArray joption = JSONArray.fromObject(options);
			JSONArray janswer = JSONArray.fromObject(answers);
			%>
			<tr>
   				<td>试题选项</td>
   				<td>
			<%
			if(!"".equals(options) && options!=null){
				//String[] oarr = options.split(",");
				//String[] aarr = answers.split(",");
				for(int i=0;i<joption.size();i++){
					//for(int j=0;j<)
					//oarr[i].substring(oarr[i].indexOf("\"")+1,oarr[i].lastIndexOf("\""))
					for(int j=0;j<janswer.size();j++)
						if(janswer.get(j).equals(joption.get(i))){
						%>
						<input  type="radio" name="answer" value="<%=i+1 %>" checked="checked" />
						<%
						}else{
				%>
   				<input type="radio" name="answer" value="<%=i+1 %>"/>
   				<%
   				}
   				 %>
   				<%=i+1 %>.<input type="text" name="option" value="<%=joption.get(i)%>"/><br />
				<%
				}
				/* System.out.println("arro  :  "+oarr[1].substring(oarr[1].indexOf("\"")+1,oarr[1].lastIndexOf("\""))); */
			}
			%>
   				</td>
   			</tr>
			<%
			}else if(type == 2){
			
   			String options = new String(request.getParameter("options").getBytes("iso-8859-1"),"utf-8");
			String answers = new String(request.getParameter("answer").getBytes("iso-8859-1"),"utf-8");
			JSONArray joption = JSONArray.fromObject(options);
			JSONArray janswer = JSONArray.fromObject(answers);
			%>
			<tr>
   				<td>试题选项</td>
   				<td>
			<%
			if(!"".equals(options) && options!=null){
				boolean flag = false;
				for(int i=0;i<joption.size();i++){
						flag = false;
					for(int j=0;j<janswer.size();j++){
						if(janswer.get(j).equals(joption.get(i))){
							flag = true;
							%>
			   				<input  type="checkbox" name="answer" checked="checked" value="<%=i+1 %>"/>
			   				<%=i+1 %>.
			   				<input  type="text" name="option" value="<%=joption.get(i)%>"/><br />
			   				<%
							break;	
					}
				}
				if(!flag){
				%>
				<input  type="checkbox" name="answer" value="<%=i+1 %>"/>
   				<%=i+1 %>.
   				<input  type="text" name="option" value="<%=joption.get(i)%>"/><br />
				<%
				}
				}
				}
				 %>
   				</td>
   			</tr>
			<%
			}else if(type == 3){
   			String options = new String(request.getParameter("options").getBytes("iso-8859-1"),"utf-8");
			String answers = new String(request.getParameter("answer").getBytes("iso-8859-1"),"utf-8");
			JSONArray joption = JSONArray.fromObject(options);
			JSONArray janswer = JSONArray.fromObject(answers);
			%>
			<tr>
   				<td>试题选项</td>
   				<td>
			<%
			if(!"".equals(options) && options!=null){
				//String[] oarr = options.split(",");
				//String[] aarr = answers.split(",");
				for(int i=0;i<joption.size();i++){
					//for(int j=0;j<)
					//oarr[i].substring(oarr[i].indexOf("\"")+1,oarr[i].lastIndexOf("\""))
					for(int j=0;j<janswer.size();j++)
						if(janswer.get(j).equals(joption.get(i))){
						%>
						<input  type="radio" name="answer" value="<%=i+1 %>" checked="checked" />
						<%
						}else{
				%>
   				<input type="radio" name="answer" value="<%=i+1 %>"/>
   				<%
   				}
   				 %>
   				<%=i+1 %>.<input  type="text" name="option" value="<%=joption.get(i)%>"/><br />
				<%
				}
				/* System.out.println("arro  :  "+oarr[1].substring(oarr[1].indexOf("\"")+1,oarr[1].lastIndexOf("\""))); */
			}
			%>
   				</td>
   			</tr>
			<%
			}else if(type ==4){
				String answer = new String(request.getParameter("answer").getBytes("iso-8859-1"),"utf-8");
			%>
			<tr >
   				<td colspan="2"><font color="red">请将需要填空的位置用英文()表示，例如：在线()系统</font></td>
   			</tr>
   			<tr>
   				<td>参考答案</td>
   				<td>
   				<input type="text" name="answer" value="<%=answer.substring(answer.indexOf("\"")+1, answer.lastIndexOf("\"")) %>"/><br />
   				</td>
   			</tr>
			<%
			}
			else if(type == 5){
		//	oarr[1].substring(oarr[1].indexOf("\"")+1,oarr[1].lastIndexOf("\""))
			String answer = new String(request.getParameter("answer").getBytes("iso-8859-1"),"utf-8");
			%>
			<tr>
   				<td>参考答案</td>
   				<td><textarea rows="5" cols="60" name="answer"><%=answer.substring(answer.indexOf("\"")+1, answer.lastIndexOf("\"")) %></textarea></td>
   			</tr>
   			<tr>
   			<%
   			}
   			 %>
   				<td>题目讲解</td>
   				<td><textarea rows="5" cols="60" name="note"><%=new String(request.getParameter("note").getBytes("iso-8859-1"),"utf-8") %></textarea></td>
   			</tr>
   			<tr>
   				<td><input type="submit" value="提交" /></td>
   				<td><input type="reset" value="重置" /></td>
   			</tr>
   		</table>
   	</div>
   </form>
  </body>
</html>
