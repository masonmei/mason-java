<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Job Hunting</title>
</head>
<body>
	<c:choose>
		<c:when test="${!empty interviewMaterial}">
			<f:form method="post" action="save" modelAttribute="interviewMaterial">
				<div>
					<div>
						<div>Question</div>
						<div>
							<f:input path="question" />
						</div>
					</div>
					<div>
						<div>Weight</div>
						<div>
							<f:input path="weight"/>
						</div>
					</div>
					<div>
						<div>Add Date</div>
						<div>
							<f:input path="addDate" />
						</div>
					</div>
					<div>
						<div>Type</div>
						<div>
							<f:input path="type" />
						</div>
					</div>
					<div>
						<div>Answer</div>
						<div>
							<f:input path="answer" />
						</div>
					</div>
					<div>
						<input type="submit" value="Save"/>		
					</div>
				</div>
			</f:form>
		</c:when>
		<c:otherwise>
			<div>
				<label>Should Never Come to This</label>
			</div>
		</c:otherwise>
	</c:choose>
</body>
</html>