<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session.invalidate();	//세션삭제!			//결제가 완료되었을 때 다시 기본 담기 페이지로 이동!
	response.sendRedirect("7_basket.jsp");

%>
