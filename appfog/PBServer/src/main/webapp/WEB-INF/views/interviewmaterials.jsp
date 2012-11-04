<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
		<h3>All Materials</h3>
		<div class="add">
			<a href='<c:url value="/interviewMaterial/add"/>'>Add</a>
		</div>
		<div>
			<c:choose>
				<c:when test="${!empty interviewMaterials}">
					<table class="contenttable">

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
								<td><a
									href='<c:url value="/interviewMaterial/view?id=${mat.id }"/>'>${mat.question
										}</a></td>
								<td>${mat.weight }</td>
								<td><fmt:formatDate value="${mat.addDate }" pattern="yyyy-MM-dd hh:mm" type="both"/></td>
								<td>${mat.type }</td>
								<td><a
									href='<c:url value="/interviewMaterial/answer?id=${mat.id }"/>'>Answer</a></td>
							</tr>
						</c:forEach>
					</table>
				</c:when>
				<c:otherwise>
					<p>No Materials</p>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</body>
</html>