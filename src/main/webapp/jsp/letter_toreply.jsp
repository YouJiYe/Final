<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>받는 사람이 보낸사람에게 답장하기</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
</head>
<body>
<form method = "post" action = "letter_toreply_ok.to">
	<table>
		<tr>
			<th>받는 사람</th>
			<td>
				<input type = "text" id= le_toUser name ="le_toUser" value = "${le_toUser}">
			</td>
		</tr>
			
		<tr>
			<th>내용</th>
			<td>
				<textarea name = "le_contents" id = "le_contents" 
						  rows="5" cols="80"></textarea>
			</td>
		</tr>
</table>
</form>

	<input type = "submit" value = "보내기">
</body>
</html>