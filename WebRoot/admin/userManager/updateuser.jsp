<%@ page language="java" import="java.util.*,com.exam.model.Student,com.exam.util.JSONTool" pageEncoding="utf-8"%>
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
    <form action="updateUserServlet" method="post">
    	<input type="hidden" name="userid" value="<%=request.getParameter("user")%>"/>
    	<%
    	   Integer tag = Integer.parseInt(request.getParameter("tag"));
		   System.out.println("JSP TAG : " + tag);
		   if(tag == 1){
		   %>
    	学号：<input type="text"  name="id" value="<%=request.getParameter("user")%>" disabled="disabled"/> <br />
    	年级：<input type="text" name="grade" value="<%=new String(request.getParameter("grade").getBytes("iso-8859-1"),"utf-8")%>"/> <br />
    	<input type="hidden" name="tag" value="1"/>
		   <%
		   }else if(tag == 2){
		   	%>
    	工号：<input type="text"  name="id" value="<%=request.getParameter("user")%>" disabled="disabled"/> <br />
    	部门：<input type="text" name="grade" value="<%=new String(request.getParameter("grade").getBytes("iso-8859-1"),"utf-8")%>"/> <br />
    	<input type="hidden" name="tag" value="2"/>
		   	
		   	<%
		   }
    	 %>
    	姓名：<input type="text"  name="name" value="<%=new String(request.getParameter("name").getBytes("iso-8859-1"),"utf-8")%>" /> <br />
    	性别：<select name="sex">
    	<%
    	String sex = new String(request.getParameter("sex").getBytes("iso-8859-1"),"utf-8");
    	if("男".equals(sex)){
    	 %>
    		<option value="男" selected="selected">男</option>
    		<option value="女" >女</option>
    	<%}else{
    	%>
    		<option value="男" >男</option>
    		<option value="女" selected="selected">女</option>
    	<%
    	}
    	 %>
    	</select>
    	<br />
    	出生日期：<input type="text" name="birthday" value="<%=request.getParameter("birthday")%>"/> <br />
    	
    	<input type="submit" value="提交"/>
    </form>
  </body>
</html>
