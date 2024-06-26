<%@page import="java.util.List"%>
<%@page import="com.shinhan.emp.EmpService"%>
<%@page import="com.shinhan.emp.EmpDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#container{
	width:800px;
	border:1px solid gray;
	margin:0 auto;
}
table{
	margin:0 auto;
}
table, th, td{
	border-collapse:collapse;
	text-align:left;
	padding:10px;
}
th{
background:skyblue;
color:white;
}
tbody tr:nth-child(2n){
	background:skyblue;
	color:#fff;
}
tbody tr:nth-child(2n+1){
	background:#fff;
}
	h1{
	height:100px;
	border:1px solid #000;
	text-align:center;
	line-height:100px;
	background:beige;
	color:orange;
	margin:0;
	}
	a.headT{
	text-decoration:none;
	background:black;
	color:white;
	border-radius:5px;
	padding:10px;
	}
	
	td[data-fname]{
	font-size:20px;
	}
	td[data-fname^='A']{
	color:red;
	}
	td[data-hdate|='2005']{
		color:purple;
	}
	tbody tr:nth-child(1){
	background-color:pink;
	}
	tbody tr:nth-of-type(1){
		border:3px dotted blue;
	}
	td:nth-child(4){
	border:3px dotted red;
	}
	tbody tr:last-child{
	background: pink;
	}
</style>

</head>
<body>
<div id="container">
	<h1>전체 직원 목록</h1>
	<a class="headT" href="empInsert.jsp">신규직원 등록</a>
	<table border="1">
		<caption>직원목록</caption>
		<thead>
			<tr>
				<th>직원번호</th>
				<th>성0</th>
				<th>이름</th>
				<th>이메일</th>
				<th>전화번호</th>
				<th>입사일</th>
			</tr>
		</thead>
		<tbody>
			<%
			EmpService eService = new EmpService();
			List<EmpDTO> emplist = eService.selectAll();
			
			%>
			<%for(EmpDTO emp:emplist){ %>
			<tr>
				<td><a href="empDetail.jsp?empid=<%=emp.getEmployee_id() %>"><%=emp.getEmployee_id() %></a></td>
				<td data-fname="<%=emp.getFirst_name() %>"><%=emp.getFirst_name() %></td>
				<td><%=emp.getLast_name() %></td>
				<td><%=emp.getEmail() %></td>
				<td><%=emp.getPhone_number() %></td>
				<td data-hdate="<%=emp.getHire_date() %>"><%=emp.getHire_date() %></td>
			</tr>
			<% }%>
		</tbody>
	</table>
	</div>
</body>
</html>