<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
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
<title>管理员管理</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 系统管理 <span class="c-gray en">&gt;</span> 角色管理 <a class="btn btn-success radius r btn-refresh" style="line-height:1.6em;margin-top:3px" onclick="location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="pd-20">
  <div class="cl pd-5 bg-1 bk-gray mt-20">
    <a href="javascript:;" onclick="addObj('添加角色','/role/showAdd')" class="btn btn-primary radius"><i class="icon-plus"></i> 添加角色</a></span>
    <span class="r">共有数据：<strong>${list?size}</strong> 条</span>
  </div>
  <div class="mt-20"></div>
  <table class="table table-border table-bordered table-hover table-bg table-sort">
    <thead>
      <tr class="text-c">
        <th width="40">ID</th>
        <th width="100">角色名称</th>
        <th width="100">数据范围</th>
        <th width="60">操作</th>
      </tr>
    </thead>
    <tbody>
    <#list list as obj>
      <tr class="text-c">
        <td>${obj.id}</td>
        <td>${obj.name!}</td>
        <td>
       		<#if obj.dataRange==0>
       			当前部门
       		</#if>
       		<#if obj.dataRange==1>
       			当前机构
       		</#if>
       		<#if obj.dataRange==2>
       			当前及下属机构
       		</#if>
       		<#if obj.dataRange==3>
       			所有
       		</#if>
        </td>
        <td class="f-14 user-manage">
        	<a title="编辑" href="javascript:;" onclick="edit('修改角色信息','/role/showEdit',${obj.id})" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a>
        	<a title="删除" href="javascript:;" onclick="deleteObj(this,'${obj.name}','/role/delete',${obj.id})" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe609;</i></a>
       	</td>
      </tr>
     </#list>
    </tbody>
  </table>
  <div id="pageNav" class="pageNav"></div>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="/H-ui/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="/H-ui/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="/H-ui/static/h-ui/js/H-ui.js"></script> 
<script type="text/javascript" src="/H-ui/static/h-ui.admin/js/H-ui.admin.js"></script>
<!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="/H-ui/lib/My97DatePicker/4.8/WdatePicker.js"></script> 
<script type="text/javascript" src="/H-ui/lib/datatables/1.10.0/jquery.dataTables.min.js"></script> 
<script type="text/javascript" src="/H-ui/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">
window.onload = (function(){
    // optional set
    pageNav.pre="&lt;上一页";
    pageNav.next="下一页&gt;";
    // p,当前页码,pn,总页面
    pageNav.fn = function(p,pn){$("#pageinfo").text("当前页:"+p+" 总页: "+pn);};
    //重写分页状态,跳到第三页,总页33页
//     pageNav.go(1,13);
});
$('.table-sort').dataTable({
// 	"lengthMenu":false,//显示数量选择  默认显示
	"bFilter": true,//过滤功能
	"bPaginate": true,//翻页信息
	"bInfo": false,//数量信息
	"aaSorting": [[ 0, "desc" ]],//默认第几个排序
	"bStateSave": true,//状态保存
	"aoColumnDefs": [
	  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
// 	  {"orderable":false,"aTargets":[0,4,5]}// 制定列不参与排序
	]
});
function addObj(title,url){
// 	layer_show(title,url,700,300);
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
// 	打开全屏
	layer.full(index);
}
function edit(title,url,id){
	layer_show(title,url+"?id="+id,550,300);
// 	var index = layer.open({
// 		type: 2,
// 		title: title,
// 		content: url+"?id="+id
// 	});
// 	layer.full(index);
}

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
