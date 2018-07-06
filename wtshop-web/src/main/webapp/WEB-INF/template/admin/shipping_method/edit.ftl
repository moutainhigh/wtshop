[#escape x as x?html]
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>${message("admin.shippingMethod.edit")} - Powered By ${setting.siteAuthor}</title>
<meta name="author" content="${setting.siteAuthor}" />
<meta name="copyright" content="${setting.siteCopyright}" />
<link href="${base}/resources/admin/css/common.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${base}/resources/admin/js/jquery.js"></script>
<script type="text/javascript" src="${base}/resources/admin/js/jquery.tools.js"></script>
<script type="text/javascript" src="${base}/resources/admin/js/jquery.validate.js"></script>
<script type="text/javascript" src="${base}/resources/admin/js/webuploader.js"></script>
<script type="text/javascript" src="${base}/resources/admin/js/common.js"></script>
<script type="text/javascript" src="${base}/resources/admin/js/input.js"></script>
<style type="text/css">
.paymentMethods label {
	width: 150px;
	display: block;
	float: left;
	padding-right: 6px;
}
</style>
<script type="text/javascript">
$().ready(function() {

	var $inputForm = $("#inputForm");
	var $filePicker = $("#filePicker");
	
	[@flash_message /]
	
	$filePicker.uploader();
	
	// 表单验证
	$inputForm.validate({
		rules: {
			"shippingMethod.name": "required",
			"shippingMethod.first_weight": {
				required: true,
				digits: true
			},
			"shippingMethod.continue_weight": {
				required: true,
				integer: true,
				min: 1
			},
			"shippingMethod.default_first_price": {
				required: true,
				min: 0,
				decimal: {
					integer: 12,
					fraction: ${setting.priceScale}
				}
			},
			"shippingMethod.default_continue_price": {
				required: true,
				min: 0,
				decimal: {
					integer: 12,
					fraction: ${setting.priceScale}
				}
			},
			"shippingMethod.icon": {
				pattern: /^(http:\/\/|https:\/\/|\/).*$/i
			},
			"shippingMethod.orders": "digits"
		}
	});

});
</script>
</head>
<body>
	<div class="breadcrumb">
		<a href="${base}/admin/common/index.jhtml">${message("admin.breadcrumb.home")}</a> &raquo; ${message("admin.shippingMethod.edit")}
	</div>
	<form id="inputForm" action="update.jhtml" method="post">
		<input type="hidden" name="shippingMethod.id" value="${shippingMethod.id}" />
		<table class="input">
			<tr>
				<th>
					<span class="requiredField">*</span>${message("ShippingMethod.name")}:
				</th>
				<td>
					<input type="text" name="shippingMethod.name" class="text" value="${shippingMethod.name}" maxlength="200" />
				</td>
			</tr>
			<tr>
				<th>
					${message("ShippingMethod.defaultDeliveryCorp")}:
				</th>
				<td>
					<select name="defaultDeliveryCorpId">
						<option value="">${message("admin.common.choose")}</option>
						[#list deliveryCorps as deliveryCorp]
							<option value="${deliveryCorp.id}"[#if deliveryCorp == shippingMethod.defaultDeliveryCorp] selected="selected"[/#if]>
								${deliveryCorp.name}
							</option>
						[/#list]
					</select>
				</td>
			</tr>
			<tr>
				<th>
					<span class="requiredField">*</span>${message("ShippingMethod.firstWeight")}:
				</th>
				<td>
					<input type="text" name="shippingMethod.first_weight" class="text" value="${shippingMethod.firstWeight}" maxlength="9" title="${message("admin.shippingMethod.weightTitle")}" />
				</td>
			</tr>
			<tr>
				<th>
					<span class="requiredField">*</span>${message("ShippingMethod.continueWeight")}:
				</th>
				<td>
					<input type="text" name="shippingMethod.continue_weight" class="text" value="${shippingMethod.continueWeight}" maxlength="9" title="${message("admin.shippingMethod.weightTitle")}" />
				</td>
			</tr>
			<tr>
				<th>
					<span class="requiredField">*</span>${message("ShippingMethod.defaultFirstPrice")}:
				</th>
				<td>
					<input type="text" name="shippingMethod.default_first_price" class="text" value="${shippingMethod.defaultFirstPrice}" maxlength="16" />
				</td>
			</tr>
			<tr>
				<th>
					<span class="requiredField">*</span>${message("ShippingMethod.defaultContinuePrice")}:
				</th>
				<td>
					<input type="text" name="shippingMethod.default_continue_price" class="text" value="${shippingMethod.defaultContinuePrice}" maxlength="16" />
				</td>
			</tr>
			<tr>
				<th>
					${message("ShippingMethod.icon")}:
				</th>
				<td>
					<span class="fieldSet">
						<input type="text" name="shippingMethod.icon" class="text" value="${shippingMethod.icon}" maxlength="200" />
						<a href="javascript:;" id="filePicker" class="button">${message("admin.upload.filePicker")}</a>
						[#if shippingMethod.icon??]
							<a href="${fileServer}${shippingMethod.icon}" target="_blank">${message("admin.common.view")}</a>
						[/#if]
					</span>
				</td>
			</tr>
			<tr class="paymentMethods">
				<th>
					${message("ShippingMethod.paymentMethods")}:
				</th>
				<td>
					[#list paymentMethods as paymentMethod]
						<label>
							<input type="checkbox" name="paymentMethodIds" value="${paymentMethod.id}"[#if shippingMethod.paymentMethods?seq_contains(paymentMethod)] checked="checked"[/#if] />${paymentMethod.name}
						</label>
					[/#list]
				</td>
			</tr>
			<tr>
				<th>
					${message("ShippingMethod.description")}:
				</th>
				<td>
					<input type="text" name="shippingMethod.description" class="text" value="${shippingMethod.description}" maxlength="200" />
				</td>
			</tr>
			<tr>
				<th>
					${message("admin.common.order")}:
				</th>
				<td>
					<input type="text" name="shippingMethod.orders" class="text" value="${shippingMethod.orders}" maxlength="9" />
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