<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	</head>
	<body>		
		<jsp:include page="adminHomeHeader.jsp"></jsp:include>
			<div id="divReplace">
				<table class="table table-bordered table-hover table-striped">
				<tr>
					<th> Admin Id </th>
					<th> Admin Name </th>				
					<th> Admin Mobile</th>
					<th> Reg Status </th>
				</tr>
				<c:forEach items="${adminBeanList}" var="adminBean">
					<tr>
						<td>${adminBean.adminId}</td>
						<td>${adminBean.adminName}</td>
						<td>${adminBean.adminMobile}</td>														
						<td><a href='#'onclick="activeAdminAccess(${adminBean.adminId});">Active</a></td>
					</tr>
				</c:forEach>
				</table>	
			</div>		
		<jsp:include page="adminHomeFooter.jsp"></jsp:include>
	</body>
</html>