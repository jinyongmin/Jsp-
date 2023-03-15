<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.koreait.db.Dbconn"%>
<%@ include file="./include/sessioncheck.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");

%>
<jsp:useBean class="com.koreait.Member" id="member"/>
<jsp:setProperty property="*" name="member"/>
<jsp:useBean class="com.koreait.MemberDAO" id="dao"/>

<%
	member.setUserid((String)session.getAttribute("userid"));
	if(!dao.pwCheck(member)){
%>
<script>
	alert('비밀번호가 틀렸습니다.');
	history.back();
</script>
<%
	}else {
	if(dao.edit(member)){
		%>
		<Script>
		alert('수정되었습니다');
		location.href = 'login.jsp'
		</Script>
		<%
	}else{
		%>
		<Script>
		alert('실패하였습니다.');
		history.back();
		</Script>
		<%
	}
	}
%>