<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link href="resources/css/adventurePage.css" rel="stylesheet"
	type="text/css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="resources/js/self/adventurerScript.js"
	type="text/javascript"></script>

<title>Adventurer page</title>

</head>
<body>
	<!-- navbar starts -->
	<div class="container-fluid">
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#myNavbar">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">The Bucket List</a>
				</div>
				<div class="collapse navbar-collapse" id="myNavbar">
					<ul class="nav navbar-nav">
						<li class="active"><a href="#">Home</a></li>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li><a href="#"><span class="glyphicon glyphicon-user"></span>Hi,
								${adventurer.firstName}</a></li>
						<li><a href="logout.htm"><span
								class="glyphicon glyphicon-log-in"></span>Logout</a></li>
					</ul>
				</div>
			</div>
		</nav>
		<!-- navbar ends -->
		<div class="row">
			<!-- first div start -->
			<div class="col-md-3">

<!-- 				<ul class="nav nav-pills nav-stacked"> -->
<!-- 					<li class="active"><a href="#">Home</a></li> -->
<!-- 					<li><a href="#" data-toggle="modal" data-target="#myModal">Add -->
<!-- 							Adventure</a></li> -->
<!-- 					<li><button id="showBucketList" class="btn btn-primary">My Bucket List</button></li> -->
<!-- 					<li><a href="#">Manage Bucket List</a></li> -->
<!-- 				</ul> -->

					<div class="list-group">
						  <button type="button" class="list-group-item active">Home</button>
						  <button type="button" class="list-group-item" data-toggle="modal" data-target="#myModal">Add Adventure</button>
						  <button type="button" class="list-group-item" id="showBucketList">My Bucket List</button>
						  <button type="button" class="list-group-item" id="viewBucketList">View Bucket List</button>
					</div>

				<!-- 			 <button type="button" id="btnBucketList" class="btn btn-primary">My BucketList</button> -->
				<!-- 			 <button type="button" id="btnUpdateBucketList" class="btn btn-primary">Manage BucketList</button> -->
				<!-- 			 <button type="button" id="btnCreateAdventure" class="btn btn-primary" data-toggle="modal" data-target="#myModal">Add Adventure</button> -->

				<!-- modal starts -->

				<div class="modal fade" id="myModal" role="dialog">
					<div class="modal-dialog">
						<!-- 		      Modal content -->
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">&times;</button>
								<h4 class="modal-title">Create Adventure</h4>
							</div>
							<div class="modal-body">
								<spring:form action="advMainPage.htm"
									modelAttribute="adventures" method="post" role="form">

									<div class="form-group" id="idDivAdventureName">
										<label for="adventureName">Adventure Name</label>
										<spring:input type="text" class="form-control"
											id="idadventureName" path="adventureName" />
										<label id="errAdventureName"></label>
									</div>
									
									 <div class="form-group" id="iddivdropdown">
											<label for="adventureName"> Adventure Name</label>
											<spring:select class="form-control" path="adventureName">
											  <c:forEach var="adv" items="${adventureList}">
											   <spring:option value="${adv}"></spring:option>
											  </c:forEach>
											</spring:select>
										
									 </div>

									<!-- 			            <a href="#" id="idShowhiddenDiv">Add existing adventures</a> -->

									<!-- 			            <div class="form-group" id="iddivdropdown"> -->
									<!-- 					      <label for="adventureName">Adventure Name</label> -->
									<%-- 					      <spring:select class="form-control" path="adventureName" items="${adventureList}"/> --%>
									<!-- 					      <label id="errAdventureName"></label> -->
									<!-- 			            </div> -->


									<div class="form-group">
										<label for="">Type of Category</label>
										<spring:radiobutton class="radio-inline"
											path="typeOfAdventure" name="typeOfAdventure" value="sports" />
										Sports
										<spring:radiobutton class="radio-inline"
											path="typeOfAdventure" name="typeOfAdventure" value="events" />
										Events
										<spring:radiobutton class="radio-inline"
											path="typeOfAdventure" name="typeOfAdventure"
											value="adventures" />
										Adventures
									</div>


									<spring:hidden path="postedBy"
										value="${adventurer.userAccount.email}" />


									<button id="btnSubmit" type="submit" class="btn btn-primary">Add
										Adventure</button>

								</spring:form>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-danger"
									data-dismiss="modal">Close</button>
							</div>
						</div>

					</div>
				</div>
				<!-- 		  end of modal -->

			</div>
			<!-- first div end -->
			<!-- second div start -->
			<div class="col-md-6" id="mybucketList">
			
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Adventure Name</th>
							<th>Adventure Type</th>
							<th>Adventure Completed</th>
							<th>Adventure Deleted</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="adventure" items="${adventureListBucket}" varStatus="i">
							<tr>
								<td>${adventure.adventureName}</td>
								<td>${adventure.typeOfAdventure}</td>
								<td>
								
									<button value="${adventurer.personId}_${adventure.adventureID}" type="button"
										 data-toggle="modal" data-target="#myModalBucketList"  name="btnCompleted${i.count}" class="btn btn-primary">Done</button>
								</td>
								<td>
									<button value="${adventurer.personId}_${adventure.adventureID}" type="button"
										 name="btnDeleted${i.count}" class="btn btn-primary">Delete</button>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				
				<!-- modal bucket list started -->
				
				<div class="modal fade" id="myModalBucketList" role="dialog">
					<div class="modal-dialog">
						<!-- 		      Modal content -->
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">&times;</button>
								<h4 class="modal-title">Complete Adventure</h4>
							</div>
							<div class="modal-body">
								
								<form id="" method="post">
									<div class="form-group">
										<label>Best Time</label>
										<input type="text" name="besttime" class="form-control" required/>
									</div>
									
									<div class="form-group">
										<label>Date Completed</label>
										<input type="text" name="datecompleted" class="form-control" required/>
									</div>
									
									<div class="form-group">
										<label>Expected Expense</label>
										<input type="number" name="expectedexpense" class="form-control" required/>
									</div>
									
									<div class="form-group">
										<label>Feedback</label>
										<input type="text" name="feedback" class="form-control" required/>
									</div>
									
									<div class="form-group">
										<label>Rating of your experience</label>
										<input type="number" name="rating" class="form-control" required/>
									</div>
									
									<div class="form-group">
										<label>Status</label>
										<input type="text" name="status" value="Y" class="form-control" disabled/>
									</div>
									
									<input type="hidden" name="adVal" />
									<input type="hidden" name="adValButton" />
									<input id="completeBucketList" type="button" onclick="submitBucketForm();" class="btn btn-success"  value="Store Experience" />
									
								</form>
								
								
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-danger"
									data-dismiss="modal">Close</button>
							</div>
						</div>

					</div>
				</div>
				
				<!-- bucket list modal end -->
				
			<div id="viewCompletedBucketList1">
				
				<table class="table table-striped">
					<thead>
						<tr>
							
							<th>Adventure Best Time</th>
							<th>Date Completed</th>
							<th>Expected Expense</th>
							<th>Feedback</th>
							<th>Rating</th>
							<th>Status</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="bucketlist" items="${listBucketList}" varStatus= "i">
							<tr>
								<td>${bucketlist.bestTime}</td>
								<td>${bucketlist.dateCompleted}</td>
								<td>${bucketlist.expense}</td>
								<td>${bucketlist.feedback}</td>
								<td>${bucketlist.rating}</td>		
								<td>Y</td>
							</tr>
						</c:forEach>
					
					
