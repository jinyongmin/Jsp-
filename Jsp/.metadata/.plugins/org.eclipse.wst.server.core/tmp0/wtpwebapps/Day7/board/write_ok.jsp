<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.koreait.db.Dbconn" %>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page import="com.koreait.FileService" %>
<%@ page import="java.io.File" %>
<%@ include file="../include/sessioncheck.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
	
	FileService fs = new FileService();
	String savePath = fs.SAVE_PATH;
	int maxSize = fs.MAX_SIZE;
	String format = fs.ENC_FORMAT;
	String uploadFile = "";
	File file = null;
	
	try{
		MultipartRequest mr = new MultipartRequest(request, savePath, maxSize, format, new DefaultFileRenamePolicy());
		String userid = (String)session.getAttribute("userid");
		String name = (String)session.getAttribute("name");
		String b_title = mr.getParameter("b_title");
		String b_content = mr.getParameter("b_content");
		uploadFile = mr.getFilesystemName("b_file");
		boolean isSuccess = false;
		
		if(uploadFile != null){
			file = new File(savePath + "/" + uploadFile);
			isSuccess = fs.dataUpload(userid, name, b_title, b_content, file);
		}else{
			isSuccess = fs.dataUpload(userid, name, b_title, b_content);
		}
		
		if(isSuccess){
			out.print("<script>alert('등록되었습니다!');location.href='list.jsp';</script>");
		}else{
			out.print("<script>alert('에러발생!');history.back();</script>");
		}
		
	}catch(Exception e){
		e.printStackTrace();
	}
%>