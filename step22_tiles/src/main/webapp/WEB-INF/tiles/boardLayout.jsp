<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
 table{
 	width: 800px;
 	border: red solid 5px;
 }
 
 th,td{border-collapse: collapse; border: gray 1px solid}
 .a{width: 100px}
</style>
</head>
<body>
<table>
<tr>
	<th colspan="2">
	<tiles:insertAttribute name="top"/>
	</th>
</tr>

<tr>
	<td >
	<tiles:insertAttribute name="content"/>
	</td>
	<td class="a">
	<tiles:insertAttribute name="aside"/>
	</td>
</tr>

<tr>
	<td colspan="2">
	<tiles:insertAttribute name="footer"/>
	</td>
</tr>
</table>
</body>
</html>