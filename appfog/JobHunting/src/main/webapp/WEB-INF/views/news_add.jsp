<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Job Hunting</title>
</head>
<body>
	<c:choose>
		<c:when test="${!empty news}">
			<f:form method="post" action="save?companyId=${companyId }" modelAttribute="news">
				<div>
					<div>
						<div>News Title</div>
						<div>
							<f:input path="title" />
						</div>
					</div>
					<div>
						<div>Date</div>
						<div>
							<f:input path="date" />
						</div>
					</div>
					<div>
						<div>Description</div>
						<div>
							<f:textarea path="description" />
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