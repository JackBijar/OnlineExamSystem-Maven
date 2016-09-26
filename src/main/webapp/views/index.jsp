<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Online Examation System</title>
		<link rel="stylesheet" href="css/main.css"></link>
		<link href="css/bootstrap.min.css" rel="stylesheet"></link>
		<link href="css/hover.css" rel="stylesheet"></link>
		<link href="css/font-awesome.min.css" rel="stylesheet"></link>
		<script src="js/jquery.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  		<script type="text/javascript" src="javascripts/applications.js"></script> 
  		<script type="text/javascript" src="javascripts/admin.js"></script>
  		<script type="text/javascript" src="javascripts/candidate.js"></script> 
	</head>
<!-- -------------------------------------------------------------------------------Start Manu------------------------------------------------------------------------------------ -->
	<body>
		<div class="container">
			<div class="full-area">
				<div class="row">
					<div class="col-md-12 txt-oes uppercase"> Online Examination System </div>
					<HR WIDTH=28% ALIGN=CENTER>
				</div>
				<div class="row">
					<div class="col-sm-12 col-md-2 col-xs-12"> </div>
					<div class="col-sm-12 col-md-8 col-xs-12">
						<div class="col-sm-4 col-md-3 col-xs-12 logo-area">
							<div class="hvr-bob"> <img src="images/sign-in-bg.png" /></div>
							<div class="line-effect "><a href="#" data-toggle="modal" data-target="#myModal">Sign In </a></div><br />
						</div>
						<div class="col-sm-4 col-md-3 col-xs-12 logo-area">
							<div class="hvr-bob"><img src="images/sign-up-bg.png" /> </div>
							<div class="line-effect "> <a href="#" data-toggle="modal" data-target="#myModal_4" >Sign UP </a></div>
						</div>
						<div class="col-sm-4 col-md-3 col-xs-12 logo-area">
							<div class="hvr-bob"> <img src="images/admin-sign-in-bg.png" /></div>
							<div class="line-effect"> <a href="#" data-toggle="modal" data-target="#myModal_3">Admin Sign In </a></div>
						</div>						
						<div class="col-sm-4 col-md-3 col-xs-12 logo-area">
							<div class="hvr-bob"><img src="images/admin-sign-up-bg.png" /> </div>
							<div class="line-effect "> <a href="#" data-toggle="modal" data-target="#myModal_2" >Admin Sign UP </a></div>
						</div>
					</div>
					<div class="col-sm-12 col-md-2 col-xs-12"> </div>
				</div>
			</div>
		</div>
