﻿<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	//假如你的项目名称是ssp,那么basePath最后获得的值就是 --> http://localhost:8080/ssp/
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/lucky/";
%>
<html lang="en">

<head>
	<base href="<%=basePath%>">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no">
<title></title>

<link href="css/layer.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-2.2.0.min.js" type="text/javascript"></script>
<style>
	*, :after, :before {
		margin: 0;
		padding: 0;
		box-sizing: border-box;
	}
	* {
		margin: 0;
		padding: 0;
	}
	table {
		border-spacing: 0;
		border-collapse: collapse;
		text-align: center;
	}
	
	.draw {
		width: 7.46rem;
		height: 8rem;
		margin: 0 auto;
		padding:0.68rem;
		background-image: url(images/bg.png);
		background-repeat: no-repeat;
		background-size: 100%;
	}
	
	.draw .item {
		width: 2rem;
		height: 2rem;
		background-image: url(images/bg1.png);
		background-repeat: no-repeat;
		background-size: 96%;
	}
	
	.draw .item.active {
		background-image: url(images/bg2.png);
		background-repeat: no-repeat;
		background-size: 100%;
	}
	
	.draw .img {
		display: table-cell;
		width: 2rem;
		height: 0.81rem;
		vertical-align: middle;
		text-align: center;
	}
	
	.draw .img img {
		vertical-align: top;
	}
	
	.draw .gap {
		width: 0.06rem;
	}
	
	.draw .gap-2 {
		height: 0.06rem;
	}
	
	.draw .name {
		display: block;
		margin-top: 0.13rem;
		font-size: 0.18rem;
	}
	
	.draw .draw-btn {
		display: block;
		height: 2rem;
		line-height: 2rem;
		border-radius: 0.26rem;
		font-size: 0.33rem;
		font-weight: 700;
		text-decoration: none;
		background-image: url(images/bg3.png);
		background-repeat: no-repeat;
		background-size: 96%;
	}
</style>

</head>
<body ng-app="mainApp" ng-controller="indexCtrl" style="background: #f02d2f;">

<div class="headerWrapper container-fluid">
	
</div>

<main style="background: #f02d2f;">
	<div class="draw" id="lottery">
		<table>
			<tr>
				<td class="item lottery-unit lottery-unit-0">
					<div class="img">
						<img src="images/img1.png" alt="">
					</div>
					<span class="name">终身VIP会员</span>
				</td>
				<td class="gap"></td>
				<td class="item lottery-unit lottery-unit-1">
					<div class="img">
						<img src="images/img2.png" alt="">
					</div>
					<span class="name">三年VIP会员</span>
				</td>
				<td class="gap"></td>
				<td class="item lottery-unit lottery-unit-2">
					<div class="img">
						<img src="images/img3.png" alt="">
					</div>
					<span class="name">半年VIP会员</span>
				</td>
			</tr>
			<tr>
				<td class="gap-2" colspan="5"></td>
			</tr>
			<tr>
				<td class="item lottery-unit lottery-unit-7">
					<div class="img">
						<img src="images/img4.png" alt="">
					</div>
					<span class="name">399元充值卡一张</span>
				</td>
				<td class="gap"></td>
				<td class="">
					<a class="draw-btn" href="javascript:"></a>
				</td>
				<td class="gap"></td>
				<td class="item lottery-unit lottery-unit-3">
					<div class="img">
						<img src="images/img5.png" alt="">
					</div>
					<span class="name">100元充值卡一张</span>
				</td>
			</tr>
			<tr>
				<td class="gap-2" colspan="5"></td>
			</tr>
			<tr>
				<td class="item lottery-unit lottery-unit-6">
					<div class="img">
						<img src="images/img7.png" alt="">
					</div>
					<span class="name">免费体验一次</span>
				</td>
				<td class="gap"></td>
				<td class="item lottery-unit lottery-unit-5">
					<div class="img">
						<img src="images/img6.png" alt="">
					</div>
					<span class="name">九折优惠券一张</span>
				</td>
				<td class="gap"></td>
				<td class="item lottery-unit lottery-unit-4">
					<div class="img">
						<img src="images/img8.png" alt="">
					</div>
					<span class="name">参与大礼包一份</span>
				</td>
			</tr>
		</table>
	</div>

</main>

<!--弹窗layer-->
<script src="js/layer.js"></script>





