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
		News Of Company
		<c:if test="${not empty company }">${company.companyName }</c:if>
	</h1>

	<div>
		<c:choose>
			<c:when test="${!empty companyNews}">
				<table border="6">

					<tr>
						<th>News Title</th>
						<th>Date</th>
						<th>Description</th>
						<th>Operation</th>
					</tr>

					<c:forEach var="news" items="${companyNews }">
						<tr>
							<td hidden="true">${news.id }</td>
							<td>${news.title }</td>
							<td>${news.date }</td>
							<td>${news.desc }</td>
							<td><a href="news/delete?id=${news.id }">Delete</a></td>
						</tr>
					</c:forEach>

				</table>
			</c:when>
			<c:otherwise>
				<p>No News</p>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>