<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Job Hunting</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/layout.css"/>">

</head>
<body>
	<div class="content">
		<h3>All Interviews</h3>
		<div class="add">
			<a href='<c:url value="add"/>'>Add</a>
		</div>
		<div>
			<c:choose>
				<c:when test="${!empty interviews}">
					<table class="contenttable">
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
								<td><a
									href='<c:url value="view?id=${interview.id }"/>'>${interview.interviewName
										}</a></td>
								<td><fmt:formatDate value="${interview.date }"
										pattern="yyyy-MM-dd HH:mm" type="both" /></td>
								<td>${interview.location }</td>
								<td>${interview.notes }</td>
								<td>${interview.contactInfo }</td>
								<td><a
									href='<c:url value="delete?id=${interview.id }"/>'>Delete</a></td>
							</tr>
						</c:forEach>
					</table>
				</c:when>
				<c:otherwise>
					<p>No Interviews</p>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</body>
</html>