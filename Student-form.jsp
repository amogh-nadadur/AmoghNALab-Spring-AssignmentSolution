<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>

<head>
<style>
.button {
  background-color: #4CAF50; /* Green */
  border: none;
  color: white;
  padding: 6px 15px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}

.buttonBlue {background-color: #008CBA;} /* Blue */

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

<title>Save Student</title>
</head>
<body>
	<div class="container">
		<h3 class="h3">Student Registration For Debate Event</h3>
		<hr>
		<p style="color:black">Enter Student Details</p>
		
		<form action="/StudentRegistration/students/save"
			method="POST">
			<!-- Add hidden form field to handle update -->
			<input type="hidden" name="id" value="${Student.id}" />

			<div class="form-inline">
				<input type="text" name="name" value="${Student.name}"
					class="form-control mb-4 col-4" placeholder="Name">
			</div>
			<div class="form-inline">
				<input type="text" name="department" value="${Student.department}"
					class="form-control mb-4 col-4" placeholder="Department">
			</div>
			<div class="form-inline">
				<input type="text" name="country" value="${Student.country}"
					class="form-control mb-4 col-4" placeholder="Country">
			</div>
			<button type="submit" class="button buttonBlue">Save</button>
		</form>
		<hr>
		<a href="/StudentRegistration/students/list">Back to
			Students List</a>
	</div>
</body>

</html>