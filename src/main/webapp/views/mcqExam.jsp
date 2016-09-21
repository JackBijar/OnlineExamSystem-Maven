<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
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
  		<script type="text/javascript" src="javascripts/timer.js"></script>
	</head>
	<body onload="setTimer()">
		<div class="container">
			<div class="full-area"> 		
				<div class="row"> 
					<!--<div class="col-md-12">
						<div class="text-center"><img src="images/online-test-exm.png" class="hvr-bob" /></div>
					</div>-->			  
					<div class="row">
						<div class="col-md-2"> </div>
						<div class="col-md-8">
							<div class="back-color" id="mcqFinalResult">
								<c:set var="count" value="0" scope="page" />
								<ol>
									<form class="form-signin mg-btm" id='formMcqResult' name='formMcqResult'>
										<h3 class="heading-desc">Online MCQ Test :</h3>	<div id="showTime"></div>
										<div id="startTime"></div>									
										<div class="Contain-area">
											<div class="main">
												<c:forEach items="${mcqBeanList}" var="mcqBean">				
													<c:set var="count" value="${count + 1}" scope="page"/>
													<label><li> ${mcqBean.mcqQuestion} </li></label>
													<div class="qaBlock" id="${mcqBean.mcqId}">
														<div class="radio">
															<label><input type="radio" name="${count}" id="${count}" value="1" /> ${mcqBean.mcqAns1}</label>															
														</div>
														<div class="radio">
															<label><input type="radio" name="${count}" id="${count}" value="2" /> ${mcqBean.mcqAns2}</label>
														</div>
														<div class="radio">
														  <label><input type="radio" name="${count}" id="${count}" value="3" /> ${mcqBean.mcqAns3}</label>
														</div>
														<div class="radio">
														  <label><input type="radio" name="${count}" id="${count}" value="4" /> ${mcqBean.mcqAns4}</label>
														</div>
													</div>	
												</c:forEach>
												<div class="form-group"> </div>
											</div>
										</div>
										<span class="clearfix"></span>
										<div class="modal-footer">
											<button type="button" class="btn btn-default" data-dismiss="modal">Close<i class="fa fa-times" aria-hidden="true"></i> </button>
											<button type="button" class="btn btn-default" data-dismiss="modal" id="btGetData" onclick="sendMcqresult();"> Next Question <i class="fa fa-arrow-right" aria-hidden="true"></i></button>											
										</div>
									</form>
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
