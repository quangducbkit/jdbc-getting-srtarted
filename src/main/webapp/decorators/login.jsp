<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title><dec:title default="Login" /></title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="<c:url value='/template/login/style.css'/>"
	rel="stylesheet">
</head>
<body>
	<div id="login">
		<h3 class="text-center text-white pt-5">Login form</h3>
		<div class="container">
			<dec:body />
		</div>
	</div>

</body>
</html>