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
<style type="text/css">
.tbtd{background-color: #4495F7;border-color:#4495F7;color: #fff;}
.sb{float: left;padding: 4% 2%;width: 45%;box-sizing: border-box;margin-right: 1%;margin-left: 4%;position: relative;}
.tip-bot{background:#fff;padding:5px}
.prov{border: solid 1px #ddd;width: 33%;}
.city{border: solid 1px #ddd;width: 33%;}
.county{border: solid 1px #ddd;}
.tip-p{position: absolute;top: 16px;left: 7px;background: #939393;color: #fff;}
.as{display: inline-block;height: 144.28px;width: 100%;}
.footer{
            padding: 6px 0;
            position: fixed;
    		bottom: 80px;
            left: 0;
            width: 100%;
            background-color: #ffffff;
        }

</style>
<title>参选人列表</title>
</head>
<body>
<div id="content" class="page-container" style="background-color: #FAFAFA;">
<div class="text-c">
	<img src="${fm?if_exists}" style="width: 100%;height: 144.28px;">
</div>
	<div class="text-c">
	<div class="text-c">
	<table style="background-color: #4495f7;">
	<tr>
	<td class="tbtd">${list?size}<p>参选数</p></td>
	<td class="tbtd"><span id="tp" data-tp="${totle}">${totle}</span><p>总投票 </p></td>
	<td class="tbtd">${vist!}<p>浏览量</p></td>
	</tr>
	</table>
	<form action="" id="vform" style="margin-top: 10px;">
	<div>
	选择机构:
	<select name="organize" class="prov"></select>
    <select name="dept" class="city"></select>
    <!-- <select name="voter" class="county"></select> -->
	</div>
	<div style="margin-top: 8px;">
    <input type="text" id="name" name="name" class="input-text" style="width: 70%;" placeholder="姓名/编号">
    <button type="submit" style="background-color: #4495F7;width: 25%;border-color:#4495F7;" class="btn btn-success" ><i class="icon-search"></i> 搜索</button>
  	</div>
  	</form>
  </div>
	</div>
	<div class="mt-20" style="background: #eee;overflow: hidden;">
	<ul id="ull" style="overflow: hidden;margin-left: -2%;font-size: 12px;">
		<#if list?exists>
			 <#list list as obj>
					<li class="sb">
						<a class="as" href="/wechatvshow?id=${obj.uid!}&vId=${obj.vId!}">
						<img src="${obj.img?if_exists}" style="width: 100%;height: 144.28px;">
						</a>
						<p class="tip-p">&nbsp;编号：${obj.uid?if_exists}&nbsp;</p>	
						<div class='tip-bot'>
							<p style="color: #7a838c;margin-bottom: 3px;">
							${obj.uid?if_exists}号：
							${obj.name?if_exists}
							</p>
							<p id="ps_${obj.uid?if_exists}" data-ps="${obj.number?if_exists}" style="color: #4495F7;margin-bottom: 3px;">
						 	${obj.number?if_exists} 票
						 	</p>
						 	<p>
							<button type="button" onclick="voting(${obj.uid?if_exists},${obj.vId?if_exists})" style="background-color: #4495F7;width: 100%;border-color:#4495F7;" class="btn btn-success tou-btn" >投票 </button>
						 	</p>
					 	</div>
					 	
					</li>
				</#list>
				</#if>
	</ul>
	</div>
</div>
<!--bottom-->
<div id="menu" class="footer">
<table id="mt" style="margin-left: 28px;">
<tr>
<th><a href="/wechatvlist">
<img src="../../H-ui/static/h-ui/images/首页.png" style="width: 25%;"/><br>首页</a></th>
<th><a href="/wechatvlists">
<img src="../../H-ui/static/h-ui/images/排行榜.png" style="width: 25%;"/><br>排行榜</a></th>
<th><a href="/wechatrule">
<img src="../../H-ui/static/h-ui/images/说明.png" style="width: 25%;"/><br>说明</a></th>
</tr>
</table>
</div>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="../H-ui/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="../H-ui/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="../H-ui/static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="../H-ui/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="../H-ui/lib/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="../H-ui/lib/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="../H-ui/lib/My97DatePicker/4.8/WdatePicker.js"></script> 
<script type="text/javascript" src="../H-ui/lib/datatables/1.10.0/jquery.dataTables.min.js"></script> 
<script type="text/javascript" src="../H-ui/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">
$(function() {
	loadProv();//初始化
});
//当select标签内容发生改变是触发事件
$(".prov").change(function() {
    loadCity();
});
/* $(".city").change(function() {
    loadCounty();
}); */
	//加载公司
	function loadProv() {
	    $.ajax({
	        type: "post",
	        url: "/getallorganize",
	        dataType: "json",
	        async: false, //同步
	        success: function(data) {
	            var provlist = data;
	            //console.log(citylist);
	            var str = '';
					str +='<option value=""> 请选择</option>'
	            for(var i = 0; i < provlist.length; i++) {
	                str += '<option value=' + provlist[i].id + '>' + provlist[i].name + '</option>'
	            }
	            $(".prov").html(str);
	            loadCity(); //加载部门
	        },
	        error: function() {
	            console.log("获取公司失败");
	        }
	    });
	}

	function loadCity() {
	    var prov_id = $(".prov").find("option:selected").val();
	    $.ajax({
	        type: "post",
	        url: "/getalldept",
	        data: {
	            id: prov_id
	        },
	        dataType: "json",
	        async: true,
	        success: function(data) {
	            var citylist = data;
	            //console.log(citylist);
	            var str = ''
	            for(var i = 0; i < citylist.length; i++) {
	                str += '<option value=' + citylist[i].id + '>' + citylist[i].name + '</option>'
	            }
	            $(".city").html(str);
	           // loadCounty();

	        },
	        error: function() {
	            console.log("获取部门失败");
	        }
	    });
	}

	//加载参选人
	function loadCounty() {
	    var prov_id = $(".prov").find("option:selected").val();
	    var city_id = $(".city").find("option:selected").val();
	    $.ajax({
	        type: "post",
	        url: "/getallvoter",
	        async: true,
	        data: {
	            id: city_id
	        },
	        dataType: "json",
	        async: true,
	        success: function(data) {
	            var countylist = data;
	            //console.log(citylist);
	            var str = ''
	            for(var i = 0; i < countylist.length; i++) {
	                str += '<option value=' + countylist[i].id + '>' + countylist[i].name + '</option>'
	            }
	            $(".county").html(str);
	        },
	        error: function() {
	            console.log("获取选手失败");
	        }
	    });
	}

	//提交搜索
	$(function(){
		$("#vform").validate({
			onkeyup:false,
			focusCleanup:true,
			success:"valid",
			submitHandler:function(form){
				$(form).ajaxSubmit({
					type: 'post',
					url: "/chagewechatvlist" ,
					success: function(data){
						$("#ull").children().filter('li').remove();
						for (var  i= 0; i < data.length; i++) {
						$("#ull").append("<li class='sb'><a class='as' href='/wechatvshow?id="+data[i].uid+"&vId="+data[i].vId+"'><img style='width: 100%;height: 144.28px;' src="+data[i].img+"></a><p class='tip-p'>&nbsp;编号："+data[i].uid+"&nbsp;</p><div class='tip-bot'><p style='color: #7a838c;margin-bottom: 3px;'>"+data[i].uid+"号："+data[i].name+"</p><p id='ps_"+data[i].uid+"' data-ps='"+data[i].number+"' style='color: #4495F7;margin-bottom: 3px;'>"+data[i].number+"票</p><p><button type='button' onclick='voting("+data[i].uid+","+data[i].vId+")' style='background-color: #4495F7;width: 100%;border-color:#4495F7;' class='btn btn-success'>投票 </button></p></div></li>"); 					
						}
					},
	                error: function(XmlHttpRequest, textStatus, errorThrown){
						layer.msg('网络异常,请刷新重试!',{icon:2,time:1000});
					}
				});
			}
		});
	});


	
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
						//window.location.reload();
						if(data.result==true){
							//刷新选手票数：
							var ps=$("#ps_"+uid).attr("data-ps");
							$("#ps_"+uid).html(parseInt(ps)+1);
							//刷新总票数：
							var tp=$("#tp").attr("data-tp");
							$("#tp").html(parseInt(tp)+1);
							}
					},
	                error: function(XmlHttpRequest, textStatus, errorThrown){
						layer.msg('网络异常,请刷新重试!',{icon:2,time:1000});
					}
				});
	}
	
</script> 
</body>
</html>