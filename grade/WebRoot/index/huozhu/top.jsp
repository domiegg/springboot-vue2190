<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath() + "/";
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<base href="<%=basePath%>" target="leftFrame"/>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>车货匹配物流信息平台</title>
	<link href="<%=basePath %>resource/admin/css/style.css" rel="stylesheet" type="text/css" />
	<!-- 引入JQuery支持的库 -->
    <script language="JavaScript" src="<%=basePath %>resource/admin/js/jquery.js"></script>
    <!-- 引入artDailog支持的库 -->
    <link rel="stylesheet" href="<%=basePath %>resource/admin/artDialog/css/ui-dialog.css">
    <script language="JavaScript" src="<%=basePath %>resource/admin/artDialog/dist/dialog-plus.js"></script>
    <script type="text/javascript">
		function loginOut(){
			if(window.confirm("您确定要退出系统吗？")){
				window.top.location.href="login.jsp"
		}
	}
    </script>
    
	 <script type="text/javascript">
    function testDate(){
	var date=new Date();
	var result=date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate()+"  "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
	document.getElementById("mydate").innerHTML=result;
	}


	setInterval("testDate()", 1000);
    
     </script>
</head>

<body style="background:url(<%=basePath %>resource/admin/images/topbg.gif) repeat-x;">

<div class="topleft">
	<a href="main.html" target="_parent"><img src="<%=basePath %>resource/admin/images/logo.png" title="系统首页" /></a>
</div>
    
<%--<ul class="nav">
	<li><a href="index/admin/left2.jsp" class="selected"><img src="<%=basePath%>images/icon02.png" title="模板管理" /><h2>信息管理</h2></a></li>
	<li><a href="index/admin/left1.jsp"><img src="<%=basePath%>images/icon01.png" title="工作台" /><h2>查询报表</h2></a></li>
</ul>
        
--%><div class="topright">    
	<ul>
	  <li><a href="#"><font color="red" size="2"><p id="mydate"></p></font></a></li>
	 <li><a href="<%=basePath%>login.jsp" target="_parent">切换账号</a></li>
	<li><a href="javascript:void(0)" onclick="loginOut()" target="_parent">安全退出</a></li>
	</ul>
	<div class="user">
		<span>学生--<font color="red" >${sessionScope.account}</font></span>
		<i>编号</i>
		<b>${sessionScope.id}</b>
	</div>  
</div>
    
<script type="text/javascript" src="<%=basePath %>plugins/jQuery/jquery.js"></script>
<script type="text/javascript">
	$(function(){	
		//顶部导航切换
		$(".nav li a").click(function(){
			$(".nav li a.selected").removeClass("selected")
			$(this).addClass("selected");
		})	
	});	
</script>
</body>
</html>

