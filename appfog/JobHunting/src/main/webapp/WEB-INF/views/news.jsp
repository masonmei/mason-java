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
		<c:when test="${!empty news}">
			<div>
				<div>
					<div>News Title</div>
					<div>
						<label>${news.title }</label>
					</div>
				</div>
				<div>
					<div>Date</div>
					<div>
						<label>${news.date }</label>
					</div>
				</div>
				<div>
					<div>Description</div>
					<div>
						<label>${news.description }</label>
					</div>
				</div>
				<div>
				
					<div>Content</div>
					<div>
						<label>${news.content }</label>
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