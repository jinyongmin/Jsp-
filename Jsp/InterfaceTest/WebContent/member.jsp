<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
		String userid = null;
		String name = null;
		boolean aaa= false;
    	if(session.getAttribute("userid") != null && (aaa==false)){ 
            <!-- aaa==false 왜?? -->
    		userid =(String)session.getAttribute("userid");
    		name =(String)session.getAttribute("name");
    	}
    %>    
    
    
<!DOCTYPE html>
<html lang="en">
<head>
<!--두번째줄 
    세번째줄 뷰포트??  -->
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>
</head>
<body>
<% 
	if(userid == null){
%>
    <h2>회원가입</h2>
    <form action="Member_ok" name="regform" id="regform" method="post" >
        <!--method="post" 넘어갈때 보이지 않게 함  -->

        <p>아이디 : <input type="text" name="userid" id="userid" maxlength="20" ></p>  
        <p>비밀번호: <input type="password" name="userpw" id="userpw" maxlength="20"></p>

        <p>이름: <input type="text"name="name" id="name"></p>
        <p>이메일 <input type="text" name="email" id="email"></p>
        <p>성별 : 
        <label> 남자<input type="radio" name="gender" value="남자" checked></label>
        <label>여자<input type="radio" name="gender" value="여자" ></label></p>
        <p>휴대폰 번호: <input type ="text" name="hp" id="hp"></p>

        <p>직업 : <input type="text" name="job" id="job" maxlength="20" ></p>  


        <p><button>가입완료</button><button type="reset">다시작성</button></p>
        <!-- 버튼의 기본은 서브밋 -->
	<%
		aaa=true;
		}else{
	%>
	<h2>회원가입 완료</h2>
	<p><%=name%> (<%=userid%>)님 회원가입이 완료되었습니다.</p>
	<p><a href="login.jsp">로그인하러 가기</a></p>
	<%
		}
	%>

    </form>
</body>
</html>