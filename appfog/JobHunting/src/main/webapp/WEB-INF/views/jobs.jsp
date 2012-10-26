<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Job Hunting</title>
</head>
<body>
	<h1>
		Jobs Of Company
		<c:if test="${not empty company }">${company }</c:if>
	</h1>

	<div>
		<c:choose>
			<c:when test="${!empty companyJobs}">
				<table border="6">
					<tr>
						<th>Position Title</th>
						<th>Publish Date</th>
						<th>Required Skill</th>
						<th>Operation</th>
					</tr>

					<c:forEach var="job" items="${companyJobs }">
						<tr>
							<td hidden="true">${job.id }</td>
							<td>${job.jobTitle }</td>
							<td>${job.publishDate }</td>
							<td>${job.requiredTech }</td>
							<td><a href="job/delete?id=${job.id }">Delete</a></td>
						</tr>
					</c:forEach>

				</table>
			</c:when>
			<c:otherwise>
				<p>No Jobs</p>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>