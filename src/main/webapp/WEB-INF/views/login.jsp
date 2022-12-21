<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"	crossorigin="anonymous"></script>
	<script	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"	crossorigin="anonymous"></script>
	<script	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
	<title>로그인</title>
</head>
<body>
	<c:if test ="${not empty msg}">
		<script>
			alert('<c:out value="${msg}"/>');
		</script>
	</c:if>
	<div class="container mx-auto" style="height: 100vh">
		<section class="text-center col-12 col-lg-10 h-50 mx-auto p-4">
			<div class="col-lg-6 mx-auto border rounded p-4 bg-light">
				<h3 class="pb-4">로그인</h3>
				<form method="post">
					<input type="text" name="id" class="form-control p-4" autocomplete="off" placeholder="아이디를 입력하세요"><br>
					<input type="password" name="password" class="form-control p-4" placeholder="비밀번호를 입력하세요"><br>
					<button type="submit" name="button" class="btn btn-outline-dark btn-block">로그인</button>
				</form>
				<a href="${pageContext.request.contextPath}/register">회원이 아니신가요?</a>
			</div>
		</section>
	</div>
</body>
</html>
