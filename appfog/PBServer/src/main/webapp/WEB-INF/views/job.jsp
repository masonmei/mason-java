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
			<c:when test="${!empty job}">
				<div class="contentView">
					<div>
						<div>Job Title</div>
						<div>
							<span>${job.jobTitle }</span>
						</div>
					</div>
					<div>
						<div>Publish Date</div>
						<div>
							<span><fmt:formatDate value="${job.publishDate }"
									pattern="yyyy-MM-dd" type="both" /></span>
						</div>
					</div>
					<div>
						<div>Request Skill</div>
						<div>
							<span>${job.requiredTech }</span>
						</div>
					</div>
					<div>
						<div>Content</div>
						<div>
							<span class="descriptionspan">${job.content }</span>
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