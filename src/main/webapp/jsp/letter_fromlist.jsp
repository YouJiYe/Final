<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>보낸 쪽지함</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
</head>
<body>
	<table>
		<caption>보낸 쪽지함</caption>
		
		<tr>
			<td>번호</td>
			<td>내용</td>
			<td>받는 사람</td>
			<td>쪽지 상태</td>
			<td>날짜</td>
		</tr>
		
			<!-- 화면 출력 번호  변수 정의 -->
			<c:set var="num" value="${fromlistcount-(page-1)*10}" />
			
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
					<a href="letter_fromcont.to?le_inx=${l.le_inx}&state=cont">
					${l.le_contents}
					</a>
					
				</td>
				<td>${l.le_toUser}</td>
				<td>${l.le_state}</td>
				<td>${l.le_date}</td>
			</tr>
		</c:forEach>
		<!-- 반복문 끝 -->
	</table>
	
	<div>
		<c:if test="${page <=1 }">
				[이전]&nbsp;
		</c:if>
	
		<c:if test="${page > 1 }">
			<a href="bbs_list.to?page=${page-1}">[이전]</a>&nbsp;
		</c:if>
		
		<c:forEach var="a" begin="${startpage}" end="${endpage}">
			<c:if test="${a == page }">
				[${a}]
			</c:if>
			<c:if test="${a != page }">
				<a href="letter_fromlist.to?page=${a}">[${a}]</a>&nbsp;
			</c:if>
		</c:forEach>
		
		<c:if test="${page >= maxpage }">
				[다음] 
		</c:if>
		
		<c:if test="${page < maxpage }">
			<a href="letter_fromlist.to?page=${page+1}">[다음]</a>
		</c:if>
	</div>
	
	<input type = "button" value = "삭제">
	
	<input type = "button" value = "쪽지 쓰기"
		   onclick="location='letter_wrmain.to?le_inx=${letterbean.le_inx}'">
		   
	<input type = "button" value = "받은 쪽지함"
		   onclick="location='letter_tolist.to?le_inx=${letterbean.le_inx}'">
</body>
</html>