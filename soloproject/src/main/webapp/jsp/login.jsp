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
    <div class="wrapper">
        <div class="container">
          <div class="sign-in-container">
            <form action="/jsp/login.do" method="post">
              <h1>안녕하세요!</h1>
              <span>아이디와 비밀번호를 입력하세요</span>
              <input type="text" id="user_id" placeholder="아이디">
              <input type="password" id="password" placeholder="비밀번호">
              <div class="msg">
              
                <span class="logErrMsg" id="logErrMsg"></span>
               
              </div>
              <div class="sign-btn">
                <button type="button" id="login" class="form_btn" onclick="loginCheck()">로그인</button>
                <button type="button" id="sigh" class="form_btn" onclick ="location.href='sign.html'">화원가입</button>
              </div>
            </form>
          </div>
        </div>
      </div>
</body>
</html>
