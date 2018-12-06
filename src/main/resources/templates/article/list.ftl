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
<title>参选人列表</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 文章管理 <span class="c-gray en">&gt;</span> 文章管理 <a class="btn btn-success radius r btn-refresh" style="line-height:1.6em;margin-top:3px" onclick="location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	<div class="text-c">
	<div class="text-c">
<!-- 	<form action=""> -->
<!--     <input type="text" class="input-text" style="width:250px" placeholder="输入参选人名字" id="name" name="name"> -->
<!--     <button type="submit" class="btn btn-success" ><i class="icon-search"></i> 搜索</button> -->
<!--   	</form> -->
  </div>
	</div>
	<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l">
	 <a href="javascript:;" onclick="member_add('添加文章','/article/showAdd')" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i>添加文章</a></span> 
	 <span class="r">共有数据：<strong>${list?size}</strong> 条</span> </div>
	<div class="mt-20">
		<table class="table table-border table-bordered table-bg table-hover table-sort table-responsive">
			<thead>
				<tr class="text-c">
					<th width="80">文章编号</th>
					<th width="80">文章图片</th>
					<th width="80">文章主题</th>
					<th width="120">发布时间</th>
					<th width="80">状态提示</th>
					<th width="80">审核消息</th>
					<th width="120">操作</th>
				</tr>
			</thead>
			<tbody>
			<#if list?exists>
			 <#list list as obj>
				<tr class="text-c">
					<td>${obj.id}</td>
					<td>${obj.img}</td>
					<td>${obj.title}</td>
					<td>${obj.time?string("yyyy-MM-dd")!} </td>
					<td class="td-status">
						<#if obj.state?? && obj.state==0>
							<span class="label label-secondary radius">待审核</span>
						</#if>
						<#if obj.state?? && obj.state==1>
							<span class="label label-success radius">审核通过</span>
						</#if>
						<#if obj.state?? && obj.state==2>
							<span class="label label-danger  radius">审核失败</span>
						</#if>
					</td>
					<td>
						<#if obj.state?? && obj.state==0>
							审核中
						</#if>
						<#if obj.state?? && obj.state==1>
							审核通过
						</#if>
						<#if obj.state?? && obj.state==2>
							${obj.fail?if_exists}
						</#if>
					</td>
					<td class="f-14 td-manage">
					<a style="text-decoration:none" class="ml-5" onClick="obj_examine('审核文章','/article/showExamine',${obj.id})" href="javascript:;" title="审核"><i class="Hui-iconfont">&#xe725;</i></a>
					<a style="text-decoration:none" class="ml-5" onClick="showRemark('${obj.title}',${obj.id})"href="javascript:;" title="查看详情介绍"><i class="Hui-iconfont">&#xe665;</i></a>
					<a title="编辑" href="javascript:;" onclick="article_edit('修改文章信息','/article/showEdit',${obj.id})" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a>
					<a title="删除" href="javascript:;" onclick="deleteObj(this,'${obj.title}','/article/delete',${obj.id})" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe609;</i></a>
					</td>
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
	  {"orderable":false,"aTargets":[5]}// 不参与排序的列
	]
});

/*用户-添加*/
function member_add(title,url,pId){
	 /* 用途: 接收地直栏参数 取id=1 根据ID的值 */
	  urlinfo=window.location.href; //获取当前页面的url
	  len=urlinfo.length;//获取url的长度
	  offset=urlinfo.indexOf("?");//设置参数字符串开始的位置
	  newsidinfo=urlinfo.substr(offset,len)//取出参数字符串 这里会获得类似“id=1”这样的字符串
	 newsids=newsidinfo.split("=");//对获得的参数字符串按照“=”进行分割
	  newsid=newsids[1];//得到参数值
	  newsname=newsids[0];//得到参数名字
	var index = layer.open({
		type: 2,
		title: title,
		content: url+"?pId="+newsid
	});
// 	打开全屏
	layer.full(index);
}
function showRemark(title,id){
	var index = layer.open({
		type: 2,
		title:title+"详情介绍",
		area: ['50%', '500px'], //宽高
		content: '/article/showRemark?id='+id,
	});
	layer.full(index);
}
function showHeadImg(id){
	layer.open({
		  type: 1,
		  title: false,
		  closeBtn: 0,
		  area: '516px',
// 		  skin: 'layui-layer-nobg', //没有背景色
		  shadeClose: true,
		  content: $('#'+id+"_img")
		});
}
function obj_examine(title,url,id){
	$.ajax({url:"/article/isExamine",
		type:"post",
		dataType:"json",
		async:false,
		data:{"id":id},
		success:function(data){
			if(data.result){
				var index = layer.open({
					type: 2,
					title: title,
					content: url+"?id="+id
				});
			// 	打开全屏
				layer.full(index);
			}else{
				layer.msg(data.msg,{icon:2,time:2000});				
			}		
		}
	});
}
/*资讯-编辑*/
function article_edit(title,url,id){
	  urlinfo=window.location.href; //获取当前页面的url
	  len=urlinfo.length;//获取url的长度
	  offset=urlinfo.indexOf("?");//设置参数字符串开始的位置
	  newsidinfo=urlinfo.substr(offset,len)//取出参数字符串 这里会获得类似“id=1”这样的字符串
	 newsids=newsidinfo.split("=");//对获得的参数字符串按照“=”进行分割
	  newsid=newsids[1];//得到参数值
	  newsname=newsids[0];//得到参数名字
	  var index = layer.open({
			type: 2,
			title: title,
			content: url+"?id="+id+"&pId="+newsid
		});
//	 	打开全屏
		layer.full(index);
	}
/*资讯-删除*/
function deleteObj(obj,o,u,id){
	layer.confirm("确认要删除"+o+"吗？",function(index){
		$.ajax({
			type: 'POST',
			url: u,
			data:{"id":id},
			dataType: 'json',
			success: function(data){
				layer.msg(data.msg,{icon:1,time:2000});
				if(data.result){
					$(obj).parents("tr").remove();
				}
			},
			error:function(data) {
				layer.msg("网络异常,请稍后再试.",{icon:1,time:2000});
			},
		});		
	});
}
</script> 
</body>
</html>