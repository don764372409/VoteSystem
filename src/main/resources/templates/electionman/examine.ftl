<!--_meta 作为公共模版分离出去-->
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
<script type="text/javascript" src="../H-ui/lib/html5shiv.js"></script>
<script type="text/javascript" src="../H-ui/lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="../H-ui/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="../H-ui/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="../H-ui/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="../H-ui/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="../H-ui/lib/webuploader/0.1.5/webuploader.css" />
<link rel="stylesheet" type="text/css" href="../H-ui/static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="../H-ui/lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<!--/meta 作为公共模版分离出去-->

<title>添加预选人</title>
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
	<form class="form form-horizontal" id="form-member-add">
		<div class="row cl">
			<label class="form-label  col-sm-1"><span class="c-red">*</span>人员姓名：</label>
			<div class="formControls col-xs-8 col-sm-11">
				<input type="hidden" value="${obj.id}" name="id">
				<input type="text" class="input-text" value="${obj.name}" readonly="readonly" placeholder="请输入人员姓名" id="username" name="name">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-1"><span class="c-red">*</span>所属部门：</label>
			<div class="formControls col-xs-8 col-sm-11">
				<div style="position: relative;">
				<input type="hidden" value="${(obj.deptId)!}" name="deptId">
				<input type="text" readonly="readonly" class="input-text" value="${(dept.name)!}" placeholder="请选择所属机构部门" name="deptName">
				</div>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-1"><span class="c-red">*</span>展示头像：</label>
			<div class="formControls col-xs-8 col-sm-11">
				<div class="uploader-thum-container">
					<div id="fileList" class="uploader-list"></div>
					<div style="margin-bottom: 10px;">
						<#if obj.img??>
							<img alt="" id="headImg" src="${obj.img}" width="100" height="120" >
							<#else>
							<img alt="" id="headImg" src="/commons/jia.png" width="100" height="120" >
						</#if>
						
					</div>
				</div>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-1"><span class="c-red">*</span>人物介绍：</label>
			<div class="formControls col-xs-8 col-sm-11"> 
				<input name="rem" value='${obj.remark!}' type="hidden">
				<script id="editor" type="text/plain" style="width:100%;height:400px;"></script> 
			</div>
		</div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-sm-offset-1">
				<button class="btn btn-success  radius" type="button" onclick="examine(1)"><i class="Hui-iconfont">&#xe676;</i> 准以通过</button>
				<button class="btn btn-warning radius" type="button" onclick="examine(2)"><i class="Hui-iconfont">&#xe706;</i> 不准通过</button>
			</div>
		</div>
	</form>
</article>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="../H-ui/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="../H-ui/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="../H-ui/static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="../H-ui/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer /作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="../H-ui/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="../H-ui/lib/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="../H-ui/lib/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="../H-ui/lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript" src="../H-ui/lib/webuploader/0.1.5/webuploader.min.js"></script> 
<script type="text/javascript" src="/H-ui/lib/ueditor/1.4.3.3/ueditor.config.js"></script> 
<script type="text/javascript" src="/H-ui/lib/ueditor/1.4.3.3/ueditor.all.js"> </script> 
<script type="text/javascript" src="/H-ui/lib/ueditor/1.4.3.3/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript">
$(function(){
	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});
	var ue = UE.getEditor('editor');
	ue.addListener("ready", function () { 
		var rem = $("input[name=rem]").val();
		ue.setContent(rem,true);
		ue.setDisabled('fullscreen');
	});
});
function examine(state){
	var id = $("input[name=id]").val();
	if (state==1) {
		$.post("/electionman/examine",{"id":id,"state":1},function(data){
			
		});
	}
	if(state==2){
		layer.prompt({title: '请输入不准通过原因', formType: 2}, function(text, index){
			layer.close(index);
			$.post("/electionman/examine",{"id":id,"state":2,"fail":text},function(data){
				if(data.result){
					layer.msg(data.msg,{icon:1,time:1000});
					parent.$('.btn-refresh').click();
					var index = parent.layer.getFrameIndex(window.name);
					parent.layer.close(index);
				}else{
					layer.msg(data.msg,{icon:2,time:2000});
				}	
			});
		});
	}
}
</script>
</body>
</html>