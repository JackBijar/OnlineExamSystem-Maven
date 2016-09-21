/*-----------------------------------------------Used in Add MCQ Portion-------------------------------------------------- */

/*function setCorrectAns(option)
{	
	var output = "<label class='option-txt'>Correct Answer : </label>"
		+"<input type='text' class='form-option' name='mcqCorrectAns' id='mcqCorrectAns'>"
		+"<div class='clearfix'> </div><br>";
		$('#divMcqCorrectAns').html(output);
		
	if(option == 1)
	{
		$('#mcqCorrectAns').val($('input#mcqAns1').val());
	}
	else if(option == 2)
	{
		$('#mcqCorrectAns').val($('input#mcqAns2').val());
	}
	else if(option == 3)
	{
		$('#mcqCorrectAns').val($('input#mcqAns3').val());
	}
	else if(option == 4)
	{
		$('#mcqCorrectAns').val($('input#mcqAns4').val());
	}
	else
	{
		alert("Select Courrect Answer Option");
	}
	
}*/

/*---------------------------------------Select Category for Add New MCQ---------------------------------------------- */

function selectQCategory()
{		
	$.ajax({
		type: "GET",
		url: 'http://localhost:8080/OnlineExamSystem/selectQCategory',		
		success: function(data) 
		{				
			var output = "<select class='form-control' id='qCategoryId' name='qCategoryId' onchange='searchQSubCategoryForMcq();' required>"
							+"<option value=''>---- Select ----</option>";
			for(i = 0; i < data.length; i++)
			{
				output +="<option value='"+data[i].qCategoryId+"'>"+data[i].qCategoryName+"</option>";
			}
			output +="</select>";			
			$('#divqCategoryOption').html(output);
		}
	});									
}

/*---------------------------------------Select Sub Category for Add New MCQ---------------------------------------------- */

function searchQSubCategoryForMcq()
{
	var qCategoryId = $('select#qCategoryId').val();
	alert("Sub Category ID : "+qCategoryId);	
	if(qCategoryId != 0)
	{
		$.ajax({
			type: "POST",
			url: 'http://localhost:8080/OnlineExamSystem/searchQSubCategory',
			data:  ({
						qCategoryId : qCategoryId
					}),
			success: function(data) 
			{
				var output = "<div class='form-group'>"
								+"<label class='option-txt'>Select Question Sub Category :  </label>"												
								+"<select class='form-control' id='qSubCategoryId' name='qSubCategoryId' required>"												
									+"<option value=''>---- Select ----</option>";				
				for(i = 0; i < data.length; i++)
				{
					output +="<option value='"+data[i].qSubCategoryId+"'>"+data[i].qSubCategoryName+"</option>";						
				}
				
				output += "</select>"
							+"<div class='clearfix'></div>"
							+"</div>";	
				alert(output);				
				
				$('#showQSubCategoryList').html(output);
			}
		});			
	}
	else
		alert("Else Part");
}

/*-----------------------------------------------Used for Delete MCQ-------------------------------------------------- */

