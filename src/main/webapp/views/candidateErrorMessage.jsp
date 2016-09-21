<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>Online Examination System</title>
	<link rel="stylesheet" href="css/main.css"></link>
	<link href="css/bootstrap.css" rel="stylesheet"></link>
	<link href="css/hover.css" rel="stylesheet"></link>
	<link href="css/font-awesome.css" rel="stylesheet"></link>
	<script src="js/jquery.js"></script>
	<script src="js/bootstrap.js"></script>
	<script src="js/bootstrap.min.js"></script>	
	<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script> -->
	<script type="text/javascript" src="javascripts/applications.js"></script> 
	<script type="text/javascript" src="javascripts/admin.js"></script>
	<script type="text/javascript" src="javascripts/candidate.js"></script>	
	</head>
	<body>
		<div class="container">
			<div class="full-area">
				<div class="row">
					<div class="col-md-12">
						<p style="color:#fff;"><img src="images/welcome.png" /> ${candidateBean.cName}</p>
						<span style="color:red;">${mcqExamMessage}</span>
						<span style="color:red;">${descExamMessage}</span>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12 txt-oes uppercase "> Select Examination Type </div>
					<HR WIDTH=25% ALIGN=CENTER>
				</div>
				<div class="row">
					<div class="col-sm-12 col-md-2 col-xs-12"> </div>
					<div class="col-sm-12 col-md-8 col-xs-12">
						<div class="col-sm-3 col-md-3 col-xs-12 logo-area">
							<div class="hvr-bob"> <img src="images/mcq.png" /></div>
								<div class="line-effect"><a href="mcqExamQuestion">MCQ<br /> Examination </a></div>
						</div>
						<div class="col-sm-3 col-md-3 col-xs-12 logo-area">
							<div class="hvr-bob"> <img src="images/descriptive-logo.png" /></div>
							<div class="line-effect"> <a href="descriptiveExamination"> Descriptive <br />Examination </a></div>
						</div>
						<div class="col-sm-3 col-md-3 col-xs-12 logo-area">
							<div class="hvr-bob"> <img src="images/descriptive-logo.png" /></div>
							<div class="line-effect"> <a href="checkMcqResultReport"> Check MCQ <br /> Result </a></div>
						</div>
                        <div class="col-sm-3 col-md-3 col-xs-12 logo-area">
							<div class="hvr-bob"> <img src="images/descriptive-logo.png" /></div>
							<div class="line-effect"> <a href="candidateProfile"> Candidate <br /> Profile </a></div>
						</div>
					</div>
					<div class="col-sm-12 col-md-2 col-xs-12"> </div>
				</div>
			</div>
			<div align="right"><a href="cLogout" ><b>Logout</b></a></div>
		</div>
		<!-- <div id="generateMcq" align="left">	/div>		
		<div id="generateDescQuestion" align="left"></div> -->
	</body>
</html>
