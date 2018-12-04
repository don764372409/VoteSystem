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
			<label class="form-label col-xs-4 col-sm-1"><span class="c-red">*</span>人员姓名：</label>
			<div class="formControls col-xs-8 col-sm-11">
				<input type="text" class="input-text" value="" placeholder="请输入人员姓名" id="username" name="name">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-1"><span class="c-red">*</span>所属部门：</label>
			<div class="formControls col-xs-8 col-sm-11">
				<div style="position: relative;">
				<input type="hidden" value="" name="deptId">
				<input type="text" readonly="readonly" onclick="openOrganizeDialog()" class="input-text" value="" placeholder="请选择所属机构部门" name="deptName">
				<a title="点击查看机构列表" href="javascript:;" onclick="openOrganizeDialog()" class="ml-5 searchBtn" style="text-decoration:none;"><i class="Hui-iconfont">&#xe665;</i></a>
				</div>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-1"><span class="c-red">*</span>展示头像：</label>
			<div class="formControls col-xs-8 col-sm-11">
				<div class="uploader-thum-container">
					<div id="fileList" class="uploader-list"></div>
					<div style="margin-bottom: 10px;">
						<input name="headImg" type="hidden">
						<img alt="" id="headImg" src="/commons/jia.png" width="100" height="120" >
					</div>
					<div id="filePicker">上传头像图片</div>
				</div>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-1"><span class="c-red">*</span>人物介绍：</label>
			<div class="formControls col-xs-8 col-sm-11"> 
				<script id="editor" type="text/plain" style="width:100%;height:400px;"></script> 
			</div>
		</div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-sm-offset-1">
				<button class="btn btn-primary radius" type="submit"><i class="Hui-iconfont">&#xe632;</i> 保存并提交审核</button>
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
function openOrganizeDialog(){
	var index = layer.open({
		  type: 2,
		  title:"部门选择",
		  area: ['50%', '500px'], //宽高
		  content: '/admin/showOrg',
		  btn:['确定'],
		  yes:function(){
			  layer.close(index);
		  }
	});
}
$(function(){
	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});
	var ue = UE.getEditor('editor');
	
	$("#form-member-add").validate({
		rules:{
			name:{
				required:true
			},
		},
		onkeyup:false,
		focusCleanup:true,
		success:"valid",
		submitHandler:function(form){
			var deptId = $("input[name=deptId]").val();
			var remark = ue.getContent();
			var headImg = $("input[name=headImg]").val();
			$(form).ajaxSubmit({
				type: 'post',
				url: "/electionman/add" ,
				data:{"deptId":deptId,"remark":remark,"img":headImg},
				success: function(data){
					layer.msg(data.msg,{icon:1,time:1000});
					if(data.result){
						parent.$('.btn-refresh').click();
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
			layer.msg("头像上传成功,点击按钮可替换.",{icon:1,time:1000});
			$("#headImg").attr("src",ret.msg);
			$("input[name=headImg]").val(ret.msg);
			$(".webuploader-pick").html("修改头像图片");
		}else{
			layer.msg("头像上传失败,请刷新重试.",{icon:1,time:1000});
			$(".webuploader-pick").html("上传头像图片");
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
</body>
</html>