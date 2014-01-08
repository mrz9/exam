<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
  
  <body>
  <form name="form1" action="QueManager" method="post">
    	
    	<div id="questionBox">
   		<input type="hidden" name="method" value="add"/>
   		<table width="600px">
   			<thead>
   			<select name="type">
   				<option value="1">单选题</option>
   				<option value="2">多选题</option>
   				<option value="3">判断题</option>
   				<option value="4">填空题</option>
   				<option value="5">问答题</option>
   			</select>
   			</thead>
   			<tr>
   				<td>知识点</td>
   				<td>
   				<input type="text" name="pointid"/>
   				</td>
   			</tr>
   			<tr>
   				<td>题目内容</td>
   				<td><textarea rows="5" cols="60" name="title"></textarea></td>
   			</tr>
   			<tr>
   				<td>选择题答案</td>
   				<td>
   				<input type="checkbox" name="answer" value="1"/>1<input type="text" name="option"/><br />
   				<input type="checkbox" name="answer" value="2"/>2<input type="text" name="option"/><br />
   				<input type="checkbox" name="answer" value="3"/>3<input type="text" name="option"/><br />
   				<input type="checkbox" name="answer" value="4"/>4<input type="text" name="option"/><br />
   				</td>
   				<tr>
   				<td>问答题答案</td>
   				<td><textarea rows="5" cols="60" name="answer1"></textarea></td>
   			</tr>
   			<tr>
   				<td>题目讲解</td>
   				<td><textarea rows="5" cols="60" name="note"></textarea></td>
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
