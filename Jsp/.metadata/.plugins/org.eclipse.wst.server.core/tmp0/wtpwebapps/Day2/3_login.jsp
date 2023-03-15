<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	Cookie[] cookies = request.getCookies();		//request객체 배열불러오는 변수 cookies 를쓰면 getCookies에 쓰인행동을 가져옴? Cookies는 쓰지도 않았는데 어떻게 알고 가져올까? cookie를 cookies(cookie안의 값들)까지 for문을 돌린다?
    	String userid = null;
    	
    	if(cookies != null){													//null값을 나중에 확인 안하면 nullPointexception해야함!
    		for(Cookie cookie : cookies){						//??
    			if("userid".equals(cookie.getName())){			//userid와같ㅇ
    				userid = cookie.getValue();					//userid가 있으면 null값이 아님!
    			}
    		}
    	}
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키로 구현한 로그인</title>
</head>
<body>
	<h2>쿠키로 구현한 로그인</h2>
	<%
		if(userid ==null){	//id가 없으면 다시 로그인창나오게!
	%>
	<form method="get" action="3_login_ok.jsp">
	<p>아이디: <input type="text" name="userid"></p>
	<p>비밀번호: <input type="password" name="userpw"></p>
	<p><button>로그인</button></p>
	
	</form>
	<%
		}else{
	%>
		<h3><%=userid%>님 환영합니다!!!!!!</h3>
		<p><a href="3_logout.jsp">로그아웃</a></p>	
		
	<%			//로그아웃페이지 3_logout.jsp
			}
	
	%>
</body>
</html>