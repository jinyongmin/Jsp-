<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String userid = null;
    	if(session.getAttribute("userid") != null){
    		userid = (String)session.getAttribute("userid");		//리턴해주는건 세션 객체이기 때문에 저장이 안됨 session 문자열 만들어줌 다운캐스팅하면 스트링으로 형변환 저장가능!
    	}else{
    		userid ="아이디 없음";
    	}
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션 읽어오기</title>
</head>
<body>
	<h2>세션 읽어오기</h2>
		<p>세션 아이디: <%=session.getId()%></p>
		<p>세션 변수(아이디): <%=userid%></p>
	
</body>
</html>