<%@page import="java.util.HashMap"%>
<%@page import="org.firstzone.myapp.dept.DeptDTO"%>
<%@page import="org.firstzone.myapp.emp.JobDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>신규 직원 등록!!</title>
  <a href="empAll.do">직원목록 보기</a>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
  <script src="/webshop17/static/js/jquery-3.7.1.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  <script>
    $(function() {
        $("form").on("submit",call);
        $('#hire_date').val(new Date().toISOString().substring(0,10));
    });
    
    function call(event) {
        var salary = $("#salary").val();
        if(salary=="" || salary<=0) {
            alert("월급의 값은 0보다 커야합니다.");
            event.preventDefault(); // default이벤트 취소(서버전송 취소)
            document.querySelector("#salary").focus();
        }
    }
    
    // 아이디 중복체크
    $(function() {
        $("form").on("submit", call);
        $("#btnDupCheck").on("click",f_dupCheck);
    });
    
    function call(event) {
        var salary = $("#salary").val();
        if(salary == "" || salary <= 0 ) {
            alert("salary값은 0보다 큰 값이어야 한다.");
            event.preventDefault(); // default 이벤트 취소 ()
            document.querySelector("#salary").focus();
        }
        
    }
    
    function f_dupCheck() {
        var empid = $("#employee_id").val();
        if(empid == "") {
            alert("직원 번호를 입력하세요.");
            $("#employee_id").focus();
        }
        $.ajax({
            url: "empIdCheck.do",
            data: {empid: empid},
            type: "GET",
            success: function(responseData) {
                var message = "";
                if(responseData == "0") {
                    message = "사용 가능한 계정입니다.";
                } else {
                    $("#employee_id").val("");
                    message = "중복된 계정입니다.";
                }
                
                $("#resultMessage").val(message);
            }, error: function(e) {
                
            }
        });
    }
  </script>
</head>
<body>
<div class="container mt-3">
  <h2>신규직원 등록</h2>
  <form action="empInsert.do" method="post">
    <div class="mb-3 mt-3">
      <label for="employee_id">직원번호: </label>
      <input type="number" class="form-control" id="employee_id" placeholder="Enter employee_id" name="employee_id" required>
      <input type="button" value="중복체크" id="btnDupCheck">
      <input type="text" placeholder="ID입력 후 중복체크" id="resultMessage">
    </div>
    <div class="mb-3 mt-3">
      <label for="first_name">firstname: </label>
      <input type="text" class="form-control" id="employee_id" placeholder="Enter first_name" name="first_name">
    </div>
    <div class="mb-3 mt-3">
      <label for="last_name">lastname: </label>
      <input type="text" class="form-control" id="last_name" placeholder="Enter last_name" name="last_name" required>
    </div>
    <div class="mb-3 mt-3">
      <label for="email">email: </label>
      <input type="email" class="form-control" id="email" placeholder="Enter email" name="email" required>
    </div>
    <div class="mb-3 mt-3">
      <label for="phonenumber">phone number: </label>
      <input type="text" class="form-control" id="phonenumber" placeholder="Enter phonenumber" name="phonenumber">
    </div>
    <div class="mb-3 mt-3">
      <label for="department_id">부서번호: </label>
      <select name="department_id">
        <c:forEach items="${deptlist}" var="dept">
            <option value="${dept.getDepartment_id()}">${dept.getDepartment_name()}</option>
        </c:forEach>
      </select>
    </div>
    <div class="mb-3 mt-3">
      <label for="manager_id">매니져 ID: </label>
      <select name="manager_id">
        <c:forEach items="${mlist}" var="mng">
            <option value="${mng.employee_id}">${mng.fullname}</option>
        </c:forEach>
      </select>
    </div>
    <%-- ScriptLet문법, EL, JSTL문법을 사용하는것이 좋다 --%>
    <div class="mb-3 mt-3">
      <label for="job_id">직책:</label>
      <select name="job_id" required>
	    <c:forEach items="${jlist}" var="job">
	      <option value="${job.job_id}">${job.job_title}</option>
	    </c:forEach>
      </select>
    </div>
    <div class="mb-3 mt-3">
      <label for="salary">월급: </label>
      <input type="number" class="form-control" id="salary" placeholder="Enter salary" name="salary">
    </div>
    <div class="mb-3 mt-3">
      <label for="commision_pct">보너스: </label>
      <input type="text" class="form-control" id="commision_pct" placeholder="Enter commision_pct" name="commision_pct">
    </div>
    <div class="mb-3 mt-3">
      <label for="hire_date">입사날짜: </label>
      <input type="date" class="form-control" id="hire_date" placeholder="Enter hire_date" name="hire_date" required>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
  </form>
</div>
</body>
</html>