<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="true"%>
<html>
<body>
	<section class="text-center col-12 col-lg-10 h-75 mx-auto">
		<div class="btn-group btn-group-toggle m-2" data-toggle="buttons">
			<label class="btn btn-secondary" for="radio1"> 
				<input type="radio" class="btn-check" name="type" id="radio1" value="income" autocomplete="off" checked /> 수입
			</label> 
			<label class="btn btn-secondary" for="radio2"> 
				<input type="radio" class="btn-check" name="type" id="radio2" value="expend" /> 지출
			</label>
		</div>
		<div>
			<label> 
				<input type="month" id="currentMonth"/>
			</label>
		</div>
		<div id="total" class="col-lg-10 mx-auto rounded p-2">
			<div class="row text-center p-2">
				<div class="col-sm-4"><h6>잔액</h6><h5 id="totalAmount" class="text-muted"></h5></div>
				<div class="col-sm-4"><h6>수입</h6><h5 id="incomeAmount" class="text-success"></h5></div>
				<div class="col-sm-4"><h6>지출</h6><h5 id="expendAmount" class="text-danger"></h5></div>
			</div>
		</div>
		<div class="col-lg-10 mx-auto border rounded p-2">
			<div id="chart" class="col-lg-12"></div>
			<div id="table" class="col-lg-12">
				<table class="table table-sm text-center">
					<thead>
						<tr>
							<th scope="col">번호</th>
							<th scope="col">날짜</th>
							<th scope="col">내역</th>
							<th scope="col">금액</th>
						</tr>
					</thead>
					<tbody id="chartList">
					</tbody>
				</table>
			</div>
		</div>
	</section>
	<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/chart.js"></script>
</body>
</html>
