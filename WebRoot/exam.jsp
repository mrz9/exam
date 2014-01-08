<%@ page language="java" import="java.util.*,com.exam.model.*,net.sf.json.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>开始考试</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
	<div>
		<div id="_title" class="_title"><h1><%=request.getAttribute("title") %></h1></div>
		<div id="_note" class="_note"><h2>注  意：<%=request.getAttribute("note") %></h2></div>
		<div id="_ptime" class="_ptime"><h2>考试时间：<%=request.getAttribute("ptime") %></h2></div>
		<div id="_select01" class="_select01">
		<form action="PaperManager" method="post">
		<input type="hidden" name="method" value="answer" />
		<input type="hidden" name="paperid" value="<%=request.getAttribute("paperid")%>" />
		<table>
		<%
			//String[] quesiont = ["一、单选题","二、多选题","三、判断题","四、问答题","五、填空题"];
			List<Question> lselect01 = (List)request.getAttribute("que1");
			List<Question> lselect02 = (List)request.getAttribute("que2");
			List<Question> lpanduan = (List)request.getAttribute("que3");
			List<Question> lwenda = (List)request.getAttribute("que4");
			List<Question> ltiankong = (List)request.getAttribute("que5");
			int i = 0;
			for(Question que : lselect01){
			Object[] options = JSONArray.fromObject(que.getOptions()).toArray(); 
			%>
			
			<tr>
				<td colspan="2"><%=i=i+1 %>。<%=que.getTitle() %></td>
			</tr>
			<% 
				for(int j=0 ;j<options.length;j++){
				%>
			<tr>
				<td><input type="radio" name="question_<%=i %>" value="<%=options[j] %>"/><%=options[j] %></td>
			</tr>
			<%
				}
			%>
			
			<%
			}
			
			for(Question que : lselect02){
			Object[] options = JSONArray.fromObject(que.getOptions()).toArray(); 
			%>
			
			<tr>
				<td colspan="2"><%=i=i+1 %>。<%=que.getTitle() %></td>
			</tr>
			<% 
				for(int j=0 ;j<options.length;j++){
				%>
			<tr>
				<td><input type="checkbox" name="question_<%=i %>" value="<%=options[j] %>"/><%=options[j] %></td>
			</tr>
			<%
				}
			%>
			
			<%
			}
			
			for(Question que : lpanduan){
			Object[] options = JSONArray.fromObject(que.getOptions()).toArray(); 
			%>
			<tr>
				<td colspan="2"><%=i=i+1 %>。<%=que.getTitle() %></td>
			</tr>
			<% 
				for(int j=0 ;j<options.length;j++){
				%>
			<tr>
				<td><input type="radio" name="question_<%=i %>" value="<%=options[j] %>"/><%=options[j] %></td>
			</tr>
			<%
				}
			%>
			
			<%
			}
			
			for(Question que : lwenda){
			Object[] options = JSONArray.fromObject(que.getOptions()).toArray(); 
			%>
			<tr>
				<td colspan="2"><%=i=i+1 %>。<%=que.getTitle() %></td>
			</tr>
			<tr>
				<td><input type="text" name="question_<%=i %>"/></td>
			</tr>
			<%
			}
			
			for(Question que : ltiankong){
			Object[] options = JSONArray.fromObject(que.getOptions()).toArray(); 
			%>
			<tr>
				<td colspan="2"><%=i=i+1 %>。<%=que.getTitle() %></td>
			</tr>
			<tr>
				<td><input type="text" name="question_<%=i %>"/></td>
			</tr>
			<%
			}
		 %>
		</table>
		<input type="submit" value="提交"/>
		</form>
		</div>
	</div>    

  </body>
</html>
