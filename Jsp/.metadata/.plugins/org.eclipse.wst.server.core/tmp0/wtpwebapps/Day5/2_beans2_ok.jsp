
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
		request.setCharacterEncoding("UTF-8");

%>
<!-- 담기 -->
<!--  자바 데이터 만들고 게터 세터까지 해줌? 유지공사하기 좋음,  로직은 자바쪽으로 액션태그를 사용하여 자바를 담아줌  간단 -->
<jsp:useBean class="com.koreait.Member"  id="member" scope="request"/>
<!--<jsp:setProperty property="userid" name="member"/>
<jsp:setProperty property="userpw" name="member"/>
<jsp:setProperty property="name" name="member"/>
<jsp:setProperty property="email" name="member"/>
<jsp:setProperty property="hp" name="member"/>
-->
<jsp:setProperty property="*" name="member"/>			<!-- 필드와 네임이 같아야함 -->
<jsp:setProperty property="hp" param="tel" name="member"/>			<!-- 필드와 네임이 같아야함 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Java Beans</title>
</head>
<body>
		<h2>Java Beans</h2>
		<p>아이디: <jsp:getProperty property="userid" name="member"/></p>
		<p>비밀번호: <jsp:getProperty property="userpw" name="member"/></p>
		<p>이름: <jsp:getProperty property="name" name="member"/></p>
		<p>이메일: <jsp:getProperty property="email" name="member"/></p>
		<p>휴대폰번호: <jsp:getProperty property="hp" name="member"/></p>
</body>
</html>