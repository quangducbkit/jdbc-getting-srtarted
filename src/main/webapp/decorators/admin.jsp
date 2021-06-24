<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title><dec:title default="Home Page" /></title>

<!-- bootstrap & fontawesome -->
<link rel="stylesheet"
	href="<c:url value='/template/admin/css/bootstrap.min.css'/>" />
<link rel="stylesheet"
	href="<c:url value='/template/admin/font-awesome/4.5.0/css/font-awesome.min.css'/>" />

<!-- page specific plugin styles -->

<!-- text fonts -->
<link rel="stylesheet"
	href="<c:url value='/template/admin/css/fonts.googleapis.com.css'/>" />

<!-- ace styles -->
<link rel="stylesheet"
	href="<c:url value='/template/admin/css/ace.min.css'/>"
	class="ace-main-stylesheet" id="main-ace-style" />

<link rel="stylesheet"
	href="<c:url value='/template/admin/css/ace-skins.min.css' />" />
<link rel="stylesheet"
	href="<c:url value='/template/admin/css/ace-rtl.min.css' />" />
<script src="<c:url value='/template/admin/js/ace-extra.min.js' />"></script>
<script
		src="<c:url value='/template/paging/jquery.twbsPagination.js' /> "></script>
</head>
<body>

	<%@include file="/common/admin/header.jsp"%>

	<div class="main-container ace-save-state" id="main-container">
		<script type="text/javascript">
			try {
				ace.settings.loadState('main-container')
			} catch (e) {
			}
		</script>
		<%@include file="/common/admin/menu.jsp"%>
		<dec:body />
		<%@include file="/common/admin/footer.jsp"%>
		<a href="#" id="btn-scroll-up"
			class="btn-scroll-up btn btn-sm btn-inverse"> <i
			class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
		</a>
	</div>









	<script src="<c:url value='/template/admin/js/jquery-2.1.4.min.js' /> "></script>
	<script src="<c:url value='/template/admin/js/bootstrap.min.js' /> "></script>
	<script
		src="<c:url value='/template/admin/js/jquery-ui.custom.min.js' /> "></script>
	<script
		src="<c:url value='/template/admin/js/jquery.ui.touch-punch.min.js' /> "></script>
	<script
		src="<c:url value='/template/admin/js/jquery.easypiechart.min.js' /> "></script>
	<script
		src="<c:url value='/template/admin/js/jquery.sparkline.index.min.js' /> "></script>
	<script src="<c:url value='/template/admin/js/jquery.flot.min.js' /> "></script>
	<script
		src="<c:url value='/template/admin/js/jquery.flot.pie.min.js' /> "></script>
	<script
		src="<c:url value='/template/admin/js/jquery.flot.resize.min.js'/>"></script>
	<script src="<c:url value='/template/admin/js/ace-elements.min.js'/>"></script>
	<script src="<c:url value='/template/admin/js/ace.min.js'/>"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	
</body>
</html>