<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<style>

.button {
	border: 2px;
	color: white;
	padding: 5px 12px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 13px;
	margin: 5px 3px;
	cursor: pointer;

}
 
.buttonGreen {
background-color: #4CAF50;
} /* Blue */
.buttonRed {
	background-color: #f44336;
} /* Red */
.buttonBlack {
	background-color: #555555;
} /* Black */

</style>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<title>Students Directory</title>
</head>
<body>

	<div class="container">
		<h3 class="h3">Student Registration For Debate Event</h3>
		<hr>




				<!-- Add a button -->
				<a href="/StudentRegistration/students/addStudent"
					class="btn btn-primary btn-sm mb-3"> Add Student </a> 
					
				
					

					<a href="/StudentRegistration/logout" 
					class="btn btn-primary btn-sm mb-3 mx-auto"> Logout </a> 

	

		<table class="table table-bordered">
			<thead >
				<tr>
					<th>Student Id</th>
				    <th>Name</th>
					<th>Department</th>
					<th>Country</th>
					<th>Action</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${Students}" var="tempStudent">
					<tr>
											<td><c:out value="${tempStudent.id}" /></td>
					
						<td><c:out value="${tempStudent.name}" /></td>
						<td><c:out value="${tempStudent.department}" /></td>
						<td><c:out value="${tempStudent.country}" /></td>
						<td>
				
							<!-- Add "update" button/link --> <a
							href="/StudentRegistration/students/updateStudent?student_id=${tempStudent.id}"
							> Update</a> <!-- Add "delete" button/link -->
							<a
							href="/StudentRegistration/students/delete?student_id=${tempStudent.id}"
							
							onclick="if (!(confirm('Are you sure you want to delete this Student?'))) return false">
								Delete </a>
						</td>

					</tr>
				</c:forEach>

			</tbody>
		</table>

	</div>

</body>
</html>


