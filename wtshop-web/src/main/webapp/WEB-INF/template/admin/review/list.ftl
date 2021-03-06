[#escape x as x?html]
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>${message("admin.review.list")} - Powered By ${setting.siteAuthor}</title>
<meta name="author" content="${setting.siteAuthor}" />
<meta name="copyright" content="${setting.siteCopyright}" />
<link href="${base}/resources/admin/css/common.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${base}/resources/admin/js/jquery.js"></script>
<script type="text/javascript" src="${base}/resources/admin/js/common.js"></script>
<script type="text/javascript" src="${base}/resources/admin/js/list.js"></script>
<script type="text/javascript">
$().ready(function() {

	var $listForm = $("#listForm");
	var $type = $("#type");
	var $typeMenu = $("#typeMenu");
	var $typeMenuItem = $("#typeMenu li");

	[@flash_message /]
	
	$typeMenu.hover(
		function() {
			$(this).children("ul").show();
		}, function() {
			$(this).children("ul").hide();
		}
	);
	
	$typeMenuItem.click(function() {
		$type.val($(this).attr("val"));
		$listForm.submit();
	});

	[#--$("#nohandle").click(function () {--]
		[#--var ids = $(this).attr("name");--]
        [#--$.ajax({--]
            [#--type: 'POST',--]
            [#--dataType: 'json',--]
            [#--url: '${base}/admin/review/handle.jhtml',--]
            [#--data: {id: ids},--]
            [#--success: function (data) {--]
                [#--if(data.status == 1){--]
                  [#--window.location.href="${base}/admin/review/list.jhtml";--]
                [#--}--]
            [#--}--]
        [#--});--]
    [#--});--]

});
</script>
</head>
<body>
	<div class="breadcrumb">
		<a href="${base}/admin/common/index.jhtml">${message("admin.breadcrumb.home")}</a> &raquo; ${message("admin.review.list")} <span>(${message("admin.page.total", page.totalRow)})</span>
	</div>
	<form id="listForm" action="list.jhtml" method="post">
		<input type="hidden" id="type" name="type" value="${type}" />
		<div class="bar">
			<div class="buttonGroup">
				<a href="javascript:;" id="deleteButton" class="iconButton disabled">
					<span class="deleteIcon">&nbsp;</span>${message("admin.common.delete")}
				</a>
				<a href="javascript:;" id="refreshButton" class="iconButton">
					<span class="refreshIcon">&nbsp;</span>${message("admin.common.refresh")}
				</a>
				<div id="typeMenu" class="dropdownMenu">
					<a href="javascript:;" class="button">
						${message("admin.review.type")}<span class="arrow">&nbsp;</span>
					</a>
					<ul>
						<li[#if type == null] class="current"[/#if] val="">${message("admin.review.allType")}</li>
						[#assign currentType = type]
						[#list types as type]
							<li[#if type == currentType] class="current"[/#if] val="${type}">${message("Review.Type." + type)}</li>
						[/#list]
					</ul>
				</div>
				<div id="pageSizeMenu" class="dropdownMenu">
					<a href="javascript:;" class="button">
						${message("admin.page.pageSize")}<span class="arrow">&nbsp;</span>
					</a>
					<ul>
						<li[#if page.pageSize == 10] class="current"[/#if] val="10">10</li>
						<li[#if page.pageSize == 20] class="current"[/#if] val="20">20</li>
						<li[#if page.pageSize == 50] class="current"[/#if] val="50">50</li>
						<li[#if page.pageSize == 100] class="current"[/#if] val="100">100</li>
					</ul>
				</div>
			</div>
			<div id="searchPropertyMenu" class="dropdownMenu">
				<div class="search">
					<span class="arrow">&nbsp;</span>
					<input type="text" id="searchValue" name="pageable.searchValue" value="${pageable.searchValue}" maxlength="200" />
					<button type="submit">&nbsp;</button>
				</div>
				<ul>
					<li[#if pageable.searchProperty == "name"] class="current"[/#if] val="name">${message("Review.goodsName")}</li>
                    <li[#if pageable.searchProperty == "memberNick"] class="current"[/#if] val="nickname">${message("Review.memberNick")}</li>
				</ul>
			</div>
		</div>
		<table id="listTable" class="list">
			<tr>
				<th class="check">
					<input type="checkbox" id="selectAll" />
				</th>
				<th>
					<span>${message("Review.goods")}</span>
				</th>
				<th>
                    <span>	${message("Review.score")}</span>

				</th>
				<th>
					<span>	${message("Review.content")}</span>
				</th>
				<th>
					<span>	${message("Review.member")}</span>
				</th>
				<th>
					<span>	${message("Review.isShow")}</span>
				</th>
                <th>
                    <span>${message("Review.isPhoto")}</span>
                </th>
                <th>
                   <span>${message("Review.stuats")}</span>
                </th>

                <th>
					<a href="javascript:;" class="sort" name="create_date">${message("admin.common.createDate")}</a>
				</th>
				<th>
					<span>${message("admin.common.action")}</span>
				</th>
			</tr>
			[#list page.list as review]
				<tr>
					<td>
						<input type="checkbox" name="ids" value="${review.id}" />
					</td>
					<td>
					${abbreviate(review.goods.name, 40, "...")}
					</td>
					<td>
						${review.score}
					</td>
					<td>
						<span title="${review.content}">${abbreviate(review.content, 20, "...")}</span>
					</td>
					<td>
						[#if review.member??]
							${review.member.nickname}
						[#else]
							${message("admin.review.anonymous")}
						[/#if]
					</td>
					<td>
						<span class="${review.isShow?string("true", "false")}Icon">&nbsp;</span>
					</td>
                    <td>
						[#if review.images = "1"]
						    是
						[#else ]
						    否
						[/#if]
                    </td>

                    <td>
						 ${review.status?string("已处理","未处理")}
                    </td>
					<td>
						<span title="${review.createDate?string("yyyy-MM-dd HH:mm:ss")}">${review.createDate}</span>
					</td>
					<td>
						[#--<a href="reply.jhtml?id=${review.id}">[${message("admin.review.reply")}]</a>--]
						<a href="edit.jhtml?id=${review.id}">[${message("admin.common.edit")}]</a>
					</td>
				</tr>
			[/#list]
		</table>
		[@pagination pageNumber = page.pageNumber totalPages = page.totalPage]
			[#include "/admin/include/pagination.ftl"]
		[/@pagination]
	</form>
</body>
</html>
[/#escape]