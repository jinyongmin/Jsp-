<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.koreait.Member" %>
    <%
    	Member member1 = new Member();
    	member1.setUserid("apple");
    	member1.setUserpw("1234");
    	member1.setName("김사과");
    	member1.setHp("010-1111-1111");
    	member1.setEmail("apple@apple.com");
    
    %>
    <!-- set 프로퍼티 -->
    <jsp:useBean class="com.koreait.Member" id="member2" scope="page"/>		<!-- scope는 범위 -->
    <jsp:setProperty property="userid" name="member2" value="banana"/>
    <jsp:setProperty property="userpw" name="member2" value="2222"/>
    <jsp:setProperty property="name" name="member2" value="반하나"/>
    <jsp:setProperty property="hp" name="member2" value="010-2222-2222"/>
    <jsp:setProperty property="email" name="member2" value="banana@banana.com"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Java Beans</title>
</head>
<body>
		<h2>Java Beans</h2>
		<hr>
		<p>member1 userid: <%=member1.getUserid() %></p>
		<p>member1 userpw: <%=member1.getUserpw() %></p>
		<p>member1 name: <%=member1.getName() %></p>
		<p>member1 hp: <%=member1.getHp() %></p>
		<p>member1 email: <%=member1.getEmail() %></p>
		<hr>
		<p>member2 userid: <jsp:getProperty property="userid" name="member2"/></p>
		<p>member2 userpw: <jsp:getProperty property="userpw" name="member2"/></p>
		<p>member2 name: <jsp:getProperty property="name" name="member2"/></p>
		<p>member2 hp: <jsp:getProperty property="hp" name="member2"/></p>
		<p>member2 email: <jsp:getProperty property="email" name="member2"/></p>
		
		
</body>
</html>