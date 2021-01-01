<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
\${memberListDTO.list} = ${memberListDTO.list}
<h1> MemberList 결과 Page</h1>
<table>
<tr>
	<th>선택여부</th>
	<th>이름</th>
	<th>나이</th>
	<th>주소</th>
</tr>
<c:forEach items="${memberListDTO.list}" var="dto">
<tr>
	<th>${dto.state}</th>
	<th>${dto.name}</th>
	<th>${dto.age}</th>
	<th>${dto.addr}</th>
</tr>
</c:forEach>
</table>
</body>
</html>