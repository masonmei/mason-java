<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<title>Job Hunting</title>
</head>
<body>
	<h1>All Companies</h1>
	<div>
		<c:if test="${!empty companies}">
			<table border="6">

				<tr>
					<th>&nbsp;</th>
					<th>Company Name</th>
					<th>Province</th>
					<th>City</th>
					<th>Business Type</th>
					<th>Scale</th>
					<th>&nbsp;</th>
				</tr>

				<c:forEach var="com" items="${companies }">
					<tr>
						<td hidden="true">${com.id }</td>
						<td>${com.companyName }</td>
						<td>${com.provice }</td>
						<td>${com.city }</td>
						<td>${com.businessType }</td>
						<td>${com.scale }</td>
						<td><a >News</a><a>Products</a><a>Jobs</a></td>
					</tr>
				</c:forEach>

			</table>
		</c:if>
	</div>
</body>
</html>