<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>News List</title>
</head>

<body>

		<div class="main-content">
		<form action="<c:url value='/admin-news'/>" id="formSubmit" method="get">
			<div class="main-content-inner">
				<div class="breadcrumbs ace-save-staete" id="breadcrumbs">
					<ul class="breadcrumb">
						<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Home</a>
						</li>
					</ul>
					<!-- /.breadcrumb -->
					<div class="page-content">
						<div class="row">
							<div class="col-xs-12">
								<table class="table table-condensed">
									<thead>
										<tr>
											<th>Title</th>
											<th>Short Description</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="item" items="${model.listResult}">
											<tr>
												<td>${item.title}</td>
												<td>${item.shortDescription}</td>
											</tr>
										</c:forEach>

									</tbody>
								</table>
								<ul class="pagination" id="pagination"></ul>
								<input type="hidden" value="" id="page" name="page" />
								<input type="hidden" value="" id="maxPageItem" name="maxPageItem" />
							</div>
						</div>
						</form>
					</div>

	<script type="text/javascript">
		var totalPages = ${
			model.totalPage
		};
		var currentPage = ${
			model.page
		};
		var limit = 2;
		$(function () {
			window.pagObj = $('#pagination').twbsPagination({
				totalPages: totalPages,
				visiblePages: 10,
				startPage: currentPage,
				onPageClick: function (event, page) {
					if(currentPage != page){
						$('#maxPageItem').val(limit);
						$('#page').val(page);
						$('#formSubmit').submit();
					}
					
				}
			});
		});
	</script>

</body>

</html>