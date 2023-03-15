<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String userid =null;
    if(session.getAttribute("userid")!= null){
    	userid=(String)session.getAttribute("userid");
    	//저장 		아이디가 들어가 있으면 로그인된사람 없으면 로그인 안된 사람 
    }
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션으로 구현한 로그인</title>
</head>

<body>
	<h2>로그인</h2>
	<%
		if(userid == null){
			
		
	%>
	<form method ="post" action="5_login_ok.jsp">
		<p>아이디: <input type="text" name="userid"></p>
		<p>비밀번호: <input type="password" name="userpw"></p>
		<p><button>로그인</button></p>
	</form>
	<p>아직 회원이 아니신가요? <a href="5_member.jsp">회원가입</a></p>
	<%
		}else{
	%>
	<h3><%=userid%>님 환영합니다.!!!!</h3>
	<p><a href ="5_logout.jsp">로그아웃</a></p>
	<%
		}
	%>
</body>
</html>