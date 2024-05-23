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
	<form id="insertForm" action="${path }/dept/deptInsert.do" method="post">
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
	<button onclick="f_deptInsert()">입력(ajax)</button>
</body>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
	function f_deptInsert(){
		var arr = $("#insertForm").serializeArray();
		var obj = {};
		
		$.each(arr, function(index, item){
			obj[item.name] = item.value;
		});
		//contentType 생략시 :'application/x-www-form-urlencoded;charset=UTF-8'
		$.ajax({
			url:"${path}/dept/api/insert",
			type:"post",
			data:JSON.stringify(obj),	//@RequestBody
			contentType:"application/json;charset=utf-8",
			success:function(responseStr){
				alert(responseStr);
			}
		});
	}
</script>
</html>