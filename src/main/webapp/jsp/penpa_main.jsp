<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>
<style type="text/css">
	
	h2{
		color:#000000;
		text-align:center;
	}
</style>
<!-- <link rel="stylesheet" type="text/css" href="./resources/css/penpel_main.css"> -->
<script src="http://code.jquery.com/jquery-latest.js"></script>
</head>
<body>
	<input type = "submit" value = "ENG"><!-- 영어 클릭하면 영어로 번역됨 -->
	
	<h2>로고</h2>
	
	<div id = "member">
		<a href = "letter/">회원가입</a>
		<a href = "member_login.to">로그인</a>
	</div>
		
	<div id = "link">
		<a href = "/">친구검색</a>
		<a href = "/">자유게시판</a>
		<a href = "/">채팅</a>
		<a href = "letter_wrmain.to">쪽지</a>
	</div>
</body>
</html>