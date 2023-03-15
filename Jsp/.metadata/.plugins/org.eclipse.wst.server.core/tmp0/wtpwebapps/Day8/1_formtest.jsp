<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>폼 테스트</title>
</head>
<body>
		<h2>폼 테스트</h2>
		<!-- <form method="get" action="1_formtest_ok.jsp"> get방식 -->
		<!--<form method="post" action="1_formtest_ok.jsp"> post방식-->
		<form method="post" action="Formtest">
		<p>메세지: <input type="text" name="msg"></p>
		<p><button>전송</button></p>
		</form>
</body>
</html>