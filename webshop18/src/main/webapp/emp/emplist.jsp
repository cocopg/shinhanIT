<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	
</script>
</head>
<body>
<%--include지시자:jsp를 합쳐서 컴파일한다 --%>
<%--include액션태그:각각 컴파일해서 합친다, 밑은 액션태그 --%>
<jsp:include page="../common/loginHeader.jsp"></jsp:include>
<h2>접속인원:${total_user }</h2>
<ul>
  <c:forEach var="user" items="${user_list}">
    <li>${user}</li>
  </c:forEach>
</ul>
<h1>${loginEmp.first_name}님 환영합니다</h1>
<a href="../auth/logout.do">로그아웃</a>
<h2>현재 접속한 사용자는 : ${loginUser.user_id}</h2>
<h2>현재 접속자 수 : ${loginUser.total_user}</h2>
<h1>세션에서읽기:${memberId }</h1>
<h1>세션에서읽기:${memberPass}</h1>
<a href="empInsert.do">신규직원등록</a>
<a href="javascript:location.href'empInsert.do'">신규직원등록</a>
<h1>직원 전부조회</h1>
<table border="1">
	<thead>
		<tr>
			<th>직원 번호</th>
			<th>이름</th>
			<th>성</th>
			<th>이메일</th>
			<th>전화번호</th>
			<th>직책</th>
			<th>급여</th>
			<th>부서</th>
			<th>매니져</th>
			<th>커미션</th>
			<th>입사일</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${emplist}" var="emp">
			<tr>
				<td><a href="javascript:call(${emp.employee_id})">${emp.employee_id}</td>
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
				<td><button onclick="location.href='empDelete.do?empid=${emp.employee_id}'">삭제</button>
			</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>