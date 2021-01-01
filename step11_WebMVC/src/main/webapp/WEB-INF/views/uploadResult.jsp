<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Upload결과</h1>
<h4>
	작성자 : ${name} <br>
	첨부파일이름 : ${fileName} <br>
	첨부사이즈 : ${fileSize} <br>
	경로 : ${path} 
</h4>

<hr color="red">

<h1>Upload결과 UploadDTO이용</h1>
<h4>
	작성자 : ${uploadDTO.name} <br>
	첨부파일이름 : ${uploadDTO.fileName} <br> <!-- uploadDTO.getFileName() -->
	첨부사이즈 : ${uploadDTO.fileSize} <br>
</h4>
</body>
</html>