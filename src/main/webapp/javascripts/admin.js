$( document ).ready(function() 
{    
	console.log("Now Your Application is Ready!");	
	$("#divAdminSingUp").hide();
});

function openDivAdminSingIn()
{
	$("#divAdminSingIn").show();
	$("#divCSingUp").hide();
	$("#divHome").hide();
	$("#divCSingIn").hide();	
}

function openDivAdminSingUp()
{
	$("#divAdminHome").hide();
	$("#divAdminSingUp").show();
}

/*---------------------------------------------------Active Admin Status-------------------------------------------------------*/

function activeAdminAccess(adminId)
{
	alert(adminId);		
	$.ajax({
		type: "POST",
		url: 'http://localhost:8080/OnlineExamSystem/activeAdminAccess',
		data: ({
					adminId : adminId
			}),
		success: function(data) 
		{
			alert(data);					
			var output="<div id='divReplace'>" 
					+"<br><br><table class='table table-bordered table-hover table-striped'>"
					+"<tr>"
						+"<th> Admin Id </th>"
						+"<th> Admin Name </th>"				
						+"<th> Admin Mobile</th>"
						+"<th> Reg Status </th>"
					+"</tr>";

			for(i = 0; i < data.length; i++)
			{
				output+="<tr>"
							+"<td>" + data[i].adminId + "</td>"
							+"<td>" + data[i].adminName + "</td>"
							+"<td>" + data[i].adminMobile + "</td>"														
							+"<td><a href='#'onclick='activeAdminAccess("+data[i].adminId+");'>Active</a></td>"
						+"</tr>";
			}
			output+="</table></div>";
			alert(output);
			$('#divReplace').html(output);
		},
		error: function(data, status, error) 
		{				
			alert("Data : "+data+"\nStatus : "+status+"\nError : "+error);	        
	    }
	});
}

/*---------------------------------------------------Show Candidate Info-------------------------------------------------------*/

function showCandidateInfo(cId)
{
	alert("CID : "+cId);	
	$.ajax({
		type: "POST",
		url: 'http://localhost:8080/OnlineExamSystem/showCandidateInfo',
		data: ({
					cId : cId
			}),
		success: function(data) 
		{
			alert(data);
			var output="<br><br><table class='table table-bordered table-hover table-striped' id='tableId'>" +
			"<tr>"
				+"<th> Candidate Id </th>"
				+"<th> Name </th>"				
				+"<th> Mobile</th>"
				+"<th> Email </th>"
				+"<th> Date of Birth </th>"
				+"<th> Qualification </th>"
				+ "<th> Skill </th>"
				+"<th> Profile Update </th>"
			+"</tr>";
			
				output+="<tr>"
							+"<td>" + data.cId + "</td>"
							+"<td>" + data.cName + "</td>"
							+"<td>" + data.cMobile + "</td>"	
							+"<td>" + data.cEmail + "</td>"	
							+"<td>" + data.cDob + "</td>"	
							+"<td>" + data.cQualification + "</td>"	
							+"<td>" + data.tempCSkill + "</td>"	
							+"<td><a href='#' onclick='updateCandidateInfo("+data.cId+");'>Profile Update</a></td>"
						+"</tr>";
			
			output+="</table>";
			alert(output);
			$('#page-wrapper').html(output);
		},
		error: function(data, status, error) 
		{				
			alert("Data : "+data+"\nStatus : "+status+"\nError : "+error);	        
		}		
	});	
}


function updateCandidateInfo(cId)
{
	alert("Candidate Id "+cId);
}

/*function adminSingUp()
{
	var dataString = $("#formAdminSingUp").serialize();
	alert("Admin Sing UP");
	$.ajax({
				type: "POST",
				url: 'http://localhost:8080/OnlineExamSystem/aSingUp',
				data: dataString,
				success: function(data) 
				{
						alert(data);				
				}
			});
}*/


