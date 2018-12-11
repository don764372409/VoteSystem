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
<title>参选人详情</title>
</head>
<body>
<div class="cl pd-20" style=" background-color:#4495F7">
<a href="javascript:history.go(-1);" ><img style="width: 25px;" src="../../H-ui/static/h-ui/images/rollpic/back.png"/></a><p>
  <img style="width:30%;height:30%;margin-top: 8px;" class="avatar avatar-XL l" src="${obj.img!}">
  <dl style="margin-left:80px; color:#fff">
    <dt>
	<span class="f-18" style="margin: 10px;"></span>
	<span class="f-18" style="margin: 10px;">${obj.name!}</span></br>
	<span class="f-18" style="margin: 10px;">编号：${obj.id!}</span>
	</dt>
  </dl>
</div>
<div class="page-container">
<div class="mt-20">
<style>
.img-wrap p{
	width:100%;
	height:auto;
}
.img-wrap p img{
	width:100%;
	height:100%
}
</style>	
<div class="pd-20 img-wrap">
		${obj.remark!}
</div>
<button type="button" onclick="voting(${obj.id!},${vId!})" style="background-color: #4495F7;width: 100%;border-color:#4495F7;width: 50%;margin-left: 22.22%;" class="btn btn-success" >投票 </button>
</div></div>
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
//投票
	function voting(uid,vId){
		 $.ajax({
					type: 'post',
					url: "/wechatvoting" ,
					data: {
			        	"id":uid,
			        	"vId":vId
			        	},  
					success: function(data){
						layer.msg(data.msg,{icon:1,time:1000});
						window.location.reload();
					},
	                error: function(XmlHttpRequest, textStatus, errorThrown){
						layer.msg('网络异常,请刷新重试!',{icon:2,time:1000});
					}
				});
	}
	</script> 
</body>
</html>