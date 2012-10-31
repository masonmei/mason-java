<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
							<span>${job.publishDate }</span>
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
							<span>${job.content }</span>
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