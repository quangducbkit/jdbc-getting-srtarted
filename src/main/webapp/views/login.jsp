<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css"></style>
</head>
<body>

	<div id="login-row"
		class="row justify-content-center align-items-center">
		<div id="login-column" class="col-md-6">
			<div id="login-box" class="col-md-12">
				<form id="loginForm" action="<c:url value='/login'/>" method="post">

					<h3 class="text-center text-info">Login</h3>
					<div>
						<label for="username" class="text-info">Username:</label><br>
						<input type="text" name="userName" id="username"
							placeholder="Username" class="form-control">
					</div>
					<div>
						<label for="password" class="text-info">Password:</label><br>
						<input type="password" name="password" id="password"
							placeholder="Password" class="form-control">
					</div>
					<div>
						<br> <input type="submit" name="submit"
							class="btn btn-info btn-md" value="submit"> <input
							type="hidden" value="login" name="action" />
					</div>

					<c:if test="${not empty messageRespone }">
						<div class="alert alert-${alert}" role="alert">${messageRespone}</div>
					</c:if>


				</form>
			</div>
		</div>
	</div>
</body>
</html>