<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="Bookmark" href="/favicon.ico" >
<link rel="Shortcut Icon" href="/favicon.ico" />
<!--[if lt IE 9]>
<script type="text/javascript" src="/H-ui/lib/html5shiv.js"></script>
<script type="text/javascript" src="/H-ui/lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="/H-ui/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="/H-ui/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="/H-ui/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="/H-ui/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="/H-ui/static/h-ui.admin/css/style.css" />

<script type="text/javascript" src="/H-ui/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="/H-ui/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="/H-ui/static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="/H-ui/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<script type="text/javascript" src="/H-ui/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="/H-ui/lib/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="/H-ui/lib/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="/H-ui/lib/jquery.validation/1.14.0/messages_zh.js"></script>
<!--[if IE 6]>
<script type="text/javascript" src="/H-ui/lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<!--/meta 作为公共模版分离出去-->
<title>个人中心</title>
<style type="text/css">
	.searchBtn{
		position: absolute;
		display: inline-block;
		width: 30px;
		height:31px;
		border: 1px solid #ddd;
		right: 0;
		top:-1px;
		background: #f4f4f4;
		line-height: 30px;
		text-align: center;
	}
</style>
</head>
<body>
<article class="page-container">
	<form action="" method="post" class="form form-horizontal" id="form-member-add">
	<div class="panel panel-default">
		<div class="panel-header">基本信息</div>
		<div class="panel-body">
			<div class="row cl">
				<label class="form-label col-sm-2"><span class="c-red">*</span>姓名：</label>
				<div class="formControls col-sm-10">
					<input type="text" class="input-text" readonly="readonly" value="${obj.name}" style="width:45%;">
					手机：
					<input type="text" class="input-text" readonly="readonly" value="${obj.phone}" style="width:45%;">
				</div>
			</div>
		</div>
	</div>
	<div class="mt-20"></div>
	<div class="panel panel-default">
		<div class="panel-header">机构部门信息</div>
		<div class="panel-body">
			<div class="row cl">
				<label class="form-label col-sm-2"><span class="c-red">*</span>所属部门：</label>
				<div class="formControls col-sm-10">
					<div style="position: relative;">
					<input type="text" readonly="readonly" class="input-text" value="${obj.dept.name}">
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="mt-20"></div>
	<div class="panel panel-default">
		<div class="panel-header">角色信息</div>
		<div class="panel-body">
			<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>选择角色：</label>
			<div class="formControls col-xs-8 col-sm-10">
				<input type="text" readonly="readonly" class="input-text" value="${obj.role.name}">
			</div>
			</div>
		</div>
	</div>
	<div class="mt-20"></div>
	<div class="panel panel-default">
		<div class="panel-header">密码信息</div>
		<div class="panel-body">
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>原密码：</label>
				<div class="formControls col-xs-8 col-sm-10">
					<input type="password" class="input-text" value="" name="password">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>新密码：</label>
				<div class="formControls col-xs-8 col-sm-10">
					<input type="password" class="input-text" value="" name="newPassword" id="newPassword">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2"><span class="c-red" >*</span>确认密码：</label>
				<div class="formControls col-xs-8 col-sm-10">
					<input type="password" class="input-text" value="" name="configPassword">
				</div>
			</div>
				<div class="row cl">
					<div class="col-xs-8 col-sm-10 col-sm-offset-2">
						<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
					</div>
				</div>
		</div>
	</div>
	</form>
</article>
<script type="text/javascript">
$(function(){
	$("#form-member-add").validate({
		rules:{
			password:{
				required:true
			},
			newPassword:{
				required:true,
			},
			configPassword:{
				required:true,
				equalTo: "#newPassword"
			},
		},
		onkeyup:false,
		focusCleanup:true,
		success:"valid",
		submitHandler:function(form){
			var confPassword = $("input[name=configPassword]").val();
			$(form).ajaxSubmit({
				type: 'post',
				url: "/my/editPassword" ,
				data:{"confPassword":confPassword},
				success: function(data){
					if(data.result){
						layer.msg(data.msg,{icon:1,time:2000},function(){
							location.href="/login/show";
						});
// 						location.reload();
					}else{
						layer.msg(data.msg,{icon:2,time:2000});
					}
				},
                error: function(XmlHttpRequest, textStatus, errorThrown){
					layer.msg('网络异常,请刷新重试!',{icon:2,time:1000});
				}
			});
		}
	});
});
</script> 
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>