<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1"> 
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<title>Organizer page</title>
</head>
<body>


	
	<div class="container-fluid">
	
	<!-- navbar starts -->
	<div class="container-fluid">
	<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span> 
      </button>
      <a class="navbar-brand" href="#">The Bucket List</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Home</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon glyphicon-user"></span> Hi,  ${organizer.firstName}</a></li>
        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span>Logout</a></li>
      </ul>
    </div>
  </div>
</nav>
<!-- navbar ends -->
	
	
		<div class="row">
		<!-- first div start -->
			<div class="col-md-3">
				
			   <button type="button" id="btnCreateAdvertisement" class="btn btn-primary" data-toggle="modal" data-target="#myModal">Create Advertisement</button>
			   
			
	<!-- modal starts -->
			
		<div class="modal fade" id="myModal" role="dialog">
		    <div class="modal-dialog">
<!-- 		      Modal content -->
		      <div class="modal-content">
		        <div class="modal-header">
		          <button type="button" class="close" data-dismiss="modal">&times;</button>
		          <h4 class="modal-title">Create Advertisement</h4>
		        </div>
		        <div class="modal-body">
		          	<spring:form  action="orgMainPage.htm" modelAttribute="advertisement" method="post" role="form">
		          		
		          		<div class="form-group">
					      <label for="description">Advertisement Title</label>
					      <spring:input type="text" class="form-control" path="description"/>
			            </div>
			            <div class="form-group">
					      <label for="message">Advertisement message</label>
					      <spring:input type="text" class="form-control" path="message"/>
			            </div>
			         
			            <div class="form-group">:
					      <label for="dateofEvent">Advertisement DateTime</label>
					      <spring:input type="text" class="form-control" path="dateofEvent"/>
			            </div>
			            
			            <div class="form-group">:
					      <label for="adventures">Adventure List</label>
					      <spring:select class="form-control" path="adventures.adventureName" items="${adventureList}"/>
			            </div>
			            
<!-- 			            <div class="form-group">: -->
<!-- 					      <label for="">Upload Photo</label> -->
<%-- 					      <spring:input type="file" path="photo"/> --%>
<!-- 			            </div> -->

					    <spring:hidden path="postedBy" value="${organizer.userAccount.email}"/>
						
						
						<button id="btnSubmit" type="submit" class="btn btn-primary">Create Advertisement </button> 

  					</spring:form>
		        </div>
			        <div class="modal-footer">
			          <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
			        </div>
		      </div>
		      
		    </div>
		  </div>
<!-- 		  end of modal -->
	
			</div>
		<!-- first div end -->	
		<!-- second div start -->
			<div class="col-md-6">
			
			</div>
		<!-- second div ends -->
		
		<!-- third div start -->
			<div class="col-md-3">
				
				
			</div>
		<!-- third div ends -->
		
		
		</div>
	
	
	</div>
<!--end of fluid -->


</body>
</html>