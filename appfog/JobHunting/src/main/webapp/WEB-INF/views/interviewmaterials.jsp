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
	<h1>All Materials</h1>
	<div>
		<c:choose>
			<c:when test="${!empty interviewMaterials}">
				<table border="6">

					<tr>
						<th>Question</th>
						<th>Weight</th>
						<th>Add Date</th>
						<th>Type</th>
						<th>Operation</th>
					</tr>

					<c:forEach var="mat" items="${interviewMaterials }">
						<tr>
							<td hidden="true">${mat.id }</td>
							<td>${mat.question }</td>
							<td>${mat.weight }</td>
							<td>${mat.addDate }</td>
							<td>${mat.type }</td>
							<td><a href='<c:url value="/meterial/answer?id=${mat.id }"/>'>Answer</a></td>
						</tr>
					</c:forEach>
				</table>
			</c:when>
			<c:otherwise>
				<p>No Materials</p>
			</c:otherwise>
		</c:choose>
	</div>

</body>
</html>