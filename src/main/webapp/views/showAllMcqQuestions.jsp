<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	</head>
	<body>
		<jsp:include page="adminHomeHeader.jsp"></jsp:include>
        <div id="page-wrapper">
            <div class="container-fluid">
				<div class="row" id="divMcqUpdate">
                    <div class="col-lg-12 col-md-12">
                        <h2>Show All MCQ Question</h2>
                        <div class="table-responsive" id="divShowAllMcq">
                            <table class="table table-bordered table-hover table-striped" id="tableId">
                                <thead>
                                    <tr>
                                        <th>MCQ ID</th>
                                        <th> Question </th>
                                        <th> Option 1 </th>
                                        <th> Option 2 </th>
                                        <th> Option 3 </th>
                                        <th> Option 4 </th>
                                        <th> Correct ID </th>
                                        <th> Correct Answer </th>
                                        <th> Answer Description </th>
                                        <th> Category ID </th>
                                        <th> Sub Category ID </th>
                                        <th>Update</th>
                                        <th>Delete</th>
                                    </tr>
                                </thead>
                                <tbody>
									<c:forEach items="${mcqBeanList}" var="mcqBean">									
										<tr id="tr_${mcqBean.mcqId}">
											<td id="td1">${mcqBean.mcqId}</td>
											<td id="td2">${mcqBean.mcqQuestion}</td>
											<td id="td3">${mcqBean.mcqAns1}</td>
											<td id="td4">${mcqBean.mcqAns2}</td>
											<td id="td5">${mcqBean.mcqAns3}</td>
											<td id="td6">${mcqBean.mcqAns4}</td>
											<td id="td7">${mcqBean.mcqCorrectId}</td>
											<td id="td8">${mcqBean.mcqCorrectAns}</td>
											<td id="td9">${mcqBean.mcqAnsDescription}</td>
											<td id="td10">${mcqBean.qCategoryId}</td>
											<td id="td10">${mcqBean.qSubCategoryId}</td>
											<td id="td11"><a href="#" onclick="updateMcqQuestion(${mcqBean.mcqId});"> Update </a></td>
											<td id="td12"><a href="#" onclick="deleteMcqQuestion(${mcqBean.mcqId});"> Delete </a></td>
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
