
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
	//이메일찾기
	$(function(){
		$("#btn1").on("click", function(){
			$("tr td:nth-child(4)").filter(function(index, item){
				if($(item).text().indexOf("@")>=0) return true;
				return false;
			}).css("color","red");
		});
		//급여찾기:급여가 10000이상인 것만 salary:nth-child(7)
		$("#btn2").on("click", function(){
			$("tr td:nth-child(7)").css("color","black");
			$("tr td:nth-child(7)").filter(function(index, data){
				// console.log(typeof($(item).text()), $(item).text()>=10000);
				return $(item).text()>=10000;
			}).css("color","blue");
		});
	})
</script>
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
	background:#2c2c2c;
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
				<td><%=emp.getFirst_name() %></td>
				<td><%=emp.getLast_name() %></td>
				<td><%=emp.getEmail() %></td>
				<td><%=emp.getPhone_number() %></td>
				<td><%=emp.getHire_date() %></td>
			</tr>
			<% }%>
		</tbody>
	</table>
	</div>
</body>
</html>