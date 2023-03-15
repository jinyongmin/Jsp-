<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션으로 구현한 장바구니</title>
<script>
	function payment(){
		alert('결제페이지로 이동합니다');
		location.href='payment';
	}
</script>
</head>
<body>
	<h2>세션으로 구현한 장바구니</h2>
	<form method="post" action="hw_ok">
		<p>구입할 물건을 선택하세요:  
		<select name="product">
			<option value="그래픽카드">그래픽카드</option>[]
			<option value="닌텐도">닌텐도</option>
			<option value="맥북프로">맥북프로</option>
			<option value="34인치모니터">34인치모니터</option>
			<option value="페라리로마">페라리로마</option>
			<option value="집">집</option>
		</select>
		</p>
		<p><input type="submit" value="담기"> | <input type="button" value="결제" onclick="payment()"></p>
	</form>
	<hr>
	<p>
		<%
			List<String> list = (List)session.getAttribute("productList");
			if(list != null){
				for(String product : list){
					out.print(product + " ");
				}
			}
		%>
	</p>
</body>
</html>