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
		<c:when test="${!empty offer}">
			<f:form method="post" action="save"	modelAttribute="offer">
				<div>
					<div>
						<div>Offer Name</div>
						<div>
							<f:input path="offerName" />
						</div>
					</div>
					<div>
						<div>Received Date</div>
						<div>
							<f:input path="receivedDate" />
						</div>
					</div>
					<div>
						<div>Work Date</div>
						<div>
							<f:input path="workDate" />
						</div>
					</div>
					<div>
						<div>Salary</div>
						<div>
							<f:input path="salary" />
						</div>
					</div>
					<div>
						<div>Salary Description</div>
						<div>
							<f:input path="salaryDescription" />
						</div>
					</div>
					<div>
						<div>Company</div>
						<div>
							<f:input path="company" />
						</div>
					</div>
					<div>
						<div>Working Place</div>
						<div>
							<f:input path="workplace" />
						</div>
					</div>
					<div>
						<div>Note</div>
						<div>
							<f:textarea path="note" />
						</div>
					</div>
					<div>
						<input type="submit" value="Save" />
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