<script type="text/javascript">
	var lottery = {
		index: -1, //当前转动到哪个位置，起点位置
		count: 0, //总共有多少个位置
		timer: 0, //setTimeout的ID，用clearTimeout清除
		speed: 20, //初始转动速度
		times: 0, //转动次数
		cycle: 50, //转动基本次数：即至少需要转动多少次再进入抽奖环节
		prize: -1, //中奖位置
		init: function(id) {
			if($('#' + id).find('.lottery-unit').length > 0) {
				$lottery = $('#' + id);
				$units = $lottery.find('.lottery-unit');
				this.obj = $lottery;
				this.count = $units.length;
				$lottery.find('.lottery-unit.lottery-unit-' + this.index).addClass('active');
			};
		},
		roll: function() {
			var index = this.index;
			var count = this.count;
			var lottery = this.obj;
			$(lottery).find('.lottery-unit.lottery-unit-' + index).removeClass('active');
			index += 1;
			if(index > count - 1) {
				index = 0;
			};
			$(lottery).find('.lottery-unit.lottery-unit-' + index).addClass('active');
			this.index = index;
			return false;
		},
		stop: function(index) {
			this.prize = index;
			return false;
		}
	};

	function roll() {
		lottery.times += 1;
		lottery.roll(); //转动过程调用的是lottery的roll方法，这里是第一次调用初始化

		if(lottery.times > lottery.cycle + 10 && lottery.prize == lottery.index) {
			clearTimeout(lottery.timer);

			layer.open({
			   type: 1,
			   shadeClose: true,
			   shade: false,
			   maxmin: true, //开启最大化最小化按钮
			   area: ['893px', '600px'],
			   content: $("#info").html()
			});

			lottery.prize = -1;
			lottery.times = 0;
			click = false;
		} else {
			if(lottery.times < lottery.cycle) {
				lottery.speed -= 10;
			} else if(lottery.times == lottery.cycle) {
				//var index = Math.random() * (lottery.count) | 0; //静态演示，随机产生一个奖品序号，实际需请求接口产生
				var dataa={
                   id:4
				}
				  $.ajax({ url:"../api/activity/lottery.jhtml",data:dataa, success: function(data){

                console.info(data.data);
                        var index=data.data.Ranking;
                        //alert(index);
                        lottery.prize = index;

                 }});
			//	lottery.prize = index;
			} else {
				if(lottery.times > lottery.cycle + 10 && ((lottery.prize == 0 && lottery.index == 7) || lottery.prize == lottery.index + 1)) {
					lottery.speed += 110;
				} else {
					lottery.speed += 20;
				}
			}
			if(lottery.speed < 40) {
				lottery.speed = 40;
			};
			lottery.timer = setTimeout(roll, lottery.speed); //循环调用
		}
		return false;
	}

	var click = false;

	window.onload = function() {
		lottery.init('lottery');
		$('.draw-btn').click(function() {
            //click控制一次抽奖过程中不能重复点击抽奖按钮，后面的点击不响应
			if(click) {
				return false;

			} else {
                //转圈过程不响应click事件，会将click置为false
				lottery.speed = 100;
				roll();
                //一次抽奖完成后，设置click为true，可继续抽奖
				click = true;
				return false;
			}
		});
	};
</script>


<div id='info' style = "display : none">
   <a href=""><img src="images/tk_img.png"></a>
   <h1 style="font-size: 16px;width: 120px;">100元</h1>
</div>


</body>
</html>
<script>

	!(function(win, doc){
    function setFontSize() {
        // 获取window 宽度
        // zepto实现 $(window).width()就是这么干的
        var winWidth =  window.innerWidth;
        // doc.documentElement.style.fontSize = (winWidth / 640) * 100 + 'px' ;
        console.log(winWidth)
        // 640宽度以上进行限制 需要css进行配合
        var size = (winWidth / 750) * 75;
        console.log(size);
        doc.documentElement.style.fontSize = (size < 75 ? size : 75) + 'px' ;
        console.log(doc.documentElement.style.fontSize);
    }

    var evt = 'onorientationchange' in win ? 'orientationchange' : 'resize';

    var timer = null;

    win.addEventListener(evt, function () {
        clearTimeout(timer);

        timer = setTimeout(setFontSize, 300);
    }, false);

    win.addEventListener("pageshow", function(e) {
        if (e.persisted) {
            clearTimeout(timer);

            timer = setTimeout(setFontSize, 300);
        }
    }, false);

    // 初始化
    setFontSize();

}(window, document));
</script>