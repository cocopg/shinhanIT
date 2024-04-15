
<%@page import="com.shinhan.emp.EmpDTO"%>
<%@page import="com.shinhan.emp.EmpService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    EmpService eService = new EmpService();
    String empid = request.getParameter("empid");
    EmpDTO emp=null;
    int i_empid=0;
    if(empid!=null){
    	i_empid = Integer.parseInt(empid);
    	emp = eService.selectById(i_empid);
    }
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>사용자정보 상세보기</h1>
<p>직원번호:<%=emp.getEmployee_id() %></p>
<p>직원번호:<%=emp.getFirst_name() %></p>
<p>직원번호:<%=emp.getLast_name() %></p>
<p>직원번호:<%=emp.getEmail() %></p>
<p>직원번호:<%=emp.getPhone_number() %></p>
<p>직원번호:<%=emp.getHire_date() %></p>
</body>
</html>