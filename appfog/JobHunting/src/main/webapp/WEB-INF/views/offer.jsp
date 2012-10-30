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
		<c:when test="${!empty offer}">
			<div class="contentView">
				<div>
					<div>Offer Name</div>
					<div>
						<label>${offer.offerName }</label>
					</div>
				</div>
				<div>
					<div>Received Date</div>
					<div>
						<label>${offer.receivedDate }</label>
					</div>
				</div>
				<div>
					<div>Work Date</div>
					<div>
						<label>${offer.workDate }</label>
					</div>
				</div>
				<div>
					<div>Salary</div>
					<div>
						<label>${offer.salary }</label>
					</div>
				</div>
				<div>
					<div>Salary Description</div>
					<div>
						<label>${offer.salaryDescription }</label>
					</div>
				</div>
				<div>
					<div>Company</div>
					<div>
						<label>${offer.company }</label>
					</div>
				</div>
				<div>
					<div>Working Place</div>
					<div>
						<label>${offer.workplace }</label>
					</div>
				</div>
				<div>
					<div>Note</div>
					<div>
						<label>${offer.note }</label>
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