<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Online Examination System</title>
		<link rel="stylesheet" href="css/main.css"></link>
		<link href="css/bootstrap.min.css" rel="stylesheet"></link>
		<link href="css/hover.css" rel="stylesheet"></link>
		<link href="" rel="stylesheet"></link>
		<link href="css/font-awesome.min.css" rel="stylesheet"></link>
		<script src="js/jquery.js"></script>
		<script src="js/bootstrap.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  		<script type="text/javascript" src="javascripts/applications.js"></script> 
  		<script type="text/javascript" src="javascripts/admin.js"></script>
  		<script type="text/javascript" src="javascripts/candidate.js"></script>
  		<!-- <script type="text/javascript" src="javascripts/timer.js"></script> -->
	</head>
	</head>
	<body>
		<div class="container">
			<div class="full-area"> 		
				<div class="row"> 
					<div class="col-md-12">
						<div class="text-center"><img src="images/online-test-exm.png" class="hvr-bob" /></div>
					</div>			  
					<div class="row">
						<div class="col-md-2"> </div>
						<div class="col-md-8">
							<div class="back-color" id="updateStatus">
								<c:set var="count" value="0" scope="page" />
								<ol>
									<div class="form-signin mg-btm">
										<h3 class="heading-desc">Candidate Profile :</h3>										
										<div class="Contain-area">
											<div class="main">
												<label>Candidate Id : ${candidateBean.cId}</label><br>
												<label>Name : ${candidateBean.cName}</label><br>
												<label>Mobile No : ${candidateBean.cMobile}</label><br>
												<label>Email Id : ${candidateBean.cEmail}</label><br>
												<label>Date of birth : ${candidateBean.cDob}</label><br>
												<label>Highest Qualification :  ${candidateBean.cQualification}</label><br>
												<label>Candidate Skill : ${candidateBean.tempCSkill}</label><br>										
											</div>
										<span class="clearfix"></span>
										<div class="modal-footer">
											<a href="candidateHomePage"><button type="button" class="btn btn-default" data-dismiss="modal">Close<i class="fa fa-times" aria-hidden="true"></i> </button></a>
											<button type="button" class="btn btn-default" data-dismiss="modal" id="btGetData" onclick="updateCandidate();"> Update <i class="fa fa-arrow-right" aria-hidden="true"></i></button>											
										</div>
									</div>
								</ol>
							</div>
							<div class="col-md-2"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>