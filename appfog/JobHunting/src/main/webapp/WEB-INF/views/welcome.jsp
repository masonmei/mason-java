<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Job Hunting</title>
<script type="text/javascript" src="<c:url value="/resources/javascript/jquery.tools.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/javascript/menu.js"/>"></script>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/standalone.css"/>">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/login/main.css"/>">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/login/menu.css"/>">

</head>
<body>
	<header>
		<div id="mainview">
			<div id="banner">This is the title</div>

			<nav id="menubar">
				<ul class="menus" id="menus">
					<li class="current-cat"><a title="Home" href="/">Home</a></li>
					<li class="cat-item"><a href="javascript:void(0);">Company</a>
						<ul class="children"
							style="visibility: hidden; position: relative; overflow: hidden; display: block;">
							<li class="cat-item"><a>News</a></li>
							<li class="cat-item"><a>Jobs</a></li>
							<li class="cat-item"><a>Products</a></li>
						</ul></li>
					<li class="cat-item"><a href="javascript:void(0);">Interview</a>
						<ul class="children"
							style="visibility: hidden; position: relative; overflow: hidden; display: block;">
							<li class="cat-item"><a>News</a></li>
							<li class="cat-item"><a>Jobs</a></li>
							<li class="cat-item"><a>Products</a></li>
						</ul></li>
					<li class="cat-item"><a href="javascript:void(0);">Material</a>
						<ul class="children"
							style="visibility: hidden; position: relative; overflow: hidden; display: block;">
							<li class="cat-item"><a>News</a></li>
							<li class="cat-item"><a>Jobs</a></li>
							<li class="cat-item"><a>Products</a></li>
						</ul></li>
					<li class="cat-item"><a href="javascript:void(0);">Offer</a>
						<ul class="children"
							style="visibility: hidden; position: relative; overflow: hidden; display: block;">
							<li class="cat-item"><a>News</a></li>
							<li class="cat-item"><a>Jobs</a></li>
							<li class="cat-item"><a>Products</a></li>
						</ul></li>
				</ul>
			</nav>

			<div style="width: auto; background: blue;"></div>
		</div>
	</header>

	<section>Hello World</section>

	<footer> This is the footer. </footer>
</body>
</html>