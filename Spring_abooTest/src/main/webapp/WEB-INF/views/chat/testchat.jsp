<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.5/sockjs.min.js"></script>
</head>
<body>
<form>
	<input type="text" name="msg" id="msg" placeholder="메시지">
	<input type="submit" id="send" value="전송">
	<hr>
	<textarea rows="5" cols="30" id="msgArea"></textarea>
</form>
</body>
<script type="text/javascript">
	document.querySelector("#send").click(function(){
		sendMessage();
		document.querySelector("#msg").val('')
	});
	
	let sock = new SockJS("http://localhost:8484/echo");
	sock.onmessage = onMessage;
	xock.onclose = onClose;
	
	function sendMessage(){
		sock.send(document.querySelector("#msg").val());
	}
	
	function onMessage(msg){
		var data = msg.data;
		document.querySelector("#msgArea").append(data + "<br/>");
	}
	
	function onClose(evt){
		document.querySelector("#msgArea").append("연결 끊김");
	}
</script>
</html>