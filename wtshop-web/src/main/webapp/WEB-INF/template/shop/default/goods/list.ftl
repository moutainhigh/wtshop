[#escape x as x?html]
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
[#if productCategory??]
	[@seo type = "goodsList"]
		<title>[#if productCategory.seoTitle??]${productCategory.seoTitle}[#elseif seo.title??][@seo.title?interpret /][/#if][#if showPowered] - Powered By ${setting.siteAuthor}[/#if]</title>
		<meta name="author" content="${setting.siteAuthor}" />
		<meta name="copyright" content="${setting.siteCopyright}" />
		[#if productCategory.seoKeywords??]
			<meta name="keywords" content="${productCategory.seoKeywords}" />
		[#elseif seo.keywords??]
			<meta name="keywords" content="[@seo.keywords?interpret /]" />
		[/#if]
		[#if productCategory.seoDescription??]
			<meta name="description" content="${productCategory.seoDescription}" />
		[#elseif seo.description??]
			<meta name="description" content="[@seo.description?interpret /]" />
		[/#if]
	[/@seo]
[#else]
	<title>${message("shop.goods.title")}[#if showPowered] - Powered By ${setting.siteAuthor}[/#if]</title>
	<meta name="author" content="${setting.siteAuthor}" />
	<meta name="copyright" content="${setting.siteCopyright}" />
[/#if]
<link href="${base}/resources/shop/${theme}/css/common.css" rel="stylesheet" type="text/css" />
<link href="${base}/resources/shop/${theme}/css/goods.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${base}/resources/shop/${theme}/js/jquery.js"></script>
<script type="text/javascript" src="${base}/resources/shop/${theme}/js/jquery.lazyload.js"></script>
<script type="text/javascript" src="${base}/resources/shop/${theme}/js/common.js"></script>
<script type="text/javascript">
$().ready(function() {

	var $headerCart = $("#headerCart");
	var $compareBar = $("#compareBar");
	var $compareForm = $("#compareBar form");
	var $compareSubmit = $("#compareBar a.submit");
	var $clearCompare = $("#compareBar a.clear");
	var $goodsForm = $("#goodsForm");
	var $brandId = $("#brandId");
	var $promotionId = $("#promotionId");
	var $orderType = $("#orderType");
	var $pageNumber = $("#pageNumber");
	var $pageSize = $("#pageSize");
	var $filter = $("#filter dl");
	var $hiddenFilter = $("#filter dl:hidden");
	var $moreOption = $("#filter dd.moreOption");
	var $brand = $("#filter a.brand");
	var $attribute = $("#filter a.attribute");
	var $moreFilter = $("#moreFilter a");
	var $gridType = $("#gridType");
	var $listType = $("#listType");
	var $size = $("#layout a.size");
	var $previousPage = $("#previousPage");
	var $nextPage = $("#nextPage");
	var $sort = $("#sort a, #sort li");
	var $orderMenu = $("#orderMenu");
	var $startPrice = $("#startPrice");
	var $endPrice = $("#endPrice");
	var $result = $("#result");
	var $productImage = $("#result img");
	var $addCart = $("#result a.addCart");
	var $exchange = $("#result a.exchange");
	var $addFavorite = $("#result a.addFavorite");
	var $addCompare = $("#result a.addCompare");
	
	[#if productCategory??]
		$filter.each(function() {
			var $this = $(this);
			var scrollHeight = this.scrollHeight > 0 ? this.scrollHeight : $.swap(this, {display: "block", position: "absolute", visibility: "hidden"}, function() {
				return this.scrollHeight;
			});
			if (scrollHeight > 30) {
				if ($this.find("a.current").size() > 0) {
					$this.height("auto");
				} else {
					$this.find("dd.moreOption").show();
				}
			}
		});
		
		$moreOption.click(function() {
			var $this = $(this);
			if ($this.hasClass("close")) {
				$this.removeClass("close");
				$this.attr("title", "${message("shop.goods.moreOption")}");
				$this.parent().height(30);
			} else {
				$this.addClass("close");
				$this.attr("title", "${message("shop.goods.closeOption")}");
				$this.parent().height("auto");
			}
		});
		
		$moreFilter.click(function() {
			var $this = $(this);
			if ($this.hasClass("close")) {
				$this.removeClass("close");
				$this.text("${message("shop.goods.moreFilter")}");
				$hiddenFilter.hide();
			} else {
				$this.addClass("close");
				$this.text("${message("shop.goods.closeFilter")}");
				$hiddenFilter.show();
			}
			return false;
		});
		
		$brand.click(function() {
			var $this = $(this);
			if ($this.hasClass("current")) {
				$brandId.val("");
			} else {
				$brandId.val($this.attr("brandId"));
			}
			$pageNumber.val(1);
			$goodsForm.submit();
			return false;
		});
		
		$attribute.click(function() {
			var $this = $(this);
			if ($this.hasClass("current")) {
				$this.closest("dl").find("input").prop("disabled", true);
			} else {
				$this.closest("dl").find("input").prop("disabled", false).val($this.text());
			}
			$pageNumber.val(1);
			$goodsForm.submit();
			return false;
		});
	[/#if]
	
	var layoutType = getCookie("layoutType");
	if (layoutType == "listType") {
		$listType.addClass("currentList");
		$result.removeClass("grid").addClass("list");
	} else {
		$gridType.addClass("currentGrid");
		$result.removeClass("list").addClass("grid");
	}
	
	$gridType.click(function() {
		var $this = $(this);
		if (!$this.hasClass("currentGrid")) {
			$this.addClass("currentGrid");
			$listType.removeClass("currentList");
			$result.removeClass("list").addClass("grid");
			addCookie("layoutType", "gridType");
		}
		return false;
	});
	
	$listType.click(function() {
		var $this = $(this);
		if (!$this.hasClass("currentList")) {
			$this.addClass("currentList");
			$gridType.removeClass("currentGrid");
			$result.removeClass("grid").addClass("list");
			addCookie("layoutType", "listType");
		}
		return false;
	});
	
	$size.click(function() {
		var $this = $(this);
		$pageNumber.val(1);
		$pageSize.val($this.attr("pageSize"));
		$goodsForm.submit();
		return false;
	});
	
	$previousPage.click(function() {
		$pageNumber.val(${page.pageNumber - 1});
		$goodsForm.submit();
		return false;
	});
	
	$nextPage.click(function() {
		$pageNumber.val(${page.pageNumber + 1});
		$goodsForm.submit();
		return false;
	});
	
	$orderMenu.hover(
		function() {
			$(this).children("ul").show();
		}, function() {
			$(this).children("ul").hide();
		}
	);
	
	$sort.click(function() {
		var $this = $(this);
		if ($this.hasClass("current")) {
			$orderType.val("");
		} else {
			$orderType.val($this.attr("orderType"));
		}
		$pageNumber.val(1);
		$goodsForm.submit();
		return false;
	});
	
	$startPrice.add($endPrice).focus(function() {
		$(this).siblings("button").show();
	});
	
	$startPrice.add($endPrice).keypress(function(event) {
		return (event.which >= 48 && event.which <= 57) || (event.which == 46 && $(this).val().indexOf(".") < 0) || event.which == 8 || event.which == 13;
	});
	
	$goodsForm.submit(function() {
		if ($brandId.val() == "") {
			$brandId.prop("disabled", true);
		}
		if ($promotionId.val() == "") {
			$promotionId.prop("disabled", true);
		}
		if ($orderType.val() == "" || $orderType.val() == "topDesc") {
			$orderType.prop("disabled", true);
		}
		if ($pageNumber.val() == "" || $pageNumber.val() == "1") {
			$pageNumber.prop("disabled", true);
		}
		if ($pageSize.val() == "" || $pageSize.val() == "20") {
			$pageSize.prop("disabled", true);
		}
		if ($startPrice.val() == "" || !/^\d+(\.\d+)?$/.test($startPrice.val())) {
			$startPrice.prop("disabled", true);
		}
		if ($endPrice.val() == "" || !/^\d+(\.\d+)?$/.test($endPrice.val())) {
			$endPrice.prop("disabled", true);
		}
		if ($goodsForm.serializeArray().length < 1) {
			location.href = location.pathname;
			return false;
		}
	});
	
	$productImage.lazyload({
		threshold: 100,
		effect: "fadeIn"
	});
	
	// 加入购物车
	$addCart.click(function() {
		var $this = $(this);
		var productId = $this.attr("productId");
		$.ajax({
			url: "${base}/cart/add.jhtml",
			type: "POST",
			data: {productId: productId, quantity: 1},
			dataType: "json",
			cache: false,
			success: function(message) {
				if (message.type == "success" && $headerCart.size() > 0 && window.XMLHttpRequest) {
					var $image = $this.closest("li").find("img");
					var cartOffset = $headerCart.offset();
					var imageOffset = $image.offset();
					$image.clone().css({
						width: 170,
						height: 170,
						position: "absolute",
						"z-index": 20,
						top: imageOffset.top,
						left: imageOffset.left,
						opacity: 0.8,
						border: "1px solid #dddddd",
						"background-color": "#eeeeee"
					}).appendTo("body").animate({
						width: 30,
						height: 30,
						top: cartOffset.top,
						left: cartOffset.left,
						opacity: 0.2
					}, 1000, function() {
						$(this).remove();
					});
				}
				$.message(message);
			}
		});
		return false;
	});
	
	// 积分兑换
	$exchange.click(function() {
		var productId = $(this).attr("productId");
		$.ajax({
			url: "${base}/order/checkExchange.jhtml",
			type: "GET",
			data: {productId: productId, quantity: 1},
			dataType: "json",
			cache: false,
			success: function(message) {
				if (message.type == "success") {
					location.href = "${base}/order/checkout.jhtml?type=exchange&productId=" + productId + "&quantity=1";
				} else {
					$.message(message);
				}
			}
		});
		return false;
	});
	
	// 添加商品收藏
	$addFavorite.click(function() {
		var goodsId = $(this).attr("goodsId");
		$.ajax({
			url: "${base}/member/favorite/add.jhtml",
			type: "POST",
			data: {goodsId: goodsId},
			dataType: "json",
			cache: false,
			success: function(message) {
				$.message(message);
			}
		});
		return false;
	});
	
	// 对比栏
	var compareGoods = getCookie("compareGoods");
	var compareGoodsIds = compareGoods != null ? compareGoods.split(",") : [];
	if (compareGoodsIds.length > 0) {
		$.ajax({
			url: "${base}/goods/compareBar.jhtml",
			type: "GET",
			data: {goodsIds: compareGoodsIds},
			dataType: "json",
			cache: true,
			success: function(data) {
				$.each(data, function (i, item) {
					var thumbnail = item.thumbnail != null ? item.thumbnail : "${setting.defaultThumbnailProductImage}";
					$compareBar.find("dt").after(
						[@compress single_line = true]
							'<dd>
								<input type="hidden" name="goodsIds" value="' + item.id + '" \/>
								<a href="' + escapeHtml(item.url) + '" target="_blank">
									<img src="' + escapeHtml(thumbnail) + '" \/>
									<span title="' + escapeHtml(item.name) + '">' + escapeHtml(abbreviate(item.name, 50)) + '<\/span>
								<\/a>
								<strong>' + currency(item.price, true) + '[#if setting.isShowMarketPrice]<del>' + currency(item.marketPrice, true) + '<\/del>[/#if]<\/strong>
								<a href="javascript:;" class="remove" goodsId="' + item.id + '">[${message("shop.common.remove")}]<\/a>
							<\/dd>'
						[/@compress]
					);
				});
				$compareBar.fadeIn();
			}
		});
		
		$.each(compareGoodsIds, function(i, goodsId) { 
			$addCompare.filter("[goodsId='" + goodsId + "']").addClass("selected");
		});
	}
	
	// 移除对比
	$compareBar.on("click", "a.remove", function() {
		var $this = $(this);
		var goodsId = $this.attr("goodsId");
		$this.closest("dd").remove();
		for (var i = 0; i < compareGoodsIds.length; i ++) {
			if (compareGoodsIds[i] == goodsId) {
				compareGoodsIds.splice(i, 1);
				break;
			}
		}
		$addCompare.filter("[goodsId='" + goodsId + "']").removeClass("selected");
		if (compareGoodsIds.length == 0) {
			$compareBar.fadeOut();
			removeCookie("compareGoods");
		} else {
			addCookie("compareGoods", compareGoodsIds.join(","));
		}
		return false;
	});
	
	$compareSubmit.click(function() {
		if (compareGoodsIds.length < 2) {
			$.message("warn", "${message("shop.goods.compareNotAllowed")}");
			return false;
		}
		
		$compareForm.submit();
		return false;
	});
	
	// 清除对比
	$clearCompare.click(function() {
		$addCompare.removeClass("selected");
		$compareBar.fadeOut().find("dd:not(.action)").remove();
		compareGoodsIds = [];
		removeCookie("compareGoods");
		return false;
	});
	
	// 添加对比
	$addCompare.click(function() {
		var $this = $(this);
		var goodsId = $this.attr("goodsId");
		if ($.inArray(goodsId, compareGoodsIds) >= 0) {
			return false;
		}
		if (compareGoodsIds.length >= 4) {
			$.message("warn", "${message("shop.goods.addCompareNotAllowed")}");
			return false;
		}
		$.ajax({
			url: "${base}/goods/addCompare.jhtml",
			type: "GET",
			data: {goodsId: goodsId},
			dataType: "json",
			cache: false,
			success: function(data) {
				if (data.message.type == "success") {
					$this.addClass("selected");
					var thumbnail = data.thumbnail != null ? data.thumbnail : "${setting.defaultThumbnailProductImage}";
					$compareBar.show().find("dd.action").before(
						[@compress single_line = true]
							'<dd>
								<input type="hidden" name="goodsIds" value="' + data.id + '" \/>
								<a href="' + escapeHtml(data.url) + '" target="_blank">
									<img src="' + escapeHtml(thumbnail) + '" \/>
									<span title="' + escapeHtml(data.name) + '">' + escapeHtml(abbreviate(data.name, 50)) + '<\/span>
								<\/a>
								<strong>' + currency(data.price, true) + '[#if setting.isShowMarketPrice]<del>' + currency(data.marketPrice, true) + '<\/del>[/#if]<\/strong>
								<a href="javascript:;" class="remove" goodsId="' + data.id + '">[${message("shop.common.remove")}]<\/a>
							<\/dd>'
						[/@compress]
					);
					compareGoodsIds.unshift(goodsId);
					addCookie("compareGoods", compareGoodsIds.join(","));
				} else {
					$.message(data.message);
				}
			}
		});
		return false;
	});
	
	$.pageSkip = function(pageNumber) {
		$pageNumber.val(pageNumber);
		$goodsForm.submit();
		return false;
	}

});
</script>
</head>
<body>
	[#include "/shop/${theme}/include/header.ftl" /]
	<div class="container goodsList">
		<div id="compareBar" class="compareBar">
			<form action="${base}/goods/compare.jhtml" method="get">
				<dl>
					<dt>${message("shop.goods.compareBar")}</dt>
					<dd class="action">
						<a href="javascript:;" class="submit">${message("shop.goods.compareSubmit")}</a>
						<a href="javascript:;" class="clear">${message("shop.goods.clearCompare")}</a>
					</dd>
				</dl>
			</form>
		</div>
		<div class="row">
			<div class="span2">
				[#include "/shop/${theme}/include/hot_product_category.ftl" /]
				[#include "/shop/${theme}/include/hot_brand.ftl" /]
				[#include "/shop/${theme}/include/hot_goods.ftl" /]
				[#include "/shop/${theme}/include/hot_promotion.ftl" /]
			</div>
			<div class="span10">
				<div class="breadcrumb">
					<ul>
						<li>
							<a href="${base}/">${message("shop.breadcrumb.home")}</a>
						</li>
						[#if productCategory??]
							[@product_category_parent_list product_category_id = productCategory.id]
								[#list productCategories as productCategory]
									<li>
										<a href="${base}${productCategory.path}">${productCategory.name}</a>
									</li>
								[/#list]
							[/@product_category_parent_list]
							<li>${productCategory.name}</li>
						[#else]
							<li>${message("shop.goods.title")}</li>
						[/#if]
					</ul>
				</div>
				<form id="goodsForm" action="${base}${(productCategory.path)!"/goods/list.jhtml"}" method="post">
					<input type="hidden" id="brandId" name="brandId" value="${(brand.id)!}" />
					<input type="hidden" id="promotionId" name="promotionId" value="${(promotion.id)!}" />
					<input type="hidden" id="orderType" name="orderType" value="${orderType}" />
					<input type="hidden" id="pageNumber" name="pageNumber" value="${page.pageNumber}" />
					<input type="hidden" id="pageSize" name="pageSize" value="${page.pageSize}" />
					[#if productCategory??]
						[@product_category_children_list product_category_id = productCategory.id recursive = false]
							[#assign filterProductCategories = productCategories /]
						[/@product_category_children_list]
						[@brand_list product_category_id = productCategory.id]
							[#assign filterBrands = brands /]
						[/@brand_list]
						[@attribute_list product_category_id = productCategory.id]
							[#assign filterAttributes = attributes /]
						[/@attribute_list]
						[#if filterProductCategories?has_content || filterBrands?has_content || filterAttributes?has_content]
							<div id="filter" class="filter">
								<div class="title">${message("shop.goods.filter")}</div>
								<div class="content">
									[#assign rows = 0 /]
									[#if filterProductCategories?has_content]
										[#assign rows = rows + 1 /]
										<dl class="clearfix">
											<dt>${message("shop.goods.productCategory")}:</dt>
											[#list filterProductCategories as filterProductCategory]
												<dd>
													<a href="${base}${filterProductCategory.path}">${filterProductCategory.name}</a>
												</dd>
											[/#list]
											<dd class="moreOption" title="${message("shop.goods.moreOption")}">&nbsp;</dd>
										</dl>
									[/#if]
									[#if filterBrands?has_content]
										[#assign rows = rows + 1 /]
										<dl class="clearfix">
											<dt>${message("shop.goods.brand")}:</dt>
											[#list filterBrands as filterBrand]
												<dd>
													<a href="javascript:;"[#if filterBrand == brand] class="brand current" title="${message("shop.goods.cancel")}"[#else] class="brand"[/#if] brandId="${filterBrand.id}">${filterBrand.name}</a>	
												</dd>
											[/#list]
											<dd class="moreOption" title="${message("shop.goods.moreOption")}">&nbsp;</dd>
										</dl>
									[/#if]
									[#assign hasHiddenAttribute = false /]
									[#list filterAttributes as filterAttribute]
										[#assign rows = rows + 1 /]
										<dl class="clearfix[#if rows > 3 && !attributeValueMap?keys?seq_contains(filterAttribute)][#assign hasHiddenAttribute = true /] hidden[/#if]">
											<dt>
												<input type="hidden" name="attribute_${filterAttribute.id}"[#if attributeValueMap?keys?seq_contains(filterAttribute)] value="${attributeValueMap.get(filterAttribute)}"[#else] disabled="disabled"[/#if] />
												<span title="${filterAttribute.name}">${abbreviate(filterAttribute.name, 12)}:</span>
											</dt>
											[#list filterAttribute.optionsConverter as option]
												<dd>
													<a href="javascript:;"[#if attributeValueMap.get(filterAttribute) == option] class="attribute current" title="${message("shop.goods.cancel")}"[#else] class="attribute"[/#if]>${option}</a>
												</dd>
											[/#list]
											<dd class="moreOption" title="${message("shop.goods.moreOption")}">&nbsp;</dd>
										</dl>
									[/#list]
								</div>
								<div id="moreFilter" class="moreFilter">
									[#if hasHiddenAttribute]
										<a href="javascript:;">${message("shop.goods.moreFilter")}</a>
									[#else]
										&nbsp;
									[/#if]
								</div>
							</div>
						[/#if]
					[/#if]
					<div class="bar">
						<div id="layout" class="layout">
							<label>${message("shop.goods.layout")}:</label>
							<a href="javascript:;" id="gridType" class="gridType">
								<span>&nbsp;</span>
							</a>
							<a href="javascript:;" id="listType" class="listType">
								<span>&nbsp;</span>
							</a>
							<label>${message("shop.goods.pageSize")}:</label>
							<a href="javascript:;" class="size[#if page.pageSize == 20] current[/#if]" pageSize="20">
								<span>20</span>
							</a>
							<a href="javascript:;" class="size[#if page.pageSize == 40] current[/#if]" pageSize="40">
								<span>40</span>
							</a>
							<a href="javascript:;" class="size[#if page.pageSize == 80] current[/#if]" pageSize="80">
								<span>80</span>
							</a>
							<span class="page">
								<label>${message("shop.goods.totalCount", page.totalRow)} ${page.pageNumber}/[#if page.totalPage > 0]${page.totalPage}[#else]1[/#if]</label>
								[#if page.totalPage > 0]
									[#if page.pageNumber != 1]
										<a href="javascript:;" id="previousPage" class="previousPage">
											<span>${message("shop.goods.previousPage")}</span>
										</a>
									[/#if]
									[#if page.pageNumber != page.totalPage]
										<a href="javascript:;" id="nextPage" class="nextPage">
											<span>${message("shop.goods.nextPage")}</span>
										</a>
									[/#if]
								[/#if]
							</span>
						</div>
						<div id="sort" class="sort">
							<div id="orderMenu" class="orderMenu">
								[#if orderType??]
									<span>${message("Goods.OrderType." + orderType)}</span>
								[#else]
									<span>${message("Goods.OrderType." + orderTypes[0])}</span>
								[/#if]
								<ul>
									[#list orderTypes as type]
										<li[#if type == orderType] class="current"[/#if] orderType="${type}">${message("Goods.OrderType." + type)}</li>
									[/#list]
								</ul>
							</div>
							<a href="javascript:;"[#if orderType == "priceAsc"] class="currentAsc current" title="${message("shop.goods.cancel")}"[#else] class="asc"[/#if] orderType="priceAsc">${message("shop.goods.priceAsc")}</a>
							<a href="javascript:;"[#if orderType == "salesDesc"] class="currentDesc current" title="${message("shop.goods.cancel")}"[#else] class="desc"[/#if] orderType="salesDesc">${message("shop.goods.salesDesc")}</a>
							<a href="javascript:;"[#if orderType == "scoreDesc"] class="currentDesc current" title="${message("shop.goods.cancel")}"[#else] class="desc"[/#if] orderType="scoreDesc">${message("shop.goods.scoreDesc")}</a>
							<input type="text" id="startPrice" name="startPrice" class="startPrice" value="${startPrice}" maxlength="16" title="${message("shop.goods.startPrice")}" onpaste="return false" />
							<label>-</label>
							<input type="text" id="endPrice" name="endPrice" class="endPrice" value="${endPrice}" maxlength="16" title="${message("shop.goods.endPrice")}" onpaste="return false" />
							<button type="submit">${message("shop.goods.submit")}</button>
						</div>
					</div>
					<div id="result" class="result grid clearfix">
						[#if page.list?has_content]
							<ul>
								[#list page.list as goods]
									[#assign defaultProduct = goods.defaultProduct /]
									<li>
										<a href="${goods.url}">
											<img src="${base}/upload/image/blank.gif" data-original="${goods.thumbnail!setting.defaultThumbnailProductImage}" />
											<div>
												[#if goods.caption?has_content]
													<span title="${goods.name}">${abbreviate(goods.name, 24)}</span>
													<em title="${goods.caption}">${abbreviate(goods.caption, 24)}</em>
												[#else]
													${abbreviate(goods.name, 48)}
												[/#if]
											</div>
										</a>
										<strong>
											[#if goods.typeName == "general"]
												${currency(defaultProduct.price, true)}
												[#if setting.isShowMarketPrice]
													<del>${currency(defaultProduct.marketPrice, true)}</del>
												[/#if]
											[#elseif goods.typeName == "exchange"]
												<em>${message("Product.exchangePoint")}:</em>
												${defaultProduct.exchangePoint}
											[/#if]
										</strong>
										<div class="action">
											[#if goods.typeName == "general"]
												<a href="javascript:;" class="addCart" productId="${defaultProduct.id}">${message("shop.goods.addCart")}</a>
											[#elseif goods.type == "exchange"]
												<a href="javascript:;" class="exchange" productId="${defaultProduct.id}">${message("shop.goods.exchange")}</a>
											[/#if]
											<a href="javascript:;" class="addFavorite" title="${message("shop.goods.addFavorite")}" goodsId="${goods.id}">&nbsp;</a>
											<a href="javascript:;" class="addCompare" title="${message("shop.goods.addCompare")}" goodsId="${goods.id}">&nbsp;</a>
										</div>
									</li>
								[/#list]
							</ul>
						[#else]
							[#noescape]
								${message("shop.goods.noListResult")}
							[/#noescape]
						[/#if]
					</div>
					[@pagination pageNumber = page.pageNumber totalPages = page.totalPage pattern = "javascript: $.pageSkip({pageNumber});"]
						[#include "/shop/${theme}/include/pagination.ftl"]
					[/@pagination]
				</form>
			</div>
		</div>
	</div>
	[#include "/shop/${theme}/include/footer.ftl" /]
</body>
</html>
[/#escape]