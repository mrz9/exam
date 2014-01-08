<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'adduser.jsp' starting page</title>
    
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
  
    <form action="UserServlet" method="post" name="form">
    	<div>
    		<select id="select01" >
    			<option value="1" selected>学生</option>
    			<option value="2" >老师</option>
    		</select>
    	</div>
    	<div class = "teacher" id = "teacher">
    	<input type="hidden" name="tag" value="2"/>
    	工号：<input type="text"  name="userid"/> <br />
    	姓名：<input type="text"  name="name"/> <br />
    	性别：<select name="sex">
    		<option value="男" selected="selected">男</option>
    		<option value="女" >女</option>
    	</select>
    	<br />
    	出生日期：<input type="text" name="birthday"/> <br />
    	部门：<input type="text" name="grade" /> <br />
    	</div>
    	<input type="submit" value="提交"/>
    </form>
  </body>
</html>