function deleteMcqQuestion(mcqId)
{
	alert(mcqId);
	$.ajax({
			type: "POST",
			url: 'http://localhost:8080/OnlineExamSystem/deleteMcqQuestion',
			data:  ({
						mcqId : mcqId
					}),
			success: function(data) 
			{
				alert(data);			
				var output="<br><br><table class='table table-bordered table-hover table-striped' id='tableId'>"
                                +"<thead>"
                                	+"<tr>"
										+"<th> MCQ Id </th>"
										+"<th> Question </th>"
										+"<th> Option 1 </th>"
										+"<th> Option 2 </th>"
										+"<th> Option 3 </th>"
										+"<th> Option 4 </th>"
										+"<th> Correct Answer </th>"
										+"<th> Correct ID </th>"
										+"<th> Answer Description </th>"
										+"<th> Update </th>"
										+"<th> Delete </th>"
									+"</tr>"
								+"</thead>"
								+"<tbody>";

				for(i = 0; i < data.length; i++)
				{
					output+="<tr id='tr_"+ data[i].mcqId +"'>"
								+"<td id='td1'>" + data[i].mcqId + "</td>"
								+"<td id='td2'>" + data[i].mcqQuestion + "</td>"
								+"<td id='td3'>" + data[i].mcqAns1 + "</td>"
								+"<td id='td4'>" + data[i].mcqAns2 + "</td>"
								+"<td id='td5'>" + data[i].mcqAns3 + "</td>"
								+"<td id='td6'>" + data[i].mcqAns4 + "</td>"
								+"<td id='td7'>" + data[i].mcqCorrectAns + "</td>"
								+"<td id='td8'>" + data[i].mcqCorrectId + "</td>"
								+"<td id='td9'>" + data[i].mcqAnsDescription + "</td>"
								+"<td id='td10'><a href='#' onclick='updateMcqQuestion("+data[i].mcqId+");'> Update </a></td>"
								+"<td id='td11'><a href='#'onclick='deleteMcqQuestion("+data[i].mcqId+");'> Delete </a></td>"
							+"</tr>";
				}
				output+= "</tbody>"
						+"</table>";
				alert(output);
				$('#divShowAllMcq').html(output);
			}
		});
}

/*----------------------------------------------Used for Delete Descriptive---------------------------------------------- */

function deleteDescQuestion(dQuestionId)
{
	alert(dQuestionId);
	$.ajax({
			type: "POST",
			url: 'http://localhost:8080/OnlineExamSystem/deleteDescQuestion',
			data:  ({
						dQuestionId : dQuestionId
					}),
			success: function(data) 
			{
				alert(data);			
				var output="<br><br><table class='table table-bordered table-hover table-striped' id='tableId'>"
                                +"<thead>"
                                	+"<tr>"
										+"<th> Descriptive ID </th>"
										+"<th> Question </th>"
										+"<th> Answer </th>"
										+"<th> Question Marks </th>"										
										+"<th> Update </th>"
										+"<th> Delete </th>"
									+"</tr>"
								+"</thead>"
								+"<tbody>";

				for(i = 0; i < data.length; i++)
				{
					output+="<tr id = 'tr_"+ data[i].dQuestionId +"'>"
								+"<td id='td1'>" + data[i].dQuestionId + "</td>"
								+"<td id='td2'>" + data[i].dQuestion + "</td>"
								+"<td id='td3'>" + data[i].dQuestionAns + "</td>"
								+"<td id='td4'>" + data[i].dQuestionMarks + "</td>"
								+"<td id='td5'><a href='#' onclick='updateDescQuestion("+data[i].dQuestionId+");'> Update </a></td>"
								+"<td id='td5'><a href='#'onclick='deleteDescQuestion("+data[i].dQuestionId+");'> Delete </a></td>"
							+"</tr>";
				}
				output+= "</tbody>"
						+"</table>";
				alert(output);
				$('#showAllDescQuestion').html(output);
			}
		});
}


/*-----------------------------------------------Used for Send MCQ Result------------------------------------------------- */

function sendMcqresult()					
{	
	var qaData = {},
	qaBlocks = $('.qaBlock');

	$.each(qaBlocks, function(){
		var el = $(this),
			selected = el.find("input[type='radio']:checked");
			
		qaData[el.attr('id')] = ((selected.length == 0) ? "0" : selected.val());
	});	
	
	var mcqResult = JSON.stringify(qaData);
	alert(mcqResult);
	
	$.ajax({
		type: "POST",
		url: 'http://localhost:8080/OnlineExamSystem/saveMcqResult',
		data: ({
					mcqResult : mcqResult
				}),
		success: function(data) 
		{
			alert(data);
			var output="<div class='Contain-area'>"
							+"<div class='main'>"
							+"<h3>Your Report ID : "	+ data.reportId +"</h3>"
							+"<h3>Your MCQ Score : "+data.mcqResult +"</h3>"
							+"<div align='right'><a href='candidateHomePage'>Back to Home</a></div>"
							+"</div>"							
						+"</div>";				
			
			$('#mcqFinalResult').html(output);
		},
		error: function(data, status, error) 
		{
	        alert("Data := "+data+" Status := "+status+" Error := "+error);	        
	    }
	});
}

