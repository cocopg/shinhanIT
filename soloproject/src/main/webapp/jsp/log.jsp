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
  <script src="${path }/other/main.js"></script>
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
          <div class="table-box2">
            <table>
              <thead>
                <tr>
                  <th>No</th>
                  <th>기기ID</th>
                  <th>시간</th>
                  <th>전원상태</th>
                  <th>전원</th>
                </tr>
              </thead>
            </table>
            <div class="scroll-box2" id="scroll-box" style="display:none;">
            <table>
              <tbody>
                <c:forEach items="${loglist}" var="log">
				    <tr>
				        <td>${log.log_id}</td>
				        <td>${log.user_id}</td>
				        <td>${log.device_id}</td>
				        <td>${log.timestamp}</td>
				        <td>${log.status}</td>
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
        	<button type="button" id="deviceLook" class="form_btn" onclick="deviceLook()">조회하기</button>
      	</div>
      </div>
    </div>
  </div>
</body>

</html>