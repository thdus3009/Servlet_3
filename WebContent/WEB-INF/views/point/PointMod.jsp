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
	<h1>Point Update Page</h1>
	
	<form action="./pointMod" method="post">
    <div class="form-group">
      <label for="Name">Name:</label>
      <input type="text" value="${dto.name}" class="form-control" id="name" placeholder="Enter Name" name="name">
    </div>

    <div class="form-group">
      <label for="Num">Num:</label>
      <input type="text" value="${dto.num}" readonly="readonly" class="form-control" id="num" placeholder="Enter Num" name="num">
    </div> 
       
    <div class="form-group">
      <label for="Kor">Kor:</label>
      <input type="text" value="${dto.kor}" class="form-control" id="kor" placeholder="Enter Kor" name="kor">
    </div>  
    
    <div class="form-group">
      <label for="Num">Eng:</label>
      <input type="text" value="${dto.eng}" class="form-control" id="eng" placeholder="Enter Eng" name="eng">
    </div>  
    
    <div class="form-group">
      <label for="Math">Math:</label>
      <input type="text" value="${dto.math}" class="form-control" id="math" placeholder="Enter Math" name="math">
    </div>          
   
    <button type="submit" class="btn btn-default">Update</button>
    
  </form>

	</div>
	</div>
	
