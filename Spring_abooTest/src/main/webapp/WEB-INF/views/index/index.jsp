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
	<h1>Toy Project Index Page</h1>
	<h1>구현한 기능들</h1>
	<ol>
		<c:choose>
			<c:when test="${empty sessionScope.user}">
			<li><a href="/member/login">로그인</a></li>
			<li><a href="/member/join">회원가입</a></li>
			</c:when>
			<c:otherwise>
			<li><a href="/member/logout">로그아웃</a></li>
			<li><a href="/member/mypage">마이페이지</a></li>
			<li><a href="/board//write">글쓰기</a></li>
			</c:otherwise>
		</c:choose>
	</ol>
	
	<h2><a href="/board/detail">게시글 보기</a></h2>
</body>
</html>