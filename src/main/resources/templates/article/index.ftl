<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="apple-mobile-web-app-status-bar-style" content="black">
		<!--标准mui.css-->
		<link rel="stylesheet" href="../H-ui/static/h-ui/css/mui.min.css">
		<!--App自定义的css-->
		<link rel="stylesheet" type="text/css" href="../H-ui/static/h-ui/css/app.css"/>
		<script type="text/javascript" src="../H-ui/lib/jquery/1.9.1/jquery.min.js"></script> 
		
		<style>
			.title {
				margin: 20px 15px 10px;
				color: #6d6d72;
				font-size: 15px;
			}
			#y{
		overflow: hidden;
text-overflow:ellipsis;
white-space: nowrap;}
#more{text-align: center;}
#mm{text-align: center; display: none;}
	#nolist{text-align: center; display: none;}
		</style>
	</head>

	<body>
			<div class="mui-card">
				<ul id="ull" class="mui-table-view" >
					
						<li class="mui-table-view-cell mui-media">
							<a href="/frontArt/selectArt?id=64">
								<img class="mui-media-object mui-pull-right" src="/artimgvoid/img/1529067137657.jpg">
								<div  id="y" class="mui-media-body">
									泸县总工会2018年公开招聘 社会化工会工作者拟录用人员公示
									<p class='mui-ellipsis'>
										2018-06-15 20:49:26
									</p>
								</div>
							</a>
						</li>
				</ul>
				 <div class="mui-col-sm-12 mui-col-xs-12" style="margin-top: 20px">
			 	<div id="more"><p class='mui-ellipsis'><span style="cursor:pointer;">查看更多</span>
			 	</p>
				</div>
				<div id="mm" ><p class='mui-ellipsis'>加载中...</p></div>
				<div id="nolist"><p class='mui-ellipsis'>没有了</p></div>
			 </div>
			</div>
			

	</body>
	<script src="../H-ui/static/h-ui/js/mui.min.js"></script>
	<script>
		mui.init({
			swipeBack:true //启用右滑关闭功能
		});
	</script>
	<script type="text/javascript">
	$(function(){
		var c=2;
		if (c<=1) {
			$("#more").hide();
			$("#nolist").show();
		}else {
			$("#more").show();
			$("#nolist").hide();
		}
		
	});
	
	var curr=2;
	$(function(){
		$("#more").click(function(){
			$("#mm").show();
			$("#more").hide();
			$.ajax({
				 type: "POST",  
			        url: "/frontArt/getArt",  
			        data: {
			        	"currentPage":curr
			        	},  
			        dataType:"json",  
			        async:true,  
			        success: function(data){
		        	console.log(data);
		        		for (var  i= 0; i < data.rows.length; i++) {
							//$("#im2").append("<img src="+data.rows[i].img+" class="+" col-xs-6 col-sm-6 col-md-6 col-xs-6"+">")
 							$("#ull").append("<li class='mui-table-view-cell mui-media'><a href="+"/frontArt/selectArt?id="+data.rows[i].id+"><img class='mui-media-object mui-pull-right' src="+data.rows[i].img+"><div id='y' class='mui-media-body'>"+data.rows[i].title+"<p class='mui-ellipsis'>"+data.rows[i].publish_time+"</p></div></a></li>");	 							
 						}
			       		$("#more").show();
			       		$("#mm").hide();
						curr+=1;
			        	if(data.totalPage<curr){
			        		$("#nolist").show();
			        		$("#more").hide();
			        		$("#mm").hide();
			        		
			        	}
			       		
			        }
			        	
			 });
		});
		
		//获取所有#dd
	/* 	$("#bbt name").each(index,item){
			alert($(this).val());
		} */
		
	});
	
	
	
	</script>
	
	
	
</html>