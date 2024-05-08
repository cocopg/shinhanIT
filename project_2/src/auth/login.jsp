<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="main.css">
    <script src="main.js"></script>
</head>
<body>
    <div class="wrapper">
        <div class="container">
          <div class="sign-in-container">
            <form>
              <h1>안녕하세요!</h1>
              <span>아이디와 비밀번호를 입력하세요</span>
              <input type="text" placeholder="아이디">
              <input type="password" placeholder="비밀번호">
              <div class="sign-btn">
                <button type="button" id="login" class="form_btn" onclick="location.href='main.html'">로그인</button>
                <button type="button" id="sigh" class="form_btn" onclick ="location.href='sign.html'">화원가입</button>
              </div>
            </form>
          </div>
        </div>
      </div>
</body>
</html>