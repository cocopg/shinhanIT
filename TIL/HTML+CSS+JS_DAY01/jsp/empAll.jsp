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
</head>
<body>
	<h1>전체 직원 목록</h1>
	<a href="empInsert.jsp">신규직원 등록</a>
	<table border="1">
		<caption>직원목록</caption>
		<thead>
			<tr>
				<th>직원번호</th>
				<th>성</th>
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
</body>
</html>