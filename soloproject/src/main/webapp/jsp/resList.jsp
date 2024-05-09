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
    <div class="container1">
      <div class="top-select">
        <button type="button" id="select" class="form_btn" onclick="location.href='res.do'">예약</button>
        <button type="button" id="select" class="form_btn" onclick="location.href='resCancel.do'">취소</button>
        <button type="button" id="select" class="form_btn" onclick="location.href='resList.do'">내역</button>
      </div>
      <div class="sign-in-container">
        <form id="main1">
          <h1>예약내역</h1><div class="table-box3">
            <table>
              <thead>
                <tr>
                  <th>예약번호</th>
                  <th>기기ID</th>
                  <th>시작시간</th>
                  <th>종료시간</th>
                </tr>
              </thead>
            </table>
            <div class="scroll-box3" id="scroll-box">
            <table>
              <tbody>
                <c:forEach items="${reslist}" var="res">
				    <tr>
				        <td>${res.reservation_id}</td>
				        <td>${res.device_id}</td>
				        <td>${res.start_time}</td>
				        <td>${res.end_time}</td>
				    </tr>
				</c:forEach>
				</tbody>
              </table>
            </div>
            </tbody>
            </table>
          </div>
        </form>
      </div>
    </div>
  </div>
</body>