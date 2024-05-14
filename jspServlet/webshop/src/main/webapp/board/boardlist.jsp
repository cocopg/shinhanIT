<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <c:set var="path" value="${pageContext.request.servletContext.contextPath}/board"/>
    <c:set var="cpath" value="${pageContext.request.servletContext.contextPath}"/>
    
    <%-- &lt; &amp;<br>
    <c:out value="%lt" escapeXml="true"></c:out><br>
    <c:out value="%amp" escapeXml="true"></c:out><br>
    <c:out value="%amp" escapeXml="false"></c:out><br>
    <c:out value="%lt" escapeXml="false"></c:out><br> --%>
    
    <%
        request.setCharacterEncoding("utf-8");
    %>
    <script src="${cpath}/static/js/jquery-3.7.1.min.js"></script>
    <script>
        $(function() {
            $("#btnJSON").on("click", f_jsonCall);
            $("#btnJSON2").on("click", f_jsonCall2);
        });
        function f_jsonCall2(){//react시 이렇게
        	var output = "<ul>";
        	$.ajax({
        		url:"${cpath}/json2",
        		type:"get",
        		success:function(responseData){
        			console.log(responseData);
        			var obj = JSON.parse(responseData);
        			var boardlist = obj["boardlist"];
        			$.each(boardlist, function(index, item){
        				output +="<li>"+item.title + "</li>"
        			});
        			output += "</ul>";
        			$(#"here").html(output);
        		},
        		error:function(err){
        			alert(err);
        		}
        	});
        }
        
        function f_jsonCall() {
            var boardObj = {bno:100, title:"주스", content:"맛집", writer:"익명"};
            var boardStr = JSON.stringify(boardObj);
            console.log(boardObj);
            console.log(boardObj.title);
            console.log(boardStr);
            
            $.ajax({
                url:"${cpath}/json",
                type:"get",
                data:{"jsonInfo":boardStr},
                success:function(responseData) {
                    console.log(responseData);
                },
                error:function(error) {
                    alert(errorInfo);
                }
                
            })
        }
    </script>
    <button id="btnJSON">JSON보내기</button>
    <button id="btnJSON2">JSON받기</button>
    <div id="here">여기</div>
    <a href="${path}/boardInsert.do">게시판등록</a>
    <h1>Board목록</h1>
    <table border="1">
        <tr>
            <th>bno</th>
            <th>title</th>
            <th>content</th>
            <th>writer</th>
            <th>pic</th>
            <th>작성일</th>
            <th></th>
        </tr>
        <c:forEach var="board" items="${blist}">
            <tr>
                <td>
                <a href="${path}/boardDetail.do?bno=${board.bno}">${board.bno}</a>
                </td>
                <td>${board.title}</td>
                <td>${board.content}</td>
                <td>${board.writer}</td>
                <td>
                    <img alt="${board.title}" src="${cpath}/upload/${board.pic}">
                    <a href="${cpath}/download.do?fileName=${board.pic}">사진 다운받기</a>
                </td>
                <td>${board.create_date}</td>
                <td><button onclick="location.href='${path}/boardDelete.do?bno=${board.bno}'">삭제</button></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>