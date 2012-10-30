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
<body><div class="content">
	<c:choose>
		<c:when test="${!empty job}">
			<div class="contentView">
				<div>
					<div>Job Title</div>
					<div>
						<label>${job.jobTitle }</label>
					</div>
				</div>
				<div>
					<div>Publish Date</div>
					<div>
						<label>${job.publishDate }</label>
					</div>
				</div>
				<div>
					<div>Request Skill</div>
					<div>
						<label>${job.requiredTech }</label>
					</div>
				</div>
				<div>
					<div>Content</div>
					<div>
						<label>${job.content }</label>
					</div>
				</div>
			</div>
		</c:when>
		<c:otherwise>
			<div>
				<label>Should Never Come to This</label>
			</div>
		</c:otherwise>
	</c:choose></div>
</body>
</html>