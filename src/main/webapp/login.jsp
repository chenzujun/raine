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
<title>Insert title here</title>
</head>
<body>
<center>
	<h1>系统登录</h1>
	<hr>
	<form action="<%=path %>/LoginServlet" name="loginForm"  method="post">
		用户名：<input type="text" name="name">
		<br>密&nbsp;&nbsp;码：<input type="password" name="password">
		<br><input type="submit" value="登录 ">
		<br><input type="button" value="登录1" onclick="javascript:document.loginForm.action='<%=path %>/user/login1.action';document.loginForm.submit();">
		<br><input type="button" value="登录2" onclick="javascript:document.loginForm.action='<%=path %>/user/login2.action';document.loginForm.submit();">
		<br><input type="button" value="登录3" onclick="javascript:document.loginForm.action='<%=path %>/user/login3.action';document.loginForm.submit();">
		<br><input type="button" value="登录4" onclick="javascript:document.loginForm.action='<%=path %>/user/login4.action';document.loginForm.submit();">
	</form>
</center>
</body>
</html>