<!-- -------------------------------------------------------------------------------End------------------------------------------------------------------------------------------ -->
<!-- ----------------------------------------------------------------------------Model Candidate SING IN------------------------------------------------------------------------- -->
		<div class="modal fade" id="myModal" role="dialog">
			<div class="modal-dialog"> 		
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-body">
						<div class="full-area">
							<div class="row">
								<div class="col-md-12">
									<div class="text-center"><img src="images/login.png"  class="hvr-bob" /></div>
								</div>
								<div class="row">
									<div class="col-md-1"> </div>
									<div class="col-md-10">
										<div class="back-color">
											<form class="form-signin mg-btm" action="cSingIn" method="post" name="formCSingIn" id="formCSingIn">
												<h3 class="heading-desc">Sign In Details :</h3>
												<div class="main">
													<label>Mobile No</label>
													<div class="form-group input-group"> <span class="input-group-addon"><i class="fa fa-phone" aria-hidden="true"></i></span>
														<input type="text" class="form-control" name="cMobile" id="cMobile" placeholder="Enter Your Mobile No" required />
													</div>
												</div>
												<span class="clearfix"></span>
												<div class="login-footer">
													<div class="box-footer clearfix">
														<div class="form-group"><button class="btn btn-sm btn-default btn-flat pull-right" id="buttonCSingIn">Sign In</button></div>
													</div>
												</div>
											</form>
										</div>
									</div>
									<div class="col-md-1"></div>
								</div>							
							</div>						
						</div>
						<h6><font color="red">${loginStatus}</font></h6>
					</div>				
					<div class="modal-footer">					
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>
<!-- -------------------------------------------------------------------------------End------------------------------------------------------------------------------------------ -->
<!-- ----------------------------------------------------------------------------Model Candidate SING UP------------------------------------------------------------------------ -->
		<div class="modal fade" id="myModal_4" role="dialog">
			<div class="modal-dialog"> 
			
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-body">
						<div class="full-area">
							<div class="row">
								<div class="col-md-12">
									<div class="text-center"><img src="images/login.png" class="hvr-bob" /></div>
								</div>
								<div class="row">
									<div class="col-md-12">
										<div class="back-color">
											<form class="form-signin mg-btm" action="cSingUp" method="post" name="formCSingUp" id="formCSingUp">
												<h3 class="heading-desc">Sign Up Details</h3>
												<h6><font color="red">${singUpStatus}</font></h6>
												<div class="main">
													<div id="myDiv1">
														<div class="row">
															<div class="col-md-6">
																<label>Full Name</label>
																<div class="form-group input-group"> <span class="input-group-addon"><i class="fa fa-user" aria-hidden="true"></i></span>
																	<input type="text" class="form-control" name="cName" id="cName" placeholder="Your Name" required />
																</div>
															</div>
															<div class="col-md-6">
																<label>Mobile No</label>
																<div class="form-group input-group"> <span class="input-group-addon"><i class="fa fa-phone" aria-hidden="true"></i></span>
																	<input type="text" class="form-control" name="cMobile" id="cMobile" placeholder="Your Mobile No" required />
																</div>
															</div>
															<div class="col-md-6">
																<label>Email ID</label>
																<div class="form-group input-group"> <span class="input-group-addon"><i class="fa fa-phone" aria-hidden="true"></i></span>
																	<input type="text" class="form-control" name="cEmail" id="cEmail" placeholder="Your Email ID" required />
																</div>
															</div>
															<div class="col-md-6">
																<label>Date of Birth</label>
																<div class="form-group input-group"> <span class="input-group-addon"><i class="fa fa-calendar" aria-hidden="true"></i></span>
																	<input type="text" class="form-control" name="cDob" id="cDob" placeholder="Your Date of Birth" required />
																</div>
															</div>
														</div>
														<hr />
														<label>Knowledge Skill</label>
														<div class="form-group">
															<label class="checkbox-inline">	<input type="checkbox" name="cSkill" value="Php" /> PHP </label>
															<label class="checkbox-inline"> <input type="checkbox" name="cSkill" value="Asp.Net" /> Asp .Net </label>
															<label class="checkbox-inline"> <input type="checkbox" name="cSkill" value="Java" /> Java </label>
															<label class="checkbox-inline"> <input type="checkbox" name="cSkill" value="Angular JS" /> Angular JS </label>
															<label class="checkbox-inline"> <input type="checkbox" name="cSkill" value="Node JS" /> Node JS </label>
															<label class="checkbox-inline"> <input type="checkbox" name="cSkill" value="3D Animation" /> 3D Animation </label>
														</div>
														<span class="clearfix"></span>
														<div class="login-footer">
															<div class="row">																	
																<div class="col-xs-6 col-md-6 pull-right">
																	<div class="form-group"><button id="buttonCSingUp" class="btn btn-sm btn-default btn-flat pull-right" onclick="openMyDiv2();">Next Step</button></div>
																</div>
															</div>
														</div>
													</div>	
													<div id="myDiv2">
														<div style="text-align:center; font-size:16px; margin:10px 0px 10px 0px;"><strong>Highest Qualification Details</strong></div>
														<hr />
														<div class="row">
															<div class="col-md-12">
																<div class="col-md-6">
																	<label>Examination</label>
																	<div class="form-group input-group"> <span class="input-group-addon"><i class="fa fa-clipboard" aria-hidden="true"></i></i></span>
																		<input type="text" placeholder="Exam" class="form-control" name="cQualification" required>
																	</div>
																</div>
																<div class="col-md-6">
																	<label>University</label>
																	<div class="form-group input-group"> <span class="input-group-addon"><i class="fa fa-university" aria-hidden="true"></i></span>
																		<input type="text" placeholder="University" class="form-control" name="cQualification" required>
																	</div>
																</div>
																<div class="col-md-6">
																	<label>Passing year</label>
																	<div class="form-group input-group"> <span class="input-group-addon"><i class="fa fa-male" aria-hidden="true" required></i></span>
																		<input type="text" placeholder="Year" class="form-control" name="cQualification">
																	</div>
																</div>
																<div class="col-md-6">
																	<label>Marks</label>
																	<div class="form-group input-group"> <span class="input-group-addon"><i class="fa fa-file-o" aria-hidden="true" required></i></i></span>
																		<input type="text" placeholder="Your Marks (%)" class="form-control" name="cQualification">
																	</div>
															  </div>
															</div>
															<!-- <div class="clearfix"></div>										
															<div id="divAddEduQuali">
																<div class="col-xs-6 col-md-6 pull-right"> 
																	<button id="buttonAddMore" class="btn btn-sm btn-default btn-flat pull-right" onclick="addEQualifications();">Add More</button> 
																</div>
															</div>
														</div>		-->													
														<span class="clearfix"></span>
														<div class="login-footer">
															<div class="row">
                                                            	<div class="col-xs-6 col-md-6 pull-right">
																	<div class="form-group"><button id="buttonCSingUp" class="btn btn-sm btn-default btn-flat pull-right">Sing Up</button></div>
																</div>
																<div class="col-xs-6 col-md-6 pull-right">
																	<div class="form-group"><button id="buttonCSingUp" class="btn btn-sm btn-default btn-flat" onclick="openMyDiv1();">Previous Step</button></div>
																</div>
																
															</div>
														</div>
													</div>
												</div>	
                                                </div>											
											</form>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>
