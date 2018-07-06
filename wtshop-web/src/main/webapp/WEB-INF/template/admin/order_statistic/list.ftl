[#escape x as x?html]
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>${message("admin.orderStatistic.list")} - Powered By ${setting.siteAuthor}</title>
<meta name="author" content="${setting.siteAuthor}" />
<meta name="copyright" content="${setting.siteCopyright}" />
<link href="${base}/resources/admin/css/common.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${base}/resources/admin/js/jquery.js"></script>
<script type="text/javascript" src="${base}/resources/admin/js/common.js"></script>
<script type="text/javascript" src="${base}/resources/admin/js/list.js"></script>
<script type="text/javascript" src="${base}/resources/admin/datePicker/WdatePicker.js"></script>
<style type="text/css">
.chart {
	height: 500px;
	padding: 0px 10px;
	border-top: 1px solid #d7e8f1;
	border-bottom: 1px solid #d7e8f1;
}
</style>
<script type="text/javascript">
$().ready(function() {

	var $listForm = $("#listForm");
	var $period = $("#period");
	var $periodMenu = $("#periodMenu");
	var $periodMenuItem = $("#periodMenu li");
	var $beginDate = $("#beginDate");
	var $endDate = $("#endDate");
	
	[@flash_message /]
	
	// 周期
	$periodMenu.hover(
		function() {
			$(this).children("ul").show();
		}, function() {
			$(this).children("ul").hide();
		}
	);
	
	// 周期
	$periodMenuItem.click(function() {
		var $this = $(this);
		if ($this.hasClass("checked")) {
			$period.val("");
		} else {
			$period.val($this.attr("val"));
		}
		$beginDate.add($endDate).val("");
		$listForm.submit();
	});
	$('#daochu').click(function () {
		location.href='';
    })

});
</script>
</head>
<body>
	<div class="breadcrumb">
		<a href="${base}/admin/common/index.jhtml">${message("admin.breadcrumb.home")}</a> &raquo; ${message("admin.orderStatistic.list")}
	</div>
	<form id="listForm" action="list.jhtml" method="post">
		<input type="hidden" id="period" name="period" value="${period}" />
		<div class="bar">
			<div class="buttonGroup">
				<a href="javascript:;" id="refreshButton" class="iconButton">
					<span class="refreshIcon">&nbsp;</span>${message("admin.common.refresh")}
				</a>
				<div id="periodMenu" class="dropdownMenu">
					<a href="javascript:;" class="button">
						${message("admin.orderStatistic.period")}<span class="arrow">&nbsp;</span>
					</a>
					<ul class="check">
						[#list periods as value]
							<li[#if value == period] class="checked"[/#if] val="${value}">${message("Statistic.Period." + value)}</li>
						[/#list]
					</ul>
				</div>
			</div>
			${message("admin.orderStatistic.beginDate")}:
			<input type="text" id="beginDate" name="beginDate" class="text Wdate" value="${beginDate?string("yyyy-MM-dd")}" style="width: 120px;" onfocus="WdatePicker({maxDate: '#F{$dp.$D(\'endDate\')}'});" />
			${message("admin.orderStatistic.endDate")}:
			<input type="text" id="endDate" name="endDate" class="text Wdate" value="${endDate?string("yyyy-MM-dd")}" style="width: 120px;" onfocus="WdatePicker({minDate: '#F{$dp.$D(\'beginDate\')}'});" />
			<input type="submit" class="button" value="${message("admin.common.submit")}" />
			<input type="button" class="button hidden" value="导出" id="daochu"  />
		</div>
		<div id="chart" class="chart"></div>
	</form>
		<script type="text/javascript" src="${base}/resources/admin/js/echarts.js"></script>
		<script type="text/javascript">
			var chart = echarts.init(document.getElementById("chart"));
			
			chart.setOption({
				tooltip: {
					trigger: "axis",
				},
				legend: {

					data: [
						"${message("Statistic.createOrderCount")}",
						"${message("Statistic.completeOrderCount")}",
						"${message("Statistic.createOrderAmount")}",
						"${message("Statistic.completeOrderAmount")}"
					]
				},
				xAxis: [
					{
                        boundaryGap: true,
                        data: [
							[#list d.xTitle as e]
							${e}
								[#if e_has_next],[/#if]
							[/#list]
                        ],
						axisLabel: {
                            interval:0,
						}
					}
				],
				yAxis: [
					{
						type: "value"
					}
				],
				series: [
					{
						name: "${message("Statistic.createOrderCount")}",
						type: "bar",
						smooth: true,
						data: [
							[#list d.result1 as e]
							${e}
								[#if e_has_next],[/#if]
							[/#list]
						],

					},
					{
						name: "${message("Statistic.completeOrderCount")}",
						type: "bar",
						smooth: true,
						data: [
							[#list d.result2 as e]
							${e}
								[#if e_has_next],[/#if]
							[/#list]
						],
					},
					{
						name: "${message("Statistic.createOrderAmount")}",
						type: "bar",
						smooth: true,

                        data: [
							[#list d.result3 as e]
							${e}
								[#if e_has_next],[/#if]
							[/#list]
                        ],

					},
					{
						name: "${message("Statistic.completeOrderAmount")}",
						type: "bar",
						smooth: true,
						data: [
							[#list d.result4 as e]
							${e}
								[#if e_has_next],[/#if]
							[/#list]
						],

					}
				]
			});
		</script>

</body>
</html>
[/#escape]