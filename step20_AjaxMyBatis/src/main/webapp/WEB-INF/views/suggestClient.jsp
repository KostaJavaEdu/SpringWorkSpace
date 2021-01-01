<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.4.1.min.js"></script>

<script>
  $(function() {
	  $("#keyWord").keyup(function(){
		   if($(this).val()==""){
			   $("#suggest").hide();
			   return;
		   }
		   
		   
		   //ajax기능구현
		   $.ajax({
			   type:"post" ,//전송방식
			   url: "suggest", //서버주소
			   data:"keyWord="+ $(this).val(),//서버에게 보낼 parameter 정보
			   dataType:"text" , //서버가 front로 보내주는 데이터 타입(text,html,xml,json)
		       success: function(result){//개수|단어,단어,단어,...
		    		console.log(result)
		       } , 
		       error:function(err){
		    	   console.log("에러 발생 : " + err);
		       }
			   
		   });//ajax끝
	   });//keyup끝
	   
	   // a태그를 클릭했을때 이벤트 처리
	   /* $("a").click(function(){ -- 동적으로 생성된 element에 이벤트 적용안됨.-> on()함수
		   alert("하하");
	   }) */
	   
	   /*
	      동적으로 생성된 요소에 이벤트 적용할때 on()함수 사용법
	       $(이벤트대상부모노드).on(이벤트종류, 이벤트대상, 함수);
	   */
	   $("#suggest").on("click","a" ,function(){
		   $("#keyWord").val($(this).text());
		   $("#suggest").hide();
		   
	   });
	   
	
  })

</script>


</head>
<body>
<h3> [ Suggest 기능 구현 ]</h3>	
<form name="search" id="search">
	<input type="text" name="word" id="keyWord"/>	
</form>
<!--제시어 단어 출력부분 -->
<div id="suggest" style="display:none">
 

</div>

</body>
</html>








