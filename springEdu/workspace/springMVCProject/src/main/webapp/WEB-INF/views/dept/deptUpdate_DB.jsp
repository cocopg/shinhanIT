<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.deptTitle{
	background:orange;
}
input[readonly]{
	background-color:lightgray;
}
</style>
</head>
<body>
	<h1 class="deptTitle">부서정보 수정</h1>
	
	<%@ include file="../common/header.jsp" %>
	<form action="${path }/dept/deptDBUpdate.do" method="post">
		부서번호: <input type="number" name="department_id" value ="${dept.department_id }"readonly><br>
		부서이름: <input type="text" name="department_name" value ="${dept.department_name }"><br>
		매니저:
		<select name="manager_id">
			<c:forEach items="${mlist}" var="manager">
			<option value="${manager.employee_id}" 
			${dept.manager_id == manager.employee_id?"selected":"" }>
			${manager.employee_id }/${manager.fullname }
			</option>
			</c:forEach>
		</select>
		<br>
		지역코드: <input type="number" name="location_id" value ="${dept.location_id }"><br>
		<input type="submit" value="저장">
	</form>
</body>
</html>