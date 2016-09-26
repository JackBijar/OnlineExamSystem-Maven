$(document).ready(function() 
{    
	console.log("Now Your Application is Ready!");	
	$("#myDiv2").hide();
});

function openDivSingIn()
{	
	$("#divCSingIn").show();
	$("#divHome").hide();
	$("#divCSingUp").hide();
}

function openDivSingUp()
{	
	$("#divCSingUp").show();
	$("#divHome").hide();
	$("#divCSingIn").hide();
}

function openMyDiv1()
{
	$("#myDiv2").hide();
	$("#myDiv1").show();
}
function openMyDiv2()
{	
	$("#myDiv1").hide();
	$("#myDiv2").show();
}

function updateCandidate()
{
	alert("Update Candidate Details == '/updateCProfile'");
}

/*function addEQualifications()
{
	var addDiv = "<hr />"
				+"<div class='col-md-12'>"
					+"<div class='col-md-6'>"
						+"<label>Exam</label>"
						+"<div class='form-group input-group'> <span class='input-group-addon'><i class='fa fa-clipboard' aria-hidden='true'></i></i></span>"
						+	"<input type='text' placeholder='Exam' class='form-control' name='cQualification'>"
						+"</div>"
					+"</div>"
					+"<div class='col-md-6'>"
					+	"<label>University</label>"
					+	"<div class='form-group input-group'> <span class='input-group-addon'><i class='fa fa-university' aria-hidden='true'></i></span>"
							+"<input type='text' placeholder='University' class='form-control' name='cQualification'>"
						+"</div>"
					+"</div>"
					+"<div class='col-md-6'>"
						+"<label>Passing year</label>"
						+"<div class='form-group input-group'> <span class='input-group-addon'><i class='fa fa-male' aria-hidden='true'></i></span>"
							+"<input type='text' placeholder='Year' class='form-control' name='cQualification'>"
						+"</div>"
					+"</div>"
					+"<div class='col-md-6'>"
						+"<label>marks</label>"
						+"<div class='form-group input-group'> <span class='input-group-addon'><i class='fa fa-file-o' aria-hidden='true'></i></i></span>"
							+"<input type='text' placeholder='Your Marks (%)' class='form-control' name='cQualification'>"
						+"</div>"
					+"</div>"
				+"</div>"
				+"<div class='clearfix'></div>"
				+"<div id='divAddEduQuali'>" 
					+"<div class='col-xs-6 col-md-6 pull-right'>" 
						+"<button id='buttonAddMore' class='btn btn-sm btn-default btn-flat pull-right' onclick='addEQualifications();'>Add More</button>" 
					+"</div>"
				+"</div>";
	
				$('#divAddEduQuali').html(addDiv);
}*/

