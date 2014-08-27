<%@ page language="java" import="java.util.*"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%
String path = request.getContextPath();
String basepath = request.getScheme() + "//" + path;
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<base href="<%=basepath %>">
<title>个人信息</title>
</head>
<body>
<center>
	<h1>个人信息</h1>
	<hr>
	用户名：<input type="text" name="name">
	<br>密&nbsp;&nbsp;码：<input type="password" name="password">
</center>
</body>
</html>