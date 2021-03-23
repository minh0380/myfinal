<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<%-- 모든 페이지에서 공통적으로 사용할 헤더정보를 담은 헤더태그! --%>
<head>
<meta charset="UTF-8">

<%-- generation! --%>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link href="https://fonts.googleapis.com/css?family=Work+Sans:300,400,,500,600,700" rel="stylesheet">
<link rel="stylesheet" href="../../../resources/css/generation/open-iconic-bootstrap.min.css">
<link rel="stylesheet" href="../../../resources/css/generation/animate.css">
<link rel="stylesheet" href="../../../resources/css/generation/owl.carousel.min.css">
<link rel="stylesheet" href="../../../resources/css/generation/owl.theme.default.min.css">
<link rel="stylesheet" href="../../../resources/css/generation/magnific-popup.css">
<link rel="stylesheet" href="../../../resources/css/generation/aos.css">
<link rel="stylesheet" href="../../../resources/css/generation/ionicons.min.css">
<link rel="stylesheet" href="../../../resources/css/generation/bootstrap-datepicker.css">
<link rel="stylesheet" href="../../../resources/css/generation/jquery.timepicker.css">
<link rel="stylesheet" href="../../../resources/css/generation/flaticon.css">
<link rel="stylesheet" href="../../../resources/css/generation/icomoon.css">
<link rel="stylesheet" href="../../../resources/css/generation/style.css">
<link rel="stylesheet" href="../../../resources/css/all.css">

<title>pclass</title>
<%-- 
	contextPath를 context변수에 저장
	ex) 이 프로젝트에서는 contextPath가 jsp 이므로 jsp가 변수에 담긴다.
 --%>
<c:set var="context" value="${pageContext.request.contextPath}"/>
<script type="text/javascript" src="/resources/js/common/urlEncoder.js"></script>
<script type="text/javascript" src="/resources/js/common/asyncPageError.js"></script>
</head>
