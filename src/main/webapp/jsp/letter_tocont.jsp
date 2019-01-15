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
		<caption>쪽지 상세 보기</caption>
		<tr>
			<th>보낸 사람</th>
			<td>${letterbean.le_fromUser}</td>
		</tr>
		
		<tr>
			<th>내용</th>
			<td>${letterbean.le_contents}</td>
		</tr>
		
		<tr>
			<th>보낸 시간</th>
			<td>${letterbean.le_date}</td>
		</tr>
	</table>
	
	<div>
		<input type = "button" value = "답장"
		   		onclick="location='letter_toreply.to?le_inx=${letterbean.le_inx}'">
		<input type = "button" value = "삭제">
	</div>
</form>
</body>
</html>