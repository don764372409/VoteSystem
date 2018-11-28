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
<title>添加短信用户</title>
</head>
<body>
<article class="page-container">
	<form action="" method="post" class="form form-horizontal" id="form-member-add">
		<input name="id" type="hidden" value="${obj.id}">
		<div class="row cl">
			<label class="form-label col-xs-3 col-sm-3"><span class="c-red">*</span>姓名：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${obj.name}" placeholder="请输入姓名" name="name">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-3 col-sm-3"><span class="c-red">*</span>手机：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${obj.phone}" placeholder="请输入手机" name="phone">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-3 col-sm-3"><span class="c-red">*</span>借款时间：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" placeholder="请输入借款时间" onfocus="WdatePicker()" name="loanTime" value="${obj.loanTime?string('yyyy-MM-dd')}" class="input-text Wdate">	
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-3 col-sm-3">还款时间：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" placeholder="请输入还款时间" onfocus="WdatePicker()" name="repaymentTime" value="${obj.repaymentTime?string('yyyy-MM-dd')}" class="input-text Wdate">	
			</div>
		</div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-3 col-sm-offset-3">
				<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
			</div>
		</div>
	</form>
</article>
<script type="text/javascript">
$(function(){
	$("#form-member-add").validate({
		rules:{
			name:{
				required:true
			},
			phone:{
				required:true,
				isMobile:true
			},
			loanTime:{
				required:true
			},
			repaymentTime:{
				required:true
			},
		},
		onkeyup:false,
		focusCleanup:true,
		success:"valid",
		submitHandler:function(form){
			$(form).ajaxSubmit({
				type: 'post',
				url: "/borrower/edit" ,
				success: function(data){
					layer.msg(data.msg,{icon:1,time:1000});
					if(data.result){
						parent.$('.btn-refresh').click();
// 						var index = parent.layer.getFrameIndex(window.name);
// 						parent.layer.close(index);
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