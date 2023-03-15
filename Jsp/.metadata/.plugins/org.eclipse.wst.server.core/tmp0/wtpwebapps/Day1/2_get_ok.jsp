<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    		request.setCharacterEncoding("UTF-8");				// 파일(jsp, html)에서 폼 태그에 입력한 값을 전송했을때 한글이 깨지지 않게 하기 위해 사용 request.setCharacterEncoding("UTF-8");
    		String userid = request.getParameter("userid");	//request.getParameter: 클라이언트가 받은 변수를(userid)를 요청 get.jsp form태그 안의 값을 받아옴
    		String userpw = request.getParameter("userpw");
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전송방식(get)</title>
</head>
<body>
		<h2>전송방식</h2>
		<p>아이디: <%=userid%></p>		<!-- userid 값을 받아온 변수 userid를 사용할때 <안에 사용?> -->
		<p>비밀번호: <%=userpw%></p>
</body>
</html>