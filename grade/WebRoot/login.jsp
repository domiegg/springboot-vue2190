<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath() + "/";
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>成绩管理系统</title>
	<link href="<%=basePath %>resource/admin/css/style.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="<%=basePath %>plugins/jQuery/jquery.js"></script>
	<script type="text/javascript" src="<%=basePath %>resource/admin/cloud.js" ></script>
		<!-- 引入JQuery支持的库 -->
    <script language="JavaScript" src="<%=basePath %>resource/admin/js/jquery.js"></script>
    <!-- 引入artDailog支持的库 -->
    <link rel="stylesheet" href="<%=basePath %>resource/admin/artDialog/css/ui-dialog.css">
    <script language="JavaScript" src="<%=basePath %>resource/admin/artDialog/dist/dialog-plus.js"></script>
	<script language="javascript">
		$(function() {
			$('.loginbox').css( {
				'position' : 'absolute',
				'left' : ($(window).width() - 692) / 2
			});
			$(window).resize(function() {
				$('.loginbox').css( {
					'position' : 'absolute',
					'left' : ($(window).width() - 692) / 2
				});
			});
		});
	</script>
	<script type="text/javascript">
		$(function(){
			$("#account").focus();
		});
		function login(){
			var account=$.trim($("#account").val());
			var password=$.trim($("#password").val());
			var role=$.trim($("#role").val());
			if(account.length==0){
				alert("账号不能为空");
				$("#account").focus();
				return false;
			}
			if(password.length==0){
				alert("密码不能为空");
				$("#password").focus();
				return false;
			}
			if(role.length==0){
				alert("请选择一个角色");
				$("#role").focus();
				return false;
			}
			return true;
		}
	</script>
	  <script type="text/javascript">
	function sel(){
		var role = $("#role").val();
		if(role.length==0){
				alert("请选择一个角色");
				$("#role").focus();
				return false;
			}
          var d = top.dialog({
        	 	title:' ',
                width:600,
                height:700,
                url:'user/showUser?role='+role,//可以是一个访问路径Action|Servlet等或者jsp页面资源
                onclose: function () {
                if (this.returnValue="success") {
                    window.location.href= window.location.href;
                }
            }
          });
           d.showModal();
        }
	
	</script>
</head>
		<%
		
			String error = (String)request.getAttribute("message");
			error = error == null?"":error;
			String account = (String)request.getParameter("account");
			account = account == null?"":account;
		%>
<body style="background-color: #1c77ac; background-image: url(images/light.png); background-repeat: no-repeat; background-position: center top; overflow: hidden;">

	<!-- 漂浮云效果 开始-->
	<div id="mainBody">
		<div id="cloud1" class="cloud"></div>
		<div id="cloud2" class="cloud"></div>
	</div>
	<!-- 漂浮云效果 结束-->

	<!-- 顶部导航 -->
	<div class="logintop">
		<span>欢迎登录后台管理界面平台</span>
		<ul>
			<li>
				<a href="javascript:void(0)">帮助</a>
			</li>
			<li>
				<a href="javascript:void(0)">关于</a>
			</li>
		</ul>
	</div>
	<!-- 顶部导航 -->

	<div class="loginbody">
		<span class="systemlogo"></span>
			<div class="loginbox">
				<form action="login.do?method=login" method="post" onsubmit="return login()">
			<ul>
				<li>
					<input name="account" id="account" type="text" class="loginuser" name="account" value="<%=account %>"
						placeholder="请输入账号" />
				</li>
				<li>
					<input name="password" id="password" type="password" class="loginpwd" name="password"
						placeholder="请输入密码" />
				</li>
					<select class="dfinput" name="role" id="role">
					<option value="">请选择一个角色</option>
					<option value="0">管理员</option>
					<option value="1">老师</option>
					<option value="2">学生</option>
					</select>
					<br/>
				 <input type="submit" class="loginbtn" value="登录" />
				  <input type="button" class="loginbtn" onclick="sel()" value="注册" />
				  &nbsp;<font size = "5" color = "red" ><%=error %></font>	
				<li>
					
					<label>
						<!-- 可以用于错误提示功能 -->
						<!--
                       <input name="" type="checkbox" value="" checked="checked" />记住密码</label><label><a href="#">忘记密码？</a>
                       -->
					</label>
				</li>
			</ul>
			</form>
		</div>
		
	</div>

</body>

</html>
