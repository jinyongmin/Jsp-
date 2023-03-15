<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드</title>
</head>
<body>
		<h2>파일 업로드</h2>
		<form method="post" action="6_fileupload_ok.jsp" enctype="multipart/form-data">
		<p>파일이름: <input type="text" name="title"></p>
		<p>이미지: <input type="file" name="image"></p>
		<p><button>전송</button></p>
		</form>
</body>
</html>