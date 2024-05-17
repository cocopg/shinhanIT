<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="path" value="${pageContext.servletContext.contextPath }" />
<%-- <c:set var ="loginUser" value="${loginEmp.first_name} ${loginEmp.last_name }"/> --%>
	<form action="${path }/board/boardDetail.do" method="post">
		bno : ${board.bno } 
		<input type = "hidden" name="bno" value = "${board.bno }"><br>
		제  목 : <input type="text" name="title" value = "${board.title }"><br>
		컨텐츠 : <input type="text" name="content" value = "${board.content}"><br>
		작성자 : <input type="text" name="writer" value = "${board.writer }" readonly><br>
		작성일 : <input type="text" name="create_date" value = "${board.create_date }" readonly><br>
		이미지 : <input type="text" name="pic" value = "${board.pic }"><br>
	
		
		<%-- <c:if test="${loginUser==board.writer }"> --%>
		<input type="submit" value="수정">
		<%-- </c:if> --%>
		<%-- <c:if test="${loginUser!=board.writer }">
		<input type="submit" value="수정불가" disabled>
		</c:if> --%>
	</form>
</body>
</html>