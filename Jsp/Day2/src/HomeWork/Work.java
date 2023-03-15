package HomeWork;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class Work
 */
@WebServlet("/Work")
public class Work extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Work() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doget 메소드 호출!");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();

		
		
		int sum=0;
	List<String> list=(List)session.getAttribute("productList");
	if(list != null){
		for(String product : list){
			if("그래픽카드".equals(product)){
				sum +=1300000;
				
			}else if("닌텐도".equals(product)){
				sum+= 400000;
			}else if("맥북프로".equals(product)){
				sum +=3800000;
			}else if("34인치 모니터".equals(product)){
				sum+=500000;
			}else if("페라리로마".equals(product)){
				sum +=320000000;
			}else if("집".equals(product)){
				sum +=800000000;
			}
		}
	

			}
		}
//				response.sendRedirect("9_login.jsp");
	}


