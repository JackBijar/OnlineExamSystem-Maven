<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="description" content="">
		<meta name="author" content="">
		<title>Online Examination System</title>
		<!-- Bootstrap Core CSS -->
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<!-- Custom CSS -->
		<link href="css/sb-admin.css" rel="stylesheet">
		<!-- Custom Fonts -->
		<link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">
		<link rel="stylesheet" href="css/main.css">
		<link href="css/hover.css" rel="stylesheet">
		<!-- jQuery --> 
		<script src="js/jquery.js"></script>
		<!-- Bootstrap Core JavaScript --> 
		<script src="js/bootstrap.min.js"></script>
		<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script> -->
  		<script type="text/javascript" src="javascripts/applications.js"></script> 
  		<script type="text/javascript" src="javascripts/admin.js"></script>
  		<script type="text/javascript" src="javascripts/candidate.js"></script>
	</head>
	<body>
		<div id="wrapper"> 	  
			<!-- Navigation -->
			<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation"> 
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
					<a class="navbar-brand" href="index.html">Online Examination System</a> 
				</div>
				<!-- Top Menu Items -->
				<ul class="nav navbar-right top-nav">
					<li class="dropdown"> <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-envelope"></i> <b class="caret"></b></a>
						<ul class="dropdown-menu message-dropdown">
							<li class="message-preview"> 
								<a href="#">
									<div class="media"> <span class="pull-left"> <img class="media-object" src="http://placehold.it/50x50" alt=""> </span>
										<div class="media-body">
											<h5 class="media-heading"><strong>John Smith</strong> </h5>
											<p class="small text-muted"><i class="fa fa-clock-o"></i> Yesterday at 4:32 PM</p>
											<p>Lorem ipsum dolor sit amet, consectetur...</p>
										</div>
									</div>
								</a> 
							</li>
							<li class="message-footer"> <a href="#">Read All New Messages</a> </li>
						</ul>
					</li>
					<li class="dropdown"> <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i>${adminBean.adminName}<b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li> <a href="#"><i class="fa fa-fw fa-user"></i> Profile</a> </li>
							<li> <a href="#"><i class="fa fa-fw fa-envelope"></i> Inbox</a> </li>
							<li> <a href="#"><i class="fa fa-fw fa-gear"></i> Settings</a> </li>
							<li class="divider"></li>
							<li> <a href="adminLogout"><i class="fa fa-fw fa-power-off"></i>Log Out</a> </li>
						</ul>
					</li>
				</ul>
				<!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
				<div class="collapse navbar-collapse navbar-ex1-collapse">
					<ul class="nav navbar-nav side-nav">
						<li class="active"> <a href="activeNewAdmin"><i class="fa fa-fw fa-dashboard"></i>Active Admin A/c</a> </li>	
						
						<li> <a href="openMcqQuestionPage"><i class="fa fa-fw fa-bar-chart-o"></i>Add MCQ Question</a> </li>
						<li> <a href="showAllMcq"><i class="fa fa-fw fa-table"></i> Show MCQ Questions</a> </li>
						<!-- <li> <a href="#"><i class="fa fa-fw fa-desktop"></i> Update MCQ Question</a> </li>
						<li> <a href="#"><i class="fa fa-fw fa-wrench"></i>Delete MCQ Question</a> </li> -->
						
						<li> <a href="openDescQuestionPage"><i class="fa fa-fw fa-edit"></i> Add Descriptive Question</a> </li>
						<li> <a href="showAllDescQuestion"><i class="fa fa-fw fa-table"></i> Show Descriptive Questions</a> </li>
						<!-- <li> <a href="#"><i class="fa fa-fw fa-desktop"></i> Update Descriptive Question</a> </li>
						<li> <a href="#"><i class="fa fa-fw fa-wrench"></i>Delete Descriptive Question</a> </li> -->							
						
						<li> <a href="viewCandidateReport"><i class="fa fa-fw fa-dashboard"></i> View Candidate Report </a> </li>
						<li> <a href="fetchDescUncheckCandidate"><i class="fa fa-fw fa-dashboard"></i> Check Descriptive Results </a> </li>
						<li> <a href="addModelQuestionPage"><i class="fa fa-fw fa-edit"></i> Set Model Question </a> </li>
						<li> <a href="showModelQSet"><i class="fa fa-fw fa-table"></i> Show Model Question</a> </li>
						<li> <a href="openAddQCategoryPage"><i class="fa fa-fw fa-edit"></i> Add Question Categories</a> </li>
						<li> <a href="showQCategory"><i class="fa fa-fw fa-table"></i> Show Question Categories</a> </li>
					</ul>
				</div>
				<!-- /.navbar-collapse --> 
			</nav> 
	</body>
</html>
			