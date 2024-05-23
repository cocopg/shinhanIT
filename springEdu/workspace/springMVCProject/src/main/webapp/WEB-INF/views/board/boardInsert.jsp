<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록</title>
</head>
<body>
<h1>게시글 등록</h1>
<c:set var="path" value="${pageContext.servletContext.contextPath }"/>
    <form action="${path}/board/boardInsert.do" method="post" enctype="multipart/form-data">
        제목 : <input type="text" name="title" value="${board.title}"><br>
        내용 : <input type="text" name="content" value="${board.content}"><br>
        pic : 
        <input type="file" name="pic"><br>
        <input type="submit" value="등록">
    </form>
</body>
</html>