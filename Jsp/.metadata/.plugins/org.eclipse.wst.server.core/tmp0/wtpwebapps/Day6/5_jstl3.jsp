<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="fn" uri ="http://java.sun.com/jsp/jstl/functions"%>
    <%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl - functions</title>
</head>
<body>
<h2>jstl - functions</h2>
<p>${fn:length('1234567890')}</p>

<p>${fn:indexOf('jstl 예제', 's')}</p>

<p>${fn:trim('          jstl 예제              ')}</p>
<hr>
<p>${fn:substring('jstl 예제',0,3)}</p>

<p>${fn:replace('jstl 예제','jstl','jsp')}</p>

<c:set var="arr" value="${fn:split('j,s,t,l', ' , ')}"/>

<c:forEach var="ch" items="${arr}" varStatus="i">

<p>${i.count} :%{ch}</p>
</c:forEach>
</body>
</html>