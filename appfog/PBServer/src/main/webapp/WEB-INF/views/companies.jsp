<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Job Hunting</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/layout.css"/>">
</head>
<body>
	<div class="content">
		<h3>All Companies</h3>
		<div class="add">
			<a href='<c:url value="new"/>'>New</a>
		</div>
		<div>
			<c:choose>
				<c:when test="${!empty companies}">
					<table class="contenttable">
						<tr>
							<th>Company Name</th>
							<th>Province</th>
							<th>City</th>
							<th>Business Type</th>
							<th>Scale</th>
							<th>Operation</th>
						</tr>

						<c:forEach var="com" items="${companies }">
							<tr>
								<td hidden="true">${com.id }</td>
								<td><a href='<c:url value="view?id=${com.id }"/>'>${com.companyName
										}</a></td>
								<td>${com.province }</td>
								<td>${com.city }</td>
								<td>${com.businessType }</td>
								<td>${com.scale }</td>
								<td><a
									href='<c:url value="/web/news/list?companyId=${com.id }"/>'>News</a>&nbsp;<a
									href='<c:url value="/web/product/list?companyId=${com.id }"/>'>Products</a>&nbsp;<a
									href='<c:url value="/web/job/list?companyId=${com.id }"/>'>Jobs</a></td>
							</tr>
						</c:forEach>
					</table>
				</c:when>
				<c:otherwise>
					<p>No Companies</p>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</body>
</html>