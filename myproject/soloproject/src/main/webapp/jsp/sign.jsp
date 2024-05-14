<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var='path' value='${pageContext.request.servletContext.contextPath }'/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="${path }/other/main.css">
    <script src="${path}/other/main.js"></script>
</head>
<body>	
<header>
    <button type="button" id="back" onclick="location.href='login.do'">뒤로가기</button>
    </header>
    <div class="con-wrapper">
        <div class="container">
          <div class="sign-in-container">
            <form action="${path}/jsp/login.do" method="post">
              <h1>안녕하세요!</h1>
              <span>아이디와 비밀번호를 입력하세요</span>
              <input type="text" id="userid" name="userid" placeholder="아이디">
              <input type="password" id="password" name="password" placeholder="비밀번호">
              <input type="text" id="name" name="name" placeholder="이름">
              <div class="msg">
                <span class="signErrMsg" id="signErrMsg"></span>
              </div>
              <div class="sign-btn">
                <button type="button" id="signIn" name ="signIn" class="form_btn" onclick="sign()">가입</button>
              </div>
            </form>
          </div>
        </div>
      </div>
</body>
</html>
