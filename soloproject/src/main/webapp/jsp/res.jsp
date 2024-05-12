<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var='path' value='${pageContext.request.servletContext.contextPath }'/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <link rel="stylesheet" href="${path }/other/main.css">
    <script src="${path}/other/main.js"></script>
</head>

<body>
  <header>
    <button type="button" onclick="location.href='main.do'" id="back">뒤로가기</button>
    <button type="button" onclick="location.href='login.do'" id="logoutBtn">로그아웃</button>
  </header>
  <div class="con-wrapper">
    <div class="container3">
      <div class="top-select">
        <button type="button" id="select" class="form_btn" onclick="location.href='res.do'">예약</button>
        <button type="button" id="select" class="form_btn" onclick="location.href='resCancel.do'">취소</button>
        <button type="button" id="select" class="form_btn" onclick="location.href='resList.do'">내역</button>
      </div>
      <div class="sign-in-container">
        <form class="form3">
          <h1>동작 예약</h1>
          <input type="text" id="deviceId" placeholder="기기ID">
          <input type="text" id="startTime" placeholder="시작시간(yyyy-mm-dd hh:mm:ss)">
          <input type="text" id="endTime" placeholder="종료시간(yyyy-mm-dd hh:mm:ss)">
          <div class="msg">
              <span class="resErrMsg" id="resErrMsg"></span>
          </div>
            <button type="button" class="form_btn" onclick="reserve()">예약</button>
        </form>
      </div>
    </div>
  </div>
</body>
</html>