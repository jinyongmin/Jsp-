<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(session.getAttribute("userid") == null){
%>
		<script>
			alert('로그인 후 접속하세요!');
			location.href='login.jsp';
		</script>
<%
	return;
	}
%>