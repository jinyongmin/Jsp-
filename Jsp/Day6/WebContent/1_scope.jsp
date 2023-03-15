<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
		pageContext.setAttribute("text","pageContext 영역의 변수");//bean 내부적으로 사용
		request.setAttribute("text","request 영역의 변수");		//bean 내부적
		session.setAttribute("text","session 영역의 변수");		//개별적으로 사용하는 변수
		application.setAttribute("text","application 영역의 변수");	//공용적으로 사용하는변수
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>scope</title>
</head>
<body>
			<!-- 표현형 -->
			<h2>scope</h2>
			<p><%=pageContext.getAttribute("text") %></p>
			<p><%=request.getAttribute("text") %></p>
			<p><%=session.getAttribute("text") %></p>
			<p><%=application.getAttribute("text") %></p>
			<hr>
			<!-- jsp 내장객체 표현식  EL표기법-->
			<p>default: ${text}</p>
			<p>page: ${pageScope.text}</p>
			<p>request: ${requestScope.text}</p>
			<p>session: ${requestScope.text}</p>
			<p>application: ${requestScope.text}</p>
</body>
</html>