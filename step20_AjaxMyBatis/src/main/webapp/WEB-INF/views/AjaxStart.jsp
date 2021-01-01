<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
  $(document).ready(function() {
	$("#loadBtn").click(function() {
		$("#display").load("load");
	});
	
	$("#ajaxBtn").click(function() {
		$.ajax({
			url : "ajax", //서버 요청방식
			type : "post", //요청방식(get|post|put|patch|delete)
			dataType : "text", //서버가 보내온 데이터타입(text,html,json,xml)
			data : "name=장희정", //서버에게 보내는 parameter정보
			success : function(result) {
				$("#display").text(result)
			}, //성공했을때
			error : function(err) {
				alert(err+"오류 발생")
			}//실패했을때
			
		});
	});
	/////////////////////////////////////////////////////////////////////
	/* 서버 응답 결과 json 형태로 오기 */
	$("#jsonArr").click(function() {
		$.ajax({
			url : "jsonArr", //서버 요청방식
			type : "post", //요청방식(get|post|put|patch|delete)
			dataType : "json", //서버가 보내온 데이터타입(text,html,json,xml)
			//data : "name=장희정", //서버에게 보내는 parameter정보
			success : function(result) {
				//alert(result)
				var str = "";
				$.each(result,function(index,item){
					str += "<input type='checkbox' value='"+item+"'>"+item
				})
				$('#display').html(str);
			}, //성공했을때
			error : function(err) {
				alert(err+"오류 발생")
			}//실패했을때
			
		});
	});
	
	
	$("#jsonDTO").click(function() {
		$.ajax({
			url : "jsonDTO", //서버 요청방식
			type : "get", //요청방식(get|post|put|patch|delete)
			dataType : "json", //서버가 보내온 데이터타입(text,html,json,xml)
			//data : "name=장희정", //서버에게 보내는 parameter정보
			success : function(result) {
				//alert(result)
				var str = "";
				$.each(result,function(index,item){
					str += "<input type='checkbox' value='"+item+"'>"+item
				})
				$('#display').html(str);
			}, //성공했을때
			error : function(err) {
				alert(err+"오류 발생")
			}//실패했을때
			
		});
	});
	
	$("#jsonList").click(function() {
		$.ajax({
			url : "jsonList", //서버 요청방식
			type : "post", //요청방식(get|post|put|patch|delete)
			dataType : "json", //서버가 보내온 데이터타입(text,html,json,xml)
			//data : "name=장희정", //서버에게 보내는 parameter정보
			success : function(result) {
				//alert(result)
				var str = "";
				$.each(result,function(index,items){
					$.each(items,function(index,item){
						str += item
					})
					str+="<br>"
				})
				$('#display').html(str);
			}, //성공했을때
			error : function(err) {
				alert(err+"오류 발생")
			}//실패했을때
			
		});
	});
	
	
	$("#jsonMap").click(function() {
		$.ajax({
			url : "jsonMap", //서버 요청방식
			type : "get", //요청방식(get|post|put|patch|delete)
			dataType : "text", //서버가 보내온 데이터타입(text,html,json,xml)
			//data : "name=장희정", //서버에게 보내는 parameter정보
			success : function(result) {
				//alert(result)
				alert(result.message)
				alert(result.pagenum)
				alert(result.member.id)
				alert(result.member.name)
				alert(result.member.addr)
				alert(result.member.age)
				$.each(result,function(index,item){
					item.id
				})
			}, //성공했을때
			error : function(err) {
				alert(err+"오류 발생")
			}//실패했을때
			
		});
	});
	
	
	
  });//ready
</script>
</head>
<body>

<input type="button" value="load함수" id="loadBtn">
<input type="button" value="ajax함수" id="ajaxBtn">

<input type="button" value="array결과" id="jsonArr">
<input type="button" value="DTO결과" id="jsonDTO">
<input type="button" value="list결과" id="jsonList">
<input type="button" value="map결과" id="jsonMap">

<hr>
<div id="display"></div>



</body>
</html>



