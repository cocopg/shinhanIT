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
<%@ include file="../common/header.jsp" %>
<img alt="" src="${path }/resources/image/Group 230.png" width="100" height="100">
	<h1>부서등록</h1>
	<form action="${path }/dept/deptInsert.do" method="post">
		부서번호: <input type="number" name="department_id" value =""><br>
		부서이름: <input type="text" name="department_name" value =""><br>
		매니저:
		<select name="manager_id">
		<c:forEach var="manager" items="${mlist }">
			<option value="${manager.employee_id }">${manager.fullname }</option>
		</c:forEach>
		</select>
		<br>
		지역코드: <input type="number" name="location_id" value ="1700"><br>
		<input type="submit" value="부서저장">
	</form>
</body>
</html>