<%@ page language="java" import="java.util.*"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basepath = request.getScheme() + "//" + path;
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<base href="<%=basepath %>">
<title>用户列表</title>
</head>
<body>
<center>
	<h1>用户列表</h1>
	<hr>
	<ul>
		<c:forEach items="${userList }" var="user">
			<li>
				<tt><c:out value="${user.name }"></c:out></tt>
			</li>		
		</c:forEach>	
	</ul>
</center>
</body>
</html>