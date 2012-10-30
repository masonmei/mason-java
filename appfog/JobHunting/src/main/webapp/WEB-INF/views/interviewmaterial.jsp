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
		<c:when test="${!empty interviewMaterial}">
			<div class="contentView">
				<div>
					<div>Question</div>
					<div>
						<label>${interviewMaterial.question }</label>
					</div>
				</div>
				<div>
					<div>Weight</div>
					<div>
						<label>${interviewMaterial.weight }</label>
					</div>
				</div>
				<div>
					<div>Add Date</div>
					<div>
						<label>${interviewMaterial.addDate }</label>
					</div>
				</div>
				<div>
					<div>Type</div>
					<div>
						<label>${interviewMaterial.type }</label>
					</div>
				</div>
				<div>
					<div>Answer</div>
					<div>
						<label>${interviewMaterial.answer }</label>
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