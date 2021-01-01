<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>user/loginForm.jsp 입니다.</h1>
<h3>로그인 하기</h3>

<c:if test="${param.ng!=null}">
	Login Fail!!
	<c:if test="${SPRING_SECURITY_LAST_EXCEPTION!=NULL}">
		MESSAGE : ${SPRING_SECURITY_LAST_EXCEPTION.message}
	</c:if>
</c:if>

<form action="${pageContext.request.contextPath}/loginCheck" method="post">
아이디 : <input type="text" name="userId"><p>
비밀번호 : <input type="password" name="userPass"><p>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<input type="submit" value="로그인">
<input type="reset" value="취소">
</form>
</body>
</html>