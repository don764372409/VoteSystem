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
<title>投票参选人列表</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 投票统计管理 <span class="c-gray en">&gt;</span> 投票参选人列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	<div class="text-c">
	<div class="text-c">
	<form action="">
    <!-- <input type="text" class="input-text" style="width:250px" placeholder="输入参选人名字" id="name" name="name">
    <button type="submit" class="btn btn-success" ><i class="icon-search"></i> 搜索</button> -->
  	</form>
  </div>
	</div>
	<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l">
	<#if btn1s??>
				<#list btn1s as btn>
				 	<a href="javascript:;" onclick="${btn.fn}" class="btn btn-primary radius"><i class="Hui-iconfont">${btn.icon}</i>${btn.name}</a>
				</#list>
			</#if>
	 </span> 
	 <span class="r">共有数据：<strong>${list?size}</strong> 条</span> </div>
	<div class="mt-20">
		<table class="table table-border table-bordered table-bg table-hover table-sort table-responsive">
			<thead>
				<tr class="text-c">
					<th width="80">编号</th>
					<th width="80">姓名</th>
					<th width="80">头像</th>
					<th width="75">得票数</th>
					<th width="120">所属活动</th>
					<th width="120">所属部门</th>
					<th width="120">投票截止日期</th>
					<th width="120">操作</th>
				</tr>
			</thead>
			<tbody>
			<#if list?exists>
			 <#list list as list>
				<tr class="text-c">
					<td>${list.eId?if_exists}</td>
					<td class="text-l">${list.name?if_exists}</td>
					<td><img src="${list.img?if_exists}" style="width: 80px;height: 80px;"></td>
					<td>${list.number?if_exists}</td>
					<td>${list.title?if_exists} </td>
					<td>${(list.dept.name)!}</td>
					<td><#if list.endtime?exists>${list.endtime?string("yyyy-MM-dd")!}</#if></td>
					<td>
					<#if btn2s??>
							<#list btn2s as btn2>
								<a style="text-decoration:none" class="ml-5" onClick="${btn2.fn?replace('list.id','${list.id}')?replace('list.name','${list.name}')?replace('list.eId','${list.eId}')}" href="javascript:;" title="${btn2.name}"><i class="Hui-iconfont">${btn2.icon}</i></a> 
							</#list>
						</#if>
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
	  {"orderable":false,"aTargets":[0,7]}// 不参与排序的列
	]
});

/*用户-添加*/
function member_add(title,url,w,h){
	layer_show(title,url,w,h);
}

/*资讯-编辑*/
function article_edit(title,url,id){
	layer_show(title,url+"?id="+id,"",550);
}
/*资讯-删除*/
function obj_del(obj,id){
	layer.confirm('确认要删除吗？',function(index){
		$.ajax({
			type: 'post',
			data:{"id":id},
			url: "/votingelection/delete",
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
function showRemark(name,id){
	var index = layer.open({
		type: 2,
		title:name+"详情介绍",
		area: ['50%', '500px'], //宽高
		content: '/electionman/showRemark?id='+id,
	});
	layer.full(index);
}


</script> 
</body>
</html>