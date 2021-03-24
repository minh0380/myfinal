<%@page import="com.kh.aboo.common.code.Configcode"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
<body>
	<h1>반갑습니다. ${param.userId }님!</h1>
	<h1>toy-project 사이트에 가입하신 것을 환영합니다!</h1>
	<h1>회원가입 마무리 위해 아래 링크를 클랙해주세요!</h1>
	<a href="<%= Configcode.DOMAIN %>/member/joinimpl.do">회원 가입 완료</a>
</body>
</html>