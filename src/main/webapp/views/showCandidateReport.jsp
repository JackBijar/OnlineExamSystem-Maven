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
				<div class="row">
					<div class="col-lg-12 col-md-12">
						<h2>Candidate Report </h2>
						<div class="table-responsive" id="showAllDescQuestion">
							<table class="table table-bordered table-hover table-striped">
								<thead>
									<tr>
										<th> Report ID </th>
										<th> Candidate ID </th>
										<th> MCQ Result </th>
										<th> Descriptive Result </th>
										<th> Total </th>
										<th> Grade </th>
										<th> Show Profile </th>										
										<th> Delete Candidate </th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${examReportBeanList}" var="examReportBean">
										<tr>
											<td>${examReportBean.reportId}.</td>
											<td>${examReportBean.cId}</td>
											<td>${examReportBean.mcqResult}</td>
											<td>${examReportBean.descResult}</td>
											<td>${examReportBean.total}</td>
											<td>${examReportBean.grade}</td>
											<td><a href="#" onclick="showCandidateInfo(${examReportBean.cId});">Show Profile</a></td>											
											<td><a href="#" onclick="deleteCandidateInfo(${examReportBean.cId});">Delete Candidate</a></td>
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
