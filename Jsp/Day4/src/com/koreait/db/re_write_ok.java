
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
 * Servlet implementation class re_wriye_ok
 */
@WebServlet("/re_wriye_ok")
public class re_write_ok extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public re_write_ok() {
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
	
		String userid=request.getParameter("userid");
		String name=request.getParameter("name");
		String re_content=request.getParameter("re_content");
		String b_idx=request.getParameter("b_idx");
		String sql = request.getParameter("insert into tb_reply (re_userid, re_name, re_content, re_boardidx) values(?, ?, ?, ?);");
		String conn=request.getParameter("conn = Dbconn.getConnection();");
		writer.println(conn);
			
			if(userid !="userid") {
						writer.println("<script>alert('등록되었습니다.');location.href=./board/'view.jsp?b_idx=<%=b_idx%>'</script>");
					}
		else if(name !="name") {
						writer.println("<script>alert('등록되었습니다.');location.href=./board/'view.jsp?b_idx=<%=b_idx%>'</script>");
					}
		else if(re_content !="re_content") {
						writer.println("<script>alert('등록되었습니다.');location.href=./board/'view.jsp?b_idx=<%=b_idx%>'</script>");
					}
		else if(b_idx!="b_idx") {
						writer.println("<script>alert('등록되었습니다.');location.href=./board/'view.jsp?b_idx=<%=b_idx%>'</script>");
					}
				}
			}

		
	