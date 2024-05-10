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
        <h1>메인화면</h1>
    <button type="button" onclick="location.href='login.do'" id="logoutBtn">로그아웃</button>
    </header>
    <div class="main-header">
        <h1>서비스를 선택하세요</h1>
    </div>
    <div class="main-wrapper">
        <div class="content-box">
            <div class="main-container" onclick="location.href='deviceList.do'">
                <div class="contents">
                    <form>
                        <img src="Vector.png">
                        <p>기기목록</p>
                    </form>
                </div>
            </div>
            <div class="main-container" onclick="location.href='status.do'">
                <div class="contents">
                    <form>
                        <img src="Vector.png">
                        <p>전원설정</p>
                    </form>
                </div>
            </div>
            <div class="main-container" onclick="location.href='res.do'">
                <div class="contents">
                    <form>
                        <img src="Vector.png">
                        <p>기기예약</p>
                    </form>
                </div>
            </div>
            <div class="main-container" onclick="location.href='devInsert.do'">
                <div class="contents">
                    <form>
                        <img src="Vector.png">
                        <p>기기등록/삭제</p>
                    </form>
                </div>
            </div>
            <div class="main-container" onclick="location.href='log.do'">
                <div class="contents">
                    <form>
                        <img src="Vector.png">
                        <p>전원로그</p>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>

</html>