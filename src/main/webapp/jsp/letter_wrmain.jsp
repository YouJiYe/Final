<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쪽지 메인페이지</title>
<!-- <link rel="stylesheet" type="text/css" href="./resources/css/member.css"> -->
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script>
function letter_check(){
	if($.trim($("#le_toUser").val()) == "") {
		alert("받는 사람을 입력하세요.");
		$("#le_toUser").val("").focus();
		return false;
	}
	
	if($.trim($("#le_contents").val()) == "") {
		alert("쪽지 내용을 입력하세요.");
		$("#le_contents").val("").focus();
		return false;
	}
	
	if($("#le_contents").val().length > 1000) {
		alert("쪽지 내용은 1000자 이내로 입력 해 주세요.");
		$("#le_contents").val();
		$("#le_contents").focus();
		return false;
	}
}
</script>
</head>
<body>
<form method="post" action="letter_wrmain_ok.to" 
	  onsubmit="return letter_check()">
	<table>
		<caption>쪽지</caption>
		<tr>
			<th>보내는 사람</th>
			<td>
				<input type = "text" id="le_fromUser" name ="le_fromUser" value="${id}">
			</td>
		
		<tr>
			<th>받는 사람</th>
			<td>
				<input type = "text" id= le_toUser name ="le_toUser">
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
		<input type = "submit" value = "보내기">
		<input type = "button" value = "보낸 쪽지함"
			   onclick="location='letter_fromlist.to?le_inx=${letterbean.le_inx}'">
		<input type = "button" value = "받은 쪽지함"
			   onclick="location='letter_tolist.to?le_inx=${letterbean.le_inx}'">
</form>
</body>
</html>