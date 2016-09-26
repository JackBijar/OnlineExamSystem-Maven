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
				<div class="row" id="divDescUpdate">
					<div class="col-lg-12 col-md-12">
						<h2>Show All Descriptive Question </h2>
						<div class="table-responsive" id="showAllDescQuestion">
							<table class="table table-bordered table-hover table-striped" id="tableId">
								<thead>
									<tr>
										<th> Descriptive ID </th>
										<th> Question </th>
										<th> Answer </th>
										<th> Question Marks </th>
										<th> Question Category</th>
										<th> Question Sub Category</th>
										<th> Update </th>
										<th> Delete </th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${descriptiveQBeanList}" var="descriptiveQBean">
										<tr id = "tr_${descriptiveQBean.dQuestionId}">
											<td id="td1">${descriptiveQBean.dQuestionId}</td>
											<td id="td2">${descriptiveQBean.dQuestion}</td>
											<td id="td3">${descriptiveQBean.dQuestionAns}</td>
											<td id="td4">${descriptiveQBean.dQuestionMarks}</td>
											<td id="td5">${descriptiveQBean.qCategoryId}</td>
											<td id="td6">${descriptiveQBean.qSubCategoryId}</td>
											<td id="td7"><a href="#" onclick="updateDescQuestion(${descriptiveQBean.dQuestionId});">Update</a></td>
											<td id="td8"><a href="#" onclick="deleteDescQuestion(${descriptiveQBean.dQuestionId});">Delete</a></td>
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
