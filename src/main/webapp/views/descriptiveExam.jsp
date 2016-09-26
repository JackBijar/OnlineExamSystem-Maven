<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Online Examation System</title>
		<link rel="stylesheet" href="css/main.css"></link>
		<link href="css/bootstrap.css" rel="stylesheet"></link>
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
				<!--<div class="row">
					<div class="col-md-12 txt-oes"> Admin Sign In Details </div>
					<HR WIDTH=18% ALIGN=CENTER>
				</div>-->
				<div class="row">
					<!-- <div class="col-md-12">
						<div class="text-center"><img src="images/online-test-exm.png" class="hvr-bob" /></div>
					</div> -->
					<div class="row">
						<div class="col-md-2"> </div>
						<div class="col-md-8">
							<div class="back-color" id="mcqFinalResult">
								<form class="form-signin mg-btm" id="formDescQResult" name="formDescQResult">
									<ol>
										<h3 class="heading-desc">Online Descriptive Test:</h3>
										<div class="main">
											<c:forEach items="${descriptiveQBeanList}" var="descBean">												
												<label><li>${descBean.dQuestion}</li></label>
												<div class="qbBlock" id="${descBean.dQuestionId}">
													<div class="form-group input-group"> <span class="input-group-addon"><i class="fa fa-newspaper-o" aria-hidden="true"></i></span>
														<textarea rows="4" id="input-message message-area" name="${descBean.dQuestionId}"></textarea><%--  name="desc_${descBean.dQuestionId}_QId" --%>
													</div> 
												</div>  
											</c:forEach>
										</div>
										<span class="clearfix"></span>
										<div class="login-footer">
											<div class="box-footer clearfix">
												<div class="modal-footer">
													<button type="button" class="btn btn-default" data-dismiss="modal">Close<i class="fa fa-times" aria-hidden="true"></i> </button>
													<button type="button" class="btn btn-default" data-dismiss="modal" onclick="submitDescResult();"> Next Question <i class="fa fa-arrow-right" aria-hidden="true"></i></button>
											  </div>
											  <!--<a href="#" class="btn btn-sm btn-info btn-flat pull-left">Your Marks</a>-->						  
											</div>
										</div>
									</ol>
								</form>
							</div>
							<div class="col-md-2"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
