<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="Bookmark" href="/favicon.ico" >
<link rel="Shortcut Icon" href="/favicon.ico" />
<!--[if lt IE 9]>
<script type="text/javascript" src="../H-ui/lib/html5shiv.js"></script>
<script type="text/javascript" src="../H-ui/lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="../H-ui/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="../H-ui/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="../H-ui/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="../H-ui/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="../H-ui/static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="../H-ui/lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<!--/meta 作为公共模版分离出去-->
<title>投票统计</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 投票统计管理 <span class="c-gray en">&gt;</span> 投票统计 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
<div class="text-c">
		<form class="Huiform" method="post" action="" >
		投票类别：
		<span class="select-box" style="width:150px">
			<select class="select" name="vid" size="1">
			<#if list?exists>
			<#list list as list>
				<option value="${list.id?if_exists}">${list.title?if_exists}</option>
			</#list>
			</#if>
			</select>
			</span><button type="submit" class="btn btn-success" id="" name="">切换</button>
		</form>
	</div>

<div id="main" style="width: 100%;height:550px;"></div>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="../H-ui/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="../H-ui/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="../H-ui/static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="../H-ui/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="../H-ui/lib/My97DatePicker/4.8/WdatePicker.js"></script> 
<script type="text/javascript" src="../H-ui/lib/datatables/1.10.0/jquery.dataTables.min.js"></script> 
<script type="text/javascript" src="../H-ui/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript" src="../echarts/echarts.simple.min.js"></script>
<script type="text/javascript">
 var myChart = echarts.init(document.getElementById('main'));
option = {
    title : {
        text: '投票活动票数统计',
    },
    tooltip : {
        trigger: 'axis'
    },
    legend: {
        data:['得票数']
    },
    toolbox: {
        show : true,
        feature : {
            dataView : {show: true, readOnly: false},
            magicType : {show: true, type: ['line', 'bar']},
            restore : {show: true},
            saveAsImage : {show: true}
        }
    },
    calculable : true,
    xAxis : [
        {
            type : 'category',
            data : ["一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"]
			//data : [<#list map as list>${list.name?if_exists}</#list>]
        }
    ],
    yAxis : [
        {
            type : 'value'
        }
    ],
    series : [
        {
            name:'降水量',
            type:'bar',
            data:[5, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3],
            markPoint : {
                data : [
                    {name : '年最高', value : 182.2, xAxis: 7, yAxis: 183},
                    {name : '年最低', value : 2.3, xAxis: 11, yAxis: 3}
                ]
            },
            markLine : {
                data : [
                    {type : 'average', name : '平均值'}
                ]
            }
        }
    ]
};
// 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
</script> 
</body>
</html>