<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath() + "/";
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<base href="<%=basePath%>"/>
    
		<title>图片预览示例</title>
    
		<meta http-equiv="pragma" content="no-cache"/>
		<meta http-equiv="cache-control" content="no-cache"/>
		<meta http-equiv="expires" content="0"/>    
		<!--
		<link rel="stylesheet" type="text/css" href="styles.css"/>
		-->

	</head>
  
	<body>
		<table>
			<tr>
				<td>添加圖片:</td>
	  			<td>
					<input type="file" id="file" name="tip.uploadImage" value="文档上传" onchange="preview(this,'preview','imghead',150,200)"/>
  					<div id="preview">
						<img id="imghead" width="202" height="111"/>
					</div>
				</td>
	  		</tr>
			<tr>
				<td>添加圖片:</td>
	  			<td>
					<input type="file" id="file" name="tip.uploadImage" value="文档上传" onchange="preview(this,'preview1','imghead1',150,200)"/>
  					<div id="preview1">
						<img id="imghead1" width="202" height="111"/>
					</div>
				</td>
	  		</tr>
		</table>
	
		<script type="text/javascript" src="<%=path %>plugins/jQuery/jquery.js"></script>
    	<script type="text/javascript" src="<%=path %>plugins/imagePreview/imagePreview.js"></script>
	</body>
</html>
