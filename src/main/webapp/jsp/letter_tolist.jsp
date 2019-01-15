<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>받는 쪽지함</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
</head>
<body>
<form>
	<table>
		<caption>받은 쪽지함</caption>
		
		<tr>
			<td>번호</td>
			<td>내용</td>
			<td>보낸 사람</td>
			<td>날짜</td>
		</tr>
		
			<!-- 화면 출력 번호  변수 정의 -->
			<c:set var="num" value="${tolistcount-(page-1)*10}" />
			
				<!-- 반복문 시작 -->
		<c:forEach var="l" items="${letterlist}">
			<tr>
				<td>
					<!-- 번호 출력 -->
					<c:out value="${num}" />
					<c:set var="num" value="${num-1}"/>
				</td>
				
				<td>
				<!-- 제목 출력 부분 -->
					<a href="letter_tocont.to?le_inx=${l.le_inx}&state=cont">
					${l.le_contents}
					</a>
					
					</td>
				<td>${l.le_fromUser}</td>
				<td>${l.le_date}</td>
			</tr>
		</c:forEach>
		<!-- 반복문 끝 -->
	</table>
	
	<div>
		<input type = "button" value = "답장"
		   		onclick="location='letter_toreply.to?le_inx=${letterbean.le_inx}'">
		<input type = "button" value = "삭제">
	</div>
</form>
</body>
</html>