<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*"%>
<%@ page import="com.koreait.db.Dbconn"%>
<%@ include file="../include/sessioncheck.jsp"%>

<%
	String b_idx = request.getParameter("b_idx");
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	String b_userid ="";
	String b_name ="";
	String b_title ="";
	String b_regdate ="";
	String b_content ="";
	int b_hit =0;
	int b_like =0;
	
	
	try {
		conn = Dbconn.getConnection();
		if (conn != null) {
			
			String  sql = "update tb_board set b_like = b_like +1 where b_idx =?";
			  pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, b_idx);
				pstmt.executeUpdate();
				
			 sql = "select b_like from  tb_board where b_idx=?"; 
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b_idx);
			pstmt.execute();
			rs =pstmt.executeQuery();
			
			
			if(rs.next()){
				 b_like = rs.getInt("b_like");
				}
			
			
			}
	} catch (Exception e) {
		e.printStackTrace();
	}
	out.println(Integer.toString(b_like));
%>
    
    
    
    
    
