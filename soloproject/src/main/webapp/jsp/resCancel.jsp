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
    <button type="button" onclick="history.back()" id="back">뒤로가기</button>
    <button type="button" onclick="location.href='login.html'" id="logoutBtn">로그아웃</button>
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
          <h1>예약취소</h1>
          <input type="text" id="residInput" placeholder="예약번호">
            <button type="button" class="form_btn" onclick="cancelReservation()">취소하기</button>
        </form>
      </div>
    </div>
  </div>
</body>