function submitDescResult()
{
	alert("In DESC Question");
	
	/*var descResult = $("#formDescQResult").serialize();
	alert(descResult);*/
	
	var qbData = {},
	qbBlocks = $('.qbBlock');

	$.each(qbBlocks, function(){
		var el = $(this),
			 ans = el.find("div textarea").val();
			
		qbData[el.attr('id')] = ans;
	});
	
	var descResult = JSON.stringify(qbData);
	alert(descResult);
	console.log(descResult);
	
	$.ajax({
		type: "POST",
		url: 'http://localhost:8080/OnlineExamSystem/saveDescResult',
		data: ({
					descResult : descResult
				}),
		success: function(data) 
		{
			alert(data);
			var output="<div class='Contain-area'>"
							+"<div class='main'>"
							+"<h3>Your Report ID : "+ data.reportId +"</h3>"
							+"<h3>Your MCQ Score : "+data.mcqResult +"</h3>"
							+"<h2>Descriptive Result is Not Published at This Time</h2>"
							+"<div align='right'><a href='candidateHomePage'>Back to Home</a></div>"
							+"</div>"							
						+"</div>";				
			
			$('#mcqFinalResult').html(output);
		},
		error: function(data, status, error) 
		{
	        alert("Data := "+data+" Status := "+status+" Error := "+error);	        
	    }
	});	
}

function checkAns(reportId)
{
	alert(reportId);
	$.ajax({
			type: "POST",
			url: 'http://localhost:8080/OnlineExamSystem/checkDescAns',
			data:  ({
						reportId : reportId
					}),
			success: function(data) 
			{
				alert(data);
				alert("SET a POPUP Div Style");
				var output="<div class='col-lg-12 col-md-12'>"
							+ "<h2>Descriptive Exam Details </h2>"
							+ "<br><br><table class='table table-bordered table-hover table-striped' id='tableDescAnsId'>"
                                +"<thead>"
                                	+"<tr>"
										+"<th> Descriptive ID </th>"
										+"<th> Question </th>"
										+"<th> Answer </th>"
										+"<th> Question Marks </th>"										
										+"<th> Candidate Ans </th>"
										+"<th> Given Marks </th>"
									+"</tr>"
								+"</thead>"
								+"<tbody>"
								+"</div>";

				for(i = 0; i < data.length; i++)
				{
					output+="<div class='qcBlock' id='"+ data[i].dQuestionId +"'><tr id='trDescAnsId'>"
								+"<td id='td1'>" + data[i].dQuestionId + "</td>"
								+"<td id='td2'>" + data[i].dQuestion + "</td>"
								+"<td id='td3'>" + data[i].dQuestionAns + "</td>"
								+"<td id='td4'>" + data[i].dQuestionMarks + "</td>"
								+"<td id='td5'>" + data[i].cGivenAns + "</td>"
								+"<td id='td6'><input type='text' placeholder='Enter Marks' id='"+ data[i].dQuestionId +"' name='"+ data[i].dQuestionId +"' required></td>"
							+"</tr></div>";
				}
				output+= "</tbody>"
						+"</table>"
						+"<button id='buttonSaveDescMarks' onclick='saveDescMarks("+reportId+");'>Save Result</button>";
				alert(output);
				$('#divshowDescQuestion').html(output);				
			}
		});
}

