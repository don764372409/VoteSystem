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
<link rel="stylesheet" type="text/css" href="/zTree/metroStyle/metroStyle.css" />

<script type="text/javascript" src="/H-ui/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="/H-ui/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="/H-ui/static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="/H-ui/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<script type="text/javascript" src="/H-ui/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="/H-ui/lib/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="/H-ui/lib/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="/H-ui/lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript" src="/zTree/jquery.ztree.core.min.js"></script>
<script type="text/javascript" src="/zTree/jquery.ztree.excheck.js"></script>
<!--[if IE 6]>
<script type="text/javascript" src="/H-ui/lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<!--/meta 作为公共模版分离出去-->
<title>修改角色</title>
</head>
<body>
<article class="page-container">
	<form action="" method="post" class="form form-horizontal" id="form-member-add">
		<input type="hidden"value="${obj.id}" name="id">
		<div class="row cl">
			<label class="form-label col-xs-3 col-sm-3"><span class="c-red">*</span>角色名称：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${obj.name}" placeholder="请输入角色名称" name="name">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-3 col-sm-3"><span class="c-red">*</span>数据范围：</label>
			<div class="formControls col-xs-8 col-sm-9 skin-minimal">
				<#if obj.dataRange ==0 >
					<div class="radio-box">
						<input name="dataRange" value="0" type="radio" id="sex-1" checked>
						<label for="sex-1">当前部门</label>
					</div>
					<div class="radio-box">
						<input type="radio" value="1" id="sex-2" name="dataRange">
						<label for="sex-2">当前机构</label>
					</div>
					<div class="radio-box">
						<input type="radio" value="2" id="sex-3" name="dataRange">
						<label for="sex-3">当前及下属机构</label>
					</div>
					<div class="radio-box">
						<input type="radio" value="3" id="sex-4" name="dataRange">
						<label for="sex-4">所有机构</label>
					</div>
				</#if>
				<#if obj.dataRange ==1 >
					<div class="radio-box">
						<input name="dataRange" value="0" type="radio" id="sex-1">
						<label for="sex-1">当前部门</label>
					</div>
					<div class="radio-box">
						<input type="radio" value="1" id="sex-2" name="dataRange" checked>
						<label for="sex-2">当前机构</label>
					</div>
					<div class="radio-box">
						<input type="radio" value="2" id="sex-3" name="dataRange">
						<label for="sex-3">当前及下属机构</label>
					</div>
					<div class="radio-box">
						<input type="radio" value="3" id="sex-4" name="dataRange">
						<label for="sex-4">所有机构</label>
					</div>
				</#if>
				<#if obj.dataRange ==2 >
					<div class="radio-box">
						<input name="dataRange" value="0" type="radio" id="sex-1">
						<label for="sex-1">当前部门</label>
					</div>
					<div class="radio-box">
						<input type="radio" value="1" id="sex-2" name="dataRange">
						<label for="sex-2">当前机构</label>
					</div>
					<div class="radio-box">
						<input type="radio" value="2" id="sex-3" name="dataRange" checked>
						<label for="sex-3">当前及下属机构</label>
					</div>
					<div class="radio-box">
						<input type="radio" value="3" id="sex-4" name="dataRange">
						<label for="sex-4">所有机构</label>
					</div>
				</#if>
				<#if obj.dataRange ==3 >
					<div class="radio-box">
						<input name="dataRange" value="0" type="radio" id="sex-1">
						<label for="sex-1">当前部门</label>
					</div>
					<div class="radio-box">
						<input type="radio" value="1" id="sex-2" name="dataRange">
						<label for="sex-2">当前机构</label>
					</div>
					<div class="radio-box">
						<input type="radio" value="2" id="sex-3" name="dataRange">
						<label for="sex-3">当前及下属机构</label>
					</div>
					<div class="radio-box">
						<input type="radio" value="3" id="sex-4" name="dataRange" checked>
						<label for="sex-4">所有机构</label>
					</div>
				</#if>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-3 col-sm-3"><span class="c-red">*</span>菜单权限：</label>
			<div class="formControls col-xs-8 col-sm-9 skin-minimal">
				<div class="panel panel-default">
					<div class="panel-header">父级菜单>子级菜单>按钮</div>
					<div class="panel-body">
						<ul id="tree" class="ztree"></ul>
					</div>
				</div>
			</div>
		</div>
		
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-3 col-sm-offset-3">
				<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
			</div>
		</div>
	</form>
</article>
<script type="text/javascript">
$(function(){
	var setting = {
		check: {
			enable: true
		},
		data: {
			simpleData: {
				enable: true
			}
		}
	};
	
	var zNodes =[
	];
	$.ajax({
		url:"/role/getAllResource",
		type:"post",
		dataType:"json",
		async:false,
		success:function(data){
			for(var i = 0;i<data.length;i++){
				var parent = data[i];
				zNodes.push({id:parent.id,pId:0,name:parent.name,open:true});
				var children = parent.children;
				for (var j = 0; j < children.length; j++) {
					var child = children[j];
					zNodes.push({id:child.id,pId:child.pId,name:child.name,open:true});
					var btns = child.children;
					for (var k = 0; k < btns.length; k++) {
						var btn = btns[k];
						zNodes.push({id:btn.id,pId:child.pId,name:btn.name});
					}
				}
			}
			var tree = $.fn.zTree.init($("#tree"), setting, zNodes);
			var id = $("input[name=id]").val();
			$.ajax({
				url:"/role/getAllResourceByRole",
				type:"post",
				dataType:"json",
				data:{'roleId':id},
				async:false,
				success:function(ids){
					for (var i = 0; i < ids.length; i++) {
						var id = ids[i];
						var node = tree.getNodesByFilter(function(node){
							if (id==node.id) {
								return node;
							}
						},true,null,id);
						tree.checkNode(node,true,false);
					}
				}
			})
		}
	});
	
	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});

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
			var tree = $.fn.zTree.getZTreeObj("tree");
			var nodes = tree.getCheckedNodes(true);
			var ids =[];
			for (var i = 0; i < nodes.length; i++) {
				ids.push(nodes[i].id);
			}
			
			$(form).ajaxSubmit({
				type: 'post',
				url: "/role/edit",
				data:{"ids":ids},
				async:false,
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
});

</script> 
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>