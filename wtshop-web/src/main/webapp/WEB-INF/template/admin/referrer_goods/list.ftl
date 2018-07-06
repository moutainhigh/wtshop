[#escape x as x?html]
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <title>${message("admin.member.list")} - Powered By ${setting.siteAuthor}</title>
    <meta name="author" content="${setting.siteAuthor}" />
    <meta name="copyright" content="${setting.siteCopyright}" />
    <link href="${base}/resources/admin/css/common.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="${base}/resources/admin/js/jquery.js"></script>
    <script type="text/javascript" src="${base}/resources/admin/js/common.js"></script>
    <script type="text/javascript" src="${base}/resources/admin/js/list.js"></script>
    <script type="text/javascript">
        $().ready(function() {

            [@flash_message /]

        });
    </script>
</head>
<body>
<div class="breadcrumb">
    <a href="${base}/admin/common/index.jhtml">${message("admin.breadcrumb.home")}</a> &raquo; ${message("admin.role.referrerGoods")} <span>(${message("admin.page.total", page.totalRow)})</span>
</div>
<form id="listForm" action="list.jhtml" method="post">
    <div class="bar">
        <div class="buttonGroup">
            <a href="javascript:;" id="refreshButton" class="iconButton">
                <span class="refreshIcon">&nbsp;</span>${message("admin.common.refresh")}
            </a>
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
                <li[#if pageable.searchProperty == "name"] class="current"[/#if] val="g.name">${message("admin.productNotify.productName")}</li>
            </ul>
        </div>
        <a href="toEdit.jhtml" class="iconButton">
            <span class="moveIcon">&nbsp;</span>${message("admin.referrerGoods.edit")}
        </a>
    </div>
    <table id="listTable" class="list">
        <tr>
            <th>
                <a href="javascript:;" class="sort" name="g.id">${message("admin.referrerGoods.goodsId")}</a>
            </th>
            <th>
                <a href="javascript:;" class="sort" name="g.name">${message("admin.referrerGoods.gName")}</a>
            </th>
            <th>
                <a href="javascript:;" class="sort" name="nn.num">${message("admin.referrerGoods.referrerNum")}</a>
            </th>
            <th>
                <a href="javascript:;" class="sort" name="p.stock">${message("Product.stock")}</a>
            </th>
            <th>
                <a href="javascript:;" class="sort" name="id">${message("admin.common.action")}</a>
            </th>
        </tr>
        [#list page.list as goods]
            <tr>
                <td>
                ${goods.id}
                </td>
                <td>
                ${goods.name}
                </td>
                <td>
                    [#if goods.num??]
                    ${goods.num}
                    [#else]
                        0
                    [/#if]
                </td>
                <td>
                ${goods.stock}
                </td>
                <td>
                    <a href="queryPageByGoodsId.jhtml?goodsId=${goods.id}">[${message("admin.referrerGoods.view")}]</a>
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