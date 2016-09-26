<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

	<head>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	</head>
	<body> 
		<jsp:include page="adminHomeHeader.jsp"></jsp:include>
		<div id="page-wrapper">
			<div class="container-fluid">
				<div class="row" id="divCategoryUpdate">
					<div class="col-lg-12 col-md-12">
						<h2>Show Model Question Set</h2>
						<div class="table-responsive" id="showQuestionCategory">
							<table class="table table-bordered table-hover table-striped" id="tableId">
								<thead>
									<tr>
										<th> Model Id </th>
										<th> Model Name</th>
										<th> Total Question</th>
										<th> Examination Time </th>
										<th> Model Description</th>
										<th> Model Question Type</th>	
										<th> Model Question Ids </th>									
										<th> Update </th>
										<th> Delete </th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${questionModelBeanList}" var="questionModelBean">
										<tr id = "tr_${questionModelBean.modelId}">
											<td id="td1">${questionModelBean.modelId}</td>
											<td id="td2">${questionModelBean.modelName}</td>
											<td id="td3">${questionModelBean.totalQuestion}</td>
											<td id="td4">${questionModelBean.examTime}</td>
											<td id="td5">${questionModelBean.modelDescription}</td>
											<td id="td6">${questionModelBean.modelQuestionType}</td>
											<td id="td7">${questionModelBean.modelQuestion}</td>
											<td id="td8"><a href="#" onclick="updateModelQSet(${questionModelBean.modelId});">Update</a></td>
											<td id="td9"><a href="#" onclick="deleteModelQSet(${questionModelBean.modelId});">Delete</a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
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
