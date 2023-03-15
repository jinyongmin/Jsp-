<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
request.setCharacterEncoding("UTF-8");
	%>
<jsp:useBean class = "com.koreait.Member" id ="member" scope ="request"/>
 <jsp:setProperty property="*" name="member"/> 
 <jsp:useBean class = "com.koreait.MemberDAO" id ="dao" scope ="request"/>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 완료</title>
</head>
<body>
<%
	if(dao.join(member)){
%>


	<p> 아이디: <jsp:getProperty property="userid" name="member"/></p>
	<p>비밀번호: <jsp:getProperty property="userpw" name="member"/></p>
	<p>이름: <jsp:getProperty property="name" name="member"/></p>
	<p>휴대폰번호: <jsp:getProperty property="hp" name="member"/></p>
	<p>이메일: <jsp:getProperty property="email" name="member"/></p>
	<p>성별: <jsp:getProperty property="gender" name="member"/></p>
	<p>취미: <jsp:getProperty property="hobby" name="member"/></p>
	<%
		String hobbystr ="";
	for(String hobby : member.getHobby()){
		hobbystr = hobbystr + hobby + " " ;
	}
	%>
	
	
	<p>주민등록번호: <jsp:getProperty property="ssn1" name="member"/>
	-<jsp:getProperty property="ssn2" name="member"/></p>
	<p>우편번호: <jsp:getProperty property="zipcode" name="member"/>
	</p>
	<p>주소: <jsp:getProperty property="address1" name="member"/></p>
	<p>상세주소: <jsp:getProperty property="address2" name="member"/></p>
	<p>참고사항: <jsp:getProperty property="address3" name="member"/></p>
	<p><a href ="login.jsp">로그인</a></p>
	
	<%
	}else{
	%>
	<h2>회원가입 실패</h2>
	<%
	}
	%>
</body>
</html>