<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<div>
		<div class="category">
			<c:if test="${!empty categoryId }">
				<div>
					<a href="#"><img
						src='<c:url value="/resources/images/add.png"></c:url>' /></a>
				</div>
				<div>
					<c:if test="${ prePage > 0 }">
						<a
							href='<c:url value="/category/images?page=${prePage }&id=${categoryId }"/>'>Previous</a>
					</c:if>
					<c:if test="${ nextPage > 0 }">
						<a
							href='<c:url value="/category/images?page=${nextPage }&id=${categoryId }"/>'>Next</a>
					</c:if>
				</div>

				<div class="login-popup">
					<form action='<c:url value="/image/upload"></c:url>' method="post"
						enctype="multipart/form-data">
						<fieldset>
							<input type="file" name="uploadFile" /> <input type="submit"
								value="Upload" />
						</fieldset>
					</form>
				</div>
			</c:if>
		</div>
		<div class="gallery">
			<c:if test="${!empty images}">
				<c:forEach var="img" items="${images }">
					<a href='<c:url value="/image/original?id=${img.id }"/>'><img
						src="<c:url value="/image/thumbnail?id=${img.id }"/>"></a>
				</c:forEach>
			</c:if>
		</div>
		<script src="<c:url value="/resources/js/main.js"/>"></script>
		<c:if test="${!empty categoryId }">
			<div class="category">
				<c:if test="${ prePage > 0 }">
					<a
						href='<c:url value="/category/images?page=${prePage }&id=${categoryId }"/>'>Previous</a>
				</c:if>
				<c:if test="${ nextPage > 0 }">
					<a
						href='<c:url value="/category/images?page=${nextPage }&id=${categoryId }"/>'>Next</a>
				</c:if>
			</div>
		</c:if>
	</div>


</body>
</html>