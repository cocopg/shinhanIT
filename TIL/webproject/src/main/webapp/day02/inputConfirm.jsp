<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>화긴</h1>
	<p><%=request.getParameter("input1")%></p>
	<p><%=request.getParameter("input2")%></p>
	<p><%=request.getParameter("input3")%></p>
	<p><%=request.getParameter("input4")%></p>
	<p><%=request.getParameter("input5")%></p>
	<p><%=request.getParameter("input6")%></p>
	<p><%=request.getParameter("input7")%></p>
	<p><%=request.getParameter("input8")%></p>
	<p><%=request.getParameter("gender")%></p>
	<p><%=request.getParameter("sub")%></p>
	<ul>
		<%
		String []arr=request.getParameterValues("sub");
		for(int i=0; arr!=null && i<arr.length;i++){
			out.print("<li>"+arr[i]+"</li>");
			//out는 HTML문서의 body를 의미하는 jsp가 내장하는 객체
			//system.out은 모니터출력을 의미
			System.out.println(i+"==>"+arr[i]);
		}
		%>
	</ul>
	
	<p><%=request.getParameter("input9")%></p>
	<p><%=request.getParameter("input10")%></p>
	<p><%=request.getParameter("input11")%></p>
	<p><%=request.getParameter("input12")%></p>
	<p><%=request.getParameter("input13")%></p>
	<p><%=request.getParameter("input14")%></p>
	<p><%=request.getParameter("input15")%></p>
	<p><%=request.getParameter("input16")%></p>
	<p><%=request.getParameter("week1")%></p>
	<p><%=request.getParameter("week2")%></p>
	<p><%=request.getParameter("week3")%></p>
	
	<%
	String[] arr2 = request.getParameterValues("week2");
	for(int i=0; arr!=null&&i<arr2.length;i++){
		out.print("<li>"+arr2[i]+"</li>");
	}
	%>
	
</body>
</html>