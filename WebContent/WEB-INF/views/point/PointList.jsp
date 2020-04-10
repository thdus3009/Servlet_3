<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
<c:import url="../template/boot.jsp"></c:import>
<c:import url="../template/header.jsp"></c:import>
	
  
<div class="container">
  <h3>Right Aligned Navbar</h3>
  <p>The .navbar-right class is used to right-align navigation bar buttons.</p>
</div>

<!-- Nav -->	
<div class="container">
  <div class="jumbotron">
    <h1>Point</h1>      
    <p>Bootstrap is the most popular HTML, CSS, and JS framework for developing responsive, mobile-first projects on the web.</p>
  </div>
  <p>This is some text.</p>      
  <p>This is another text.</p>      
</div><br>

	
	
<!-- jsp출력(EL사용) name은 key값이다. -->
<div class="container">
	<div class="row">
	<h1>Point List Page</h1><br>
		<table class="table table-hover">
			<tr>
				<td>번호</td>
				<td>이름</td>
				<td>평균</td>
			</tr>
			
			<c:forEach items="${list}" var="dto"><!-- list에서 꺼내 dto에 닮기 ,list만 써도 된다.-->
				<tr>
					<td>${dto.num}</td>
					<td><a href="./pointSelect?num=${dto.num}">${dto.name}</a></td><!--a태그걸기 , 주소는 현재 페이지 기준으로 작성-, PointController에서 좀더 자세한 주소로 이동시켜줌--->
					<td>${dto.avg}</td><!-- 상세정보는 select에서 -->
				</tr>			
			</c:forEach>

		</table>
		
		<a href="./pointAdd" class="btn btn-primary">Point Add</a>
		
	</div>
</div>

