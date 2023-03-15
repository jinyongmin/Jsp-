package com.koreait;

import java.io.IOException;
import java.sql.Connection;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.db.Dbconn;
/**
 * Servlet implementation class Login
 */
@WebServlet("/Login_ok")
public class Login_ok extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login_ok() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//System.out.println("doGet 메소드 호출!");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		//???
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		  request.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();
		HttpSession session = request.getSession();
		
		String mem_userid =request.getParameter("mem_userid");
		String mem_userpw =request.getParameter("mem_userpw");
		Connection conn = null;
		ResultSet rs =null;
		
		try {
			conn =Dbconn.getConnection();
		if(conn != null) {
			String sql="select mem_idx, mem_name from tb_member where mem_userid=? and mem_userpw=sha2(?,256)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,mem_userid);
		pstmt.setString(2,mem_userpw);
		rs = pstmt.executeQuery();
		}
		if(rs.next()) {
			session.setAttribute("mem_userid",mem_userid);		
			session.setAttribute("mem_idx",rs.getInt("mem_idx"));	
			session.setAttribute("mem_name",rs.getString("mem_name"));	
		writer.println("<script>alert('로그인되었습니다'); location.href='login.jsp';</script>");
	
		}else {
			writer.println("<script>alert('아이디또는비밀번호를 확인하세요'); history.back();</script>");
			}
	}
}catch(Exception var11) {
	var11.printStackTrace();
		}
	}
}