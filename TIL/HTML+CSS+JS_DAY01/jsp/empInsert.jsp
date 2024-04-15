<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>신규직원등록</h1>
<form action="">
<fieldset>
<legend>필수항목</legend>
<label>직원번호</label>
<input type="number" name="employee_id"><br>
<label>last_name</label>
<input type="text" name="last_name"><br>
<label>email</label>
<input type="email" name="email"><br>
<label>hire_date</label>
<input type="date" name="hire_date"><br>
<label>job_id</label>
<input type="text" name="job_id" value="IT_PROG"><br>

</fieldset>
<fieldset>
<legend>선택입력</legend>
<label>first_name</label>
<input type="text" name="first_name"><br>
<label>phone_number</label>
<input type="text" name="phone_number"><br>
</fieldset>
</form>
<input type="submit" value="DB입력">
<input type="submit" value="초기화">
</body>
</html>