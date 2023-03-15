package Com.koreait;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//System.out.println("doGet 메소드 호출!");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		HttpSession session = request.getSession();
		
		String userid =request.getParameter("userid");
		String userpw =request.getParameter("userpw");
		System.out.println(userid);
		System.out.println(userpw);
	
		
		if(userid.equals("apple") && userpw.equals("1234")){
		session.setAttribute("userid",userid);		
		writer.println("<script>alert('로그인되었습니다'); location.href='9_login.jsp';</script>");
		}else {
			writer.println("<script>alert('아이디또는비밀번호를 확인하세요'); history.back();</script>");
//			response.sendRedirect("9_login.jsp");
		}
		
	}
}
