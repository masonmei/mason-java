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
    $('.shortDisableInput').datepicker({  
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
    $('#textEditor').htmlarea();
});
</script>
</head>
<body>
	<div class="content">
		<c:choose>
			<c:when test="${!empty offer}">
				<f:form method="post" action="save" modelAttribute="offer">
					<div>
						<div>
							<div>Offer Name</div>
							<div>
								<f:input path="offerName" cssClass="longInput" />
							</div>
						</div>
						<div>
							<div>Received Date</div>
							<div>
								<f:input path="receivedDate" cssClass="shortDisableInput"
									disabled="disabled" />
							</div>
						</div>
						<div>
							<div>Work Date</div>
							<div>
								<f:input path="workDate" cssClass="shortDisableInput" />
							</div>
						</div>
						<div>
							<div>Salary</div>
							<div>
								<f:input path="salary" cssClass="shortInput" />
							</div>
						</div>
						<div>
							<div>Salary Description</div>
							<div>
								<f:input path="salaryDescription" cssClass="longInput" />
							</div>
						</div>
						<div>
							<div>Company</div>
							<div>
								<f:input path="company" cssClass="longInput" />
							</div>
						</div>
						<div>
							<div>Working Place</div>
							<div>
								<f:input path="workplace" cssClass="longInput" />
							</div>
						</div>
						<div>
							<div>Note</div>
							<div>
								<f:textarea path="note" cssClass="bigTextArea" id='textEditor'/>
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