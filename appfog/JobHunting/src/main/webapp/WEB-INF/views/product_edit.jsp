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
			<f:form method="post" action="save?companyId=${companyId }" modelAttribute="product">
				<div>
					<div>
						<div>Product Name</div>
						<div>
							<f:input path="productName" />
						</div>
					</div>
					<div>
						<div>Category</div>
						<div>
							<f:select path="productCategory">
								<f:option value="NONE" label="--- Select ---" />
								<f:options items="${categories }"/>
							</f:select>
						</div>
					</div>
					<div>
						<div>Short Description</div>
						<div>
							<f:textarea path="shortDesc" />
						</div>
					</div>
					<div>
						<div>Description</div>
						<div>
							<f:textarea path="description" />
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