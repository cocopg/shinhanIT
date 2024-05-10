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
        <button type="button" id="select" class="form_btn" onclick="location.href='devInsert.do'">기기추가</button>
        <button type="button" id="select" class="form_btn" onclick="location.href='devDelete.do'">기기삭제</button>
        <button type="button" id="select" class="form_btn" onclick="location.href='deviceList.do'">기기목록</button>
      </div>
      <div class="sign-in-container">
        <form class="form4" action="${path}/jsp/devInsert.do" method="post">
          <h1>기기추가</h1>
          <span>기기정보를 입력하세요</span>
          <input type="text" id="deviceId" name="deviceId" placeholder="기기ID">
          <input type="text" id="manufacture" name="manufacture" placeholder="제조사">
          <input type="text" id="d_type" name="d_type" placeholder="종류">
          <input type="text" id="status" name="status" placeholder="전원">
          <input type="text" id="room_name" name="room_name" placeholder="위치">
            <button type="submit" class="form_btn">등록하기</button>
        </form>
      </div>
    </div>
  </div>
</body>
</html>