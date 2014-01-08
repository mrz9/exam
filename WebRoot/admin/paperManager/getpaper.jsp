<%@ page language="java" import="java.util.*,com.exam.model.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'getpaper.jsp' starting page</title>
    
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
    <table align="center" border="1px">
  	<thead>
  		<tr><th colspan="7"><%=request.getAttribute("type") %></th></tr>
  	</thead>
   <%
   	List<Paper> list = (List)request.getAttribute("list");
 	System.out.print(list);
 	for(int i=0;i<list.size();i++){
		Paper paper  = new Paper();
		paper = list.get(i); 	
 	%>
 	<tr>
 	 <td><%=i+1%></td>
	 <td><input type="checkbox" name="_<%=paper.getState() %>" id="selects01"  value="<%=paper.getId()%>"/></td>
		<td width="300px"><a href="#"><%=paper.getTitle()%></a></td>
		<td><%=paper.getBegin_time()%></td>
		<td><%=paper.getPtype()%></td>
		<td><a href='admin/paperManager/updatepaper.jsp?paperid=<%=paper.getId()%>&title=<%=paper.getTitle()%>&begin_time=<%=paper.getBegin_time()%>&ptime=<%=paper.getPtime()%>&score=<%=paper.getScore()%>&note=<%=paper.getNote()%>&questions=<%=paper.getQuestions() %>'>修改</a></td>
		<td><a href="PaperManager?method=delete&queid=<%=paper.getId()%>" onclick="return confirm('是否将该试卷删除?')">删除</a></td>
	</tr>
	<%
		System.out.println(paper.getId());
		System.out.println(paper.getTitle());
		System.out.println(paper.getPtype());
		System.out.println(paper.getScore());
		System.out.println(paper.getPtime());
		System.out.println(paper.getQuestions());
		System.out.println(paper.getNote());
 	}
   /* for(int i=0;i<list.size();i++){
		out.write(list.get(i).toString());   	
   	} */
   	//out.write(list.toString());
    %>
    </table>
  </body>
</html>
