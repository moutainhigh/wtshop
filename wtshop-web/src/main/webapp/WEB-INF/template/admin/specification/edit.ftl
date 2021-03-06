[#escape x as x?html]
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>${message("admin.specification.edit")} - Powered By ${setting.siteAuthor}</title>
<meta name="author" content="${setting.siteAuthor}" />
<meta name="copyright" content="${setting.siteCopyright}" />
<link href="${base}/resources/admin/css/common.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${base}/resources/admin/js/jquery.js"></script>
<script type="text/javascript" src="${base}/resources/admin/js/jquery.validate.js"></script>
<script type="text/javascript" src="${base}/resources/admin/js/common.js"></script>
<script type="text/javascript" src="${base}/resources/admin/js/input.js"></script>
<script type="text/javascript">
$().ready(function() {

	var $inputForm = $("#inputForm");
	var $addOptionButton = $("#addOptionButton");
	var $optionTable = $("#optionTable");
	
	[@flash_message /]
	
	// 增加可选项
	$addOptionButton.click(function() {
		$optionTable.append(
			[@compress single_line = true]
				'<tr>
					<td>
						<input type="text" name="options" class="text" maxlength="200" \/>
					<\/td>
					<td>
						<a href="javascript:;" class="remove">[${message("admin.common.remove")}]<\/a>
					<\/td>
				<\/tr>'
			[/@compress]
		);
	});
	
	// 删除可选项
	$optionTable.on("click", "a.remove", function() {
		if ($optionTable.find("tr").size() <= 2) {
			$.message("warn", "${message("admin.common.deleteAllNotAllowed")}");
			return false;
		}
		$(this).closest("tr").remove();
	});
	
	// 表单验证
	$inputForm.validate({
		rules: {
			"specification.name": "required",
			"specification.orders": "digits",
			options: "required"
		}
	});

});
</script>
</head>
<body>
	<div class="breadcrumb">
		<a href="${base}/admin/common/index.jhtml">${message("admin.breadcrumb.home")}</a> &raquo; ${message("admin.specification.edit")}
	</div>
	<form id="inputForm" action="update.jhtml" method="post">
		<input type="hidden" name="specification.id" value="${specification.id}" />
		<table class="input">
			<tr>
				<th>
					${message("Specification.productCategory")}:
				</th>
				<td>
					${specification.productCategory.name}
                    <input type="text" name="specification.product_category_id" class="text" value="${specification.product_category_id}" maxlength="200" />
				</td>
			</tr>
			<tr>
				<th>
					<span class="requiredField">*</span>${message("Specification.name")}:
				</th>
				<td>
					<input type="text" name="specification.name" class="text" value="${specification.name}" maxlength="200" />
				</td>
			</tr>
			<tr>
				<th>
					${message("admin.common.order")}:
				</th>
				<td>
					<input type="text" name="specification.orders" class="text" value="${specification.orders}" maxlength="9" />
				</td>
			</tr>
			<tr>
				<th>
					&nbsp;
				</th>
				<td>
					<a href="javascript:;" id="addOptionButton" class="button">${message("admin.specification.addOption")}</a>
				</td>
			</tr>
			<tr>
				<th>
					&nbsp;
				</th>
				<td>
					<table id="optionTable" class="item">
						<tr>
							<th>
								${message("Specification.options")}
							</th>
							<th>
								${message("admin.common.action")}
							</th>
						</tr>
						[#list specification.optionsConverter as option]
							<tr>
								<td>
									<input type="text" name="options" class="text" value="${option}" maxlength="200" />
								</td>
								<td>
									<a href="javascript:;" class="remove">[${message("admin.common.remove")}]</a>
								</td>
							</tr>
						[/#list]
					</table>
				</td>
			</tr>
			<tr>
				<th>
					&nbsp;
				</th>
				<td>
					<input type="submit" class="button" value="${message("admin.common.submit")}" />
					<input type="button" class="button" value="${message("admin.common.back")}" onclick="history.back(); return false;" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
[/#escape]