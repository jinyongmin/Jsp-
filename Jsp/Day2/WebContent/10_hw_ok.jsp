<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%
	request.setCharacterEncoding("UTF-8");
	// String product = request.getParameter("product");
	String product = request.getParameter("product") == null ? "" : request.getParameter("product");//널이 아니면 뒤에
	
	
	List list = (List)session.getAttribute("productList");//세션을 리스트로 바로 바꿀수 없음 리스트로 형변환해서 뽑음
	if(list == null){
		list = new ArrayList();
	}
	
	list.add(product);
	session.setAttribute("productList", list);
%>
<script>
	alert('<%=product%> 상품이 장바구니에 추가되었습니다');
	location.href='10_hw.jsp';
</script>