<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>500 ERROR</title>
	<style>
	body{background-color: deepskyblue;}
	h2{font-size: 50px; text-align: center;}
	p {text-align: center; color: gold;}
	</style>

</head>
<body>
			<h2>500 Error</h2>
			<p>에러 타입: <%=exception.getClass() .getName()%></p>		<!-- ?? 어디서 가져옴? -->
			<p>에러 메세지: <%=exception.getMessage() %></p>				<!--  받은메세지() ?? -->
</body>
</html>