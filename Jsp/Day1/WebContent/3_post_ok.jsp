<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
	request.setCharacterEncoding("UTF-8");
	String userid= request.getParameter("userid");
	String userpw= request.getParameter("userpw");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전송방식(post)</title>
</head>
<body>
	<h2>전송방식</h2>
	<p>아이디 : <%=userid%></p>
	<p>비밀번호 : <%=userpw%></p>
</body>
</html>