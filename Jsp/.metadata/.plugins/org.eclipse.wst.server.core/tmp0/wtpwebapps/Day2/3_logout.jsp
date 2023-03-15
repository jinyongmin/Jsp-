<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Cookie[] cookies = request.getCookies();		//쿠키 불러오기!

	if(cookies != null){
		for(Cookie cookie : cookies){
			if("userid".equals(cookie.getName())){
				Cookie newCookie = new Cookie("userid", "");
				newCookie.setMaxAge(0);
				response.addCookie(newCookie);	//사용자쪽에 보냄
			}
		}
	}
%>
<script>	
	alert('로그아웃 되었습니다');
	location.href='3_login.jsp';	// 다시 메인페이지로 돌아가기

</script>