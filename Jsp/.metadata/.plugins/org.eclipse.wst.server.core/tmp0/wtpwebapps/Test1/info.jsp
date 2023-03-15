<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">


<title>정보수정</title>
</head>
<body>
	<h2>정보수정</h2>
	<from action="Info_ok" name="regform" id="regform" method="post">


<p>아이디: <%=mem_userid %></p>
<p>비밀번호: <input type="password" name="userpw" id="userpw" maxlength="20"></p>

        <p>이름: <input type="text"name="mem_name" id="mem_name" value="<%=mem_name%>"></p>
        <p>휴대폰 번호: <input type ="text" name="mem_hp" id="mem_hp" value="<%=mem_hp%>"></p>
        <p>이메일 <input type="text" name="mem_email" id="mem_email" value="<%=mem_email%>"></p>
        
        <p>성별 : 
        <label> 남자<input type="radio" name="gender" value="남자" <% if(mem_gender.equals("남자")) out.print("checked"); %>></label>
        <label>여자<input type="radio" name="gender" value="여자" <% if(mem_gender.equals("여자")) out.print("checked"); %>></label>
        </p>
        <p>직업 : <input type="text" name="job" id="job" maxlength="20" ></p>  
		<p><button>수정완료</button>|<button onclick="location.href='login.jsp'">돌아가기</button></p>
</from>
</body>
</html>