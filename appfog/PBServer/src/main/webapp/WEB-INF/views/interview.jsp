<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
		<c:choose>
			<c:when test="${!empty interview}">
				<div class="contentView">
					<div>
						<div>Interview Name</div>
						<div>
							<span>${interview.interviewName }</span>
						</div>
					</div>
					<div>
						<div>Date</div>
						<div>
							<span><fmt:formatDate value="${interview.date }"
									pattern="yyyy-MM-dd HH:mm" type="both" /></span>
						</div>
					</div>
					<div>
						<div>Location</div>
						<div>
							<span>${interview.location }</span>
						</div>
					</div>
					<div>
						<div>Contact Info</div>
						<div>
							<span>${interview.contactInfo }</span>
						</div>
					</div>
					<div>
						<div>Notes</div>
						<div>
							<span class="descriptionspan">${interview.notes }</span>
						</div>
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