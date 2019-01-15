<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>보낸 쪽지함 - 내용보기</title>
<!-- <link rel="stylesheet" type="text/css" href="./resources/css/member.css"> -->
<script src="http://code.jquery.com/jquery-latest.js"></script>
</head>
<body>
	<table>
		<caption>쪽지 상세 보기</caption>
		<tr>
			<th>받는 사람</th>
			<td>${letterbean.le_toUser}</td>
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
		<input type = "button" value = "삭제">
	</div>
</body>
</html>