<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Insert title here</title>
	<style type="text/css">
		table{
			width: 500px;
			border: 1px solid red;
			border-collapse: collapse;
		}
		td, th{
			text-align: center;
			border: 1px solid red;
		}
		a{
			text-decoration: none;
		}
	</style>
	<script src="${pageContext.request.contextPath}/resources/js/jquery-3.4.1.min.js" ></script>
	<script type="text/javascript">
		$(function(){
			//alert(1)
			//상세보기
			$("a").on("click", function(){
				//alert($(this).attr("id"));
				location.href="read.kosta?no="+$(this).attr("id");
			});
			
			
			//등록하기
			$("#registerBtn").click(function(){
				location.href="write.kosta"
				//location.href="write.jsp"
			    //location.href="${pageContext.request.contextPath}/WEB-INF/views/write.jsp"
			});
			
			//삭제하기
			$("[value=삭제]").on("click", function(){
				var no = $(this).attr("name");
				location.href="delete.kosta?no="+no;
			})
		})
	</script>
</head>
<body>



	<h1>boardList.jsp 파일 호출</h1>
	<table>
		<tr>
			<th>no</th>
			<th>제목</th>
			<th>작성자</th>
			<th>삭제</th>
		</tr>
		<c:forEach items="${requestScope.boardList}" var="board">
			<tr>
				<th>${board.no}</th>
				<th><a href="#" id="${board.no}">${board.subject}</a></th>
				<th>${board.writer}</th>
				<th><input type="button" value="삭제" name="${board.no}"></th>
			</tr>	
		</c:forEach>
	</table>
	<a href="write.kosta">글쓰기</a>	
</body>
</html>