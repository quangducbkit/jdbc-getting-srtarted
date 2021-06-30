<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title><dec:title default="Home Page" /></title>

<%-- <link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	rel="stylesheet" />
<link href="<c:url value='/template/web/css/styles.css' />"
	rel="stylesheet" /> --%>
	
    <!-- Bootstrap Core CSS -->
    <link href="<c:url value='/template/web/vendor/bootstrap/css/bootstrap.min.css'/>" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<c:url value='/template/web/css/shop-homepage.css'/>" rel="stylesheet">


</head>
<body>
	<%@include file="/common/web/header.jsp"%>
	<div class="container">
		<dec:body />
	</div>
	<%@include file="/common/web/footer.jsp"%>

    <!-- jQuery -->
    <script src="<c:url value='/template/web/vendor/jquery/jquery.min.js'/>"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<c:url value='/template/web/vendor/bootstrap/js/bootstrap.bundle.min.js'/>"></script>
</body>
</html>