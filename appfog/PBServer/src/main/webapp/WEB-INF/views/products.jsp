<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
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
		<h3>
			Products Of Company
			<c:if test="${not empty company }">${company.companyName }</c:if>
		</h3>

		<div>
			<div class="add">
				<a href='<c:url value="add?companyId=${company.id }"/>'>Add</a>
			</div>
			<c:choose>
				<c:when test="${!empty companyProducts}">
					<table class="contenttable">

						<tr>
							<th>Product Name</th>
							<th>Category</th>
							<th>Description</th>
							<th>Operation</th>
						</tr>

						<c:forEach var="prod" items="${companyProducts }">
							<tr>
								<td hidden="true">${prod.id }</td>
								<td><a href='<c:url value="view?id=${prod.id }"/>'>${prod.productName
										}</a></td>
								<td>${prod.productCategory.categoryName }</td>
								<td>${prod.shortDesc }</td>
								<td><a
									href='<c:url value="delete?id=${prod.id }&companyId=${company.id }"/>'>Delete</a></td>
							</tr>
						</c:forEach>

					</table>
				</c:when>
				<c:otherwise>
					<p>No Products</p>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</body>
</html>