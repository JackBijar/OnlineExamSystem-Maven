<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	</head>
	<body>
		<jsp:include page="adminHomeHeader.jsp"></jsp:include>
        <div id="page-wrapper">
            <div class="container-fluid">
				<div class="row">
					<div class="col-md-2"> </div>
						<div class="col-md-8">
							<div class="back-color">
								<form class="form-signin mg-btm" action="addDescQuestion" method="post" name="formAddDescQuestion" id="formAddDescQuestion">
									<h3 class="heading-desc">Add Descriptive Question :</h3>
									<div id="spanid">${message}</div>
									<div class="main">	
										<label>Descriptive Question:</label>    
										<div class="form-group input-group">
											<span class="input-group-addon"><i class="fa fa-hand-o-right" aria-hidden="true"></i></span>
											<textarea id="dQuestion" name="dQuestion" rows="3" cols="45" placeholder="What is Your question ?"></textarea>
										</div>
										<label>Descriptive Answer:  </label>              
										<div class="form-group input-group">
											<span class="input-group-addon"><i class="fa fa-hand-o-right" aria-hidden="true"></i></span>
											<textarea id="dQuestionAns" name="dQuestionAns" rows="6" cols="45" placeholder="Write down your answer."></textarea>
										</div> 
										<label class="option-txt">Select Category : </label> 
										<div id="divqCategoryOption">                                  
											<select class="form-control" id="qCategoryId" name="qCategoryId" onfocus="selectQCategory();">
												<option value="">--Select--</option>																									
											</select>	
										</div>  
										<div id="showQSubCategoryList"></div><br>
										
										<label class="option-txt">Descriptive Question Mark</label> 
										<div id="divqCategoryOption">                                  
											<input type="text" class="form-result" name="dQuestionMarks" id="dQuestionMarks" placeholder="Descriptive Question Marks" required>
										</div> 
									</div>
									<span class="clearfix"></span>	
									<div class="login-footer">										
										<div class="box-footer clearfix">
											<div class="form-group">												
												<input type="submit" value="Save Question" class="btn btn-sm btn-default btn-flat pull-right">
											</div>																					  
										</div>
									</div>
								</form>
							</div>
							<div class="col-md-2"></div>
						</div>
					</div> 
				</div>
				<!-- /.container-fluid -->
			</div>
			<!-- /#page-wrapper -->
			<jsp:include page="adminHomeFooter.jsp"></jsp:include>
	</body>
</html>