function saveDescMarks(reportId)
{
	alert(reportId);
	var qcData = {},
	qcBlocks = $('.qcBlock');

	$.each(qcBlocks, function(){
		var el = $(this),
			 //ans = el.find("#tableDescAnsId text").val();
			ans = $("#tableDescAnsId #trDescAnsId #td6 #marks").val();
			//ans = el.find("#tableDescAnsId #trDescAnsId #td6 text").val();
		qcData[el.attr('id')] = ans;
	});
	
	console.log(qcData);
	var descMarks = JSON.stringify(qcData);		
	$.ajax({
		type: "POST",
		url: 'http://localhost:8080/OnlineExamSystem/saveDescMarks',
		data: ({
					descMarks : descMarks,
					reportId : reportId
				}),
		success: function(data) 
		{
			alert("(Build in Html) Return Data : "+data);
		},
		error: function(data, status, error) 
		{
	        alert("Data := "+data+" Status := "+status+" Error := "+error);	        
	    }
	});
}

/*-----------------------------------------------Update MCQ Question------------------------------------------------- */

function updateMcqQuestion(mcqId)
{		
	var output = "<div class='row'>"
					+ "<div class='col-md-2'> </div>"
					+ "<div class='col-md-8'>"
					+	"<div class='back-color'>"        
					+		 "<form class='form-signin mg-btm' action='updateMcqQuestion' method='post' name='formAddMcqQuestion' id='formAddMcqQuestion'>"
					+			"<h3 class='heading-desc'>Update MCQ Questions : </h3>"									
					+			"<div class='main'>	"
					+				"<label>Question:</label>"
					+				"<label class='option-txt'>MCQ ID :</label>"
					+				"<input type='text' class='form-option' name='mcqId' id='mcqId' value='"+$("#tableId #tr_"+mcqId+" #td1").text()+"' readonly>"
					+				"<div class='clearfix'></div>"
					+				"<div class='form-group input-group'>"
					+					"<span class='input-group-addon'><i class='fa fa-hand-o-right' aria-hidden='true'></i></span>"
					+					"<textarea rows='3' id='mcqQuestion' name='mcqQuestion'>"+$("#tableId #tr_"+mcqId+" #td2").text()+"</textarea>"
					+				"</div>"                
					+				"<div class='form-group'>"
					+					"<label class='option-txt'>Option 1:  </label>"
					+					"<input type='text' class='form-option' name='mcqAns1' id='mcqAns1' value='"+$("#tableId #tr_"+mcqId+" #td3").text()+"' required>"
					+					"<div class='clearfix'></div>"
					+					"<label class='option-txt'>Option 2:  </label>"
					+					"<input type='text' class='form-option' name='mcqAns2' id='mcqAns2' value='"+$("#tableId #tr_"+mcqId+" #td4").text()+"' required>"
					+					"<div class='clearfix'> </div>"
					+					"<label class='option-txt'>Option 3:  </label>"
					+					"<input type='text' class='form-option' name='mcqAns3' id='mcqAns3' value='"+$("#tableId #tr_"+mcqId+" #td5").text()+"' required>"
					+					"<div class='clearfix'> </div>"
					+					"<label class='option-txt'>Option 4:  </label>"
					+					"<input type='text' class='form-option' name='mcqAns4' id='mcqAns4' value='"+$("#tableId #tr_"+mcqId+" #td6").text()+"' required>"                                
					+					"<div class='clearfix'> </div>"
					+					"<label class='option-txt'>Select Category : </label>" 
					+					"<div id='divqCategoryOption'>"                                  
					+						"<select class='form-control' id='qCategoryId' name='qCategoryId' onfocus='selectQCategory();' required>"
					+							"<option value=''>--Select--</option>"																									
					+						"</select>"	
					+					"</div>"
					+					"<div id='showQSubCategoryList'></div><br>"
					+					"<label class='option-txt'>Select Correct Option:  </label>"                                   
					+					"<select class='form-control' id='mcqCorrectId' name='mcqCorrectId' onchange='setCorrectAns(this.value);' required>"
					+						"<option value=''>--Select--</option>";
					
											if($("#tableId #tr_"+mcqId+" #td7").text() == "1")
											{
												output = output + "<option value='1'selected='selected'>1</option>"
																	+ "<option value='2'>2</option>"
																	+ "<option value='3'>3</option>"
																	+ "<option value='4'>4</option>";
											}
											if($("#tableId #tr_"+mcqId+" #td7").text() == "2")
											{
												output = output +"<option value='1'>1</option>"
												+ "<option value='2'selected='selected'>2</option>" 
												+ "<option value='3'>3</option>"
												+ "<option value='4'>4</option>";
											}
											if($("#tableId #tr_"+mcqId+" #td7").text() == "3")
											{
												output = output + "<option value='1'>1</option>"
												+ "<option value='2'>2</option>"
												+ "<option value='3'selected='selected'>3</option>"
												+ "<option value='4'>4</option>";
											}
											if($("#tableId #tr_"+mcqId+" #td7").text() == "4")
											{												
												output = output + "<option value='1'>1</option>"
												+ "<option value='2'>2</option>"
												+ "<option value='3'>3</option>"
												+"<option value='4'selected='selected'>4</option>";
											}
											
										output = output	+"</select>"
					+					"<label>Answer Description : </label>"
					+					"<div class='form-group input-group'>"
					+						"<span class='input-group-addon'><i class='fa fa-hand-o-right' aria-hidden='true'></i></span>"
					+						"<textarea rows='3' id='mcqAnsDescription' name='mcqAnsDescription' required>"+$("#tableId #tr_"+mcqId+" #td9").text()+"</textarea>"
					+					"</div>"
					+					"<div class='clearfix'></div>"
					+				"</div>"  
					+			"</div>"
					+			"<span class='clearfix'></span>"	
					+			"<div class='login-footer'>"
					+				"<div class='box-footer clearfix'>"
					+					"<div class='form-group'>"
					+						"<input type='submit' class='btn btn-sm btn-default btn-flat pull-right' value='Update Question'>"
					+					"</div>"
					+				"</div>"
					+			"</div>"
					+		"</form>"
					+	"</div>"
					+	"<div class='col-md-2'></div>"
					+"</div>"
				+"</div>" ;
	
	alert(output);
	$('#divMcqUpdate').html(output);	
}

