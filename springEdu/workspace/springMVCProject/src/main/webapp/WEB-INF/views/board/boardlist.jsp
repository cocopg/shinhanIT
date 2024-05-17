<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
	<c:set var="path" value="${pageContext.servletContext.contextPath }" />
	<a href="${path}/board/boardInsert.do">게시판 등록</a>
	<h1>Board 목록</h1>
	<table border="1">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>내용</th>
				<th>작성자</th>
				<th>pic</th>
				<th>작성일</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${blist}" var="board">
				<tr>
					<td><a href="${path}/board/boardDetail.do?bno=${board.bno}">
							${board.bno} </a></td>
					<td>${board.title}</td>
					<td>${board.content}</td>
					<td>${board.writer}</td>
					<td><img src="${cpath}/upload/${board.pic}"
						alt="${board.title}" width=50 height=50> <a
						href="${cpath}/download.do?filename=${board.pic}">다운로드</a></td>
					<td>${board.create_date}</td>
					<td><button
							onclick="location.href='${path}/board/boardDelete.do?bno=${board.bno}'">삭제</button></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>