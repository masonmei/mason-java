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
		<h3>
			News Of Company
			<c:if test="${not empty company }">${company.companyName }</c:if>
		</h3>
		<div class="add">
			<a href='<c:url value="/news/add?companyId=${company.id }"/>'>Add</a>
		</div>
		<div>
			<c:choose>
				<c:when test="${!empty companyNews}">
					<table class="contenttable">

						<tr>
							<th>News Title</th>
							<th>Date</th>
							<th>Description</th>
							<th>Operation</th>
						</tr>

						<c:forEach var="news" items="${companyNews }">
							<tr>
								<td hidden="true">${news.id }</td>
								<td><a href='<c:url value="/news/view?id=${news.id }"/>'>${news.title
										}</a></td>
								<td><fmt:formatDate value="${news.date }"
										pattern="yyyy-MM-dd" type="both" /></td>
								<td>${news.description }</td>
								<td><a
									href='<c:url value="/news/delete?id=${news.id }&companyId=${company.id }"/>'>Delete</a></td>
							</tr>
						</c:forEach>

					</table>
				</c:when>
				<c:otherwise>
					<p>No News</p>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</body>
</html>