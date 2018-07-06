[#escape x as x?html]
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>${message("admin.parameter.edit")} - Powered By ${setting.siteAuthor}</title>
    <meta name="author" content="${setting.siteAuthor}"/>
    <meta name="copyright" content="${setting.siteCopyright}"/>
    <link href="${base}/resources/admin/css/common.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="${base}/resources/admin/js/jquery.js"></script>
    <script type="text/javascript" src="${base}/resources/admin/js/jquery.validate.js"></script>
    <script type="text/javascript" src="${base}/resources/admin/js/common.js"></script>
    <script type="text/javascript" src="${base}/resources/admin/js/input.js"></script>
    <script type="text/javascript">
        $().ready(function () {

            var $inputForm = $("#inputForm");
            var $addNameButton = $("#addNameButton");
            var $nameTable = $("#nameTable");

            [@flash_message /]

            // 增加参数名称
            $addNameButton.click(function () {
                $nameTable.append(
                    [@compress single_line = true]
                            '<tr><td><input type="text" name="names" class="text" maxlength="200"\/><\/td><td><a href="javascript:;" class="remove">[${message("admin.common.remove")}]<\/a><\/td><\/tr>'
                    [/@compress]
                )
                ;
            });

            // 删除参数名称
            $nameTable.on("click", "a.remove", function () {
                if ($nameTable.find("tr").size() <= 2) {
                    $.message("warn", "${message("admin.common.deleteAllNotAllowed")}");
                    return false;
                }
                $(this).closest("tr").remove();
            });

            // 表单验证
            $inputForm.validate({});

        });
    </script>
</head>
<body>
<div class="breadcrumb">

    <a href="${base}/admin/common/index.jhtml">${message("admin.breadcrumb.home")}</a> &raquo;
    <a href="${base}/admin/reverseAuction/list.jhtml">${message("admin.role.reverseGroup")}</a> &raquo; ${message("reverseGroup.config")}
</div>
<form id="inputForm" action="saveConfig.jhtml" method="post">
    <input type="hidden" name="parameter.id" value="${parameter.id}"/>
    <table class="input">
        <tr>
            <th>
                ${message("reverseGroup.pay_time")}
            </th>
            <td>
                <input type="text" name="maxPayTimeInSecond" class="text digits" value="${maxPayTimeInSecond}" maxlength="10" required/>
            </td>
        </tr>
        <tr>
            <th>
                ${message("reverseGroup.price_time")}
            </th>
            <td>
                <input type="text" name="downPeriodInSecond" class="text digits" value="${downPeriodInSecond}" maxlength="9" required/>
            </td>
        </tr>
        <tr>
            <th>
                ${message("reverseGroup.price_max")}
            </th>
            <td>
                <input type="text" name="downPriceInCent" class="text digits" value="${downPriceInCent}" maxlength="9" required/>
            </td>
        </tr>

        <tr>
            <th>
                &nbsp;
            </th>
            <td>
                <input type="submit" class="button" value="${message("admin.common.submit")}"/>
                <input type="button" class="button" value="${message("admin.common.back")}" onclick="history.back(); return false;"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
[/#escape]