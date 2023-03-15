package com.koreait.db;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class delete_ok
 */
@WebServlet("/delete_ok")
public class delete_ok extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delete_ok() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		HttpSession session = request.getSession();
		
		String b_idx=request.getParameter("b_idx");
		String userid=request.getParameter("userid");
		String conn=request.getParameter("conn = Dbconn.getConnection();");
		writer.println(conn);
		if(conn != null){
			String sql = "delete from tb_board where b_idx=? and b_userid=?";
 			String pstmt = request.getParameter("conn.prepareStatement(sql);");
 			writer.println("pstmt.setString(1, b_idx);");
 			writer.println("pstmt.setString(2, userid);");
 			
 			writer.println("pstmt.executeUpdate();");
		}else {
		writer.println("<script>alert('삭제되었습니다.');location.href=./board/'list.jsp';</script>");
	}
	}
}
