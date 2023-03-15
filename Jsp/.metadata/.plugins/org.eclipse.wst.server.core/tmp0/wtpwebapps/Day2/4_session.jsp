<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	session.setAttribute("userid","apple");
    //F2436A79C85F8CD1E9AA5A9F8018CED4	->userid(apple)		세션! 메모리를 사용하기때문에!!아껴쓰는게 좋음
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션</title>
</head>
<body>
	<h2>세션</h2>
	<p>세션 아이디:<%=session.getId()%>			<!-- session.setAttribute("변수","값"); 변수에 값을 설정 , 가져오기 문법임! session.getId()	F2436A79C85F8CD1E9AA5A9F8018CED4 서버에서 준 세션아이디!--> 
	
</body>
</html>