<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.deptTitle {
	background: orange;
}

input[readonly] {
	background-color: lightgray;
}
</style>
</head>
<body>
	<h1 class="deptTitle">부서정보 수정</h1>
	<%@ include file="../common/header.jsp"%>

	<form id="updateForm" action="${path }/dept/deptDBUpdate.do"
		method="post">
		부서번호: <input type="number" id="department_id" name="department_id"
			value="${dept.department_id }" readonly><br> 부서이름: <input
			type="text" name="department_name" value="${dept.department_name }"><br>
		매니저: <select name="manager_id">
			<c:forEach items="${mlist}" var="manager">
				<option value="${manager.employee_id}"
					${dept.manager_id == manager.employee_id?"selected":"" }>
					${manager.employee_id }/${manager.fullname }</option>
			</c:forEach>
		</select> <br> 지역코드: <input type="number" name="location_id"
			value="${dept.location_id }"><br> <input type="submit"
			value="저장">
	</form>
	<hr>
	<p>ajax연습</p>
	<button onclick="f_deptUpdate()">Restful API를 이용해서 수정하기</button>
	<button onclick="f_deptDelete(${dept.department_id })">Restful API를 이용해서 삭제하기</button>
</body>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
	function f_deptDelete(deptid){
		$.ajax({
			url : "${path}/dept/api/delete/" + deptid,
			type:"delete",
			success:function(responseResult){
				alert(responseResult);
			},
		});
	}

	function f_deptUpdate() {
		var arr = $("#updateForm").serializeArray();
		var obj = {};

		$.each(arr, function(index, item) {
			obj[item.name] = item.value;
		});
		//contentType 생략시 :'application/x-www-form-urlencoded;charset=UTF-8'
		$.ajax({
			url : "${path}/dept/api/update",
			type : "put",
			data : JSON.stringify(obj), //@RequestBody
			contentType : "application/json;charset=utf-8",
			success : function(responseStr) {
				alert(responseStr);
			}
		});
	}
</script>
</html>