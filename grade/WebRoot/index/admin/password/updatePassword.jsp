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
   <script type="text/javascript" src="<%=basePath %>plugins/jQuery/jquery.js"></script>
    <script type="text/javascript">
	  	function password1(){
	  	    var password = $("#password").val();
	  	    var ypassword = $("#ypassword").val();
	  		var xpassword =$.trim($("#xpassword").val());
        	var qpassword = $("#qpassword").val();
        	if(password.length==0){
				alert("请输入原密码");
				$("#password").focus();
				return false;
			}
        	if(password!= ypassword){
				alert("原密码不正确，请重新输入");
				$("#password").focus();
				return false;
			}
        	if(xpassword.length==0){
				alert("请设置新密码");
				$("#xpassword").focus();
				return false;
			}
        	if(qpassword.length==0){
				alert("请输入确认密码");
				$("#qpassword").focus();
				return false;
			}
        	if(qpassword!= xpassword){
				alert("确认密码不正确，请重新输入");
				$("#qpassword").focus();
				return false;
			}
	  	}
	  </script>
</head>

<body>

<div class="place">
	<span>位置：</span>
	<ul class="placeul">
		<li><a href="#">首页</a></li>
		<li><a href="#">修改密码</a></li>
	</ul>
</div>

<form action = "updatePassword" method = "post"   class="validate" onsubmit="return password1();" >
	<input name="ypassword" id="ypassword" type="hidden" value="${sessionScope.password}"  />
	<div class="formbody">
		<div class="formtitle"><span>修改密码</span></div>
		<ul class="forminfo">
			<li>
				<label>原密码</label>
				<input name="password" id="password" type="password" class="dfinput required" />&nbsp;&nbsp;
			</li>
			<li>
				<label>新密码</label>
				<input name="gpassword" id="xpassword" type="password"   class="dfinput required" />&nbsp;&nbsp;
			</li>
			<li>
				<label>确认密码</label>
				<input name="qpassword" id="qpassword" type="password"  class="dfinput required" />&nbsp;&nbsp;
			</li>
			<li>
				<label>&nbsp;</label>
				<input type="submit" class="btn" value="确认"/>
				<input type="reset" class="btn" value="重置"/>
			</li>
		</ul>
	</div>
</form>
<script type="text/javascript" src="<%=basePath %>plugins/js/validate.js"></script>
<script type="text/javascript" src="<%=basePath %>plugins/imagePreview/imagePreview.js"></script>
</body>
</html>
	