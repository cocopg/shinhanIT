<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
input[readonly]{
	background-color:lightgray;
}
</style>
</head>
<body>
	<h1>부서 상세보기</h1>
	
	<%@ include file="../common/header.jsp" %>
	<form action="${path }/dept/deptDetail.do" method="post">
		부서번호: <input type="number" name="department_id" value ="${dept.department_id }"readonly><br>
		부서이름: <input type="text" name="department_name" value ="${dept.department_name }"readonly><br>
		매니저: <input type="number" name="manager_id" value ="${dept.manager_id }"readonly><br>
		지역코드: <input type="number" name="location_id" value ="${dept.location_id }"readonly><br>
		<input type="submit" value="정보 수정">
	</form>
</body>
</html>