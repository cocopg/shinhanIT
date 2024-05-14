<%@page import="com.shinhan.dept.DeptDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	DeptDTO dept = new DeptDTO();
	dept.setDepartment_id(100);
	dept.setDepartment_name("개발부");
	dept.setLocation_id(1700);
	dept.setManager_id(10);
	%>
	<h1>자바빈즈 이용하기(setting)</h1>
	<jsp:useBean id="dept2" class="com.shinhan.dept.DeptDTO" scope="request">
	</jsp:useBean>
	<jsp:setProperty property="*" name="dept2"/>
	
<%-- 	<jsp:setProperty property="department_id" name="dept2" param="department_id"/>
	<jsp:setProperty property="department_name" name="dept2" param="department_name"/>
	<jsp:setProperty property="location_id" name="dept2" param="location_id"/>
	<jsp:setProperty property="manager_id" name="dept2" param="manager_id"/> --%>
	
	<jsp:forward page="javaBeansTest2.jsp"></jsp:forward>
	
</body>
</html>