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
									<form class="form-signin mg-btm" action="addMcqQuestion" method="post" name="formAddMcqQuestion" id="formAddMcqQuestion">
										<h3 class="heading-desc">Add MCQ Questions : </h3>
										<div id="spanid">${message}</div>										
										<div class="main">	
											<label>Question:</label>    
											<div class="form-group input-group">
												<span class="input-group-addon"><i class="fa fa-hand-o-right" aria-hidden="true"></i></span>
												<textarea rows="3" id="mcqQuestion" name="mcqQuestion" placeholder="What is your question ?" required></textarea>
											</div>                
											<div class="form-group">
												<label class="option-txt">Option 1:  </label>
												<input type="text" class="form-option" name="mcqAns1" id="mcqAns1" placeholder="Enter Option 1" required>
												<div class="clearfix"></div>
												<label class="option-txt">Option 2:  </label>
												<input type="text" class="form-option" name="mcqAns2" id="mcqAns2" placeholder="Enter Option 2" required>
												<div class="clearfix"> </div>
												<label class="option-txt">Option 3:  </label>
												<input type="text" class="form-option" name="mcqAns3" id="mcqAns3" placeholder="Enter Option 3" required>
												<div class="clearfix"> </div>
												<label class="option-txt">Option 4:  </label>
												<input type="text" class="form-option" name="mcqAns4" id="mcqAns4" placeholder="Enter Option 4" required>                                
												<div class="clearfix"> </div>
												
												<!-- <label class="option-txt">Select Category :  </label>
												<input type="text" class="form-option" name="qCategoryId" id="qCategoryId" placeholder="Enter Key Words" onkeyup="searchQCategory();" required>                                
												<div class="clearfix" id="divqCategoryId"></div>  -->
												
												<label class="option-txt">Select Category : </label> 
												<div id="divqCategoryOption">                                  
													<select class="form-control" id="qCategoryId" name="qCategoryId" onfocus="selectQCategory();">
														<option value="">---Select---</option>																									
													</select>	
												</div>												 
												<div id="showQSubCategoryList"></div><br>										
												
												<label class="option-txt">Select Correct Option:  </label>                                   
												<select class="form-control" id="mcqCorrectId" name="mcqCorrectId"><!-- onchange="setCorrectAns(this.value);" -->
													<option value="">--Select--</option>
													<option value="1">Option 1</option>
													<option value="2">Option 2</option>
													<option value="3">Option 3</option>
													<option value="4">Option 4</option>
												</select><br>													
												<!-- <div id="divMcqCorrectAns">	</div> -->
																				                                
												<label>Answer Description : </label>    
												<div class="form-group input-group">
													<span class="input-group-addon"><i class="fa fa-hand-o-right" aria-hidden="true"></i></span>
													<textarea rows="3" id="mcqAnsDescription" name="mcqAnsDescription" placeholder="Enter Answer Description" required></textarea>
												</div>
												<div class="clearfix"></div>
											</div>  
										</div>
										<span class="clearfix"></span>	
										<div class="login-footer">
											<div class="box-footer clearfix">
												<div class="form-group">
													<input type="submit" class="btn btn-sm btn-default btn-flat pull-right" value="Save Question">
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
