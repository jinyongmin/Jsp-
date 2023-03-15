<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl - core</title>
</head>
<body>
	<h2>jstl - core</h2>
	<p>출력: <c:out value="${'Hello jstl'}"/></p>
	<c:set var="userid" value="apple"/>
	<p>아이디: ${userid}</p>
	<c:set var="memberList" value='<%=new String[]{"apple","banana","orange","melon"}%>'/>
	<p>memberList: ${memberList}</p>
	<p>memberList: ${memberList[0]}</p>	<!-- 객체의 번호를 써야 배열로 값이 나옴 -->
	<p>memberList: ${memberList[1]}</p>
	<c:remove var="userid"/>
	<!-- 변수 삭제 -->
	<p>아이디: ${userid}</p>
	<hr>
	<!-- test가 true면 " "가 실행 -->
	<c:set var="userid" value="banana"/>
	<c:if test="${userid eq 'banana'}">
		<p>userid는 banana입니다</p>
	</c:if>
		<c:if test="${userid eq 'apple'}">
		<p>userid는 apple입니다</p>
	</c:if>
	<c:remove var="userid"/>
	<c:if test="${empty userid}">
		<p>userid의 값이 없습니다</p>
	</c:if>
	<hr>
	<c:set var="pw" value="1234"/>
	<c:choose>
		<c:when test="${empty pw}">
			<p>비밀번호가 입력되지 않았습니다</p>
		</c:when>
		<c:when test="${not empty pw}">
			<p>비밀번호가 입력되었습니다</p>
		</c:when>
		<c:otherwise>
			<p> 둘다아님</p>
		</c:otherwise>
	</c:choose>
	<hr>
<%
	String[] studentList = {"김사과","반하나","오렌지","이메론"};
	pageContext.setAttribute("list",studentList);
%>	
<table border="1" width="600">
	<tr>
		<th>index</th>
		<th>번호</th>
		<th>이름</th>
	</tr>
	<c:forEach var="student" items="${list}" varStatus="status">
		<tr>
			<td>${status.index}</td>
			<td>${status.count}</td>
			<td>${student}</td>
		</tr>
	</c:forEach>	
</table>
		<hr>
		<c:forEach var="i" begin="1" end="10" step="1">
			${i}<br>
		</c:forEach>



</body>
</html>