<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<div class="pagin">
	<ul class="paginList">
	<a href="shangpin/selSp?page=1"><font>首页</font></a>&nbsp;&nbsp;
		共<i class="blue">&nbsp;${count}&nbsp;</i>条记录，共&nbsp;<i class="blue"> ${countPage}&nbsp;</i>页
		&nbsp;&nbsp;
	<a href="shangpin/selSp?page=${lastPage}">尾页</a>
	</ul>
</div>
