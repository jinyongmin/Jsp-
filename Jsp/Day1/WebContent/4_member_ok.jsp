<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%
	request.setCharacterEncoding("UTF-8");
	String userid= request.getParameter("userid");	//"userid" 에 저장된 값을 받아올것을 요청하고 userid에 저장!	"userid"? html에 사용된 userid id? name? // name="" 을 받아옴! 이름으로 값을 반환
	String userpw= request.getParameter("userpw");
	String userpw_re= request.getParameter("userpw_re");
	String name= request.getParameter("name");
	String hp= request.getParameter("hp");
	String email= request.getParameter("email");
	String gender= request.getParameter("gender");
	String zipcode= request.getParameter("zipcode");
	String address1= request.getParameter("address1");
	String address2= request.getParameter("address2");
	String address3= request.getParameter("address3");
	String join= request.getParameter("join");
	String hobby=request.getParameterValues("hobby")[1];
	
%>
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% %>
 <p>아이디:<%=userid%></p>
        <p>비밀번호:<%=userpw%></p>
        <p>비밀번호 확인:<%=userpw_re%></p>
        <p>이름:<%=name%></p>
        <p>휴대폰번호: <%=hp%></p>
        <p>이메일: <%=name%></p>
        <p>성별: <%=gender%></label>
         <p>
            취미:<%=hobby%>
        </p>
         <p>우편번호: <%=zipcode%></p>
            <p>주소:<%=address1 %></p>
            <p>상세주소: <%=address2%></p>
            <p>참고항목: <%=address3%></p>
        <p>가입완료</p>  
        
           
</body>
</html>