<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container mt-3">
  <h2>Stacked form</h2>
  <form action="login.do" method="post">
    <div class="mb-3 mt-3">
      <label for="email">Email:</label>
      <input type="text" class="form-control" id="email" placeholder="Enter email" name="email" value="SKING">
    </div>
    <div class="mb-3">
      <label for="pwd">Password:</label>
      <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pswd" value="515.123.4567">
    </div>
    <div class="form-check mb-3">
      <label class="form-check-label">
        <input class="form-check-input" type="checkbox" name="remember"> Remember me
      </label>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
  </form>
</div>
  <script>
  $(function(){
		$("form").on("submit", f);
		$("#email").val(localStorage.getItem("email"));
  		$("#pwd").val(localStorage.getItem("pwd"));
  		var checkStatus = localStorage.getItem("checkStatus");
  		if(checkStatus == 1){
  			$("#remember").prop("checked", true);
  		}
  });
  function f(){
	  var check=$("#remember").prop("checked");
	  if(check){
		  localStorage.setItem("email",$("#email").val());
		  localStorage.setItem("pwd",$("#pwd").val());
		  localStorage.setItem("checkStatus",1);
	  }else{
		  localStorage.removeItem("email");
		  localStorage.removeItem("pwd");
		  localStorage.removeItem("checkStatus");
	  }
  }
  </script>
</body>
</html>