<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Job Hunting</title>
<script type="text/javascript"
	src="<c:url value="/resources/javascript/jquery-1.8.2.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/javascript/jquery-ui-1.9.1.custom.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/javascript/jquery-ui-timepicker.js" />"></script>
<link rel="stylesheet" type="text/css"	href="<c:url value="/resources/javascript/jquery-ui-1.9.1.custom.css"/>">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/layout.css"/>">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/javascript/jquery-ui-timepicker.css"/>">

<link rel="Stylesheet" type="text/css" href='<s:url value="/resources/jHtmlArea/style/jHtmlArea.css"></s:url>' />
<script type="text/javascript" src='<s:url value="/resources/jHtmlArea/scripts/jHtmlArea-0.7.5.js"></s:url>'></script>
	
<script type="text/javascript">
$(function() {  
    $('.bigTextArea').htmlarea();
    $('#datePicker').datetimepicker({dateFormat: 'yy-mm-dd', timeFormat: 'HH:mm'});
});
</script>
</head>
<body>
	<div class="content">
		<c:choose>
			<c:when test="${!empty interview}">
				<f:form method="post" action="save" modelAttribute="interview">
					<div>
						<div>
							<div>Interview Name</div>
							<div>
								<f:input path="interviewName" cssClass="longInput" />
							</div>
						</div>
						<div>
							<div>Date</div>
							<div>
								<f:input path="date" id="datePicker" cssClass="shortInput" />
							</div>
						</div>
						<div>
							<div>Location</div>
							<div>
								<f:input path="location" cssClass="longInput" />
							</div>
						</div>
						<div>
							<div>Contact Info</div>
							<div>
								<f:input path="contactInfo" cssClass="longInput" />
							</div>
						</div>
						<div>
							<div>Notes</div>
							<div>
								<f:textarea path="notes" cssClass="bigTextArea" />
							</div>
						</div>
						<div>
							<input type="submit" value="Save" class="button" />
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
	</div>
</body>
</html>