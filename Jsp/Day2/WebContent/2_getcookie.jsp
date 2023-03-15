<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    //	Cookie cookie1 = new Cookie("userid","apple");  Cookie cookie2 = new Cookie("name","김사과");??  향상된 for문에서 돌아가는이유 Cookie cookie : cookies?
    	
    	Cookie[] cookies = request.getCookies();		//쿠키 읽어오기!배열로 읽음 항상! 		사용자가 내페이지에 오면서 requset 객체에 정보를 저장된것을 받아오겠다!
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키읽기</title>
</head>
<body>
	<h2>쿠키읽기</h2>
	<%
		for(Cookie cookie : cookies){
			out.println(cookie.getName()+":"+cookie.getValue() +"<br>");	//네임 : 키 벨류 :값
		}
	%>
</body>
</html>