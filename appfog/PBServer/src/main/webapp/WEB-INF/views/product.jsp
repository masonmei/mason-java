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
			<c:when test="${!empty product}">
				<div class="contentView">
					<div>
						<div>Product Name</div>
						<div>
							<span>${product.productName }</span>
						</div>
					</div>
					<div>
						<div>Category</div>
						<div>
							<span>${product.productCategory.categoryName }</span>
						</div>
					</div>
					<div>
						<div>Short Description</div>
						<div>
							<span class="shortdescriptionspan">${product.shortDesc }</span>
						</div>
					</div>
					<div>
						<div>Description</div>
						<div>
							<span class="descriptionspan">${product.description }</span>
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