function updateDescQuestion(dQuestionId)
{
	alert("Update Desc : "+dQuestionId);	
	
	alert($("#tableId #tr_"+dQuestionId+" #td1").text());
	
	var output = "<div class='col-md-2'> </div>"
	+					"<div class='col-md-8'>"
	+						"<div class='back-color'>"
	+							"<form class='form-signin mg-btm' action='updateDescQuestion' method='post' name='formUpdateDescQuestion' id='formUpdateDescQuestion'>"
	+								"<h3 class='heading-desc'>Update Descriptive Question :</h3>"	
	+								"<div class='main'>"
	+									"<label>Descriptive Question ID :</label>"
	+									"<input type='text' class='form-result' name='dQuestionId' id='dQuestionId' value='"+$("#tableId #tr_"+dQuestionId+" #td1").text()+"' readonly>"
	+									"</br></br><label>Descriptive Question:</label>"
	+									"<div class='form-group input-group'>"
	+										"<span class='input-group-addon'><i class='fa fa-hand-o-right' aria-hidden='true'></i></span>"
	+										"<textarea id='dQuestion' name='dQuestion' rows='3' cols='45'>"+$("#tableId #tr_"+dQuestionId+" #td2").text()+"</textarea>"
	+									"</div>"
	+									"<label>Descriptive Answer:  </label>" 
	+									"<div class='form-group input-group'>"
	+										"<span class='input-group-addon'><i class='fa fa-hand-o-right' aria-hidden='true'></i></span>"
	+										"<textarea id='dQuestionAns' name='dQuestionAns' rows='6' cols='45'>"+$("#tableId #tr_"+dQuestionId+" #td3").text()+"</textarea>"
	+									"</div>"
	+									"<label class='option-txt'>Select Category : </label>" 
	+									"<div id='divqCategoryOption'>"                                  
	+										"<select class='form-control' id='qCategoryId' name='qCategoryId' onfocus='selectQCategory();' required>"
	+											"<option value=''>--Select--</option>"																									
	+										"</select>"	
	+									"</div>"
	+								"<div id='showQSubCategoryList'></div><br>"
	+								"</div>"
	+								"<span class='clearfix'></span>"
	+								"<div class='login-footer'>"
	+									"Descriptive Question Mark"
	+									"<div class='box-footer clearfix'>"
	+										"<div class='form-group'>"
	+											"<input type='text' class='form-result' name='dQuestionMarks' id='dQuestionMarks' value='"+$("#tableId #tr_"+dQuestionId+" #td4").text()+"' required>"
	+											"<input type='submit' value='Save Question' class='btn btn-sm btn-default btn-flat pull-right'>"
	+										"</div>"																				  
	+									"</div>"
	+								"</div>"
	+							"</form>"
	+						"</div>"
	+						"<div class='col-md-2'></div>"
	+					"</div>";
	
	alert(output);
	$('#divDescUpdate').html(output);
}

