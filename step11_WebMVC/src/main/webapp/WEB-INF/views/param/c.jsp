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
<h1> 폼 전송 결과 Page - 가입정보 확인 </h1>
<h3>
아이디 : ${memberDTO.id}
이름 : ${memberDTO.name}
나이 : ${memberDTO.age}
주소 : ${memberDTO.addr}
<hr>
<h1> 폼 전송 결과 Page - @ModelAttribute("dto") </h1>
아이디 : ${dto.id} <p>
이름 : ${dto.name} <p>
나이 : ${dto.age} <p>
주소 : ${dto.addr} <p>
</h3>

<hr color="red"/>
메시지 : ${message} <p>
과일 : 
<c:forEach items="${fruits}" var="fruit">
${fruit}
</c:forEach>
<hr>

현재시간 : ${time} <p>
파일이름 : ${fileName}
</body>
</html>