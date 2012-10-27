<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Job Hunting</title>
<script type="text/javascript">
	function getCityOfProvice(this) {
		alert(this);
	}
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
								<f:select path="provice"
									onchange="javascript:getCityOfProvice(this);">
									<f:option value="NONE" label="--- Select ---" />
									<f:options items="${provinceList }" />
								</f:select>
							</div>
						</div>
						<div>
							<div>City</div>
							<div>
								<f:select path="city">
									<f:option value="NONE" label="--- Select ---" />
									<f:options items="${cityOfProvince }" />
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
								<input type="submit" value="Save"/>
							</c:when>
							<c:otherwise>
								<input type="submit" value="Update"/>
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