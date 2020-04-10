<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     
<c:import url="../template/boot.jsp"></c:import>     
<c:import url="../template/header.jsp"></c:import>


  <!-- Nav -->
<div class="container">
  <h3>Right Aligned Navbar</h3>
  <p>The .navbar-right class is used to right-align navigation bar buttons.</p>
</div>

	
	<div class="container">
	<div class="row">
	<h1>Point Select Page</h1><br>
		<table class="table table-hover">
			<tr>
				<td>번호</td>
				<td>이름</td>
				<td>국어</td>
				<td>영어</td>
				<td>수학</td>
				<td>총점</td>
				<td>평균</td>
			</tr>
			
			<tr>
				<td>${dto.num}</td>
				<td>${dto.name}</td>
				<td>${dto.kor}</td>
				<td>${dto.eng}</td>
				<td>${dto.math}</td>
				<td>${dto.total}</td>
				<td>${dto.avg}</td>		
			</tr>			
			

		</table>
		<a href="./pointMod?num=${dto.num}" class="btn btn-primary">Update</a>
		<a href="./pointDelete?num=${dto.num}" class="btn btn-danger">Delete</a>
	</div>
</div>
	
