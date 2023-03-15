<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.koreait.db.Dbconn"%>
<%@ include file="./include/sessioncheck.jsp" %>
<%!public static boolean compareHobby(String[] arr, String item) {
		for (String i : arr) {
			if (i.equals(item)) {
				return true;
			}
		}
		return false;
	}%>
<%
	// String idx = (String)session.getAttribute("idx"); // idx를 사용하여 검색하면 속도가 유리(인덱싱)
	String userid = (String) session.getAttribute("userid");
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String mem_name = "";
	String mem_hp = "";
	String mem_email = "";
	String mem_gender = "";
	String mem_job = "";
	try {
		conn = Dbconn.getConnection();
		if (conn != null) {
			// *(별표) 절대 사용하지 말것!
			String sql = "select * from tb_ts_member where mem_userid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				mem_hp = rs.getString("mem_hp");
				mem_name = rs.getString("mem_name");
				mem_email = rs.getString("mem_email");
				mem_gender = rs.getString("mem_gender");
				mem_job = rs.getString("mem_job");
			}
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>정보수정</title>
 
</head>
<body>
    <h2>정보수정</h2>
    <form action="Info_ok" name="regform" id="regform" method="post">
        <!--method="post" 넘어갈때 보이지 않게 함  -->
        
     
        <p>아이디 :  <%=userid%> </p>
         
        <p>비밀번호: <input type="password" name="userpw" id="userpw" maxlength="20"></p>

        <p>이름: <input type="text"name="name" id="name" value="<%=mem_name%>"></p>
        <p>휴대폰 번호: <input type ="text" name="hp" id="hp" value="<%=mem_hp%>"></p>
        <p>이메일 <input type="text" name="email" id="email" value="<%=mem_email%>"></p>
        
        <p>성별 : 
        <label> 남자<input type="radio" name="gender" value="남자" <% if(mem_gender.equals("남자")) out.print("checked"); %>></label>
        <label>여자<input type="radio" name="gender" value="여자" <% if(mem_gender.equals("여자")) out.print("checked"); %>></label>
        </p>
        <p>직업 : <input type="text" name="job" id="job" maxlength="20" ></p>  



        <p><button>수정완료</button> <button type="reset">다시작성</button> <button type="button" onclick="location.href='login.jsp'">돌아가기</button></p>
        <!-- 버튼의 기본은 서브밋 -->
    </form>
</body>
</html>




