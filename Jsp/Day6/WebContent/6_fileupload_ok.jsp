<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.oreilly.servlet.MultipartRequest" %>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%
	MultipartRequest mr = new MultipartRequest(request, request.getRealPath("/image"), 1024*1024*1024, "utf-8", new DefaultFileRenamePolicy());	//이미지폴더 절대경로
	String fileName = mr.getFilesystemName("image");	//파일이름
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드</title>
</head>
<body>
	<p>파일 업로드 되었습니다</p>
	<p>저장되는 실제 경로: <%=request.getRealPath("/image")%></p>
	<p>사진 파일이름: <%=fileName %></p>
</body>
</html>