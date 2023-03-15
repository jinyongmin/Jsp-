<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String mem_userid =null;
    if(session.getAttribute("mem_userid")!= null){
    	mem_userid=(String)session.getAttribute("mem_userid");
    }
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<h2>로그인</h2>
	<%
		if(mem_userid == null){
			
		
	%>
	<form method ="post" action="Login_ok">
		<p>아이디: <input type="text" name="mem_userid"></p>
		<p>비밀번호: <input type="password" name="mem_userpw"></p>
		<p><button>로그인</button></p>
	</form>
<form method ="post" action="Joiner.jsp">
	<p>아직 회원이 아니신가요?<button>회원가입 </button></p>
	</form>	
	<%
	//aaa=true; aaa 는 트루!	
		}else{
			
		
	%>
	<h3><%=mem_userid %>님 환영합니다.!!!!</h3>
<p><a
	 href ="Logout">로그아웃</a> | <a href ='info.jsp'>정보수정</a>| <a href='list.jsp'>게시판</a> </p>
	<!-- 기존에 같은 값으로 덮어씌우면 쿠키값을 없는것처럼 할 수 있고 아니면 시간을 0 또는 마이너스로 -->
	<%
		}
	%>
</body>
</html>