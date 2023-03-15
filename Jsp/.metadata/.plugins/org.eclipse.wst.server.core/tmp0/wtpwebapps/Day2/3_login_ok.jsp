<%@ page language="java" contentType="text/html; charset=UTF-8"		
    pageEncoding="UTF-8"%>
<%
	String userid = request.getParameter("userid");		//초록색부분 맞추기!
	String userpw = request.getParameter("userpw");	//초록색부분 맞추기!

	if(userid.equals("apple") && userpw.equals("1234")){		//로그인 성공!		//post방식에서 입력한 코드 안보임 get에서는 보임!
		Cookie cookie = new Cookie("userid",userid);				//로그인 했을떄 쿠키로 심어줌
		cookie.setMaxAge(60*10);											//10분동안 로그인 유지
		response.addCookie(cookie);
		%>
		<!--  ok에서 실행 x!! jsp에서 실행 ok에서는 값을 받아서 실질적인 코드를 사용! -->
<script>	 
			alert('로그인 되었습니다');
			location.href="3_login.jsp";			//??		refresh 데이터 갱신		로그인되었습니다 창이 뜬뒤에 login.jsp로이동!	if쪽 다음 else부분으로!
</script>
	
	
	<%											
	}else{
														//로그인 실패!!
	
%>
<script>
alert('아이디 또는 비밀번호를 확인하세요');
history.back();											
														//history.back()??		cash가 남음 cash정보 저장해서 앞으로 뒤로 이동 가능!
</script>
<%
	}
%>