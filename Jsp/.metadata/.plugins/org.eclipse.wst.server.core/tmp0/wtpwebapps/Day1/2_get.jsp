<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전송방식</title>
</head>
<body>
	<h2>전송방식(get)</h2>
	<form method="get" action="2_get_ok.jsp">			<!-- get방식은 도메인에 정보를 보여준다! action 실제 실행될 코드 form 형태의 코드를 get_ok에서 받음-->
		<p>아이디:<input type = "text" name="userid"></p> 
		<p>비밀번호:<input type = "password" name="userpw"></p> 
		<p><input type = "submit" value="로그인"></p> 	<!-- submit 타입? -->
		<p><a href="2_get_ok.jsp?userid=banana&userpw=2222">바나나 전송</a></p>	<!-- 도메인에 주소가 나옴 (get)방식의 특징 -->>
	</form>


</body>
</html>