<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	a{text-decoration: none;}
</style>
</head>
<body>
<h1>파일 LIST</h1>
<c:forEach items="${fileNames}" var="name">
 	<li><a href="down.do?fname=${name}">${name}</a></li> <br>
</c:forEach>
</body>
</html>