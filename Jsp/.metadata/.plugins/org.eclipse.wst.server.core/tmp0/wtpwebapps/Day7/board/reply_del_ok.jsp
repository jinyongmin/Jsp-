<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/sessioncheck.jsp"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.koreait.db.Dbconn"%>

<%
	String b_idx = request.getParameter("b_idx");
	String re_idx = request.getParameter("re_idx");

	String userid = (String) session.getAttribute("userid");

	String re_boardidx = "";
	Connection conn = null;
	PreparedStatement pstmt = null;

	try {
		conn = Dbconn.getConnection();
		if (conn != null) {
			/* 	http://localhost:9090/Day4/board/delete_ok.jsp?b_idx=8  URL로 삭제하는 방법*/
			String sql = "delete from tb_reply where re_idx =? and re_userid=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, re_idx);
			pstmt.setString(2, userid);
		
			pstmt.executeUpdate();

		}
	} catch (Exception e) {
		e.printStackTrace();
	}
%>


<script>
	alert('삭제되었습니다.')
	location.href = 'view.jsp?b_idx=<%=b_idx%>';                      
</script>