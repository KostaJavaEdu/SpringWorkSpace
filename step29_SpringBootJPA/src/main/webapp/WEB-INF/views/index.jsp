<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> Spring Boot를 이용한 WEB-INF/views.index.jsp</h1>
<h3>PageBoard 결과 </h3>
<table>
<c:forEach items="list" var="board">
<tr>
<td>{bpard.bno}</td>
<td>{bpard.title}</td>
<td>{bpard.content}</td>
<td>{bpard.writer}</td>
<td>{bpard.regdate}</td>
</tr>
</c:forEach>
</table>
<hr>

<c:forEach begin="1" end="${totalPage}" var="i">
   <c:choose>
     <c:when test="${i==(number+1)}">
        <a href='' style='color:red'>[${i}] </a> &nbsp;&nbsp;
     </c:when>
     <c:otherwise>
        <a href=''>[${i}] </a> &nbsp;&nbsp;
     </c:otherwise>
   </c:choose>
 </c:forEach>

  <a href="select">요청</a>
</body>
</html>