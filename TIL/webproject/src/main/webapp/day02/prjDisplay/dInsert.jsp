<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>새로운 기기 등록완료</h1>
	<p>기기명:<%=request.getParameter("input1")%></p>
	<p>제조사:<%=request.getParameter("input2")%></p>
	<p>종류:<%=request.getParameter("input3")%></p>
	<p>위치:<%=request.getParameter("input4")%></p>
	<p>상태:<%=request.getParameter("status")%></p>
</body>
</html>