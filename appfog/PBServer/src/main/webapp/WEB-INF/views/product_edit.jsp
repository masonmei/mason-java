
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Job Hunting</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/layout.css"/>">
<script type="text/javascript"
	src="<c:url value="/resources/javascript/jquery-1.8.2.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/javascript/jquery-ui-1.9.1.custom.js" />"></script>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/javascript/jquery-ui-1.9.1.custom.css"/>">
	
<link rel="Stylesheet" type="text/css" href='<s:url value="/resources/jHtmlArea/style/jHtmlArea.css"></s:url>' />
<script type="text/javascript" src='<s:url value="/resources/jHtmlArea/scripts/jHtmlArea-0.7.5.js"></s:url>'></script>

<c:url var="createCategory" value="/web/category/create"></c:url>
<c:url var="categoryList" value="/web/category/list"></c:url>
<script type="text/javascript">
    $(document).ready(function() {
        $.getJSON('${categoryList}', {
            ajax : 'true'
        }, function(data) {
            var html = '<option value="">Select Category</option>';
            var len = data.length;
            for ( var i = 0; i < len; i++) {
                html += '<option value="' + data[i].id + '">' + data[i].categoryName + '</option>';
            }
            $('#productCategory').html(html);
            $('#parentCategory').html(html);
        });
    });
</script>
<script>
$(function() {
    $('.textEditor').htmlarea();
    $("#createCategoryDialogForm").dialog({
        autoOpen: false,
        height: 280,
        width: 240,
        modal: true,
        buttons: {
            "Create": function() {
                $.getJSON('${createCategory}', {
                    parentCategory : $('#parentCategory').val(),
                    categoryName: $('#newCategoryName').val(),
                    ajax : 'true'
                }, function(data) {
                    var html = '<option value="">Select Category</option>';
                    var len = data.length;
                    for ( var i = 0; i < len; i++) {
                        html += '<option value="' + data[i].id + '">' + data[i].categoryName + '</option>';
                    }
                    $('#productCategory').html(html);
                    $('#parentCategory').html(html);
                });
                $( this ).dialog( "close" );
            },
            Cancel: function() {
                $( this ).dialog( "close" );
            }
        },
        close: function() {
            allFields.val("").removeClass( "ui-state-error" );
        }
    });
    
	$("#addCategory")
	.button()
	.click(function() {
	    $( "#createCategoryDialogForm" ).dialog( "open" );
	});
});
</script>
</head>
<body>
	<div id="createCategoryDialogForm" title="Create Category"
		class="content">
		<form>
			<div>
				<div>Parent Category</div>
				<div>
					<select name="category" id="parentCategory" class="shortInput">
					</select>
				</div>
			</div>
			<div>
				<div>Category Name</div>
				<div>
					<input type="text" name="newCategoryName" id="newCategoryName"
						class="shortInput" value="" />
				</div>
			</div>
		</form>
	</div>

	<div class="content">
		<div class="add">
			<button id="addCategory" class="button">Add Category</button>
		</div>
		<c:choose>
			<c:when test="${!empty product}">
				<f:form method="post" action="save?companyId=${companyId }"
					modelAttribute="product">
					<div>
						<div>
							<div>Product Name</div>
							<div>
								<f:input path="productName" cssClass="longInput" />
							</div>
						</div>
						<div>
							<div>Category</div>
							<div>
								<f:select path="productCategoryId" cssClass="shortInput"
									id="productCategory">
								</f:select>
							</div>
						</div>
						<div>
							<div>Short Description</div>
							<div>
								<f:textarea path="shortDesc" cssClass="bigTextArea" class="textEditor"/>
							</div>
						</div>
						<div>
							<div>Description</div>
							<div>
								<f:textarea path="description" cssClass="bigTextArea" class="textEditor"/>
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