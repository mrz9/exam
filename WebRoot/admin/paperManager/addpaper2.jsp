<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>自动生成书卷</title>
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
    <form action="PaperManager" method="post">
    <input type="hidden" name="method" value="add2" />
    	<div id="select01" class="select01">
    		单选题
    		每题分值：<input type="text" name="score1" />
    		题目个数：<input type="text" name="que1num" />
    		知识点：<input type="text" name="que1point" />
    	</div>
    	<div id="select02" class="select02">
    		多选题
    		每题分值：<input type="text" name="score2" />
    		题目个数：<input type="text" name="que2num" />
    		知识点：<input type="text" name="que2point" />
    	</div>
    	<div id="panduan" class="panduan">
    		判断题
    		每题分值：<input type="text" name="score3" />
    		题目个数：<input type="text" name="que3num" />
    		知识点：<input type="text" name="que3point" />
    	</div>
    	<div id="tiankong" class="tiankong">
    		填空题
    		每题分值：<input type="text" name="score4" />
    		题目个数：<input type="text" name="que4num" />
    		知识点：<input type="text" name="que4point" />
    	</div>
    	<div id="wenda" class="wenda">
    		问答题
    		每题分值：<input type="text" name="score5" />
    		题目个数：<input type="text" name="que5num" />
    		知识点：<input type="text" name="quepoint" />
    	</div>
    	<input type="submit" value="提交"/>
    </form>
  </body>
</html>
