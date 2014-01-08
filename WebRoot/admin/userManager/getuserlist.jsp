<%@ page language="java" import="java.util.*,com.exam.model.*,com.exam.util.JSONTool" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'getuserlist.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="./js/jquery-1.7.1.min.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <%
   Integer tag = Integer.parseInt(request.getAttribute("tag").toString());
   System.out.println("JSP TAG : " + tag);
   if(tag == 1){
   %>
    <div>
  	<div><a href="admin/userManager/adduser.jsp" >添加用户</a></div>
  	<div>
   	<table align="center" border="1px">
  		<thead>
  		<tr>
  			<th>编号</th>
  			<th><></th>
  			<th width="100px">学号</th>
  			<th width="100px">姓名</th>
  		    <th width="100px">年级</th>
  		    <th>当前状态</th>
  		    <th colspan="2">操作</th>
  	  </tr>
  	</thead>
   <%
   	List<Student> list = (List)request.getAttribute("list");
 	//System.out.print(list);
 	for(int i=0;i<list.size();i++){ 
		Student student  = new Student();
		student = list.get(i); 	
 	%>
 	<tr align="center">
 	 <td><%=i+1%></td>
	 <td><input type="checkbox" name="usercheckbox" id="userid"  value="<%=student.getUserid()%>"/></td>
		<td><a href="#"><%=student.getUserid()%></a></td>
		<td><%=student.getName()%></td>
		<td><%=student.getGrade()%></td>
		<td><%=student.getState()%></td>
		<td><a href="admin/userManager/updateuser.jsp?tag=1&user=<%=student.getUserid()%>&name=<%=student.getName()%>&birthday=<%=student.getBirthday()%>&grade=<%=student.getGrade()%>&sex=<%=student.getSex()%>">修改</a></td>
		<td><a href="deleteUserServlet?userid=<%=student.getUserid()%>&tag=1" onclick="return confirm('是否将该用户删除?')">删除</a></td>
	</tr>
	<%	
	}
	%>
	</table>
	<%
 	}else if(tag==2){
 	%>
 <div>
  	<div><a href="admin/userManager/addmaster.jsp" >添加用户</a></div>
  	<div>
 		<table align="center" border="1px">
  		<thead>
  		<tr>
  			<th>编号</th>
  			<th><></th>
  			<th width="100px">工号</th>
  			<th width="100px">姓名</th>
  		    <th width="100px">部门</th>
  		    <th>当前状态</th>
  		    <th colspan="2">操作</th>
  	  </tr>
  	</thead>
   <%
   	List<Master> list = (List)request.getAttribute("list");
 	//System.out.print(list);
 	for(int i=0;i<list.size();i++){ 
		Master master  = new Master();
		master = list.get(i); 	
 	%>
 	<tr align="center">
 	 <td><%=i+1%></td>
	 <td><input type="checkbox" name="usercheckbox" id="userid"  value="<%=master.getUserid()%>"/></td>
		<td><a href="#"><%=master.getUserid()%></a></td>
		<td><%=master.getName()%></td>
		<td><%=master.getDepartment()%></td>
		<td><%=master.getState()%></td>
		<td><a href="admin/userManager/updateuser.jsp?tag=2&user=<%=master.getUserid()%>&name=<%=master.getName()%>&birthday=<%=master.getBirthday()%>&grade=<%=master.getDepartment()%>&sex=<%=master.getSex()%>">修改</a></td>
		<td><a href="deleteUserServlet?userid=<%=master.getUserid()%>&tag=2" onclick="return confirm('是否将该用户删除?')">删除</a></td>
	</tr>
 <%
 }
  %>
	</table>
	<%
	}
    %>
    </div>
  </div>
  </body>
</html>
