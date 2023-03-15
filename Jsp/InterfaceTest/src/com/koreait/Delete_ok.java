package com.koreait;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.db.Dbconn;

/**
 * Servlet implementation class Delete_ok
 */
@WebServlet("/Delete_ok")
public class Delete_ok extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete_ok() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	       response.setContentType("text/html;charset=UTF-8");
	        request.setCharacterEncoding("UTF-8");
	        PrintWriter writer = response.getWriter();
	        HttpSession session = request.getSession();
	        String b_idx = request.getParameter("b_idx");
	        String userid = (String)session.getAttribute("userid");
	        Connection conn = null;
	        PreparedStatement pstmt = null;

	        try {
	            conn = Dbconn.getConnection();
	            if (conn != null) {
	                String sql = "delete from tb_ts_board where b_idx=? and b_userid=?";
	                pstmt = conn.prepareStatement(sql);
	                pstmt.setString(1, b_idx);
	                pstmt.setString(2, userid);
	                pstmt.executeUpdate();
	                sql = "delete from tb_ts_b_hit where h_b_idx=?";
	                pstmt = conn.prepareStatement(sql);
	                pstmt.setString(1, b_idx);
	                pstmt.executeUpdate();
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        writer.println("<script>alert('삭제되었습니다.');location.href='./board/list.jsp'</script>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
