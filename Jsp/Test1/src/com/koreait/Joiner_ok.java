package com.koreait;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Joiner
 */
@WebServlet("/Joiner")
public class Joiner_ok extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Joiner_ok() {
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
		String mem_idx =request.getParameter("mem_idx");
		String mem_userid =request.getParameter("mem_userid");
		String mem_userpw =request.getParameter("mem_userpw");
		String mem_name =request.getParameter("mem_name");
		String mem_email =request.getParameter("mem_email");
		String mem_gender =request.getParameter("mem_gender");
		String mem_hp =request.getParameter("mem_hp");
		String mem_regdate =request.getParameter("mem_regdate");
		String mem_point =request.getParameter("mem_point");
	
		System.out.println(mem_idx);
		System.out.println(mem_userid);
		System.out.println(mem_userpw);
		System.out.println(mem_name);
		System.out.println(mem_email);
		System.out.println(mem_gender);
		System.out.println(mem_hp);
		System.out.println(mem_regdate);
		System.out.println(mem_point);
	}

}
