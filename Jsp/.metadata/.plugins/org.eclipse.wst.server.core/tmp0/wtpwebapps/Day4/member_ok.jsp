<%@page import="com.koreait.db.Dbconn"%>
<%@page import="java.sql.*"%>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	
    	request.setCharacterEncoding("UTF-8");
    	String userid = request.getParameter("userid");
    	String userpw = request.getParameter("userpw");
    	String name = request.getParameter("name");
    	String hp = request.getParameter("hp");
    	String email = request.getParameter("email");
    	String gender = request.getParameter("gender");
    	String hobby[] = request.getParameterValues("hobby");
    	String ssn1 = request.getParameter("ssn1");
    	String ssn2 = request.getParameter("ssn2");
    	String zipcode = request.getParameter("zipcode");
    	String address1 = request.getParameter("address1");
    	String address2 = request.getParameter("address2");
    	String address3 = request.getParameter("address3");
    	
    	try{
    		conn = Dbconn.getConnection();
    		if(conn != null){
    		// System.out.println("DB연결 성공!");
    		String sql = "insert into tb_member(mem_userid, mem_userpw, mem_name, mem_hp, mem_email, mem_hobby, mem_ssn1, mem_ssn2, mem_zipcode, mem_address1, mem_address2, mem_address3, mem_gender) values (?, sha2(?, 256), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    		pstmt = conn.prepareStatement(sql);
    		pstmt.setString(1, userid);
    		pstmt.setString(2, userpw);
    		pstmt.setString(3, name);
    		pstmt.setString(4, hp);
    		pstmt.setString(5, email);
    		String hobbystr = "";
    		for(int i=0;i<hobby.length;i++){
    			hobbystr = hobbystr + hobby[i] + " ";
    		}
    		pstmt.setString(6, hobbystr);
    		pstmt.setString(7, ssn1);
    		pstmt.setString(8, ssn2);
    		pstmt.setString(9, zipcode);
    		pstmt.setString(10, address1);
    		pstmt.setString(11, address2);
    		pstmt.setString(12, address3);
    		pstmt.setString(13, gender);
    		pstmt.executeUpdate();
    		}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 완료</title>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("sample6_extraAddress").value = extraAddr;
                
                } else {
                    document.getElementById("sample6_extraAddress").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample6_postcode').value = data.zonecode;
                document.getElementById("sample6_address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("sample6_detailAddress").focus();
            }
        }).open();
    }


    </script>
</head>
<body>
	<h2>회원가입 완료</h2>
	<p><%=name%>(<%=userid%>)님 회원가입이 완료되었습니다!</p>
	<p><a href="login.jsp">로그인 하러가기</a></p>
</body>
</html>