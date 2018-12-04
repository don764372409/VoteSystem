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
<title>投票活动列表</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 投票活动管理 <span class="c-gray en">&gt;</span> 投票活动列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	<div class="text-c">
	<div class="text-c">
	<form action="">
    <input type="text" class="input-text" style="width:250px" placeholder="投票活动标题" id="name" name="name">
    <button type="submit" class="btn btn-success" ><i class="icon-search"></i> 搜索</button>
  	</form>
  </div>
	</div>
	<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l">
	<!-- <a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a>  -->
	<a class="btn btn-primary radius" data-title="添加投票活动" onclick="voting_add('添加投票活动','/vote/showadd','','510')" href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 添加投票活动</a></span>
	<span class="r">共有数据：<strong>${voting?size}</strong> 条</span> </div>
	<div class="mt-20">
		<table class="table table-border table-bordered table-bg table-hover table-sort table-responsive">
			<thead>
				<tr class="text-c">
					<th width="25"><input type="checkbox" name="" value=""></th>
					<th width="80">活动id</th>
					<th width="80">标题</th>
					<th width="80">活动介绍（规则）</th>
					<th width="120">开始时间</th>
					<th width="75">结束时间</th>
					<th width="120">操作</th>
				</tr>
			</thead>
			<tbody>
			<#if voting?exists>
			 <#list voting as voting>
				<tr class="text-c">
					<td><input type="checkbox" value="" name=""></td>
					<td>${voting.id?if_exists}</td>
					<td class="text-l">${voting.title?if_exists}</td>
					<td>
					<#if voting.rule?length gt 33>
					${voting.rule?substring(0,30)}...
					<#else>
					${voting.rule!} 
					</#if>
					</td>
					<td>
					<#if voting.starttime?exists>${voting.starttime?string("yyyy-MM-dd")!}</#if>
					</td>
					<td><#if voting.endtime?exists>${voting.endtime?string("yyyy-MM-dd")!}</#if></td>
					<td class="f-14 td-manage">
					<a style="text-decoration:none" class="ml-5" onClick="article_edit('活动编辑','/vote/showEdit',${voting.id})" href="javascript:;" title="编辑"><i class="Hui-iconfont">&#xe6df;</i></a> 
					<a style="text-decoration:none" class="ml-5" onClick="candidate_del(this,${voting.id})" href="javascript:;" title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a></td>
				</tr>
				</#list>
				</#if>
			</tbody>
		</table>
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
$('.table-sort').dataTable({
	"aaSorting": [[ 1, "desc" ]],//默认第几个排序
	"bStateSave": true,//状态保存
	"pading":false,
	"aoColumnDefs": [
	  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
	  {"orderable":false,"aTargets":[0,6]}// 不参与排序的列
	]
});
/*活动-添加*/
function voting_add(title,url,w,h){
	layer_show(title,url,w,h);
}
/*资讯-编辑*/
function article_edit(title,url,id){
	layer_show(title,url+"?id="+id,"",550);
}
/*资讯-删除*/
function candidate_del(obj,id){
	layer.confirm('确认要删除吗？',function(index){
		$.ajax({
			type: 'post',
			data:{"id":id},
			url: "/vote/delete",
			dataType: 'json',
			success: function(data){
				layer.msg('已删除!',{icon:1,time:1000});
				$(obj).parents("tr").remove();
			},
			error:function(data) {
				$.Huimodalalert(data.msg,2000);
			},
		});		
	});
}

/*资讯-审核*/
function article_shenhe(obj,id){
	layer.confirm('审核文章？', {
		btn: ['通过','不通过','取消'], 
		shade: false,
		closeBtn: 0
	},
	function(){
		$(obj).parents("tr").find(".td-manage").prepend('<a class="c-primary" onClick="article_start(this,id)" href="javascript:;" title="申请上线">申请上线</a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已发布</span>');
		$(obj).remove();
		layer.msg('已发布', {icon:6,time:1000});
	},
	function(){
		$(obj).parents("tr").find(".td-manage").prepend('<a class="c-primary" onClick="article_shenqing(this,id)" href="javascript:;" title="申请上线">申请上线</a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-danger radius">未通过</span>');
		$(obj).remove();
    	layer.msg('未通过', {icon:5,time:1000});
	});	
}
/*资讯-下架*/
function article_stop(obj,id){
	layer.confirm('确认要下架吗？',function(index){
		$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="article_start(this,id)" href="javascript:;" title="发布"><i class="Hui-iconfont">&#xe603;</i></a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-defaunt radius">已下架</span>');
		$(obj).remove();
		layer.msg('已下架!',{icon: 5,time:1000});
	});
}

/*资讯-发布*/
function article_start(obj,id){
	layer.confirm('确认要发布吗？',function(index){
		$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="article_stop(this,id)" href="javascript:;" title="下架"><i class="Hui-iconfont">&#xe6de;</i></a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已发布</span>');
		$(obj).remove();
		layer.msg('已发布!',{icon: 6,time:1000});
	});
}
/*资讯-申请上线*/
function article_shenqing(obj,id){
	$(obj).parents("tr").find(".td-status").html('<span class="label label-default radius">待审核</span>');
	$(obj).parents("tr").find(".td-manage").html("");
	layer.msg('已提交申请，耐心等待审核!', {icon: 1,time:2000});
}
</script> 
</body>
</html>