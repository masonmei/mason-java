<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<head>
<meta charset="utf-8" />
<title>Favorite Photo Gallge</title>
<link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet"
	type="text/css" />
</head>
<body>
	<header tabindex="0">
		<div>
			<div>
				<form action="<c:url value="/account/login"/>" method="post">
				</form>
			</div>
			<div>
				<button>Logout</button>
			</div>
		</div>
		<h2>HTML5 Drag and Drop - sorting photos between albums</h2>
	</header>

	<div class="albums">
		<div class="album" id="drop_1" droppable="true">
			<h2>Album 1</h2>
		</div>
		<div class="album" id="drop_2" droppable="true">
			<h2>Album 1</h2>
		</div>
		<div class="album" id="drop_3" droppable="true">
			<h2>Album 3</h2>
		</div>
	</div>
	<div style="clear: both"></div>
	<div class="gallery">
		<a id="1" draggable="true"><img
			src="<c:url value="/resources/images/1.jpg"/>"></a> <a id="2"
			draggable="true"><img
			src="<c:url value="/resources/images/2.jpg"/>"></a> <a id="3"
			draggable="true"><img
			src="<c:url value="/resources/images/3.jpg"/>"></a> <a id="4"
			draggable="true"><img
			src="<c:url value="/resources/images/4.jpg"/>"></a> <a id="5"
			draggable="true"><img
			src="<c:url value="/resources/images/5.jpg"/>"></a> <a id="6"
			draggable="true"><img
			src="<c:url value="/resources/images/6.jpg"/>"></a> <a id="7"
			draggable="true"><img
			src="<c:url value="/resources/images/7.jpg"/>"></a> <a id="8"
			draggable="true"><img
			src="<c:url value="/resources/images/8.jpg"/>"></a> <a id="9"
			draggable="true"><img
			src="<c:url value="/resources/images/9.jpg"/>"></a> <a id="10"
			draggable="true"><img
			src="<c:url value="/resources/images/10.jpg"/>"></a> <a id="11"
			draggable="true"><img
			src="<c:url value="/resources/images/11.jpg"/>"></a> <a id="12"
			draggable="true"><img
			src="<c:url value="/resources/images/12.jpg"/>"></a>


		<c:if test="${!empty images}">
			<c:forEach var="img" items="${images }">
				<a id="1" draggable="true"><img
					src="<c:url value="/image/thumbnail?id=${img.id }"/>"></a>
			</c:forEach>
		</c:if>
	</div>
	<script src="<c:url value="/resources/js/main.js"/>"></script>

	<div>
		<form action='<c:url value="/image/upload"></c:url>' method="post"
			enctype="multipart/form-data">
			<fieldset>
				<input type="file" name="uploadFile" /> <input type="submit"
					value="Upload" />
			</fieldset>
		</form>
	</div>
</body>
</html>