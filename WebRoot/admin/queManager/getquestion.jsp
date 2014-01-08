<%@ page language="java" import="java.util.*,com.exam.util.*,com.exam.model.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'getselec.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="./js/jquery-1.7.1.min.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
function updateque(type,title,note,pointid,options,answer){
	alert("hello2");
	$.ajax({
   type: "POST",
   url: "updateque.jsp",
   data: "type="+type+"&title="+title+"&note="+note+"&pointid="+pointid+"&options="+options+"&answer="+answer,
   success: function(msg){
     alert( "Data Saved: " + msg );
   }
});
}
</script>
  </head>
  
  <body>
  	<table align="center" border="1px">
  	<thead>
  		<tr><th colspan="7"><%=request.getAttribute("type") %></th></tr>
  	</thead>
   <%
   	List<Question> list = (List)request.getAttribute("list");
 	System.out.print(list);
 	for(int i=0;i<list.size();i++){
		Question que  = new Question();
		que = list.get(i); 	
 	%>
 	<tr>
 	 <td><%=i+1%></td>
	 <td><input type="checkbox" name="_<%=que.getType() %>" id="selects01"  value="<%=que.getId()%>"/></td>
		<td width="300px"><a href='admin/queManager/queinfo.jsp?type=<%=que.getType() %>&title=<%=que.getTitle()%>&note=<%=que.getNote()%>&pointname=<%=que.getPointName()%>&pointid=<%=que.getPointID() %>&options=<%=que.getOptions()%>&answer=<%=que.getAnswer()%>'><%=que.getTitle()%></a></td>
		<td><%=que.getTypeName()%></td>
		<td><%=que.getPointName()%></td>
		<%-- <td><a href="" onclick="updateque(<%=que.getType() %>,<%=que.getTitle()%>,<%=que.getNote()%>,<%=que.getPointID() %>,<%=que.getOptions()%>,<%=que.getAnswer()%>)">修改</a></td> --%>
		<td><a href='admin/queManager/updateque.jsp?queid=<%=que.getId() %>&type=<%=que.getType() %>&title=<%=que.getTitle()%>&note=<%=que.getNote()%>&pointname=<%=que.getPointName()%>&pointid=<%=que.getPointID() %>&options=<%=que.getOptions()%>&answer=<%=que.getAnswer()%>'>修改</a></td>
		<td><a href="QueManager?method=delete&type=<%=que.getType() %>&queid=<%=que.getId()%>" onclick="return confirm('是否将该用户删除?')">删除</a></td>
	</tr>
	<%
		System.out.println(que.getAnswer());
 	}
   /* for(int i=0;i<list.size();i++){
		out.write(list.get(i).toString());   	
   	} */
   	//out.write(list.toString());
    %>
    
      </table>
      <div id="info" class="info">
      	
      </div>
  </body> 
</html>
