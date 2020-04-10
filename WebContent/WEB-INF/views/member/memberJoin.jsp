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
    <h1>Member Join</h1>      
    <p>Bootstrap is the most popular HTML, CSS, and JS framework for developing responsive, mobile-first projects on the web.</p>
  </div>
  
</div>
	
	<div class="container">
		<div class="row">
			<h1>Member Join</h1>
			<form action="./memberJoin" method="post">
			
	<div class="form-group">
      <label for="Id">ID:</label>
      <input type="text" class="form-control" id="id" placeholder="Enter Id" name="id">
    </div>

    <div class="form-group">
      <label for="Pw">PW:</label>
      <input type="password" class="form-control" id="pw" placeholder="Enter PassWord" name="pw">
    </div> 
       
    <div class="form-group">
      <label for="Name">Name:</label>
      <input type="text" class="form-control" id="name" placeholder="Enter Name" name="name">
    </div>  
    
    <div class="form-group">
      <label for="Age">Age:</label>
      <input type="text" class="form-control" id="age" placeholder="Enter Age" name="age">
    </div>  
    
    <div class="form-group">
      <label for="Phone">Phone:</label>
      <input type="text" class="form-control" id="phone" placeholder="Enter Phone" name="phone">
    </div>          
   
     <div class="form-group">
      <label for="Email">Email:</label>
      <input type="text" class="form-control" id="email" placeholder="Enter Email" name="email">
    </div>  
      
    <button type="submit" class="btn btn-default">Add</button><br><br>
    
			
			</form>
			
		</div>
	</div>
