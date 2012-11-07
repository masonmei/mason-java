<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
							<span><fmt:formatDate value="${offer.receivedDate }"
									pattern="yyyy-MM-dd" type="both" /></span>
						</div>
					</div>
					<div>
						<div>Work Date</div>
						<div>
							<span><fmt:formatDate value="${offer.workDate }"
									pattern="yyyy-MM-dd" type="both" /></span>
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
							<span class="shortdescriptionspan">${offer.salaryDescription
								}</span>
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
							<span class="descriptionspan">${offer.note }</span>
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