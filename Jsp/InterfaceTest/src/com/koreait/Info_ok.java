package com.koreait;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
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
 * Servlet implementation class Info_ok
 */
@WebServlet("/Info_ok")
public class Info_ok extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Info_ok() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html;charset=UTF-8");
	        request.setCharacterEncoding("UTF-8");
	        PrintWriter writer = response.getWriter();
	        HttpSession session = request.getSession();
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        request.setCharacterEncoding("UTF-8");
	        String userid = (String)session.getAttribute("userid");
	        String userpw = request.getParameter("userpw");
	        String name = request.getParameter("name");
	        String hp = request.getParameter("hp");
	        String email = request.getParameter("email");
	        String gender = request.getParameter("gender");
	        String job = request.getParameter("job");

	        String sql = "";
	        String hobbystr = "";

	        try {
	            conn = Dbconn.getConnection();
	            if (conn != null) {
	                sql = "select mem_idx from tb_ts_member where mem_userid=? and mem_userpw=sha2(?,256)";
	                pstmt = conn.prepareStatement(sql);
	                pstmt.setString(1, userid);
	                pstmt.setString(2, userpw);
	                rs = pstmt.executeQuery();
	                if (rs.next()) {
	                    sql = "update tb_ts_member set mem_name=?, mem_hp=?, mem_email=?, mem_gender=?, mem_job=?  where mem_userid=?";
	                    pstmt = conn.prepareStatement(sql);
	                    pstmt.setString(1, name);
	                    pstmt.setString(2, hp);
	                    pstmt.setString(3, email);
	                    pstmt.setString(4, gender);
	                    pstmt.setString(5, job);
	                    pstmt.setString(6, userid);
	                    pstmt.executeUpdate();
	                    writer.println("<script>alert('변경되었습니다!');location.href='login.jsp';</script>");
	                } else {
	                    writer.println("<script>alert('비밀번호를 확인하세요!');history.back();</script>");
	                }
	            }
	        } catch (Exception var24) {
	            var24.printStackTrace();
	        }
	}

}
