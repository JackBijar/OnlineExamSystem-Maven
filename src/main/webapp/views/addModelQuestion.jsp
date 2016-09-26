<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	</head>
	<body>
		<jsp:include page="adminHomeHeader.jsp"></jsp:include>
		<div id="wrapper">
			<div id="page-wrapper">
				<div class="container-fluid">
					<div class="row">
						<div class="row">
							<div class="col-md-2"> </div>
							<div class="col-md-8">
								<div class="back-color">        
									<form class="form-signin mg-btm" name="addNewModel" id="addNewModel" action="addNewModel" method="post" >
                                    	
										<h3 class="heading-desc">Set Model Questions : </h3>
                                        <div id="spanid">${message}</div>										
										<div class="main">	
											<div class="form-group">
                                            		
												
												<input type="text" class="form-option" name="modelName" id="modelName" placeholder="Model Name" required>
												<div class="clearfix"></div>
											</div>											
											<div class="form-group">
												<label class="option-txt">Total No of Questions :  </label>
												<input type="text" class="form-option" name="totalQuestion" id="totalQuestion" placeholder="Enter Total No of Questions" required>
												<div class="clearfix"></div>
											</div>
											<div class="form-group">
												<label class="option-txt">Examination Time Limit :  </label>
												<input type="text" class="form-option" name="examTime" id="examTime" placeholder="Enter Examination Time (In Minutes)" required>
												<div class="clearfix"></div>
											</div>
											<label>Model Description : </label>    
											<div class="form-group input-group">
												<span class="input-group-addon"><i class="fa fa-hand-o-right" aria-hidden="true"></i></span>
												<textarea rows="3" id="modelDescription" name="modelDescription" placeholder="Enter Model Description" required></textarea>
											</div>	
											
											<span class="clearfix"></span>	
											<div class="login-footer">
												<div class="box-footer clearfix">
													<div class="form-group">
														<button id="nextButton" class="btn btn-sm btn-default btn-flat pull-right">Search Questions</button>
													</div>												
												</div>
											</div>	
										</div>	
										
										
										<div class="main" id="divSearchQuestions">										
											<div class="form-group">
												<label class="option-txt">Model Question Type :  </label>
												<select class="form-control" id="modelQuestionType" name="modelQuestionType" onchange="selectModelQType(this.value);">
														<option value="">---- Select ----</option>
														<option value="1">MCQ Type</option>
														<option value="2">Descriptive Type</option>																									
												</select>												
												<div class="clearfix"></div>
											</div>
											
												
																	
											<div id="qCategoryList"></div>
											<div id="showQCategoryList"></div>											
											<div id="showQSubCategoryList"></div>
											<div id="showNoOfQuestion"></div>
											<div id="showSearchQuestion"></div>	
										</div>
										
										
										<span class="clearfix"></span>	
										<div class="login-footer">
											<div class="box-footer clearfix">
												<div class="form-group">
													<input type="submit" class="btn btn-sm btn-default btn-flat pull-right" value="Save Model">
												</div>												
											</div>
										</div>
									</form>
								</div>
								<div class="col-md-2"></div>
							</div>
						</div> 
					</div> 
				</div>
				<!-- /.container-fluid -->
			</div>
			<!-- /#page-wrapper -->
			<jsp:include page="adminHomeFooter.jsp"></jsp:include>
		</body>
</html>