<%-- 						<c:forEach var="adventure" items="${adventureListBucket}" varStatus="i"> --%>
<!-- 							<tr> -->
<%-- 								<td>${adventure.adventureName}</td> --%>
<%-- 								<td>${adventure.typeOfAdventure}</td> --%>
<!-- 								<td> -->
								
<%-- 									<button value="${adventurer.personId}_${adventure.adventureID}" type="button" --%>
<%-- 										 data-toggle="modal" data-target="#myModalBucketList"  name="btnCompleted${i.count}" class="btn btn-primary">Done</button> --%>
<!-- 								</td> -->
<!-- 								<td> -->
<%-- 									<button value="${adventurer.personId}_${adventure.adventureID}" type="button" --%>
<%-- 										 name="btnDeleted${i.count}" class="btn btn-primary">Delete</button> --%>
<!-- 								</td> -->
<!-- 							</tr> -->
<%-- 						</c:forEach> --%>
					</tbody>
				</table>
						
				
			
			</div>	
				
				



			</div>
			<!-- second div ends -->

			<!-- third div start -->
			<div class="col-md-3">
			
			<div>
                        <div class="thumbnail">
                            <img src="http://placehold.it/320x150" alt="">
                            <div class="caption">
                                <h4 class="pull-right">$24.99</h4>
                                <h4><a href="#">First Product</a>
                                </h4>
                                <p>See more snippets like this online store item at <a target="_blank" href="http://www.bootsnipp.com">Bootsnipp - http://bootsnipp.com</a>.</p>
                            </div>
                            <div class="ratings">
                                <p class="pull-right">15 reviews</p>
                                <p>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                </p>
                            </div>
                        </div>
               </div>
			
			
			</div>
			<!-- third div ends -->


		</div>


	</div>
	<!--end of fluid -->

</body>
</html>