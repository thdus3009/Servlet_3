<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
<c:import url="../template/boot.jsp"></c:import>
<c:import url="../template/header.jsp"></c:import>
	
	
	<!-- Nav -->	
<br>
<div class="container">
  <div class="jumbotron">
    <h1>Notice</h1>      
    <p>Bootstrap is the most popular HTML, CSS, and JS framework for developing responsive, mobile-first projects on the web.</p>
  </div>
   
</div><br>
	
	
	
<div class="container">
	<div class="row">
	<h1>Notice Page</h1><br>
		<table class="table table-hover">
			<tr>
				<td>NO.</td>
				<td>SUBJECT</td>
				<td>NAME</td>
				<td>DATE</td>
				<td>HIT</td>
			</tr>
			
			<c:forEach items="${list}" var="dto">
					<tr>
						<td>${dto.num}</td>
						<td><a href="./noticeSelect?num=${dto.num}&id=${dto.id}">${dto.subject}</a></td>	<!-- 파라미터이름,컬럼명,변수명 을 같게 -->
						<td>${dto.id}</td>
						<td>${dto.day}</td>
						<td>${dto.hit}</td>
					</tr>
				</c:forEach>

		</table>
		
		<c:if test="${member.id eq 'admin'}">
		<a href="./noticeAdd" class="btn btn-primary">글쓰기</a>
		</c:if>
	</div>
</div>