[#escape x as x?html]
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <title>添加团购 - Powered By ${setting.siteAuthor}</title>
    <meta name="author" content="${setting.siteAuthor}" />
    <meta name="copyright" content="${setting.siteCopyright}" />
    <link href="${base}/resources/admin/css/common.css" rel="stylesheet" type="text/css" />
    <link href="${base}/statics/lib/layer/mobile/need/layer.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="${base}/resources/admin/js/jquery.js"></script>
    <script type="text/javascript" src="${base}/resources/admin/js/jquery.tools.js"></script>
    <script type="text/javascript" src="${base}/resources/admin/js/jquery.validate.js"></script>
    <script type="text/javascript" src="${base}/resources/admin/js/webuploader.js"></script>
    <script type="text/javascript" src="${base}/resources/admin/ueditor/ueditor.js"></script>
    <script type="text/javascript" src="${base}/resources/admin/js/common.js"></script>
    <script type="text/javascript" src="${base}/resources/admin/js/input.js"></script>
    <script type="text/javascript" src="${base}/resources/admin/datePicker/WdatePicker.js"></script>
    <script type="text/javascript" src="${base}/statics/lib/layer/layer.js"></script>

    <script type="text/javascript">

        $().ready(function() {

            var $inputForm = $("#inputForm");
            var $type = $("#type");
            var $content = $("#content");
            var $path = $("#path");

            $("#addProduct").click(function() {
                layer.open({
                    title:"商品列表",
                    type: 2,
                    skin: 'layui-layer-rim', //加上边框
                    area: ['870px', '540px'], //宽高
                    content: "../reverseAuction/chooseGoods.jhtml?flag=2",
                    shadeClose:true,
                });
            });
            [@flash_message /]



            $content.editor();

            $type.change(function() {
                if ($(this).val() == "text") {
                    $content.prop("disabled", false).closest("tr").show();
                    $path.prop("disabled", true).closest("tr").hide();
                } else {
                    $content.prop("disabled", true).closest("tr").hide();
                    $path.prop("disabled", false).closest("tr").show();
                }
            });

            // 表单验证
            $inputForm.validate({
                rules: {
                    "groupBuy.title":"required",
                    "groupBuy.price":"required",
                    "groupBuy.begin_date":"required",
                    "groupBuy.end_date":"required",
                    "groupBuy.uniprice":"required",
                    "groupBuy.num": "required",
                    "product_name":"required",
                    "product.groupRate": {
                        required: true,
                        min: 0,
                        decimal: {
                            integer: 12,
                            fraction: ${setting.priceScale}
                        }
                    },

                }
            });

            var $introduction = $("#introduction");
            $introduction.editor();

        });
    </script>
</head>
<body>
<div class="breadcrumb">
    <a href="${base}/admin/common/index.jhtml">${message("admin.breadcrumb.home")}</a> &raquo;${message("groupBuy.add.llst")}
</div>
<form id="inputForm" action="save.jhtml" method="post"  enctype="multipart/form-data" >
    <ul id="tab" class="tab">
        <li>
            <input type="button" value="${message("admin.coupon.base")}"class="current" />
        </li>
    [#--   <li>
           <input type="button" value="${message("groupBuy.rule")}" />
       </li>
       <li>
           <input type="button" value="${message("admin.goods.productImage")}" />
       </li>--]
    </ul>
[#-- <input value="0" name="groupBuy.status" type="hidden"/>--]
    <table class="input tabContent">
        <tr>
            <th>
                <span class="requiredField">*</span>${message("Ad.title")}:
            </th>
            <td>
                <input type="text" name="miaobiLssue.title" class="text" maxlength="200"  />
            </td>
        </tr>





        <tr>
            <th>
                <span class="requiredField">*</span>喵币数量:
            </th>
            <td>
                <input type="text" name="miaobiLssue.number" class="text" maxlength="200" title="喵币数量" />
            </td>
        </tr>
        <th>
            ${message("Promotion.beginDate")}:
        </th>
        <td>
            <input type="text" id="beginDate" name="miaobiLssue.begin_date" class="text Wdate" onfocus="WdatePicker({dateFmt: 'yyyy-MM-dd HH:mm:ss', maxDate: '#F{$dp.$D(\'endDate\')}'});" />
        </td>
        </tr>
        <tr>
            <th>
                ${message("Promotion.endDate")}:
            </th>
            <td>
                <input type="text" id="endDate" name="miaobiLssue.end_date" class="text Wdate" onfocus="WdatePicker({dateFmt: 'yyyy-MM-dd HH:mm:ss', minDate: '#F{$dp.$D(\'beginDate\')}'});" />
            </td>
        </tr>


        <tr>
            <th>
                ${message("admin.common.setting")}:
            </th>
            <td>
                <label>
                    <input type="checkbox"  name="status" checked="checked" value="true"   />是否上架
                    <input type="hidden" name="_status" value="false" />
                </label>
            </td>
        </tr>

        <tr>
            <th>
                <span class="requiredField"></span>${message("groupBuy.message")}:
            </th>
            <td>
                <textarea rows="" cols="" name="miaobiLssue.explain" style="width: 300px;height:200px " maxlength="400" title= ${message("groupBuy.message.title")}></textarea>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" class="button" value="${message("admin.common.submit")}" />
                <input type="button" class="button" value="${message("admin.common.back")}" onclick="history.back(); return false;" />
            </td>
        </tr>

    </table>
    <table class="input tabContent">
        <tr><td><textarea id="introduction" name="groupBuy.rule" class="editor" style="width: 100%;"></textarea></td></tr>
    </table>

    <table id="productImageTable" class="item tabContent">
        <tr>
            <td colspan="4">
                <a href="javascript:;" id="addProductImage" title= ${message("groupBuy.image.title")} class="button">${message("admin.goods.addProductImage")}</a>
            </td>
        </tr>
        <tr>
            <th>
                ${message("ProductImage.file")}
            </th>
            <th>
                ${message("ProductImage.title")}
            </th>
            <th>
                ${message("admin.common.order")}
            </th>
            <th>
                ${message("admin.common.action")}
            </th>
        </tr>



    </table>
    <table class="input">
        <tr>
            <th>&nbsp;

            </th>

        </tr>
    </table>



</form>
</body>
</html>
[/#escape]