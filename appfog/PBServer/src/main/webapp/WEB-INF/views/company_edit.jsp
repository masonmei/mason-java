<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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

<title>Job Hunting</title>

<c:url var="findProvinces" value="provinces" />
<c:url var="findCities" value="cities" />
<c:url var="listLabels" value="/web/label/list" />
<c:url var="addLabel" value="label/add" />

<script type="text/javascript">
    $(document).ready(function() {
        $('.bigTextArea').htmlarea();
        $('#province').change(function() {
            $('input#provinceName').val($(this).val());
            $('input#cityName').val("");
            $.getJSON('${findCities}', {
                provinceName : $(this).val(),
                ajax : 'true'
            }, function(data) {
                var html = '<option value="">Select City</option>';
                var len = data.length;
                for ( var i = 0; i < len; i++) {
                    html += '<option value="' + data[i] + '">' + data[i] + '</option>';
                }
                $('#city').html(html);
            });
        });
    });
</script>

<script type="text/javascript">
    $(document).ready(function() {
        $.getJSON('${findProvinces}', {
            ajax : 'true'
        }, function(data) {
            var html = '<option value="">Select Province</option>';
            var len = data.length;
            for ( var i = 0; i < len; i++) {
                html += '<option value="' + data[i] + '">' + data[i] + '</option>';
            }
            $('#province').html(html);
        });
    });
</script>
<script>
    $(function() {
        $('#addLabelAC').autocomplete({
            source : '${listLabels}',
            minLength : 2
        });
    });
</script>
<script>
    $(function() {
        $('#addLabelBtn').click(function() {
            var companyId = $('input#companyId').val();
            var newLabel = $('#addLabelAC').val();
            $.get('${addLabel}', {
                label : newLabel,
                companyId : companyId
            }, function(data) {
                alert(data);
            });
        });
    });
</script>
<script>
$(function() {
    $('#city').change(function() {
        $('input#cityName').val($(this).val());
    });
});
</script>
</head>
<body>
	<div class="content">
		<c:choose>
			<c:when test="${!empty company}">
				<form method="post" action="update">
					<div>
						<input type="hidden" name="id" id="companyId"
							value="${company.id }" />
					</div>
					<div>
						<div>Company</div>
						<div>
							<input type="text" name="companyName" class="longInput"
								value="${company.companyName }" />
						</div>
					</div>
					<div>
						<div>Labels</div>
						<c:if test="${!empty labels}">
							<div>
								<c:forEach var="label" items="${labels }">
									<label class="companyLabel">${label.labelName }<img
										class="deleteImg"
										src='<c:url value="/resources/images/erase.png"></c:url>' /></label>
								</c:forEach>
							</div>
						</c:if>
						<div>
							<input id="addLabelAC" class="shortInput" /><input type="button"
								value="Add Label" id="addLabelBtn" />
						</div>
					</div>
					<div>
						<div>Province</div>
						<div>
							<input type="text" name="province" id="provinceName"
								class="shortDisableInput" readonly="readonly"
								value="${company.province }" /> <select id="province">
							</select>
						</div>
					</div>
					<div>
						<div>City</div>
						<div>
							<input type="text" name="city" id="cityName"
								class="shortDisableInput" readonly="readonly"
								value="${company.city }" /> <select id="city">
							</select>
						</div>
					</div>
					<div>
						<div>
							<div>Business Type</div>
							<div>
								<input type="text" name="businessType" class="shortInput"
									value="${company.businessType }" />
							</div>
						</div>
						<div>
							<div>Scale</div>
							<div>
								<input type="text" name="scale" class="shortInput"
									value="${company.scale }" />
							</div>
						</div>
					</div>
					<div>
						<div>Description</div>
						<div>
							<textarea name="description" class="bigTextArea">${company.description }</textarea>
						</div>
					</div>
					<div>
						<c:choose>
							<c:when test="${create }">
								<input class="button" type="submit" value="Save" />
							</c:when>
							<c:otherwise>
								<input class="button" type="submit" value="Update" />
							</c:otherwise>
						</c:choose>
					</div>
				</form>
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