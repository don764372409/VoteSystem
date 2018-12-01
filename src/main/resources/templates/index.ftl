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
<!--[if IE 6]>
<script type="text/javascript" src="/H-ui/lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>短信接口管理平台</title>
<style type="text/css">
@media (max-width: 767px){
	#Hui-userbar{
		display: block !important;
		background: #000;
		width:100%;
		height:45px;
		left:0;
		z-index:-1;
	}
	.navbar-nav>ul>li.dropDown>.dropDown_A>.Hui-iconfont{
		display: inline-block;
	}
	#Hui-userbar{
		display:block !important; 
	}
}
</style>
</head>
<body>
<header class="navbar-wrapper">
	<div class="navbar navbar-fixed-top">
		<div class="container-fluid cl"> <a class="logo navbar-logo f-l mr-10 hidden-xs" href="/index/">微信公众号管理平台</a> 
			<a aria-hidden="false" class="nav-toggle Hui-iconfont visible-xs" href="javascript:;">&#xe667;</a>
			<nav class="nav navbar-nav">
				<ul class="cl">
<!-- 					<li class="dropDown dropDown_hover"><a href="javascript:;" class="dropDown_A"><i class="Hui-iconfont">&#xe600;</i> 新增 <i class="Hui-iconfont">&#xe6d5;</i></a> -->
<!-- 						<ul class="dropDown-menu menu radius box-shadow"> -->
<!-- 							<li><a href="javascript:;" onclick="content_add('添加短信模板','/content/showAdd')"><i class="Hui-iconfont">&#xe616;</i> 短信模板</a></li> -->
<!-- 							<li><a href="javascript:;" onclick="borrower_add('添加短信用户','/borrower/showAdd')"><i class="Hui-iconfont">&#xe62d;</i> 短信用户</a></li> -->
<!-- 					</ul> -->
				</li>
			</ul>
		</nav>
		<nav id="Hui-userbar" class="nav navbar-nav navbar-userbar hidden-xs">
			<ul class="cl">
				<li class="dropDown dropDown_hover">
					<a href="#" class="dropDown_A">${loginAdmin.name}<i class="Hui-iconfont">&#xe6d5;</i></a>
					<ul class="dropDown-menu menu radius box-shadow">
						<li><a href="javascript:;" onClick="editUser('密码修改','/user/showPassword')">密码修改</a></li>
						<li><a href="javascript:;" onClick="editUser('手机号码修改','/user/showPhone')">手机修改</a></li>
						<li><a href="/login/logout">退出</a></li>
				</ul>
			</li>
				<li id="Hui-skin" class="dropDown right dropDown_hover"> <a href="javascript:;" class="dropDown_A" title="换肤"><i class="Hui-iconfont" style="font-size:18px">&#xe62a;</i></a>
					<ul class="dropDown-menu menu radius box-shadow">
						<li><a href="javascript:;" data-val="default" title="默认（黑色）">默认（黑色）</a></li>
						<li><a href="javascript:;" data-val="blue" title="蓝色">蓝色</a></li>
						<li><a href="javascript:;" data-val="green" title="绿色">绿色</a></li>
						<li><a href="javascript:;" data-val="red" title="红色">红色</a></li>
						<li><a href="javascript:;" data-val="yellow" title="黄色">黄色</a></li>
						<li><a href="javascript:;" data-val="orange" title="橙色">橙色</a></li>
					</ul>
				</li>
			</ul>
		</nav>
	</div>
</div>
</header>
<aside class="Hui-aside">
	<div class="menu_dropdown bk_2">
		<#list list as obj>
			<dl id="menu-article">
				<dt><i class="Hui-iconfont">&#xe616;</i> ${obj.name}<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
				<dd>
					<ul>
						<#list obj.children as o>
							<li><a data-href="${o.url?if_exists}" data-title="${o.name}" href="javascript:void(0)">${o.name}</a></li>
						</#list>
					</ul>
				</dd>
			</dl>
		</#list>
	</div>
</aside>
<div class="dislpayArrow hidden-xs"><a class="pngfix" href="javascript:void(0);" onClick="displaynavbar(this)"></a></div>
<section class="Hui-article-box">
	<div id="Hui-tabNav" class="Hui-tabNav hidden-xs">
		<div class="Hui-tabNav-wp">
			<ul id="min_title_list" class="acrossTab cl">
				<li class="active">
					<span title="我的办公" data-href="/sms/list">首页</span>
					<em></em></li>
		</ul>
	</div>
</div>
	<div id="iframe_box" class="Hui-article">
		<div class="show_iframe">
			<div style="display:none" class="loading"></div>
			<iframe scrolling="yes" frameborder="0" src="/sms/list"></iframe>
	</div>
</div>
</section>
<div class="contextMenu" id="Huiadminmenu">
	<ul>
		<li id="closethis">关闭当前 </li>
		<li id="closeall">关闭全部 </li>
</ul>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="/H-ui/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="/H-ui/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="/H-ui/static/h-ui/js/H-ui.js"></script>
<script type="text/javascript" src="/H-ui/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->
<script type="text/javascript">
<!--请在下方写此页面业务相关的脚本-->
function borrower_add(title,url){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
function content_add(title,url){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
function editUser(title,url){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
$(function(){
	if($("body").width()<767){
		$(".dropDown_A").click(function(){
			var liEl = $(this).parent();
			if(liEl.hasClass("open")){
				liEl.removeClass("open");
				$(".dropDown>.dropDown-menu").show();
			}else{
				liEl.addClass("open");
				$(".dropDown>.dropDown-menu").hide();
			}
			$("#Hui-skin").hide();
		})
	}
})

</script> 

</body>
</html>