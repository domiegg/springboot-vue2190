<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath() + "/";
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<base href="<%=basePath%>"/>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>无标题文档</title>
	<link href="<%=basePath %>resource/admin/css/style.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="<%=basePath %>resource/admin/commons/utils.js"></script>
	
</head>

<body>

<div class="place">
	<span>位置：</span>
	<ul class="placeul">
		<li><a href="#">课程管理</a></li>
		<li><a href="#">添加课程信息</a></li>
	</ul>
</div>

<form action = "course/addCou" method = "post"  class="validate" onsubmit="return add();" >
	<div class="formbody">
		<div class="formtitle"><span>基本信息</span></div>
		<ul class="forminfo">
			<li>
				<label>课程名称</label>
				<input name="kname" id="account" type="text" class="dfinput  " placeholder="请输入课程名称" />&nbsp;&nbsp;&nbsp;<font color="red">*</font>
			</li>
			 <li>
				<label>课时</label>
				<input name="keshi" id="keshi" type="text" class="dfinput  " placeholder="请输入课时" />&nbsp;&nbsp;&nbsp;<font color="red">*</font>
			</li>
			<li>
				<label>课程介绍</label>
				<textarea name="content" id="content" id="editor_id" cols="100" rows="8" style="width:400px;height:100px" class="dfinput" placeholder="请输入课程介绍" ></textarea><font color="red">*</font>
			</li>
			 
			<li>
				<label>&nbsp;</label>
				<input type="submit" class="btn" value="提交"  />
				<input type="reset" class="btn" value="重置"  />
			</li>
		</ul>
	</div>
</form>
<script type="text/javascript">
	/**
	 * 这个使用的单选框选择判断
	 */
	 function toAdd(){
			alert("注册成功！！！");
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
<script type="text/javascript" src="<%=basePath %>plugins/jQuery/jquery.js"></script>
<script type="text/javascript" src="<%=basePath %>resource/admin/js/validate.js"></script>
<script type="text/javascript" src="<%=path %>plugins/imagePreview/imagePreview.js"></script>
<script type="text/javascript" src="<%=path%>plugins/My97DatePicker/WdatePicker.js"></script> 
</body>
</html>
	