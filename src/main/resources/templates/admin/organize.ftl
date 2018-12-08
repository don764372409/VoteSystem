<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="/H-ui/lib/html5shiv.js"></script>
<script type="text/javascript" src="/H-ui/lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="/H-ui/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="/H-ui/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="/H-ui/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="/H-ui/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="/H-ui/static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="/H-ui/lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>管理员管理</title>
</head>
<body>
<div class="panel panel-default">
	<div class="panel-body">
		<div class="row cl">
			<div class="formControls col-sm-12">
				<input type="hidden" name="id">
				<input type="text" readonly="readonly" class="input-text" value="" placeholder="请在下方下拉菜单中选择一个部门" name="name">
			</div>
		</div>
	</div>
</div>
<div class="pt-20"></div>
<div class="panel panel-default">
	<div class="panel-body" style="overflow: scroll;">
		<ul class="dropDown-menu menu radius box-shadow">
			<#if list??>
				<#list list as parent>
					<li><a href="javascript:;">${parent.name}<i class="arrow Hui-iconfont">&#xe6d7;</i></a>
						<ul class="menu">
							<#if parent.children??>
								<#list parent.children as org>
									<li><a href="javascript:;">${org.name}<i class="arrow Hui-iconfont">&#xe6d7;</i></a>
										<ul class="menu">
											<#if org.depts??>
												<#list org.depts as dept>
													<li><a href="javascript:;" onclick="selectDept(${dept.id},'${parent.name}:${org.name}:${dept.name}')">${dept.name}</a></li>
												</#list>
											</#if>
										</ul>
									</li>
								</#list>
							</#if>
							<#if parent.depts??>
								<#list parent.depts as dept>
									<li>
										<a href="javascript:;" onclick="selectDept(${dept.id},'${parent.name}:${dept.name}')">${dept.name}</a>
									</li>
								</#list>
							</#if>
						</ul>
					</li>
				</#list>
			</#if>
		</ul>
	</div>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="/H-ui/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="/H-ui/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="/H-ui/static/h-ui/js/H-ui.js"></script> 
<script type="text/javascript" src="/H-ui/static/h-ui.admin/js/H-ui.admin.js"></script>
<!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="/H-ui/lib/My97DatePicker/4.8/WdatePicker.js"></script> 
<script type="text/javascript" src="/H-ui/lib/datatables/1.10.0/jquery.dataTables.min.js"></script> 
<script type="text/javascript" src="/H-ui/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">
function selectDept(id,name){
	$("input[name=id]").val(id);
	$("input[name=name]").val(name);
	parent.$("input[name=deptId]").val(id);
	parent.$("input[name=deptName]").val(name);
}
</script>
</body>
</html>
