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
    <h1>Bootstrap Tutorial</h1>      
    <p>Bootstrap is the most popular HTML, CSS, and JS framework for developing responsive, mobile-first projects on the web.</p>
  </div>
  <p>This is some text.</p>      
  <p>This is another text.</p>      
</div>

	
	<div class="container">
		<div class="row">
		<h1>Point Add Page</h1>
		
		<form action="./pointAdd" method="post">
    <div class="form-group">
      <label for="Name">Name:</label>
      <input type="text" class="form-control" id="name" placeholder="Enter Name" name="name">
    </div>

    <div class="form-group">
      <label for="Num">Num:</label>
      <input type="text" class="form-control" id="num" placeholder="Enter Num" name="num">
    </div> 
       
    <div class="form-group">
      <label for="Kor">Kor:</label>
      <input type="text" class="form-control" id="kor" placeholder="Enter Kor" name="kor">
    </div>  
    
    <div class="form-group">
      <label for="Num">Eng:</label>
      <input type="text" class="form-control" id="eng" placeholder="Enter Eng" name="eng">
    </div>  
    
    <div class="form-group">
      <label for="Math">Math:</label>
      <input type="text" class="form-control" id="math" placeholder="Enter Math" name="math">
    </div>          
   
   
    <button type="submit" class="btn btn-default">Add</button>
    
    
    
  </form>
		</div>
	</div>

