<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/head.jsp" %>

<body>
	<%-- 경고창 띄워주구 페이지 이동시킬 곳
	모든 예외처리 할 수 없으니 이런 페이지 만들어서 쓰는 것이 좋다. 자바스크립트 el jstl같이 쓴 작품 --%>
	<script type="text/javascript">
		let context ="${context}";
		<c:if test="${!empty alertMsg}">
			alert("${alertMsg}");
		</c:if>
		
		 <%-- 뒤로가기는 history.back --%>
		<c:if test="${!empty back}">
			history.back();
		</c:if>
		
		<c:if test="${!empty url}">
			location.href = context + '${url}';
		</c:if>
		
	</script>
</body>
</html>