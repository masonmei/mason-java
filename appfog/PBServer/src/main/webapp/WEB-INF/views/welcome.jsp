<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Job Hunting</title>
<script type="text/javascript"
	src="<c:url value="/resources/javascript/jquery.tools.min.js"/>"></script>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/frame.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/menu/menu.css"/>">

</head>
<body id="framebody">
	<header>
		<div id="banner">
			<img src='<c:url value="/resources/images/sunset.jpg"></c:url>'>
		</div>
	</header>

	<nav>
		<div class="container">
			<ul id="nav">
				<li><a href="welcome">Home</a></li>
				<li><a class="hsubs" href="company/list" target="iframe">Company</a>
					<ul class="subs">
						<li><a href="#">News</a></li>
						<li><a href="#">Jobs</a></li>
						<li><a href="#">Products</a></li>
					</ul></li>
				<li><a class="hsubs" href="interview/list" target="iframe">Interview</a></li>
				<li><a class="hsubs" href="interviewMaterial/list"
					target="iframe">Material</a></li>
				<li><a class="hsubs" href="offer/list" target="iframe">Offer</a></li>
				<div id="lavalamp"></div>
			</ul>
		</div>
	</nav>
	<section>
		<iframe name="iframe" id="frame" width="100%" height="100%"
			src='<s:url value="/company/list"/>' frameborder="0" scrolling="no"></iframe>
	</section>
	<footer> This is the footer. </footer>
</body>
</html>