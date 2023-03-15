<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/sessioncheck.jsp"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.koreait.db.Dbconn"%>

<%
	String b_idx = request.getParameter("b_idx");

	String userid = (String) session.getAttribute("userid");

	Connection conn = null;
	PreparedStatement pstmt = null;

	try {
		conn = Dbconn.getConnection();
		if (conn != null) {
			/* 	http://localhost:9090/Day4/board/delete_ok.jsp?b_idx=8  URL로 삭제하는 방법*/
			String sql = "delete from tb_board where b_idx =? and b_userid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b_idx);
			pstmt.setString(2, userid);
			pstmt.executeUpdate();

		}
	} catch (Exception e) {
		e.printStackTrace();
	}
%>


<script>
	alert('삭제되었습니다.')
	location.href = 'list.jsp';                      
</script>