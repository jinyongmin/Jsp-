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
 * Servlet implementation class re_del_ok
 */
@WebServlet("/re_del_ok")
public class re_del_ok extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public re_del_ok() {
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
		
		String b_idx= request.getParameter("b_idx");
		String re_idx= request.getParameter("re_idx");
		String userid= (String)session.getAttribute("userid");

		try{
			String conn=request.getParameter("conn = Dbconn.getConnection();");

			if(conn != null){
				String sql = "delete from tb_reply where re_idx=? and re_userid=?";
	 			writer.println("pstmt = conn.prepareStatement(sql);");
	 			writer.println("pstmt.setString(1, re_idx);");
	 			writer.println("pstmt.setString(2, userid);");
	 			writer.println("pstmt.executeUpdate();");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		writer.println("<script>alert('삭제되었습니다.');location.href=./board/'view.jsp?b_idx=<%=b_idx%>';</script>");
	}

}
