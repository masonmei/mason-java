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

<script type="text/javascript">
$(function() {  
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
			<c:when test="${!empty interviewMaterial}">
				<f:form method="post" action="save"	modelAttribute="interviewMaterial">
					<div>
						<div>
							<div>Question</div>
							<div>
								<f:input path="question" cssClass="longInput" />
							</div>
						</div>
						<div>
							<div>Weight</div>
							<div>
								<f:input path="weight" cssClass="shortInput" />
							</div>
						</div>
						<div>
							<div>Add Date</div>
							<div>
								<f:input path="addDate" id="datePicker" cssClass="shortInput" />
							</div>
						</div>
						<div>
							<div>Type</div>
							<div>
								<f:input path="type" cssClass="shortInput" />
							</div>
						</div>
						<div>
							<div>Answer</div>
							<div>
								<f:textarea path="answer" cssClass="bigTextArea" />
							</div>
						</div>
						<div>
							<input type="submit" value="Save" class="button"/>
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