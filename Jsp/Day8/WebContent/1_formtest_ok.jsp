<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
//데이터받기위해
request.setCharacterEncoding("utf-8");
String msg = request. getParameter("msg");
%>
<html>
<head>
<meta charset="UTF-8">
<title>폼 테스트</title>
</head>
<body>
	<h2>폼 테스트</h2>
	<p>전달된 메세지:<%=msg %></p>
</body>
</html>