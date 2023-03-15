<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.io.File" %>
    <%
    		String deleteImg="4043232_avatar_batman_comics_hero_icon3.png";
    		String deleteImgFullPath = request.getRealPath("/image/") + deleteImg;
    		File img = new File(deleteImgFullPath);
    		
    		if(img.exists() && img.isFile()){
    			img.delete();
    		}
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 삭제</title>
</head>
<body>
	<h2>파일 삭제</h2>
	<p>파일이 정상적으로 삭제되었습니다.</p>
</body>
</html>