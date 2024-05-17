<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Hello
<h1>이름은 ${myname }</h1>
<h1>점수는 ${myscore }</h1>

<h2>Get방식 요청(요청주소에 param이용:값 동일, field존재, 값 불일치 )</h2>
<form action="${pageContext.servletContext.contextPath}/sample/hello6.do">
	email : <input type="email" name="email" value="qwer1234@naver.com"><br>
	password : <input type="password" name="pw" value="1234"><br>
	phone : <input type="text" name="phone" value="010-1234-5678"><br>
	<input type="submit" value="서버전송(get)">

</form>

<hr>
<h2>Post방식요청</h2>
<form action="${pageContext.servletContext.contextPath}/sample/hello6.do" method="post">
	email : <input type="email" name="email" value="qwer1234@naver.com"><br>
	password : <input type="password" name="pw" value="1234"><br>
	phone : <input type="text" name="phone" value="010-1234-5678"><br>
	<input type="submit" value="서버전송(post)">

</form>

</body>
</html>