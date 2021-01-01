<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> Parameter에 대한 결과 Page입니다.</h1>

<fieldset>
	<legend>취미선택</legend>
	<c:forEach items="${hobbys}" var="hobby">
		<input type="checkbox" value="${hobby}" name="hobby">${hobby}
	</c:forEach>
</fieldset>

<hr color="red"/>
메시지 : ${message} <p>
과일 : 
<c:forEach items="${fruits}" var="fruit">
${fruit}
</c:forEach>

</body>
</html>