<%@page import="com.koreait.db.Dbconn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.koreait.db.Dbconn"%>
<%
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String userid = request.getParameter("userid");
	try{
		conn = Dbconn.getConnection();
		if(conn != null){
			String sql = "select mem_idx from tb_member where mem_userid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				out.print("no");
			}else{
				out.print("ok");
			}
		}
	}catch(Exception e){
		e.printStackTrace();
	}
%>