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
		<c:if test="${not empty company }">${company.companyName }</c:if>
	</h1>

	<div>
		<div><a href='<c:url value="/product/add?companyId=${company.id }"/>'>Add</a></div>
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
							<td><a href='<c:url value="/product/view?id=${prod.id }"/>'>${prod.productName }</a></td>
							<td>${prod.productCategory.categoryName }</td>
							<td>${prod.shortDesc }</td>
							<td><a href='<c:url value="/product/delete?id=${prod.id }&companyId=${company.id }"/>'>Delete</a></td>
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