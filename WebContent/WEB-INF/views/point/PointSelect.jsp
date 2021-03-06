<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     
<c:import url="../template/boot.jsp"></c:import>     
<c:import url="../template/header.jsp"></c:import>

<script language="JavaScript">

function deleteCheck(){ 
	if (confirm("삭제 하시겠습니까?")){ 
		var num = document.getElementById("num").value;
		//var 변수명 = document.getElementById("아이디").value;
		location.href='./pointDelete?num='+num;
	}else{ 
		alert("삭제 취소 되었습니다."); 
		return; 
	} 
} 

</script>


<div class="container">
		<div class="row">
			<h1>Board Select</h1>
			<table class="table table-hover">
				<tr>
					<td>name</td>
					<td>num</td>
					<td>kor</td>
					<td>eng</td>
					<td>math</td>
					<td>total</td>
					<td>avg</td>
				</tr>
				
					<tr>
						<td>${dto.name}</td>	<!-- 파라미터이름,컬럼명,변수명 을 같게 -->
						<td>${dto.num}</td>
						<td>${dto.kor}</td>
						<td>${dto.eng}</td>
						<td>${dto.math}</td>
						<td>${dto.total}</td>
						<td>${dto.avg}</td>
					</tr>
			</table>
					
			 <c:if test="${member.id eq 'admin'}">
			<a href="./pointMod?num=${dto.num}" class="btn btn-primary">Update</a>
			<a href="javascript:deleteCheck();" class="btn btn-danger">Delete</a>
			</c:if> 
			<input type="hidden" id="num" value="${dto.num}">
		</div>
	</div>
	
