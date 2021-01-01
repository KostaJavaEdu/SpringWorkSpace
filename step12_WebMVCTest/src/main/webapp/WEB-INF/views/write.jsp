<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>write.jsp</title>
</head>
<body>
	<h1>write.jsp 파일 호출</h1>
	<form action="register.kosta" method="post">
		글 번호 : <input type="text" name="no" > <br>
		제목 : <input type="text" name="subject" > <br>
		작성자 : <input type="text" name="writer" > <br>
		내용 : <input type="text" name="content"> <br>
		<input type="submit" value="등록">
		<input type="reset" value="취소">
	</form>
</body>
</html>