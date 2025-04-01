<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath() + "/";
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<base href="<%=basePath%>" target="rightFrame"/>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>无标题文档</title>
	<link href="<%=basePath %>resource/admin/css/style.css" rel="stylesheet" type="text/css" />
</head>

<body style="background:#f0f9fd;">

<div class="lefttop"><span></span>管理信息</div>
<dl class="leftmenu">
	<dd>
		<div class="title">
			<span><img src="<%=basePath %>resource/admin/images/leftico01.png" /></span>密码管理
		</div>
		<ul class="menuson">
			<li><cite></cite><a href="index/admin/password/updatePassword.jsp">密码管理</a><i></i></li>
		</ul>   
	</dd>
	<dd>
		<div class="title">
			<span><img src="<%=basePath %>resource/admin/images/leftico01.png" /></span>个人信息管理
		</div>
		<ul class="menuson">
			<li><cite></cite><a href="user/selHcXx">个人信息</a><i></i></li>
		</ul>   
	</dd>
	<dd>
		<div class="title">
			<span><img src="<%=basePath %>resource/admin/images/leftico01.png"/></span>课程管理
		</div>
		<ul class="menuson">
			<li><cite></cite><a href="course/selCou">课程信息</a><i></i></li>
		</ul> 
	</dd>
	<dd>
		<div class="title">
			<span><img src="<%=basePath %>resource/admin/images/leftico01.png"/></span>成绩管理
		</div>
		<ul class="menuson">
			<li><cite></cite><a href="course/selGra">成绩信息</a><i></i></li>
		</ul> 
	</dd>
	
</dl>

<script type="text/javascript" src="<%=basePath %>plugins/jQuery/jquery.js"></script>
<script type="text/javascript">
$(function(){	
	//导航切换
	$(".menuson li").click(function(){
		$(".menuson li.active").removeClass("active")
		$(this).addClass("active");
	});
	
	$('.title').click(function(){
		var $ul = $(this).next('ul');
		$('dd').find('ul').slideUp();
		if($ul.is(':visible')){
			$(this).next('ul').slideUp();
		}else{
			$(this).next('ul').slideDown();
		}
	});
})	
</script>
</body>
</html>
