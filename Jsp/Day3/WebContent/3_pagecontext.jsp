<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    session.setAttribute("userid","apple");		
    pageContext.forward("3_pagecontext_ok.jsp");
    		
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>pageContext 객체</title>
</head>
<body>
	<h2>pageContext 객체</h2>
	<p>pageContext의 forward() 예제입니다. 화면에서는 보이지 않습니다.</p>
</body>
</html>