<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var='path' value='${pageContext.request.servletContext.contextPath }'/>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ㅎㅇ</title>
    <link rel="stylesheet" href="${path }/other/main.css">
    <script src="${path}/other/main.js"></script>
</head>
<body>
  <header>
	<button type="button" onclick="location.href='main.do'" id="back">뒤로가기</button>
    <button type="button" onclick="location.href='login.do'" id="logoutBtn">로그아웃</button>
  </header>
  <div class="con-wrapper">
    <div class="container2">
      <div class="sign-in-container">
        <form>
          <h1>기기상태 변경</h1>
          <span>
            <h3>기기를 입력하세요</h3>
          </span>
          <input type="text" id="device_id" name="device_id" value="${device.device_id}" placeholder="기기명">
          <input type="text" id="status" placeholder="상태값 (On 또는 Off입력)">
          	<div class="msg">
			    <span class="statErrMsg" id="statErrMsg"></span>
			</div>
          <div class="device-btn">
            <button type="button" class="form_btn" onclick="statErrMsg()">상태변경</button>
            <button type="button" class="form_btn" onclick="location.href='deviceList.do'">목록보기</button>
          </div>
        </form>
      </div>
    </div>
  </div>
</body>

</html>