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

import com.google.protobuf.StringValue;
import com.koreait.db.Dbconn;

/**
 * Servlet implementation class Member_ok
 */
@WebServlet("/Member_ok")
public class Member_ok extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Member_ok() {
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
        request.setCharacterEncoding("UTF-8");
        String userid = request.getParameter("userid");
        String userpw = request.getParameter("userpw");
        String name = request.getParameter("name");
        String hp = request.getParameter("hp");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String job = request.getParameter("job");


        try {
            conn = Dbconn.getConnection();
            if (conn != null) {
                String sql = "insert into tb_ts_member(mem_userid, mem_userpw, mem_name, mem_hp, mem_email, mem_gender, mem_job)  values(?,sha2(?,256),?,?,?,?,?)";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, userid);
                pstmt.setString(2, userpw);
                pstmt.setString(3, name);
                pstmt.setString(4, hp);
                pstmt.setString(5, email);

                pstmt.setString(6, gender);
                pstmt.setString(7, job);
                pstmt.executeUpdate();
                session.setAttribute("name", name);
                session.setAttribute("userid", userid);
                writer.println("<script>location.href='member.jsp'; </script>");
            }
        } catch (Exception var23) {
            var23.printStackTrace();
        }
	}

}
