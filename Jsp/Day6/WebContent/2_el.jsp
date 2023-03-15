<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>el</title>
</head>
<body>
			<h2>el</h2>
			<p>덧셈: ${10 + 2}</p>
			<p>뺄셈: ${10 - 2}</p>
			<p>곱셈: ${10 * 2}</p>
			<p>나눗셈: ${10 / 2}</p>			<!-- /  -->
			<p>나눗셈: ${10 div 2}</p>			<!-- /  div 이클립스가 못받아들임 -->
			<p>나눗셈: ${10 % 2}</p>			
			<p>나눗셈: ${10 mod 2}</p>			
			<hr>
			<p>크다: ${ 10 > 2 }</p>
			<p>크다: ${ 10 gt 2 }</p>
			<p>작다: ${ 10 < 2 }</p>
			<p>작다: ${ 10 lt 2 }</p>
			<p>같다: ${ 10 == 2 }</p>
			<p>같다: ${ 10 eq 2 }</p>
			<p>다르다: ${ 10 != 2 }</p>
			<p>다르다: ${ 10 ne 2 }</p>
			<p>크거나같다: ${ 10 >= 2 }</p>
			<p>크거나같다: ${ 10 ge 2 }</p>
			<p>작거나같다: ${ 10 <= 2 }</p>
			<p>작거나같다: ${ 10 le 2 }</p>

			<jsp:useBean id="test" class="com.koreait.Eltest"/>
			<p>test.getStr() : ${test.getStr()}</p>
			<p>test.setStr("Hello el") : ${test.setStr("Hello el")}</p> 
			<p>test.getStr() : ${test.getStr()}</p>
			<p>test.sum(10,5) : ${test.sum(10,5)}</p>
		
		
</body>
</html>