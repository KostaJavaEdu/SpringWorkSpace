<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
 .a{border:solid red 5px}
 span{width:150px; color:red}
 input{border:solid gray 1px}
 table{width:100%}
 th,td{border:1px gray solid; text-align:center;padding:3px}
 h2{text-align:center}
 
</style>
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.4.1.min.js"></script>

<script type="text/javascript">
 	
 	//조회함수
 	function selectAll(){
 		 $.ajax({
			   type:"post" ,//전송방식
			   url: "select", //서버주소
			   dataType:"json" , //서버가 front로 보내주는 데이터 타입(text,html,xml,json)
		       success: function(result){//개수|단어,단어,단어,...
		    		str="";
			    		$.each(result,function(index,item){
			    				str += "<tr>";
								str += "<td>"+ item.stno +"</td>";
								str += "<td>"+ item.stname +"</td>";
								str += "<td>"+ item.stage +"</td>";
								str += "<td>"+ item.stphone +"</td>";
								str += "<td>"+ item.staddr +"</td>";
								str += "<td><input type='button' value='삭제' name='"+item.stno+"'></td>";
								str += "</tr>";
						})
						$("#listTable tr:gt(0)").remove();
						$('#listTable').append(str);
			    		
			   } , 
		       error:function(err){
		    	   console.log("에러 발생 : " + err);
		       }
			   
		   });//ajax끝
 	}
 	
 	//조회
	 $(function() {
		$("#customSel").click(function(){
			selectAll()
		})
		
		//삽입
		$("#btn").click(function() {
			 $.ajax({
				   type:"post" ,//전송방식
				   url: "insert", //서버주소
				   data:$("#inForm").serialize(),//서버에게 보낼 parameter 정보
			       success: function(){//개수|단어,단어,단어,...
			    		alert("삽입성공")
				   } , 
			       error:function(err){
			    	   console.log("에러 발생 : " + err);
			       }
				   
			   });//ajax끝
		})
		
		
		//삭제버튼 눌렀을 때 삭제
		$(document).on("click","[value='삭제']" , function(){
			  // 현재 버튼의 name의 value를 가져오기
			  $.ajax({
			   type: "post",
			   url : "delete",
			   dataType : "text",// 0 or 1
			   data : {"stno" : $(this).attr("name")}, //
			   success : function(result){//text
				 if(result>0){
					 selectAll()
				 }else{
					 alert("삭제되지 않았습니다.");
				 }
			   } ,
			   error : function(err){
				   console.log(err+" 오류발생");
			   } 
			 })//ajax끝
		  });
		
		$("#stno").keyup(function(){
			  if($(this).val()==""){
				  $("span").text("    ");
				  return;
			  }
			  
			  $.ajax({
				  type:"post",
				  url:"noCheck",
			      dataType: "text",//서버에게 받은 응답결과 type(text, xml, html, json)
			      data : {id: $(this).val() } ,//서버에게 전송할 parameter
			      success: function(result){
			    	  $("span").html(result);
			      } ,
			      error : function(err){
			    	  console.log(err+"=> 오류발생");
			      }
			  });//ajax끝
		  });//keyup끝
		
		
	})

</script>
</head>


<body >
<h2>Student 입력 </h2>

<form name="insert.do" method="post" id="inForm">
<table cellspacing="0">
	<tr bgcolor="pink" >
	    <th>학번</th>
		<th>이름</th>
		<th>나이</th>
		<th>전화번호</th>	
		<th>주소</th>
	</tr>
	<tr>
	    <td style="text-align:left"><input type="text" size="8" name="stno" id="stno"> <span>학번중복결과여부</span></td>
		<td><input type="text" size="8" name="stname" id="stname"></td>
		<td><input type="text" size="4" name="stage" id="stage"></td>
		<td><input type="text" size="12" name="stphone" id="stphone"></td>
		<td><input type="text" size="30" name="staddr" id="staddr"></td>
	</tr>
	<tr>
		<td colspan="5" align="center"> 
			<input type="button" value="가입하기"  id="btn">
		</td>
	</tr>
</table>

<br>

</form>

<hr color="red">

<h2> Student 리스트 !  </h2>
<table cellspacing="0" > 
	<tr>
		<td style="text-align:right"><input type="button" value="가져오기"  id="customSel"></td>
	</tr>
</table>

<table  id="listTable" cellspacing="0">
	<tr bgcolor="pink">
	    <th>학번</th>
		<th>이름</th>
		<th>나이</th>
		<th>전화번호</th>	
		<th>주소</th>
		<th>삭제</th>
	</tr>
	
	
	
</table>



</body>
</html>