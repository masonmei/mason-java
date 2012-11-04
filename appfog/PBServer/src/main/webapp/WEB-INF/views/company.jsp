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
				<div class="contentView">
					<div>
						<div>Company</div>
						<div>
							<span>${company.companyName }</span>
						</div>
					</div>
					<div>
						<c:if test="${!empty labels}">
							<div>Labels</div>
							<div>
								<c:forEach var="label" items="${labels }">
									<label class="companyLabel">${label.labelName }</label>
								</c:forEach>
							</div>
						</c:if>
					</div>
					<div>
						<div>
							<div>Province</div>
							<div>
								<span>${company.province }</span>
							</div>
						</div>
						<div>
							<div>City</div>
							<div>
								<span>${company.city }</span>
							</div>
						</div>
					</div>
					<div>
						<div>
							<div>Business Type</div>
							<div>
								<span>${company.businessType }</span>
							</div>
						</div>
						<div>
							<div>Scale</div>
							<div>
								<span>${company.scale }</span>
							</div>
						</div>
					</div>
					<div>
						<div>Description</div>
						<div>
							<span class="descriptionspan">${company.description }</span>
						</div>
					</div>
					<div>
						<a href='<c:url value="/company/edit?id=${company.id }"/>'>Edit</a>
					</div>
				</div>
			</c:when>
			<c:otherwise>
				<div>
					<span>Should Never Come to This</span>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>