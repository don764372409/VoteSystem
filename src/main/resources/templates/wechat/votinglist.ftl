<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
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
<style type="text/css">

</style>
<title>活动列表</title>
</head>
<body>
<div class="page-container">
	<div class="text-c">
	<div class="text-c">
	<div>
	<button type="submit" style="background-color: #4495F7;border-color:#4495F7;" class="btn btn-success" >已报名</button>
	<button type="submit" style="background-color: #4495F7;border-color:#4495F7;" class="btn btn-success" >总投票 </button>
	<button type="submit" style="background-color: #4495F7;border-color:#4495F7;" class="btn btn-success" >浏览量 </button>
	</div>
	<form action="">
    <input type="text" class="input-text" style="width:250px" placeholder="姓名/编号" id="name" name="name">
    <button type="submit" style="background-color: #4495F7;border-color:#4495F7;" class="btn btn-success" ><i class="icon-search"></i> 搜索</button>
  	</form>
  </div>
	</div>
	<div class="mt-20">
	<ul>
		<#if list?exists>
			 <#list list as obj>
					<li style="float: left;width: 50%;padding: 20px 10px;width: 43.33333333%;box-sizing: border-box;">
						<div>
						<img src="${obj.img?if_exists}" style="width: 100%;">
						</div>
						<p>
						${obj.uid?if_exists}号：
						${obj.name?if_exists}
						</p>
						<p style="color: #4495F7;">
					 	${obj.number?if_exists}票
					 	</p>
					 	<p>
					 	<button type="submit" style="background-color: #4495F7;width: 100%;border-color:#4495F7;" class="btn btn-success" >投票 </button>
					 	</p>
					</li>
				</#list>
				</#if>
	</ul>
	</div>
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
<script type="text/javascript">

</script> 
</body>
</html>