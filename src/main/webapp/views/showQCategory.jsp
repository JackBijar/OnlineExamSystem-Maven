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
						<h2>Show Question Categories</h2>
						<div class="table-responsive" id="showQuestionCategory">
							<table class="table table-bordered table-hover table-striped" id="tableId">
								<thead>
									<tr>
										<th> Question Category Id </th>
										<th> Question Category Name</th>
										<th> Question Category Description</th>										
										<th> Update </th>
										<th> Delete </th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${questionCategoryBeanList}" var="questionCategoryBean">
										<tr id = "tr_${questionCategoryBean.qCategoryId}">
											<td id="td1">${questionCategoryBean.qCategoryId}</td>
											<td id="td2">${questionCategoryBean.qCategoryName}</td>
											<td id="td3">${questionCategoryBean.qCategoryDescription}</td>
											<td id="td4"><a href="#" onclick="updateQCategory(${questionCategoryBean.qCategoryId});">Update</a></td>
											<td id="td5"><a href="#" onclick="deleteQCategory(${questionCategoryBean.qCategoryId});">Delete</a></td>
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
