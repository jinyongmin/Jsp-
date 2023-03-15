<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String userid = request.getParameter("userid");	//무조건 name에 입력된 변수명과 일치해야하고 값을 가져옴
	String userpw = request.getParameter("userpw");
	
	if(userid.equals("apple") && userpw.equals("1234")){
		//로그인 => 로그인시 쿠키생성
		session.setAttribute("userid", userid);
		//유저 아이디를 세션변수로 저장!
%>
	<script>
		alert('로그인 되었습니다.');
		location.href="6_login.jsp";
		//리플레쉬 : 새로고침이 됨
	</script>
<%		
	}else{
		//로그인 실패
%>		
	<script>
		alert("아이디 또는 비밀번호를 확인하세요");
		history.back();
		// 캐시가 남는다.
	</script>
<%	
	}
%>