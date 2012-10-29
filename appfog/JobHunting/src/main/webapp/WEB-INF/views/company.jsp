<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Job Hunting</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/layout.css"/>">	

</head>
<body>
<div class="content">
	<c:choose>
		<c:when test="${!empty company}">
			<div>
				<div>
					<div>Company</div>
					<div>
						<label>${company.companyName }</label>
					</div>
				</div>
				<div>
					<div>
						<div>Province</div>
						<div>
							<label>${company.provice }</label>
						</div>
					</div>
					<div>
						<div>City</div>
						<div>
							<label>${company.city }</label>
						</div>
					</div>
				</div>
				<div>
					<div>
						<div>Business Type</div>
						<div>
							<label>${company.businessType }</label>
						</div>
					</div>
					<div>
						<div>Scale</div>
						<div>
							<label>${company.scale }</label>
						</div>
					</div>
				</div>
				<div>
					<div>Description</div>
					<div>
						<label>${company.description }</label>
					</div>
				</div>
				<div><a href='<c:url value="/company/edit?id=${company.id }"/>'>Edit</a></div>
			</div>
		</c:when>
		<c:otherwise>
			<div>
				<label>Should Never Come to This</label>
			</div>
		</c:otherwise>
	</c:choose>
	</div>
</body>
</html>