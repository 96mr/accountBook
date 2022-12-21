<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
<link
	href='https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/main.min.css'
	rel='stylesheet' />
<script
	src='https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/main.min.js'></script>
<script
	src='https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/locales-all.min.js'></script>

<title>가계부</title>
</head>
<body>
	<section class="text-center col-12 col-lg-10 h-75 mx-auto">
		<div id="list-type" class="btn-group btn-group-toggle m-2" data-toggle="buttons">
			<label class="btn btn-secondary" for="radio1"> 
				<input type="radio" class="btn-check" name="type" id="radio1" value="income" autocomplete="off" checked /> 수입
			</label> 
			<label class="btn btn-secondary" for="radio2"> 
				<input type="radio" class="btn-check" name="type" id="radio2" value="expend" autocomplete="off"/> 지출
			</label>
		</div>
		<div id="total" class="col-lg-9 mx-auto rounded p-2">
			<div class="row text-center p-2">
				<div class="col-sm-4">
					<h6>잔액</h6>
					<h5 id="totalAmount" class="text-muted"></h5>
				</div>
				<div class="col-sm-4">
					<h6>수입</h6>
					<h5 id="incomeAmount" class="text-success"></h5>
				</div>
				<div class="col-sm-4">
					<h6>지출</h6>
					<h5 id="expendAmount" class="text-danger"></h5>
				</div>
			</div>
		</div>
		<div id="calendar" class="col-lg-9 mx-auto border rounded p-2">
		</div>
	</section>
    <script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/calendar.js"></script>
</body>
</html>
