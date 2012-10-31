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
							<span>${interview.date }</span>
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
							<span>${interview.notes }</span>
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