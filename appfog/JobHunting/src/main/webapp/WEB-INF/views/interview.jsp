<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Job Hunting</title>
</head>
<body>
	<c:choose>
		<c:when test="${!empty interview}">
			<div>
				<div>
					<div>Interview Name</div>
					<div>
						<label>${interview.interviewName }</label>
					</div>
				</div>
				<div>
					<div>Date</div>
					<div>
						<label>${interview.date }</label>
					</div>
				</div>
				<div>
					<div>Location</div>
					<div>
						<label>${interview.location }</label>
					</div>
				</div>
				<div>
					<div>Contact Info</div>
					<div>
						<label>${interview.contactInfo }</label>
					</div>
				</div>
				<div>
					<div>Notes</div>
					<div>
						<label>${interview.notes }</label>
					</div>
				</div>
			</div>
		</c:when>
		<c:otherwise>
			<div>
				<label>Should Never Come to This</label>
			</div>
		</c:otherwise>
	</c:choose>
</body>
</html>