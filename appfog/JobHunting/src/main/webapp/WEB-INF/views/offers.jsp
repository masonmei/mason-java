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
	<div><a href='<c:url value="/offer/add"/>'>Add</a></div>
	<div>
		<c:choose>
			<c:when test="${!empty offers}">
				<table border="6">
					<tr>
						<th>Offer Title</th>
						<th>Received Time</th>
						<th>Working Date</th>
						<th>Salary</th>
						<th>Company Name</th>
						<th>Working Place</th>
						<th>Salary Desc</th>
						<th>note</th>
						<th>Operation</th>
					</tr>
					<c:forEach var="offer" items="${offers }">
						<tr>
							<td hidden="true">${offer.id }</td>
							<td>${offer.offerName }</td>
							<td>${offer.receivedDate }</td>
							<td>${offer.workDate }</td>
							<td>${offer.salary }</td>
							<td>${offer.company }</td>
							<td>${offer.workplace }</td>
							<td>${offer.salaryDescription }</td>
							<td>${offer.note }</td>
							<td><a href='<c:url value="/offer/delete?id=${offer.id }"/>'>Delete</a></td>
						</tr>
					</c:forEach>
				</table>
			</c:when>
			<c:otherwise>
				<p>No Offers</p>
			</c:otherwise>
		</c:choose></div>
	</div>
</body>
</html>