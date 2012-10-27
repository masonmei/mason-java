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
		<c:when test="${!empty product}">
			<div>
				<div>
					<div>Product Name</div>
					<div>
						<label>${product.productName }</label>
					</div>
				</div>
				<div>
					<div>Category</div>
					<div>
						<label>${product.productCategory.categoryName }</label>
					</div>
				</div>
				<div>
					<div>Short Description</div>
					<div>
						<label>${product.shortDesc }</label>
					</div>
				</div>
				<div>
					<div>Description</div>
					<div>
						<label>${product.description }</label>
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