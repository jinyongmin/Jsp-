<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajax</title>
	<script>
		function sendRequest(){
			const xhr = new XMLHttpRequest();
			xhr.open('like_ok.jsp?userid=apple&userpw=1234',true);	//비동기로4_ahax_ok.jsp?userid=apple&userpw=1234 보내고  어떤응답을 해줌
			xhr.send();
			
			xhr.onreadystatechange = function(){
				if(xhr.readyState ==XMLHttpRequest.DONE && xhr.status == 200){				//readystate가 4니??	(xhr.readyState ==XMLHttpRequest.DONE)
													//(0 1 2 3 )4번부터 확인 //빠름
													
					document.getElementById('text').innerHTML = xhr.responseText;	//				xhr.responseText을	innerHTML에 찍어줌 콜백			
				}
		}
	
			
}
	</script>
</head>
<body>
	<h2>Ajax</h2>
	<p><button onclick="sendRequest()">요청 보내기</button></p>
	<hr>
	<p id = "text"></p>	
</body>
</html>