<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
//1)jsp의 EL(Expression Language)문법
var aa = "${emplist}";
//2)JavaScript의 백틱문법 : JSP문법과 혼란...JSP에서 백틱은\$를 사용
var myname = "jj"l
var bb = `나의 이름은\${myname}`;
//3)jQuery,,,,,,,
$(function(){
	$("tr th").css("backgroundColor","skyblue");
});
<%-- 4) JSTL문법(Tag Library)문법 <c:forEach ...--%>
</script>
</head>
<body>
<h1>myinfo1(다른서블릿의 request 접근불가.):${myinfo} }</h1>
<h1>myinfo2(같은 브라우저로 접근하면 session가능.):${myinfo2}</h1>
<h1>myinfo3(servletContext는 모든 서블릿에서 접근가능, 모든 사용자가 공유):${myinfo3}</h1>
<a href = "empInsert.do">신규직원등록1</a>
<a href = "javascript:location.href='empInsert.do'">신규직원등록2</a>
<button onclick = "location.href='empInsert.do'">신규직원등록3</button>
<button onclick="f_insert()">신규직원등록4</button>
<form action="empInsert.do">
	<input type="button" value="신규직원등록5"> 
</form>
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
		<td><button onclick="location.href='empdelete.do?empid=${emp.employee_id}'">삭제</button>
      </tr>
    </c:forEach>
  </tbody>
</table>
</body>
</html>