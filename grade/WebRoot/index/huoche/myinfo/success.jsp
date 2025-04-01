<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath() + "/";
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">‘

	<!-- 引入JQuery支持的库 -->
    <script language="JavaScript" src="<%=basePath %>resource/admin/js/jquery.js"></script>
    <!-- 引入artDailog支持的库 -->
    <link rel="stylesheet" href="<%=basePath %>resource/admin/artDialog/css/ui-dialog.css">
    <script language="JavaScript" src="<%=basePath %>resource/admin/artDialog/dist/dialog-plus.js"></script>
<script type="text/javascript">
	function toClose(){
        	var dialog = top.dialog.get(window);
        	dialog.close();
        	dialog.remove();
        	return false;
        }
    </script>
<html>
	<head>
		<base href="<%=basePath%>"/>
		<title></title>
		<meta http-equiv="pragma" content="no-cache"/>
		<meta http-equiv="cache-control" content="no-cache"/>
		<meta http-equiv="expires" content="0"/>    
	</head>
	<body>
		<hr />	<br/><br/><br/><br/>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font size="200" color="red">注册成功,请等待审核</font>
		<input type="button" class="btn" onclick="toClose()" value="确定"/>
	</body>
</html>
