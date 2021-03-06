[#escape x as x?html]
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>${message("admin.deliveryCenter.edit")} - Powered By ${setting.siteAuthor}</title>
<meta name="author" content="${setting.siteAuthor}" />
<meta name="copyright" content="${setting.siteCopyright}" />
<link href="${base}/resources/admin/css/common.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${base}/resources/admin/js/jquery.js"></script>
<script type="text/javascript" src="${base}/resources/admin/js/jquery.validate.js"></script>
<script type="text/javascript" src="${base}/resources/admin/js/jquery.lSelect.js"></script>
<script type="text/javascript" src="${base}/resources/admin/js/common.js"></script>
<script type="text/javascript" src="${base}/resources/admin/js/input.js"></script>
<script type="text/javascript">
$().ready(function() {

	var $inputForm = $("#inputForm");
	var $areaId = $("#areaId");
	
	[@flash_message /]
	
	// 地区选择
	$areaId.lSelect({
		url: "${base}/admin/common/area.jhtml"
	});
	
	// 表单验证
	$inputForm.validate({
		rules: {
			"deliveryCenter.name": "required",
			"deliveryCenter.contact": "required",
			areaId: "required",
			"deliveryCenter.address": "required",
			"deliveryCenter.zip_code": {
				pattern: /^\d{6}$/
			},
			"deliveryCenter.phone": {
				pattern: /^\d{3,4}-?\d{7,9}$/
			}
		}
	});

});
</script>
</head>
<body>
	<div class="breadcrumb">
		<a href="${base}/admin/common/index.jhtml">${message("admin.breadcrumb.home")}</a> &raquo; ${message("admin.deliveryCenter.edit")}
	</div>
	<form id="inputForm" action="update.jhtml" method="post">
		<input type="hidden" name="deliveryCenter.id" value="${deliveryCenter.id}" />
		<table class="input">
			<tr>
				<th>
					<span class="requiredField">*</span>${message("DeliveryCenter.name")}:
				</th>
				<td>
					<input type="text" name="deliveryCenter.name" class="text" value="${deliveryCenter.name}" maxlength="200" />
				</td>
			</tr>
			<tr>
				<th>
					<span class="requiredField">*</span>${message("DeliveryCenter.contact")}:
				</th>
				<td>
					<input type="text" name="deliveryCenter.contact" class="text" value="${deliveryCenter.contact}" maxlength="200" />
				</td>
			</tr>
			<tr>
				<th>
					<span class="requiredField">*</span>${message("DeliveryCenter.area")}:
				</th>
				<td>
					<span class="fieldSet">
						<input type="hidden" id="areaId" name="areaId" value="${(deliveryCenter.area.id)!}" treePath="${(deliveryCenter.area.treePath)!}" />
					</span>
				</td>
			</tr>
			<tr>
				<th>
					<span class="requiredField">*</span>${message("DeliveryCenter.address")}:
				</th>
				<td>
					<input type="text" name="deliveryCenter.address" class="text" value="${deliveryCenter.address}" maxlength="200" />
				</td>
			</tr>
			<tr>
				<th>
					${message("DeliveryCenter.zipCode")}:
				</th>
				<td>
					<input type="text" name="deliveryCenter.zip_code" class="text" value="${deliveryCenter.zipCode}" maxlength="200" />
				</td>
			</tr>
			<tr>
				<th>
					${message("DeliveryCenter.phone")}:
				</th>
				<td>
					<input type="text" name="deliveryCenter.phone" class="text" value="${deliveryCenter.phone}" maxlength="200" />
				</td>
			</tr>
			<tr>
				<th>
					${message("DeliveryCenter.mobile")}:
				</th>
				<td>
					<input type="text" name="deliveryCenter.mobile" class="text" value="${deliveryCenter.mobile}" maxlength="200" />
				</td>
			</tr>
			<tr>
				<th>
					${message("DeliveryCenter.isDefault")}:
				</th>
				<td>
					<input type="checkbox" name="isDefault"[#if deliveryCenter.isDefault] checked="checked"[/#if] />
					<input type="hidden" name="_isDefault" value="false" />
				</td>
			</tr>
			<tr>
				<th>
					${message("DeliveryCenter.memo")}
				</th>
				<td>
					<input type="text" name="deliveryCenter.memo" class="text" value="${deliveryCenter.memo}" maxlength="200" />
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