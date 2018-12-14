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
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 参选人员管理 <span class="c-gray en">&gt;</span> 参选人员管理 <a class="btn btn-success radius r btn-refresh" style="line-height:1.6em;margin-top:3px" onclick="location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	<div class="text-c">
	<div class="text-c">
<!-- 	<form action=""> -->
<!--     <input type="text" class="input-text" style="width:250px" placeholder="输入参选人名字" id="name" name="name"> -->
<!--     <button type="submit" class="btn btn-success" ><i class="icon-search"></i> 搜索</button> -->
<!--   	</form> -->
  </div>
	</div>
	<div class="cl pd-5 bg-1 bk-gray mt-20"> 
		<span class="l">
			<#if type!=1>
			<#if btn1s??>
				<#list btn1s as btn>
				 	<a href="javascript:;" onclick="${btn.fn}" class="btn btn-primary radius"><i class="Hui-iconfont">${btn.icon}</i>${btn.name}</a>
				</#list>
			</#if>
			</#if>
	 	</span> 
	 <span class="r">共有数据：<strong>${list?size}</strong> 条</span> </div>
	<div class="mt-20">
		<table class="table table-border table-bordered table-bg table-hover table-sort table-responsive">
			<thead>
				<tr class="text-c">
					<th width="25">编号</th>
					<th width="40">姓名</th>
					<th width="40">头像</th>
					<th width="40">所属部门</th>
					<th width="75">状态</th>
					<th width="75">审核消息</th>
					<th width="120">操作</th>
				</tr>
			</thead>
			<tbody>
			<#if list?exists>
			 <#list list as obj>
				<tr class="text-c">
					<td>${obj.id?if_exists}</td>
					<td>${obj.name?if_exists}</td>
					<td>
						<img src="${obj.img?if_exists}" style="width: 30px;height: 30px;cursor: pointer;" onclick="showHeadImg(${obj.id})">
						<img src="${obj.img?if_exists}" style="display: none;width: 516px;" id="${obj.id}_img">
					</td>
					<td>
						${(obj.dept.name)!}
					</td>
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
					<#if type==1>
					<a style="text-decoration:none" class="ml-5" onClick="obj_add(${obj.id?if_exists})" href="javascript:;" title="添加"><i class="Hui-iconfont">添加</i></a>
					</#if>
					<#if type!=1>
						<#if btn2s??>
							<#list btn2s as btn2>
								<a style="text-decoration:none" class="ml-5" onClick="${btn2.fn?replace('obj.id','${obj.id}')?replace('obj.name','${obj.name}')}" href="javascript:;" title="${btn2.name}"><i class="Hui-iconfont">${btn2.icon}</i></a> 
							</#list>
						</#if>
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
	"aaSorting": [[ 0, "desc" ]],//默认第几个排序
	"bStateSave": true,//状态保存
	"pading":false,
	"aoColumnDefs": [
	  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
	  {"orderable":false,"aTargets":[6]}// 不参与排序的列
	]
});

function obj_add(title,url){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
// 	打开全屏
	layer.full(index);
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
	$.ajax({url:"/electionman/isExamine",
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
function obj_edit(title,url,id){
	$.ajax({url:"/electionman/isEdit",
		type:"post",
		dataType:"json",
		async:false,
		data:{"id":id},
		success:function(data){
			console.log(data);
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
// 	var index = layer.open({
// 		type: 2,
// 		title: title,
// 		content: url+"?id="+id
// 	});
// 	打开全屏
// 	layer.full(index);
}
function obj_del(name,obj,id){
	layer.confirm('确认要删除'+name+'这个预选人员吗？',function(index){
		$.ajax({
			type: 'post',
			data:{"id":id},
			url: "/electionman/delete",
			dataType: 'json',
			success: function(data){
				if (data.result) {
					layer.msg(data.msg,{icon:1,time:1000});
					$(obj).parents("tr").remove();
				}else{
					layer.msg(data.msg,{icon:2,time:2000});
				}
			},
			error:function(data) {
				$.Huimodalalert(data.msg,2000);
			},
		});		
	});
}


function obj_add(id){
		$.ajax({
			type: 'post',
			data:{"id":id},
			url: "/votingelection/add",
			dataType: 'json',
			success: function(data){
				layer.msg(data.msg,{icon:1,time:1000});
				if(data.result){
					window.parent.location.reload(); //刷新父页面
					var index = parent.layer.getFrameIndex(window.name);
						parent.layer.close(index);
				}
				//var index = parent.layer.getFrameIndex(window.name);
				//setTimeout(function(){parent.layer.close(index);},1000);
			},
			error:function(data) {
				$.Huimodalalert(data.msg,2000);
			},
		});		
}
</script> 
</body>
</html>