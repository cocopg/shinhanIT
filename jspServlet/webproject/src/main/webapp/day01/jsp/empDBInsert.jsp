<%@page import="java.sql.Date"%>
<%@page import="com.shinhan.emp.EmpDTO"%>
<%@page import="com.shinhan.emp.EmpService"%>
<%@page import="com.shinhan.util.DateUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%

request.setCharacterEncoding("utf-8");  //post방식일 땐 필수

int empid = Integer.parseInt(request.getParameter("employee_id"));
String lname = request.getParameter("last_name");
String email = request.getParameter("email");
Date hdate = DateUtil.getSQLDate(request.getParameter("hire_date"));
String jobid = request.getParameter("job_id");
String fname = request.getParameter("first_name");
String phone = request.getParameter("phone_number");
EmpService eService = new EmpService();
EmpDTO emp = new EmpDTO();
emp.setEmployee_id(empid);
emp.setLast_name(lname);
emp.setEmail(email);
emp.setHire_date(hdate);
emp.setJob_id(jobid);
emp.setFirst_name(fname);
emp.setPhone_number(phone);
System.out.println(emp);
eService.empInsert(emp);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>