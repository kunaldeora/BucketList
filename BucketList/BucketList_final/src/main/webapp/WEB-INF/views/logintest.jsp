<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<link href="resources/css/homePage.css" rel="stylesheet" type="text/css">
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1"> 
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>	
	<title>The Bucket List</title>
</head>
<body>

<div class="container-fluid">
	<div class="row">
	   <div class="col-md-8">
	   		<img src="resources/images/ad7.jpg" alt="banner" width="100%" height="auto" />
	   		<h1 class="tagline">The Bucket List</h1>
	   		<h5 class="subtagline">DON'T DREAM IT. LIVE IT. </h5>
	   </div>
	   
	   <div  class="middle col-md-4">
	   		<spring:form action="login.htm" id="loginForm" modelAttribute="person"  method="post" role="form">
			    <div class="form-group">
			      <label for="userAccount.email">Email:</label>
			      <spring:input class="form-control" path="userAccount.email" id="emailAdventurer"/>
			    </div>
			    <div class="form-group">
			      <label for="userAccount.password">Password:</label>
			      <spring:input type="password" class="form-control" path="userAccount.password" id="pwdAdventurer" required="required"/>
			    </div>
			    <button id="btnSubmit" type="submit" class="btn btn-danger">Log in</button>	    
  			</spring:form>
  			
  			<div id="divLogin">
  				<button type="button" id="btnLoginAdventurer" class="btn btn-primary" data-toggle="modal" data-target="#myModal">Sign up</button>
<!--   				<button type="button" id="btnLoginOrganizer" class="btn btn-primary" data-toggle="modal" data-target="#myModal1">Sign up as Organizer</button> -->
  			</div>
  			  			
<!--   			Modal adventurer -->
		  <div class="modal fade" id="myModal" role="dialog">
		    <div class="modal-dialog">
<!-- 		      Modal content -->
		      <div class="modal-content">
		        <div class="modal-header">
		          <button type="button" class="close" data-dismiss="modal">&times;</button>
		          <h4 class="modal-title">Sign Up Form</h4>
		        </div>
		        <div class="modal-body">
		          	<spring:form action="signup.htm" id="signup" modelAttribute="person" method="post" role="form">
					    <div class="form-group">
					      <label for="firstName">First Name:</label>
					      <spring:input type="text" class="form-control" path="firstName" id="firstName" required="required"/>
					    </div>
					    <div class="form-group">
					      <label for="lastName">Last Name:</label>
					      <spring:input type="text" class="form-control" path="LastName" id="lastName" required="required"/>
					    </div>
					    <div class="form-group">
					      <label for="myLocation">City:</label>
					      <input type="text" class="form-control" name="myLocation" id="myLocation" required="required"/>
					    </div>
					    <div class="form-group">
					      <label for="userAccount.email">Email:</label>
					      <spring:input type="email" class="form-control" path="userAccount.email" id="emailAdventurer1" required="required"/>
					    </div>
					    <div class="form-group">
					      <label for="userAccount.password">Password:</label>
					      <spring:input type="password" class="form-control" path="userAccount.password" id="pwdAdventurer1" required="required"/>
			    		</div>
			    		<div class="form-group">
					      <label for="userAccount.typeOfUser">Type of User</label>
					      <spring:radiobutton class="radio-inline" path="userAccount.typeOfUser"  name="typeOfUser" value="adventurer"/> Adventurer
					      <spring:radiobutton class="radio-inline" path="userAccount.typeOfUser"  name="typeOfUser" value="organizer"/> Organizer  
			    		</div>
			    		<button id="btnSubmit1" type="submit" class="btn btn-success">Sign up</button>	    
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
	</div>
</div>




</body>
</html>