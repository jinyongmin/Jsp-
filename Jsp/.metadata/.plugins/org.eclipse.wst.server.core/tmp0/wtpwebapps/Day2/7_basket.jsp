<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션으로 구현한 장바구니</title>
<script>
	function payment(){	//1											기능 구현 코드만 작성함.. 아직 사용하지 x
		alert('결제페이지로 이동합니다');
		location.href='7_basket_payment.jsp';				//4. payment파일로 이동!
	}
</script>
</head>
<body>
	<h2>세션으로 구현한 장바구니</h2>
	<form method="post" action="7_basket_ok.jsp">	<!-- 2 OK로 가서 변수에 대한 행동을 한다? -->
		<p>구입할 물건을 선택하세요:  
		<select name="product">			<%//고른것을 볼 수 있게 name을 넣어줌 %>
			<option value="그래픽카드">그래픽카드</option>
			<option value="닌텐도">닌텐도</option>
			<option value="맥북프로">맥북프로</option>
			<option value="34인치모니터">34인치모니터</option>
			<option value="페라리로마">페라리로마</option>
			<option value="집">집</option>
		</select>
		</p>
		<p><input type="submit" value="담기"> <%//3. 누르면 담고 다시 고를수 있게  보이는건 value input type에 submit은 서버에 보냄%>| <input type="button" value="결제" onclick="payment()"><!-- 타입:버튼(버튼생김),value:결제(홈페이지에 보이는 글은 결제 ,onclick:누르면 payment()기능 만든 function으로 감.) --></p>	
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