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
<title>系统错误</title>
</head>
<body>
<center>
	<h1>==============系统错误=============</h1>
	<hr>
</center>
</body>
</html>