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
									<form class="form-signin mg-btm" action="addQCategory" method="post" name="formAddMcqQuestion" id="formAddMcqQuestion">
										<h3 class="heading-desc">Add Question Categories : </h3>
										<div id="spanid">${message}</div>										
										<div class="main">	
											<div class="form-group">
												<label class="option-txt">Category Name :  </label>
												<input type="text" class="form-option" name="qCategoryName" id="qCategoryName" placeholder="Enter Categories Name" required>
												<div class="clearfix"></div>
											</div>
											<label>Question Category Description : </label>    
											<div class="form-group input-group">
												<span class="input-group-addon"><i class="fa fa-hand-o-right" aria-hidden="true"></i></span>
												<textarea rows="3" id="qCategoryDescription" name="qCategoryDescription" placeholder="Enter Question Category Description" required></textarea>
											</div>
										</div>
										<span class="clearfix"></span>	
										<div class="login-footer">
											<div class="box-footer clearfix">
												<div class="form-group">
													<input type="submit" class="btn btn-sm btn-default btn-flat pull-right" value="Save Category">
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
