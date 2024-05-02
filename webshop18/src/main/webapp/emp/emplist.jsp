<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>직원목록</h1>
<table border="1">
  <thead>
    <tr>
      <th>직원번호</th>
      <th>이름</th>
      <th>성</th>
      <th>이메일</th>
      <th>전화번호</th>
      <th>직책</th>
      <th>급여</th>
      <th>부서</th>
      <th>매니저</th>
      <th>커미션</th>
      <th>입사일</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach var="emp" items="${emplist}">
      <tr>
        <td>
          <a href="empDetail.do?empid=${emp.employee_id}">${emp.employee_id}</a>
        </td>
        <td>${emp.first_name}</td>
        <td>${emp.last_name}</td>
        <td>${emp.email}</td>
        <td>${emp.phone_number}</td>
        <td>${emp.job_id}</td>
        <td>${emp.salary}</td>
        <td>${emp.department_id}</td>
        <td>${emp.manager_id}</td>
        <td>${emp.commission_pct}</td>
        <td>${emp.hire_date}</td>
      </tr>
    </c:forEach>
  </tbody>
</table>
</body>
</html>