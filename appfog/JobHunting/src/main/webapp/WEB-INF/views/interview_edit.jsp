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
		<c:when test="${!empty interview}">
			<f:form method="post" action="save" modelAttribute="interview">
				<div>
					<div>
						<div>Interview Name</div>
						<div>
							<f:input path="interviewName" />
						</div>
					</div>
					<div>
						<div>Date</div>
						<div>
							<f:input path="date"/>
						</div>
					</div>
					<div>
						<div>Location</div>
						<div>
							<f:input path="location" />
						</div>
					</div>
					<div>
						<div>Contact Info</div>
						<div>
							<f:input path="contactInfo" />
						</div>
					</div>
					<div>
						<div>Notes</div>
						<div>
							<f:input path="notes" />
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