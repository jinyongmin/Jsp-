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
 * Servlet implementation class Write_ok
 */
@WebServlet("/Write_ok")
public class Write_ok extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Write_ok() {
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
        String userid = (String)session.getAttribute("userid");
        String b_title = request.getParameter("b_title");
        String b_content = request.getParameter("b_content");
        int b_idx=0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String po_boardidx ="";
    	String po_userid= "";
        int po_point = 100;
        int po_totpoint =0;
        
        try {
            conn = Dbconn.getConnection();
            if (conn != null) {
                String sql = "insert into tb_ts_board(b_userid, b_title, b_content)values(?,?,?)";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, userid);
                pstmt.setString(2, b_title);
                pstmt.setString(3, b_content);
                pstmt.executeUpdate();
                
                sql="select b_idx from tb_ts_board where b_userid =? and b_title=? order by b_idx desc;";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, userid);
                pstmt.setString(2, b_title);
                rs=pstmt.executeQuery();
                
				if(rs.next()) {
					b_idx=rs.getInt("b_idx");
				}
				
				sql="select * from tb_ts_point where po_userid=? order by po_idx desc";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, userid);
                rs=pstmt.executeQuery();
                
				if(rs.next()) {
					po_totpoint =rs.getInt("po_totpoint");
			        
				}
				
				po_totpoint+=po_point;
				
				
				sql="insert into tb_ts_point(po_boardidx, po_userid, po_point, po_totpoint)values(?,?,?,?)";
                pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, b_idx);
                pstmt.setString(2, userid);
                pstmt.setInt(3, po_point);
                pstmt.setInt(4, po_totpoint);
                pstmt.executeUpdate();
                
				
				sql = "update tb_ts_member set mem_point=?  where mem_userid=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, po_totpoint);
                pstmt.setString(2, userid);
				pstmt.executeUpdate();
				

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        writer.println("<script>alert('등록되었습니다');location.href='./board/list.jsp'</script>");
	}

}