/*-----------------------------------------------Delete Question Category------------------------------------------------- */
function deleteQCategory(qCategoryId)
{
	alert("="+qCategoryId);	
	$.ajax({
			type: "POST",
			url: 'http://localhost:8080/OnlineExamSystem/deleteQCategory',
			data:  ({
						qCategoryId : qCategoryId
					}),
			success: function(data) 
			{						
				var output="<br><br><table class='table table-bordered table-hover table-striped' id='tableId'>"
                                +"<thead>"
                                	+"<tr>"
										+"<th> Question Category Id </th>"
										+"<th> Question Category Name </th>"
										+"<th> Question Category Description </th>"
										+"<th> Update </th>"
										+"<th> Delete </th>"
									+"</tr>"
								+"</thead>"
								+"<tbody>";

				for(i = 0; i < data.length; i++)
				{
					output+="<tr id = 'tr_"+ data[i].qCategoryId +"'>"
								+"<td id='td1'>" + data[i].qCategoryId + "</td>"
								+"<td id='td2'>" + data[i].qCategoryName + "</td>"
								+"<td id='td3'>" + data[i].qCategoryDescription + "</td>"
								+"<td id='td4'><a href='#' onclick='updateQCategory("+data[i].qCategoryId+");'> Update </a></td>"
								+"<td id='td5'><a href='#'onclick='deleteQCategory("+data[i].qCategoryId+");'> Delete </a></td>"
							+"</tr>";
				}
				output+= "</tbody>"
						+"</table>";				
				$('#showQuestionCategory').html(output);
			}
		});
	
}

/*-----------------------------------------------Update Question Category------------------------------------------------- */
function updateQCategory(qCategoryId)
{
	alert("--"+qCategoryId);	
	alert($("#tableId #tr_"+qCategoryId+" #td1").text());
	
	var output = "<div class='col-md-2'> </div>"
	+					"<div class='col-md-8'>"
	+						"<div class='back-color'>"
	+							"<form class='form-signin mg-btm' action='updateQCategory' method='post' name='formupdateQCategory' id='formupdateQCategory'>"
	+								"<h3 class='heading-desc'>Update Question Category :</h3>"	
	+								"<div class='main'>"
	+									"<label>Question Category Id :</label>"
	+									"<input type='text' class='form-result' name='qCategoryId' id='qCategoryId' value='"+$("#tableId #tr_"+qCategoryId+" #td1").text()+"' readonly>"
	+									"</br></br></br>" 
	+									"<label>Question Category Name</label>"	
	+									"<input type='text' class='form-result' name='qCategoryName' id='qCategoryName' value='"+$("#tableId #tr_"+qCategoryId+" #td2").text()+"'>"
	+									"</br></br></br><label>Question Category Description : </label>"    
	+									"<div class='form-group input-group'>"
	+										"<span class='input-group-addon'><i class='fa fa-hand-o-right' aria-hidden='true'></i></span>"
	+										"<textarea rows='3' id='qCategoryDescription' name='qCategoryDescription' placeholder='Enter Question Category Description' required></textarea>"
	+									"</div>"
	+								"</div>"
	+								"<span class='clearfix'></span>"
	+								"<div class='login-footer'>"
	+									"<div class='box-footer clearfix'>"
	+										"<div class='form-group'>"											
	+											"<input type='submit' value='Save Category' class='btn btn-sm btn-default btn-flat pull-right'>"
	+										"</div>"																				  
	+									"</div>"
	+								"</div>"
	+							"</form>"
	+						"</div>"
	+						"<div class='col-md-2'></div>"
	+					"</div>";
	
	alert(output);
	$('#divCategoryUpdate').html(output);
}

