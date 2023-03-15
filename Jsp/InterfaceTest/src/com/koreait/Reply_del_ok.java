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
 * Servlet implementation class Reply_del_ok
 */
@WebServlet("/Reply_del_ok")
public class Reply_del_ok extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reply_del_ok() {
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
        String re_idx = request.getParameter("re_idx");
        String userid = (String)session.getAttribute("userid");
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = Dbconn.getConnection();
            if (conn != null) {
                String sql = "delete from tb_ts_reply where re_idx=? and re_userid=?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, re_idx);
                pstmt.setString(2, userid);
                pstmt.executeUpdate();
            }
        } catch (Exception var11) {
            var11.printStackTrace();
        }

        writer.println("<script>alert('삭제되었습니다.');location.href='./board/view.jsp?b_idx=" + b_idx + "'" + "</script>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
