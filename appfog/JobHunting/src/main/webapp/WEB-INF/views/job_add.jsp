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
		<c:when test="${!empty job}">
			<f:form method="post" action="save?companyId=${companyId }" modelAttribute="job">
				<div>
					<div>
						<div>Job Title</div>
						<div>
							<f:input path="jobTitle" />
						</div>
					</div>
					<div>
						<div>Publish Date</div>
						<div>
							<f:input path="publishDate" />
						</div>
					</div>
					<div>
						<div>Require Skills</div>
						<div>
							<f:textarea path="requiredTech" />
						</div>
					</div>
					<div>
						<div>Content</div>
						<div>
							<f:textarea path="content" />
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