<!-- ---------------------------------------------------------------------------------END---------------------------------------------------------------------------------------- -->
<!-- ----------------------------------------------------------------------------Model ADMIN SING IN----------------------------------------------------------------------------- -->

		<div class="modal fade" id="myModal_3" role="dialog">
			<div class="modal-dialog"> 
			
			<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-body">
						<div class="full-area">
							<div class="row">
									<div class="col-md-12">
										<div class="text-center"><img src="images/login.png" class="hvr-bob" /></div>
									</div>
								<div class="row">
									<div class="col-md-1"> </div>
									<div class="col-md-10">
										<div class="back-color">
											<form class="form-signin mg-btm" action="aSingIn" method="post" name="formAdminSingIn" id="formAdminSingIn">
												<h3 class="heading-desc">Admin Sign In Details :</h3>
												<div class="main">
													<label>Mobile No</label>
													<div class="form-group input-group"> <span class="input-group-addon"><i class="fa fa-phone" aria-hidden="true"></i></span>
														<input type="text" class="form-control"  name="adminMobile" id="adminMobile" placeholder="Your Mobile No" required />
													</div>
													<label>Password <a href="#"> (Forgot Password)</a></label>
													<div class="form-group input-group"> <span class="input-group-addon"><i class="fa fa-unlock-alt" aria-hidden="true"></i></span>
														<input type="password" class="form-control" name="adminPass" id="adminPass" placeholder="Your Password" required />
													</div>
												</div>
												<span class="clearfix"></span>
												<div class="login-footer">
													<div class="row">
														<div class="col-xs-6 col-md-6">
															<!-- <div class="backhome"> <img src="images/back-home.png"> <a href="#">BACK TO HOME </a> </div> -->
															<h6><font color="red">${loginStatus}</font></h6>
														</div> 
														<div class="col-xs-6 col-md-6 pull-right">
															<div class="form-group"> <button id="buttonAdminSingIn" class="btn btn-sm btn-default btn-flat pull-right">Sing In</button></div>
														</div>
													</div>
												</div>
											</form>
										</div>
									</div>
									<div class="col-md-1"></div>
								</div>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>
<!-- -------------------------------------------------------------------------------End----------------------------------------------------------------------------------------- -->
<!-- -------------------------------------------------------------------------------Model ADMIN SING UP------------------------------------------------------------------------- -->
	
		<div class="modal fade" id="myModal_2" role="dialog">
			<div class="modal-dialog"> 		
		<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-body">
						<div class="full-area">
							<div class="row">
								<div class="col-md-12">
									<div class="text-center"><img src="images/login.png" class="hvr-bob" /></div>
								</div>
								<div class="row">
									<div class="col-md-1"> </div>
									<div class="col-md-10">
										<div class="back-color">
											<form class="form-signin mg-btm" action="aSingUp" method="post" name="formAdminSingUp" id="formAdminSingUp">
												<h3 class="heading-desc">Admin Sign Up Details</h3>
												<div class="main">
													<label>Full Name</label>
													 <div class="form-group input-group"> <span class="input-group-addon"><i class="fa fa-phone" aria-hidden="true"></i></span>
														<input type="text" class="form-control" name="adminName" id="adminName" placeholder="Your Name" required />
													 </div>
													<label>Mobile No</label>
													<div class="form-group input-group"> <span class="input-group-addon"><i class="fa fa-phone" aria-hidden="true"></i></span>
														<input type="text" class="form-control" name="adminMobile" id="adminMobile" placeholder="Your Mobile No" required />
													</div>
													<label>Password <a href="#"> (Forgot Password)</a></label>
													<div class="form-group input-group"> <span class="input-group-addon"><i class="fa fa-unlock-alt" aria-hidden="true"></i></span>
														<input type="password" class="form-control" name="adminPass" id="adminPass" placeholder="Enter New Password" required />
													</div>						  
												</div>
												<span class="clearfix"></span>
												<div class="login-footer">
													<div class="row">
													<!--	<div class="col-xs-6 col-md-6">
															<div class="backhome"> <img src="images/back-home.png" /> <a href="#">BACK TO HOME </a> </div>
														</div> -->
														<div class="col-xs-6 col-md-6 pull-right">
															<div class="form-group"><input type="submit" value="Sing Up" class="btn btn-sm btn-default btn-flat pull-right" /></div>
														</div>
													</div>
												</div>
											</form>
										</div>
										<div class="col-md-1"></div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
