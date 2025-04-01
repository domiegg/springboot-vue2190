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
	<script type="text/javascript" src="<%=basePath %>resource/commons/utils.js"></script>
	<script type="text/javascript" src="<%=basePath %>plugins/jQuery/jquery.js"></script>
	
	<script type="text/javascript">
	function toAdd(){
        alert("注册成功")
        }
       
    </script>
    <script type="text/javascript">
	$(function(){
		$("#account").focus();
	})
	function add(){
		var account=$.trim($("#account").val());
		var password=$.trim($("#password").val());
		var tel=$.trim($("#tel").val());
		var idk=$.trim($("#idk").val());
		if(account.length==0){
				alert("账号不能为空");
				$("#account").focus();
				return false;
			}
		if(!utils.isChinaOrNumbOrLett(password)){
				alert("密码只能由汉字、字母、数字组成");
				$("#password").focus();
				return false;
			}
		if(!utils.checkMobile(tel)){
				alert("请输入正确的手机号码");
				$("#tel").focus();
				return false;
			}
		if(!utils.isIDno(idk)){
				alert("身份证号码不符合格式");
				$("#idk").focus();
				return false;
			}
			return true;
	}
	</script>
</head>

<body>

<div class="place">
	<span>位置：</span>
	<ul class="placeul">
		<li><a href="#">首页</a></li>
		<li><a href="#">注册</a></li>
	</ul>
</div>

<form action = "user/saveUser" method = "post" enctype="multipart/form-data" class="validate" onsubmit="return add();" >
	<div class="formbody">
	<input type="hidden" name="role" value="${role}"/>
		<div class="formtitle"><span>基本信息</span></div>
		<ul class="forminfo">
			<li>
				<label>姓名</label>
				<input name="account" id="account" type="text" class="dfinput  " placeholder="请输入账号" />&nbsp;&nbsp;&nbsp;<font color="red">*</font>
			</li>
			 <li>
				<label>密码</label>
				<input name="password" id="password" type="password" class="dfinput  " placeholder="请输入密码" />&nbsp;&nbsp;&nbsp;<font color="red">*</font>
			</li>
			 <li>
				<label>年龄</label>
				<input name="age" id="password" type="text" class="dfinput  " placeholder="请输入年龄" />&nbsp;&nbsp;&nbsp;<font color="red">*</font>
			</li>
			<li>
				<label>联系方式</label>
				<input name="tel" id="tel" type="text" class="dfinput  " placeholder="请输入联系方式" />&nbsp;&nbsp;&nbsp;<font color="red">*</font>
			</li>
			<li>
				<label>家庭住址</label>
				<input name="address" id="name" type="text" class="dfinput  " placeholder="请输入家庭住址" />&nbsp;&nbsp;&nbsp;<font color="red">*</font>
			</li>
			 <li>
				<label>身份证号码</label>
				<input name="idk" id="idk" type="text" class="dfinput  " placeholder="请输入身份证号码" />&nbsp;&nbsp;&nbsp;<font color="red">*</font>
			</li>
			 <li>
				<label>院系</label>
				<select name="chexing" class="dfinput" id="chexing">
					<option value="">请选择院系</option>
					<option value="电气与计算机学院">电气与计算机学院</option>
					<option value="建筑与规划学院">建筑与规划学院</option>
					<option value="经济与管理学院">经济与管理学院</option>
					<option value="艺术设计学院">艺术设计学院</option>
					<option value="土木工程学院">土木工程学院</option>
					<option value="市政与环境工程学院">市政与环境工程学院</option>
					<option value="材料与科学工程学院">材料与科学工程学院</option>
					<option value="测绘与勘查工程学院">测绘与勘查工程学院</option>
				 </select>
			</li>
			 <li>
				<label>主教课程</label>
				<select name="jsnumber" class="dfinput" id="jsnumber">
					<option value="">请选择主教课程</option>
					<option value="java面向对象程序设计">java面向对象程序设计</option>
					<option value="数据结构">数据结构</option>
					<option value="数据库原理">数据库原理</option>
					<option value="windows程序设计">windows程序设计</option>
					<option value="计算机组成原理">计算机组成原理</option>
					<option value="离散数学">离散数学</option>
					<option value="C语言程序设计">C语言程序设计</option>
					<option value="计算机操作系统">计算机操作系统</option>
					<option value="软件工程">软件工程</option>
					<option value="数字逻辑">数字逻辑</option>
					<option value="计算机概论">计算机概论</option>
				 </select>
			</li>
			<li>
				<label>照片</label>
				<input name="photo" id="photo" type="file" onchange="preview(this,'preview','imghead',150,100)"/>
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

<script type="text/javascript" src="<%=basePath %>resource/admin/js/validate.js"></script>
<script type="text/javascript" src="<%=path %>plugins/imagePreview/imagePreview.js"></script>
<script type="text/javascript" src="<%=path%>plugins/My97DatePicker/WdatePicker.js"></script> 
</body>
</html>
	