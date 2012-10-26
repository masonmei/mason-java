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
		Products Of Company
		<c:if test="${not empty company }">${company }</c:if>
	</h1>

	<div>
		<c:choose>
			<c:when test="${!empty companyProducts}">
				<table border="6">

					<tr>
						<th>Product Name</th>
						<th>Category</th>
						<th>Description</th>
						<th>Operation</th>
					</tr>

					<c:forEach var="prod" items="${companyProducts }">
						<tr>
							<td hidden="true">${prod.id }</td>
							<td>${prod.productName }</td>
							<td>${prod.productCategory.categoryName }</td>
							<td>${prod.shortDesc }</td>
							<td><a href="/product/delete?id=${prod.id }">Delete</a></td>
						</tr>
					</c:forEach>

				</table>
			</c:when>
			<c:otherwise>
				<p>No Products</p>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>