<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>MCQ Report</title>
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
	</head>
	<body>
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
									<h3 class="heading-desc">MCQ Test Report :</h3>
									<div class="Contain-area">
										<div class="main">
											<c:forEach items="${mcqBeanList}" var="mcqBean">											
													<label><li> ${mcqBean.mcqQuestion} </li></label>	
																								
													<div class="radio">
														<label>1. ${mcqBean.mcqAns1}</label>															
													</div>
													<div class="radio">
														<label>2. ${mcqBean.mcqAns2}</label>
													</div>
													<div class="radio">
													  <label>3. ${mcqBean.mcqAns3}</label>
													</div>
													<div class="radio">
													  <label>4. ${mcqBean.mcqAns4}</label>
													</div>
													<div>
														<label>Correct Answer : <font color="lightgreen">${mcqBean.mcqCorrectId}</font></label>
													</div>																									
													<div>
														<c:if test="${mcqBean.mcqCorrectId == mcqBean.cGivenAnsId}">
															<label>Your Answer : <font color="lightgreen"> ${mcqBean.cGivenAnsId}</font></label>
														</c:if>	
														<c:if test="${mcqBean.mcqCorrectId ne mcqBean.cGivenAnsId}">
															<label>Your Answer : <font color="red"> ${mcqBean.cGivenAnsId}</font></label>
														</c:if>	
													</div>
													<c:if test="${mcqBean.mcqAnsDescription.length() gt 0}">
														<div> 
															<label>Answer Description : </label>
															<label><font color="white"> ${mcqBean.mcqAnsDescription} </font></label>
														</div>
													</c:if>
											</c:forEach>
											<div class="form-group"></div>
										</div>
									</div>
									<span class="clearfix"></span>
									<div class="modal-footer">
										<a href="candidateHomePage"><button type="button" class="btn btn-default" data-dismiss="modal">Close<i class="fa fa-times" aria-hidden="true"></i> </button></a>																						
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
