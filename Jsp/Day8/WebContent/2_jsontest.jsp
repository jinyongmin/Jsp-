<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>json 테스트</title>
	<style>
		table{width:600px; border: 1px solid deepskyblue;}
	</style>
	<script>
		fetch('http://localhost:9090/Day8/MemberView?m_idx=1').then(function(response)){
			response.json().then(function(json){
				console.log(json);
				for(let key in json){
					document.querySelector('#detail').innerHTML += 
						"<tr><td>"+ json[key]+"</td></tr>";
						console.log( json[key]);
				}
			});
		});
	</script>
	<!-- <script>
			fetch('http://localhost:9090/Day8/MemberView?m_idx=4')	//get방식으로  patch로 받음	//브라우저에서 지원 node.js에서 지원x
				.then((response) => console.log(response.json()))
				.catch((error) => console.log("error",error));
	</script>
 -->
</head>
<body>
<h2>json 테스트</h2>
<table id="detail"></table>

<!--  object내용을 여기에 출력하기  userid name gender hp address -->

</body>
</html>