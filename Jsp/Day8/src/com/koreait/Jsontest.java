package com.koreait;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

/**
 * Servlet implementation class Jsontest
 */
@WebServlet("/Jsontest")
public class Jsontest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Jsontest() {
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
		response.setContentType("text/html;charset=UTF-8");//2

		ArrayList<User> list = new ArrayList();
		list.add(new User(1, "apple", "김사과", 20, "010-1111-1111", "서울 서초구"));
		list.add(new User(2, "banana", "반하나", 20, "010-2222-2222", "서울 강남구"));
		list.add(new User(3, "orange", "오렌지", 20, "010-3333-3333", "서울 동작구"));
		list.add(new User(4, "melon", "이메론", 20, "010-4444-4444", "서울 구로구"));
		list.add(new User(5, "cherry", "채리", 20, "010-5555-5555", "서울 금천구"));
		
		JSONObject result = new JSONObject();
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		User user = list.get(idx-1);
		
		result.put("idx", user.getIdx());
		result.put("userid", user.getUserid());
		result.put("name", user.getName());
		result.put("age", user.getAge());
		result.put("hp", user.getHp());
		result.put("address",user.getAddress());
		
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.print(result);
		out.flush();
		out.close();
	}
}
