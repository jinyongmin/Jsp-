<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<%			//스크립트립 문법에서는 자바문법으로!
	String userid = "apple";
	String name = "김사과";
	int age = 20;
	double height=160.5;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>변수</title>
<style>
	h2, p{
		text-align: center;
	}
</style>
</head>
<body>
	
	<h2>변수(현재시간: <%=new Date()%>)</h2>		<!-- bodt안에 HTML문법, HTML문법안에 jsp문법 -->
	<p>아이디: <%=userid%></p>
	<p>이름: <%=name%></p>
	<p>나이: <%=age%></p>
	<p>키: <%=height%></p>
	
<%
	out.println("<p>안녕하세요. jsp 테스트 페이지 입니다.</p> ");
	out.println("<p>" + name + "님 환영합니다. </p>");		//out.println();홈페이지에 출력
	System.out.println("콘솔에 출력합니다.");							//System.out.println();콘솔창에 출력
	
	if(age > 19){
		out.println("<p>성인입니다.<p>");	
	}else{
		out.println("<p>미성년입니다.<p>");
		
	}
%>	
</body>
</html>