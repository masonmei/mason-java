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
		<c:when test="${!empty material}">
			<div>
				<div>
					<div>Question</div>
					<div>
						<label>${material.question }</label>
					</div>
				</div>
				<div>
					<div>Weight</div>
					<div>
						<label>${material.weight }</label>
					</div>
				</div>
				<div>
					<div>Add Date</div>
					<div>
						<label>${material.addDate }</label>
					</div>
				</div>
				<div>
					<div>Type</div>
					<div>
						<label>${material.type }</label>
					</div>
				</div>
				<div>
					<div>Answer</div>
					<div>
						<label>${material.answer }</label>
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