<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
	<header class="text-center h-20 mx-auto p-3">
		<nav class="navbar navbar-expand navbar-light text-center">
	    	<ul class="navbar-nav mx-auto text-center row">
	        	<li class="nav-item active">
	                <a class="nav-link" href="${pageContext.request.contextPath }/account/calendar"><i class="fas fa-calendar-day fa-2x"></i></a>
	            </li>
	            <li class="nav-item active">
	          		<a class="nav-link" href="${pageContext.request.contextPath }/account/chart"><i class="fas fa-chart-pie fa-2x"></i></a>
	            </li>
			    <li class="nav-item mr-2 ml-2">
			    	<span class="m-2">
			   		 	<img src="${pageContext.request.contextPath }/resources/images/ccoin.png" style="width:50px" class="rounded-circle" alt="가계부">
			   	 	</span>
			    </li>
	        	<li class="nav-item active">
	            	<a class="nav-link" href="${pageContext.request.contextPath }/account/add"><i class="fas fa-plus fa-2x"></i></a>
	            </li>
	            <c:choose>
		            <c:when test="${sessionID ne null }">
		            	<li class="nav-item active">
		               		<a class="nav-link" href="${pageContext.request.contextPath }/logout"><i class="fas fa-sign-out-alt fa-2x"></i></a>
		            	</li>
		            </c:when>
	            </c:choose>
	        </ul>
		</nav>
	</header>