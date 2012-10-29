<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Job Hunting</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/layout.css"/>">	

</head>
<body><div class="content">
	<h1>All Interviews</h1>
	<div><a href='<c:url value="/interview/add"/>'>Add</a></div>
	<div>
		<c:choose>
			<c:when test="${!empty interviews}">
				<table border="6">
					<tr>
						<th>Interview Title</th>
						<th>Time</th>
						<th>Location</th>
						<th>Note</th>
						<th>Contact Information</th>
						<th>Operation</th>
					</tr>

					<c:forEach var="interview" items="${interviews }">
						<tr>
							<td hidden="true">${interview.id }</td>
							<td><a href='<c:url value="/interview/view?id=${interview.id }"/>'>${interview.interviewName }</a></td>
							<td>${interview.date }</td>
							<td>${interview.location }</td>
							<td>${interview.notes }</td>
							<td>${interview.contactInfo }</td>
							<td><a href='<c:url value="/interview/delete?id=${interview.id }"/>'>Delete</a></td>
						</tr>
					</c:forEach>
				</table>
			</c:when>
			<c:otherwise>
				<p>No Interviews</p>
			</c:otherwise>
		</c:choose>
	</div></div>
</body>
</html>