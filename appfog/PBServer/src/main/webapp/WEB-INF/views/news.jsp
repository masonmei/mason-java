<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
			<c:when test="${!empty news}">
				<div class="contentView">
					<div>
						<div>News Title</div>
						<div>
							<span>${news.title }</span>
						</div>
					</div>
					<div>
						<div>Date</div>
						<div>
							<span><fmt:formatDate value="${news.date }"
									pattern="yyyy-MM-dd" type="both" /></span>
						</div>
					</div>
					<div>
						<div>Description</div>
						<div>
							<span class="shortdescriptionspan">${news.description }</span>
						</div>
					</div>
					<div>

						<div>Content</div>
						<div>
							<span class="descriptionspan">${news.content }</span>
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