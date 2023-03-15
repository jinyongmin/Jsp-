<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.koreait.db.Dbconn"%>

<%@ include file="../include/sessioncheck.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");



	String b_idx = request.getParameter("b_idx");
	String re_content = request.getParameter("re_content");
	String userid = (String) session.getAttribute("userid");
	String name = (String) session.getAttribute("name");

	Connection conn = null;
	PreparedStatement pstmt = null;

	try {
		conn = Dbconn.getConnection();
		if (conn != null) {
			String sql = "insert into tb_reply(re_userid, re_name, re_content, re_boardidx) values(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setString(2, name);
			pstmt.setString(3, re_content);
			pstmt.setString(4, b_idx);
			pstmt.executeUpdate();
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
%>

<script>
	alert('등록되었습니다.');
	location.href='./view.jsp?b_idx=<%=b_idx%>';
</script>