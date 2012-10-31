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
			<c:when test="${!empty offer}">
				<div class="contentView">
					<div>
						<div>Offer Name</div>
						<div>
							<span>${offer.offerName }</span>
						</div>
					</div>
					<div>
						<div>Received Date</div>
						<div>
							<span>${offer.receivedDate }</span>
						</div>
					</div>
					<div>
						<div>Work Date</div>
						<div>
							<span>${offer.workDate }</span>
						</div>
					</div>
					<div>
						<div>Salary</div>
						<div>
							<span>${offer.salary }</span>
						</div>
					</div>
					<div>
						<div>Salary Description</div>
						<div>
							<span>${offer.salaryDescription }</span>
						</div>
					</div>
					<div>
						<div>Company</div>
						<div>
							<span>${offer.company }</span>
						</div>
					</div>
					<div>
						<div>Working Place</div>
						<div>
							<span>${offer.workplace }</span>
						</div>
					</div>
					<div>
						<div>Note</div>
						<div>
							<span>${offer.note }</span>
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