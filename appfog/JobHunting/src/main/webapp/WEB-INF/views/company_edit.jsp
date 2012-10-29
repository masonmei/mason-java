<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="<c:url value="/resources/javascript/jquery-1.8.2.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/javascript/jquery-ui-1.9.1.custom.js" />"></script>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/javascript/jquery-ui-1.9.1.custom.css"/>">	
<title>Job Hunting</title>

<c:url var="findProvinces" value="/company/provinces"/>
<c:url var="findCities" value="/company/cities"/>

<script type="text/javascript">
	$(document).ready(function() { 
		$('#province').change(
				function() {
					$.getJSON('${findCities}', {
						provinceId : $(this).val(),
						ajax : 'true'
					}, function(data) {
						var html = '<option value="">Select City</option>';
						var len = data.length;
						for ( var i = 0; i < len; i++) {
							html += '<option value="' + data[i].cityName + '">' + data[i].cityName + '</option>';
						}
						$('#city').html(html);
					});
				});
	});
</script>
<script type="text/javascript">
	$(document).ready(function() { 
		var html = '<option value="">Select City</option>';
		html += '</option>';
		$('#city').html(html);
	});
</script>
<script type="text/javascript">
	$(document).ready(
			function() {
				$.getJSON('${findProvinces}', {
					ajax : 'true'
				}, function(data) {
					var html = '<option value="">Select Province</option>';
					var len = data.length;
					for ( var i = 0; i < len; i++) {
						html += '<option value="' + data[i].id + '">' + data[i].provinceName + '</option>';
					}
					$('#province').html(html);
				});
			});
</script>
</head>
<body>
	<c:choose>
		<c:when test="${!empty company}">
			<f:form method="post" action="update" modelAttribute="company">
				<div>
					<f:hidden path="id" />
				</div>
				<div>
					<div>
						<div>Company</div>
						<div>
							<f:input path="companyName" />
						</div>
					</div>
					<div>
						<div>
							<div>Province</div>
							<div>
								<f:select path="provice" id="province">
								</f:select>
							</div>
						</div>
						<div>
							<div>City</div>
							<div>
								<f:select path="city" id="city" >									
								</f:select>
							</div>
						</div>
					</div>
					<div>
						<div>
							<div>Business Type</div>
							<div>
								<f:input path="businessType" />
							</div>
						</div>
						<div>
							<div>Scale</div>
							<div>
								<f:input path="scale" />
							</div>
						</div>
					</div>
					<div>
						<div>Description</div>
						<div>
							<f:textarea path="description" />
						</div>
					</div>

					<div>
						<c:choose>
							<c:when test="${create }">
								<input type="submit" value="Save" />
							</c:when>
							<c:otherwise>
								<input type="submit" value="Update" />
							</c:otherwise>
						</c:choose>
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
</body>
</html>