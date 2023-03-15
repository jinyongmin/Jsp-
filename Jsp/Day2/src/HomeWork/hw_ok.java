package HomeWork;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class hw_ok
 */
@WebServlet("/hw_ok")
public class hw_ok extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public hw_ok() {
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
		request.setCharacterEncoding("UTF-8");
		// String product = request.getParameter("product");	//product를 받아서 저장
		String product = request.getParameter("product") == null ? "" : request.getParameter("product");//null값 =빈값  아니면 product
		HttpSession session = request.getSession();
		PrintWriter writer = response.getWriter();
		
		List list = (List)session.getAttribute("productList");//	세션에 저장된	세션변수중에 productList이 있으면 list로 형변환		// 세션변수를 리스트로 바로 바꿀수 없음 리스트로 형변환해서 뽑음	데이터를 담아줌
		if(list == null){
			list = new ArrayList();	//list는 arrayList의 부모이기 때문에 만들 수 있음
		}
		
		list.add(product);
		session.setAttribute("productList", list);	//arraylist 자체를 세션에 담을수 있음
		writer.println("<script>alert('"+product+"상품이 장바구니에 추가되었습니다');"
				+ " location.href='10_hw.jsp';</script>");
	
	
	
	}

}
