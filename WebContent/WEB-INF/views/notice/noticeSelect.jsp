<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
<c:import url="../template/boot.jsp"></c:import>
<c:import url="../template/header.jsp"></c:import>

<div class="container">
		<div class="row">
			<h1>Notice Select</h1>
			<table class="table table-hover">
				<tr>
					<td>SUBJECT</td>
					<td>ID</td>
					<td>DATE</td>
					<td>HIT</td>
				</tr>
				
					<tr>
						<td>${dto.subject}</td>	<!-- 파라미터이름,컬럼명,변수명 을 같게 -->
						<td>${dto.id}</td>
						<td>${dto.day}</td>
						<td>${dto.hit}</td>
					</tr>
			</table>
					<div class="well" >${dto.text}</div>
			
			<c:if test="${member.id eq 'admin'}">
			<a href="./boardDelete?num=${dto.num}" class="btn btn-danger">글삭제</a>
			<a href="./boardMod?num=${dto.num}&subject=${dto.subject}&text=${dto.text}" class="btn btn-danger">글수정</a>
			</c:if>
		</div>
	</div>