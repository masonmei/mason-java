<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Job Hunting</title>
</head>
<body background="#000000">
	<h1>All Companies</h1>
	<div>
		<table border="6">
			<thead>
				<tr>
					<td></td>
					<td>Company Name</td>
					<td>Province</td>
					<td>City</td>
					<td>Business Type</td>
					<td>Scale</td>
					<td />
				</tr>
			</thead>
			<tbody>
				<c:forEach var="com" items="${companies }">
					<tr>
						<td hidden="true">${com.id }</td>
						<td>${com.companyName }</td>
						<td>${com.provice }</td>
						<td>${com.city }</td>
						<td>${com.businessType }</td>
						<td>${com.scale }</td>
						<td><a>News</a><a>Products</a><a>Jobs</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>