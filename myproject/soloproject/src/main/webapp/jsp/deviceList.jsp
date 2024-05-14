<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="login.ControlDAO" %>
<%@ page import="login.DevDTO" %>
<%@ page import="java.sql.SQLException" %>
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
    <div class="container1">
      <div class="sign-in-container">
        <form id="main1">
          <h1>기기목록</h1>
          <div class="table-box">
            <table>
              <thead>
                <tr>
                  <th>기기ID</th>
                  <th>제조사</th>
                  <th>종류</th>
                  <th>등록일</th>
                  <th>전원</th>
                  <th>위치</th>
                  <th>사용자ID</th>
                </tr>
              </thead>
            </table>
            <div class="scroll-box" id="scroll-box">
            <table>
              <tbody>
                <c:forEach items="${devicelist}" var="device">
					<tr>
						<td>${device.device_id}</td>
						<td>${device.manufacture}</td>
						<td>${device.d_type}</td>
						<td>${device.regist_date}</td>
						<td>${device.status}</td>
						<td>${device.room_name}</td>
						<td>${device.user_id}</td>
					</tr>
				</c:forEach>
				</tbody>
              </table>
            </div>
            </tbody>
            </table>
          </div>
        </form>
        <div class="search-btn">
        	<button type="button" class="form_btn" onclick="location.href='status.do'">상태변경</button>
        	<button type="button" class="form_btn" onclick="location.href='devInsert.do'">등록/삭제</button>
      	</div>
      </div>
    </div>
  </div>
</body>

</html>