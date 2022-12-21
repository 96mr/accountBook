<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="true" %>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>가계부 작성</title>
</head>
<body>	
	<section class="text-center col-12 col-lg-10 h-75 mx-auto">
		<div class="col-lg-6 mx-auto border rounded p-4 bg-light">
			<form:form modelAttribute="info" method="post">
				<div class="form-control">
					<div class="form-check form-check-inline mr-2">
						<input type="radio" class="form-check-input" name="type" id="radio1" value="expend" checked="checked"/>
						<label class="form-check-label" for="radio1">지출</label>
					</div>
					<div class="form-check form-check-inline ml-2">
						<input type="radio" class="form-check-input" name="type" id="radio2" value="income"/>
						<label class="form-check-label" for="radio2">수입</label>
					</div>
				</div>
				<br>
				<div class="form-control">
					<div class="form-check form-check-inline mr-2">
						<input type="radio" class="form-check-input" name="p_no" id="radio3" value="1" checked="checked"/>
						<label class="form-check-label" for="radio3">현금</label>
					</div>
					<div class="form-check form-check-inline ml-2">
						<input type="radio" class="form-check-input" name="p_no" id="radio4" value="2"/>
						<label class="form-check-label" for="radio4">카드</label>
					</div>
				</div><br>
				<input type="date" class="form-control" id="regdate" name="regdate" /><br>
				<select class="form-select form-control" id="category" name="c_no">
					<c:forEach var="list" items="${category}" begin="0" end="10"> 
						<option value="${list.no}"><c:out value="${list.name}"/></option> 
					</c:forEach>
				</select><br>
				<div class="input-group">
				  <form:input type="number" class="form-control" path="amount" name="amount" autocomplete="off" placeholder="금액을 입력해주세요"/>
				  <span class="input-group-text">원</span>
				  <form:errors path="amount"/>
				</div><br>
				<button type="submit" class="btn btn-outline-dark btn-block">등록</button>
			</form:form>
		</div>
	</section>
	<script>
	document.querySelector("#regdate").value= new Date(+new Date() + 3240 * 10000).toISOString().split('T')[0];
	const radios = document.querySelectorAll('input[name=type]');
	radios.forEach((e)=>{
		e.addEventListener('change', (e)=>setCategory(e.target.value));
	});	
	function setCategory(type){
		var cate_select = document.querySelector('#category');
		var pre_ops = cate_select.getElementsByTagName('option');
		var len = pre_ops.length;
		for(var i = 0 ; i < len; i++){
			pre_ops[0].remove();
		}
		if(type == 'expend'){
			<c:forEach var='list' items='${category}' begin='0' end='10'> 
				var op = document.createElement("option"); 
				op.value = <c:out value='${list.no}'/>;
				op.innerText = "<c:out value='${list.name}'/>";
			 	cate_select.appendChild(op);
			</c:forEach>
		}else{
			<c:forEach var='list' items='${category}' begin='11'> 
				var op = document.createElement("option"); 
				op.value = <c:out value='${list.no}'/>;
				op.innerText = "<c:out value='${list.name}'/>";
				cate_select.appendChild(op);
			</c:forEach>
		}
	}
	</script>
</body>
</html>
