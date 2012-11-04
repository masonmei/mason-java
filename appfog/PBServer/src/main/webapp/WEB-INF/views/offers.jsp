<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Job Hunting</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/layout.css"/>">

</head>
<body>
	<div class="content">
		<h3>All Interviews</h3>
		<div class="add">
			<a href='<c:url value="/offer/add"/>'>Add</a>
		</div>
		<div>
			<c:choose>
				<c:when test="${!empty offers}">
					<table class="contenttable">
						<tr>
							<th>Offer Title</th>
							<th>Received Time</th>
							<th>Working Date</th>
							<th>Salary</th>
							<th>Company Name</th>
							<th>Working Place</th>
							<th>Operation</th>
						</tr>
						<c:forEach var="offer" items="${offers }">
							<tr>
								<td hidden="true">${offer.id }</td>
								<td><a href='<c:url value="/offer/view?id=${offer.id }"/>'>${offer.offerName }</a></td>
								<td><fmt:formatDate value="${offer.receivedDate }" pattern="yyyy-MM-dd" type="both"/></td>
								<td><fmt:formatDate value="${offer.workDate }" pattern="yyyy-MM-dd" type="both"/></td>
								<td>${offer.salary }</td>
								<td>${offer.company }</td>
								<td>${offer.workplace }</td>
								<td><a
									href='<c:url value="/offer/delete?id=${offer.id }"/>'>Delete</a></td>
							</tr>
						</c:forEach>
					</table>
				</c:when>
				<c:otherwise>
					<p>No Offers</p>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</body>
</html>