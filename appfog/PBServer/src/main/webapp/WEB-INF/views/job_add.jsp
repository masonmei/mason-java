<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Job Hunting</title>
<script type="text/javascript"
	src="<c:url value="/resources/javascript/jquery-1.8.2.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/javascript/jquery-ui-1.9.1.custom.js" />"></script>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/javascript/jquery-ui-1.9.1.custom.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/layout.css"/>">
		
<link rel="Stylesheet" type="text/css" href='<s:url value="/resources/jHtmlArea/style/jHtmlArea.css"></s:url>' />
<script type="text/javascript" src='<s:url value="/resources/jHtmlArea/scripts/jHtmlArea-0.7.5.js"></s:url>'></script>
	
<script type="text/javascript">
$(function() {  
    $('.textEditor').htmlarea();
    $('#datePicker').datepicker({  
    	dateFormat: 'yy-mm-dd',
        duration: '',  
        showTime: true,  
        constrainInput: false,  
        stepMinutes: 1,  
        stepHours: 1,  
        altTimeField: '',  
        time24h: false,
        changeYear: true,
        changeMonth: true,
        currentText: "Now"
     });  
});
</script>
</head>
<body>
	<div class="content">
		<c:choose>
			<c:when test="${!empty job}">
				<f:form method="post" action="save?companyId=${companyId }"
					modelAttribute="job">
					<div>
						<div>
							<div>Job Title</div>
							<div>
								<f:input path="jobTitle" cssClass="longInput" />
							</div>
						</div>
						<div>
							<div>Publish Date</div>
							<div>
								<f:input path="publishDate" id="datePicker"
									cssClass="shortInput" />
							</div>
						</div>
						<div>
							<div>Require Skills</div>
							<div>
								<f:textarea path="requiredTech" cssClass="textArea" class="textArea"/>
							</div>
						</div>
						<div>
							<div>Content</div>
							<div>
								<f:textarea path="content" cssClass="bigTextArea" class="textArea"/>
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