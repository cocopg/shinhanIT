<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	*{
		color:#2c2c2c;
	}
	#fcontainer{
		margin:0 auto;
		width: 350px;
		border:1px solid #000;
		h1, legend{
			text-align:center;
		}
	}
	label{
	display:block;
	width:200px;
	padding-left:10px;
	padding-bottom:5px;
	}
	input{
	height: 38px;
    width: 300px;
    font-size: 22px;
    padding-left: 10px;
    margin:0 auto;
	}
	.inputbtn, .resetbtn{
		width:330px;
		margin:5px 10px 5px 10px;
		border:none;
		background:#4EB5FF;
		color:#fff;
		border-radius:5px;
		:hover{
			background:#4AA5FF;
		}
	}
	fieldset{
		border:none;
	}
	legend{
			background:#4EB5FF;
			color:#fff;
			padding:10px;
			width:300px;
		}
		h1{
			background:#2DCE50;
			color:#fff;
			width:330px;
			height:60px;
			margin:5px 10px 5px 10px;
			line-height:60px;
		}
	
</style>
</head>
<body>
<div id="fcontainer">
<h1>신규직원등록</h1>
<!-- 
submit버튼을 누르면 자동으로 action으로 간다. (input들은 action)
input태그에 name을 전달(name이 parameter이름이다.)
 -->

<form name="myfrm1" action="empDBInsert.jsp" method="post">
<fieldset>
<legend>필수항목</legend>
<label>직원번호</label><input type="number" name="employee_id" ><br>
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
<input class="inputbtn" type="submit" value="DB입력">
<input class="resetbtn" type="submit" value="초기화">
</div>
</body>
</html>