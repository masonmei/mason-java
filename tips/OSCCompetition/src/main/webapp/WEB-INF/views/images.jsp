<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href='<c:url value="/resources/css/style.css"/>' />
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.1/jquery.min.js"></script>
<script src='<c:url value="/resources/js/login.js"/>'></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>
<script type="text/javascript">
	function openUploadDialog() {
		$('#upload-popup').dialog({
			width : 300,
			closeOnEscape : false,
			show : "slide"
		});
	}

	function closeUploadDialog() {
		$('#upload-popup').dialog("close");
		;
	}
</script>
</head>
<body>
	<div>
		<c:if test="${!empty categoryId }">
			<div class="category-controllbar">

				<div class="add-btn">
					<a onclick="openUploadDialog();" class="uploadButton"><img
						src='<c:url value="/resources/images/add.png"></c:url>' /></a>
				</div>
				<div class="page-controller">
					<c:if test="${ prePage > 0 }">
						<a
							href='<c:url value="/category/images?page=${prePage }&id=${categoryId }"/>'>Previous</a>
					</c:if>
					<c:if test="${ nextPage > 0 }">
						<a
							href='<c:url value="/category/images?page=${nextPage }&id=${categoryId }"/>'>Next</a>
					</c:if>
				</div>

				<div id="upload-popup">
					<a onclick="closeUploadDialog();" class="closeupload"><img
						src='<c:url value="/resources/images/close_pop.png"/>' /></a>
					<form action='<c:url value="/image/upload"></c:url>' method="post"
						enctype="multipart/form-data">
						<fieldset>
							<input type="hidden" name="cid" value="${categoryId}" /> <input
								type="file" name="uploadFile" /> <input type="submit"
								value="Upload" />
						</fieldset>
					</form>
				</div>
			</div>
		</c:if>
		<div class="gallay">
			<c:if test="${!empty images}">
				<c:forEach var="img" items="${images }">
					<a href='<c:url value="/image/original?id=${img.id }"/>'><img
						src="<c:url value="/image/thumbnail?id=${img.id }"/>"></a>
				</c:forEach>
			</c:if>
		</div>
		<script src="<c:url value="/resources/js/main.js"/>"></script>
		<c:if test="${!empty categoryId }">
			<div class="category-controllbar">
				<div class="page-controller">
					<c:if test="${ prePage > 0 }">
						<a
							href='<c:url value="/category/images?page=${prePage }&id=${categoryId }"/>'>Previous</a>
					</c:if>
					<c:if test="${ nextPage > 0 }">
						<a
							href='<c:url value="/category/images?page=${nextPage }&id=${categoryId }"/>'>Next</a>
					</c:if>
				</div>
			</div>
		</c:if>
	</div>


</body>
</html>