<%@ page language="java" import="java.util.*,net.sf.json.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'updatepaper.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link type="text/css" href="css/jquery-ui-1.8.17.custom.css" rel="stylesheet" />
     <link type="text/css" href="css/jquery-ui-timepicker-addon.css" rel="stylesheet" />
	<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
	<script type="text/javascript" src="js/jquery-ui-1.8.17.custom.min.js"></script>
	<script type="text/javascript" src="js/jquery-ui-timepicker-addon.js"></script>
    <script type="text/javascript" src="js/jquery-ui-timepicker-zh-CN.js"></script>
	<script type="text/javascript">
	    $(function () {
        $(".ui_timepicker").datetimepicker({
            //showOn: "button",
            //buttonImage: "./css/images/icon_calendar.gif",
            //buttonImageOnly: true,
            showSecond: true,
            timeFormat: 'hh:mm:ss',
            stepHour: 1,
            stepMinute: 1,
            stepSecond: 1
        })
    });
	
	function load(str,did)
	{
		var xmlhttp;
		if (window.XMLHttpRequest)
		  {// code for IE7+, Firefox, Chrome, Opera, Safari
		  xmlhttp=new XMLHttpRequest();
		  }
		else
		  {// code for IE6, IE5
		  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		  }
		xmlhttp.onreadystatechange=function()
		  {
		  if (xmlhttp.readyState==4 && xmlhttp.status==200)
		    {
		    document.getElementById(did).innerHTML = xmlhttp.responseText;
		    }
		  }
		xmlhttp.open("GET","QueManager?method=get&type="+str,true);
		xmlhttp.send();
	}
	</script>
  </head>
  
  <body>
    <form action="PaperManager" method="post">
   <input type="hidden" name="method" value="update"/>
   <input type="hidden" name="paperid" value="<%=request.getParameter("paperid") %>"/>
   <div>
   		<div>考卷标题：<input type="text" name="title" value="<%=new String(request.getParameter("title").getBytes("iso-8859-1"),"utf-8")%>"/></div>
   		<div>
   			<span>开始考试时间：<input type="text" name="begin_time" class="ui_timepicker" value="<%=request.getParameter("begin_time")%>"/></span>
   			<span>考试时间：<input type="text" name="ptime" value="<%=request.getParameter("ptime")%>"/></span>
   			<span>书卷分值：<input type="text" name="score" value="<%=request.getParameter("score")%>"/></span>
   		</div>
   		<div>
   			<textarea rows="5" cols="60" name="note"><%=new String(request.getParameter("note").getBytes("iso-8859-1"),"utf-8") %></textarea>
   		</div>
   </div>
	<div>
	<%
		String questions =  new String(request.getParameter("questions").getBytes("iso-8859-1"),"utf-8");
		JSONObject jque = JSONObject.fromObject(questions);
		System.out.println(jque.toString());
		JSONArray ja = jque.getJSONArray("单选题");
		System.out.println(ja.toString());
	 %>
		<div>
			<span><input type="button" value="单选题" onclick="load(1,'select01')"/></span>
			<span>每题分值：<input type="text" name="score1" value="<%=jque.getInt("score1")%>"/></span>
		</div>
		<div id="select01" class="select01" ></div>
	</div>
	
	<div>
		<div>
			<span><input type="button" value="多选题" onclick="load(2,'select02')"/></span>
			<span>每题分值：<input type="text" name="score2" /></span>
		</div>
		<div id="select02" class="select02"></div>
	</div>  
	
	<div>
		<div>
			<span><input type="button" value="判断题" onclick="load(3,'panduan')"/></span>
			<span>每题分值：<input type="text" name="score3" /></span>
		</div>
		<div id="panduan" class="panduan"></div>
	</div>  	
	
	<div>
		<div>
			<span><input type="button" value="填空题" onclick="load(4,'tiankong')"/></span>
			<span>每题分值：<input type="text" name="score4" /></span>
		</div>
		<div id="tiankong" class="tiankong"></div>
	</div>  
	<div>
		<div>
			<span><input type="button" value="问答题" onclick="load(5,'wenda')"/></span>
			<span>每题分值：<input type="text" name="score5" /></span>
		</div>
		<div id="wenda" class="wenda"></div>
	</div>  
	
	<hr />
	<div><input type="submit" value="提  交"/></div>
   </form>
  </body>
</html>
