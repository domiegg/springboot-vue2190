<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath() + "/";
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<base href="<%=basePath%>"/>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<title>无标题文档</title>
	<link href="<%=basePath %>resource/admin/css/style.css" rel="stylesheet" type="text/css" />
	 <link href="<%=basePath %>resource/admin/css/style.css" rel="stylesheet" type="text/css"/>
    <!-- 引入JQuery支持的库 -->
    <script type="text/javascript" src="<%=basePath %>resource/admin/js/jquery.js"></script>
  
</head>
		

<body>
<form action="course/selGra1" method="post" rel="page">
<div class="place">
	<span>位置：</span>
	<ul class="placeul">
		<li><a href="#">成绩管理</a></li>
		<li><a href="#">查看个人成绩信息</a></li>
	</ul>
</div>

		<table class="imgtable"border = "5" >
			<thead>
			<tr>
				<th>id</th>
				<th>学生</th>
				<th>课程</th>
				<th>学期</th>
				<th>分数</th>
				<th>备注</th>
			</tr>
			</thead>
			<tbody>
		<c:if test="${!empty graList}">
			<c:forEach items="${graList}" var="list" varStatus="vs">
			<tr>
				<td>${list.id}</td>
				<td>${list.account}</td>
				<td>${list.kname}</td>
				<td>${list.xueqi}</td>
				<td>${list.fenshu}</td>
				<td>${list.content}</td>
			</tr>
			</c:forEach>
		</c:if>
		<c:if test="${empty graList}">
			<tr>
				<td colspan="8" align="center">
					<strong><font color="red">暂时没有数据，请添加</font></strong>
				</td>
			</tr>
		</c:if>
		</tbody>
		</table>
		<div class="rightinfo">
			<div class="tools">
				<ul class="toolbar1">
				</ul>
			</div>
		</div>
</form>

<script type="text/javascript" src="<%=basePath %>resource/admin/jQuery/jquery.js"></script>
<script type="text/javascript">
	/**
	 * 这个使用的单选框选择判断
	 */
	  function deleteUser(){
		alert("删除成功");
		}
	function toUpdate(){
		var id = $("input[name='id']:checked").val();
		if(!id){
			alert("请选择要操作的记录");
			return false;
		}else{
			alert( "您操作的值为："+$("input[name='id']:checked").val())
		}
	}
	$(function(){
		$('.tablelist tbody tr:odd').addClass('odd');
		
		$("#formtitle").click(function(){
			$("#forminfo").slideToggle("slow");
		});
	});
</script>
<script type="text/javascript">
	$(function(){
		$('.imgtable tbody tr:odd').addClass('odd');
	});
    
</script>

</body>

</html>

