<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>read.jsp</title>
</head>
<body>
	<h1>read.jsp 파일 호출</h1>
	<h4>
		글번호 : ${board.no} <br>
		제목 : ${board.subject} <br>
		상세내용 : ${board.content} <br>
		작성자 : ${board.writer} <br>
		
	</h4>
	
</body>
</html>