/*================================================-- Add New Model Section --=============================================*/

/*-------------------------------------------------Select Model Questions Type--------------------------------------------- */

function selectModelQType(modelQuestionType)
{	
	if(modelQuestionType != 0 || modelQuestionType != "")
	{
		alert("== "+modelQuestionType);
				$('#qCategoryList').html(output);
				
			var output = "<div class=form-group>"
							+" <label class='option-txt'>Select Question Category :  </label>"												
							+"<input type='text' class='form-option' name='qCategoryId' id='qCategoryId' " 
									+"placeholder='Enter Question Category' onkeyup='searchQCategory(this.value);' required>"												
							+"<div id='qCategoryList'></div>"												
							+"<div class='clearfix'></div>"
						"</div>";
			$('#qCategoryList').html(output);
	}
	else
	{
		alert("Please Select Model Question Type");
		$('#qCategoryList').html("");
	}
}

/*-----------------------------------------Search Category for Add New Model Questions----------------------------------------- */

function searchQCategory(searchQCategoryStr)
{	
	if(searchQCategoryStr.length > 0)
	{
		$.ajax({
			type: "POST",
			url: 'http://localhost:8080/OnlineExamSystem/searchQCategory',
			data:  ({
						searchQCategoryStr : searchQCategoryStr
					}),
			success: function(data) 
			{
				output = "";
				for(i = 0; i < data.length; i++)
				{					
					var qCId = data[i].qCategoryId;
					var qCName = data[i].qCategoryName;
					output +="<div style='margin:3px; margin-left:190px; color:black'>" +
								"<a href='#' onClick='searchQSubCategory("+data[i].qCategoryId+");'><b>"+data[i].qCategoryName+"</b></a></div>";					
				}
				$('#showQCategoryList').html(output);
			}
		});			
	}
}

/*-----------------------------------------Search Sub Category ----------------------------------------------------------- */
var globalQCategoryId;
function searchQSubCategory(qCategoryId)
{
	alert("qCategoryId =:= "+qCategoryId);
	
	if(qCategoryId != 0)
	{
		globalQCategoryId = qCategoryId;
		
		$.ajax({
			type: "POST",
			url: 'http://localhost:8080/OnlineExamSystem/searchQSubCategory',
			data:  ({
						qCategoryId : qCategoryId
					}),
			success: function(data) 
			{
				var output = "<div class='form-group'>"
								+"<label class='option-txt'>Select Question Sub Category :  </label>"												
								+"<select class='form-control' id='qSubCategoryId' name='qSubCategoryId' onchange='showNoOfQuestion();'>"												
									+"<option value=''>---- Select ----</option>";				
				for(i = 0; i < data.length; i++)
				{
					output +="<option value='"+data[i].qSubCategoryId+"'>"+data[i].qSubCategoryName+"</option>";						
				}
				output += "</select>"
							+"<div class='clearfix'></div>"
							+"</div>";	
				alert(output);				
				
				$('#showQSubCategoryList').html(output);
			}
		});			
	}
	else
		alert("Else Part");
}


