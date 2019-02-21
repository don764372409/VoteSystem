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

<title>添加投票活动</title>
</head>
<body>
<article class="page-container">
	<form class="form form-horizontal" id="form-member-add">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>活动标题：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="" id="title" name="title">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>上传封面：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<div class="uploader-thum-container">
					<div id="fileList" class="uploader-list"></div>
					<div style="margin-bottom: 10px;">
						<input name="img" type="hidden">
						<img alt="" id="headImg" src="/commons/jia.png" width="100" height="120" >
					</div>
					<div id="filePicker">上传封面图片</div>
				</div>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>活动介绍（规则）：</label>
			<div class="formControls col-xs-8 col-sm-9"> 
			<textarea name="rule" cols="" rows="" class="textarea"  placeholder="规则和介绍：一人一天一票...." datatype="*10-100" dragonfly="true" nullmsg="不能为空！" onKeyUp="$.Huitextarealength(this,200)"></textarea> 
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>是否默认添加参选人员：</label>
			<div class="formControls col-xs-8 col-sm-9"> 
			<input type="radio" value="0" placeholder="" id="status" name="status" checked>否
			<input type="radio" value="1" placeholder="" id="status" name="status">是
			 </div>
		</div>
		<span class="c-red">注意：选择“是”状态可以自动添加审核通过的参选人员,且一个系统中同一时间只能存在一个状态为“是”的投票活动.</span>
		<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>开始时间：</label>
		<input type="text" name="starttimes" onfocus="WdatePicker({})" id="datemin" class="input-text Wdate" style="width:120px;">
		<span class="c-red">*</span>结束时间
		<input type="text" name="endtimes" onfocus="WdatePicker({ minDate:'#F{$dp.$D(\'datemin\')}'})" id="datemax" class="input-text Wdate" style="width:120px;">
		</div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
				<button class="btn btn-primary radius" type="submit"><i class="Hui-iconfont">&#xe632;</i> 保存并提交</button>
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
<script type="text/javascript">
$(function(){
	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});
	
	});
	//表单验证
	$(function(){
	$("#form-member-add").validate({
		rules:{
			title:{
				required:true
			},
			rule:{
				required:true
			},
			starttimes:{
				required:true
			},
			endtimes:{
				required:true
			},
			
		},
		onkeyup:false,
		focusCleanup:true,
		success:"valid",
		submitHandler:function(form){
		var headImg = $("input[name=img]").val();
			$(form).ajaxSubmit({
				type: 'post',
				url: "/vote/add" ,
				success: function(data){
					layer.msg(data.msg,{icon:1,time:2000});
					if(data.result){
						window.parent.location.reload(); //刷新父页面
						var index = parent.layer.getFrameIndex(window.name);
 						parent.layer.close(index);
					}
				},
                error: function(XmlHttpRequest, textStatus, errorThrown){
					layer.msg('网络异常,请刷新重试!',{icon:2,time:1000});
				}
			});
		}
	});
	$list = $("#fileList"),
	$btn = $("#btn-star"),
	state = "pending",
	uploader;
	var server_url = window.location.protocol+"//"+window.location.hostname+":"+window.location.port;
	var uploader = WebUploader.create({
		auto: true,
		swf: '/H-ui/lib/webuploader/0.1.5/Uploader.swf',
		// 文件接收服务端。
		server: '/upload/on',
		// 选择文件的按钮。可选。
		// 内部根据当前运行是创建，可能是input元素，也可能是flash.
		pick: {
			id:'#filePicker',
			multiple:false
		},
		// 不压缩image, 默认如果是jpeg，文件上传前会压缩一把再上传！
		resize: false,
		// 只允许选择图片文件。
		accept: {
			title: 'Images',
			extensions: 'gif,jpg,jpeg,bmp,png',
			mimeTypes: 'image/jpg,image/jpeg,image/png'
		},thumb: {
		       type: 'image/jpg,jpeg,png'
	    },auto:true
	});
	// 文件上传过程中创建进度条实时显示。
	uploader.on( 'uploadSuccess', function( object,ret ) {
		if (ret.result) {
			uploader.reset();
			layer.msg("活动图片上传成功,点击按钮可替换.",{icon:1,time:1000});
			$("#headImg").attr("src",ret.msg);
			$("input[name=img]").val(ret.msg);
			$(".webuploader-pick").html("修改活动图片");
		}else{
			layer.msg("活动图片失败,请刷新重试.",{icon:1,time:1000});
			$(".webuploader-pick").html("上传活动图片");
		}
	});
	// 文件上传失败，显示上传出错。
	uploader.on( 'uploadError', function( file ) {
		$( '#'+file.id ).addClass('upload-state-error').find(".state").text("上传出错");
	});
    $btn.on('click', function () {
         uploader.upload();
    });
});
	
</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>