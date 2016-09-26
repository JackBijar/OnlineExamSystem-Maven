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
				<div class="row" id="divshowDescQuestion">
					<div class="col-lg-12 col-md-12">
						<h2>Uncheck Candidate Details </h2>
						<div class="table-responsive">
							<table class="table table-bordered table-hover table-striped">
								<thead>
									<tr>
										<th> Candidate ID </th>
										<th> Report ID </th>
										<th> MCQ Marks </th>
										<th> Check Answer </th>										
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${examReportBeanList}" var="examReportBean">
										<tr>
											<td>${examReportBean.cId}</td>
											<td>${examReportBean.reportId}</td>
											<td>${examReportBean.mcqResult}</td>
											<td><a href="#" onclick="checkAns(${examReportBean.reportId});">Check</a></td>											
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
