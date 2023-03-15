<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>	<%//? 업캐스팅하려고 리스트를상속받아 만든것이 어레이 리스트	 %>>
<%@ page import="java.util.ArrayList" %>
<%
	request.setCharacterEncoding("UTF-8");
	// String product = request.getParameter("product");	//product를 받아서 저장
	String product = request.getParameter("product") == null ? "" : request.getParameter("product");//null값 =빈값  아니면 product
	
	
	List list = (List)session.getAttribute("productList");//	세션에 저장된	세션변수중에 productList가 있으면 list로 형변환		// 세션변수를 리스트로 바로 바꿀수 없음 리스트로 형변환해서 뽑음	데이터를 담아줌
	if(list == null){
		list = new ArrayList();	//list는 arrayList의 부모이기 때문에 만들 수 있음
	}
	
	list.add(product);
	session.setAttribute("productList", list);	//arraylist 자체를 세션에 담을수 있음
%>
<script>
	alert('<%=product%> 상품이 장바구니에 추가되었습니다');		
	location.href='7_basket.jsp';
</script>