function showNoOfQuestion()
{
	alert("showQuestionAndSaveModelInfo");
	var output = "<div class='form-group'>"
					+"<label class='option-txt'>Show No of Questions :  </label>"
					+"<input type='text' class='form-option' name='showNoOfQuestion' id='showNoOfQuestion' placeholder='Show No of Questions' onkeyup='showQuestionList(this.value);' required>"
					+"<div class='clearfix'></div>"												
					+"</div>";
	$('#showNoOfQuestion').html(output);
}

/*----------------------------------------------------Select no of Questions-------------------------------------------------- */

function showQuestionList(noOfQuestion)
{
	var modelQuestionType = $('select#modelQuestionType').val();	
	var qSubCategoryId = $('select#qSubCategoryId').val();
	var showNoOfQuestion = $('input#showNoOfQuestion').val();	
	alert("Q Type : "+modelQuestionType+" qCategoryId : "+globalQCategoryId+" qSubCategoryId : "+qSubCategoryId+" showNoOfQuestion : "+showNoOfQuestion);
	
	$.ajax({
			type: "POST",
			url: 'http://localhost:8080/OnlineExamSystem/searchQuestionList',
			data:  ({						
						modelQuestionType : modelQuestionType,
						qCategoryId : globalQCategoryId,
						qSubCategoryId : qSubCategoryId,
						showNoOfQuestion : showNoOfQuestion
					}),
			success: function(data) 
			{				
				alert(data);				
				var output = "<div class='form-group'>"
								+"<label class='option-txt'>Select Questions :  </label>";				
					for(i = 0; i < data.length; i++)
					{					
						if(modelQuestionType == 1)
						{
							output += "<div class='form-group'>"									
										+"<label class='checkbox-inline'><input type='checkbox' name='modelQuestion' id='modelQuestion' value='"+data[i].mcqId+"'/>'"+data[i].mcqQuestion+"'</label>"
									+"</div>";
						}
						else if(modelQuestionType == 2)
						{
							output += "<div class='form-group'>"									
								+"<label class='checkbox-inline' for='checkQId'><input type='checkbox' name='modelQuestion' id='modelQuestion' value='"+data[i].dQuestionId+"'/><p id='"+data[i].dQuestionId+"'>'"+data[i].dQuestion+"'</p></label>"
							+"</div>";
						}
						else
							alert("Fail");
																		
						output += "<div class='clearfix'></div>"
									+"</div>";
					}	
					output += "<span class='clearfix'></span>"	
					+	"<div class='login-footer'>"
					+		"<div class='box-footer clearfix'>"
					+			"<div class='form-group'>"
					+				"<button id='nextButton' class='btn btn-sm btn-default btn-flat pull-right' onclick='addModelQuestion();'>Add Questions</button>"
					+			"</div>"												
					+		"</div>"
					+	"</div>"
				$('#showSearchQuestion').html(output);
			}
		});
}

function addModelQuestion()
{
	alert("In addModelQuestion ");
	var questionId = [];
	var question = [];
	
    $.each($("input[name='modelQuestion']:checked"), function()
    {            
    	questionId.push($(this).val());
    	
       // question.push($(this).next("#checkQId").val());
    	//alert(document.getElementById("checkQId").text);
    	//$("#"+id).next("checkQId").html();
    	alert($(this).val());
    	alert("=h="+document.getElementById($(this).val()).html());
    	//alert("=t="+document.getElementById("checkQId").text);
    });
    alert(questionId);    
    
    //alert("My favourite sports are: " + favorite.join(", "));    
	//var modelQuestion = $('#modelQuestion').val();	
    
	alert("Questions : "+question);
}

function updateModelQSet(modelId)
{
	alert("Model ID : "+modelId);
}

function deleteModelQSet(modelId)
{
	alert("Model ID : "+modelId);
}

/*----------------------------------------------------Save New Model-------------------------------------------------- */

