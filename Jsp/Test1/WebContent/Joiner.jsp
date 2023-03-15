<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    //회원가입 앵커태그 -> 앵커태그는 자바에서 적용됨 ok파일로 가는 변수 선언
    String mem_userid =null;
    String mem_name=null;
    boolean aaa = false;
    if(session.getAttribute("mem_userid") != null &&(aaa==false)){
    	mem_userid = (String)session.getAttribute("mem_userid");
    	mem_name = (String)session.getAttribute("mem_name");
    }
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<style>
p{color:deepskyblue;}
</style>
<body>
	<%
	if(mem_userid == null){
	%>
		<!-- method="post" 넘어갈 때 보이지 않게 함 -->
	<h2>회원가입</h2>
	<form action="Joiner_ok" name="regform" id="regform"
		method="post">
	<p>아이디:<input type="text" name="mem_userid" id="mem_userid" maxlength="20" >
			<input type="button" id="btnIdCheck" value="중복체크"></p>
	<p>비밀번호:<input type="password" name="mem_userpw" id="mem_userpw"
				maxlength="20"></p>
	<p>이름:<input type="text" name="mem_name" id="mem_name"></p>
	<p>이메일:<input type="text" name="mem_email" id="mem_email"></p>
	<p>성별:<label> 남자 <input type="radio" name="gender" value="남자"
				checked></label> <label> 여자 <input type="radio"
				name="gender" value="여자"></label></p>
	<p>전화번호:<input type="text" name="mem_hp" id="mem_hp"></p>
	<p>직업:<input type="text" name="mem_job" id="mem_job"></p>
	
	<p><button>가입완료</button><button type="reset">다시작성</button>
	<!-- 버튼의 기본은 서브밋	reset은 ??? 전체 입력한 값을 지워줌 -->
	<%
	aaa= true;
	}else{
	 %>
	 <h2>회원가입 완료</h2>
	<p><%=mem_name %> (<%=mem_userid%>)님 회원가입이 완료되었습니다.</p>
	<p><a href="login.jsp">로그인하러 가기</a></p>
	<%
	}
	%>
	</form>
	</body>
</html>