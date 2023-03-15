<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
		String userid = request.getParameter("userid");
		String userpw = request.getParameter("userpw");
		
		out.println("아이디는" +userid+"이며, 비밀번호는"+userpw+"입니다.");

%>