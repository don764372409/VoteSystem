


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">

<title>文章</title>
<style type="text/css">
	*{padding: 0; margin: 0}
	a{color:#A2A2A2 }
	a:hover{color:#1B79D0 }
	#y{
	overflow: hidden;
	width:97%;
	text-overflow:ellipsis;
	-webkit-line-clamp: 3;
	white-space: nowrap;
	color: #A2A2A2
	}
	#pp{color: #515151 ;float: left; font-size: 14px;letter-spacing:3px; margin-top: 15px}
	#y:hover{color:#1B79D0 }
	@media  screen and (min-width: 300px) {
	     img{width: 100%;height: 250px}
	    
	  }
	  @media  screen and (min-width: 600px) {
	     img{width: 100%;height: 500px}
	    
	  }
</style>
</head>
<body>
	<div style="width: 98%; margin: 0 auto; margin-top: 20px;">
			<div style="width: 100%;float: left; text-align: left;">
		<h3>${obj.title}</h3>
		<div style="font-size: 14px; color: #A2A2A2;width: 100%;float: left; margin: 15px 0;">${obj.time?string("yyyy-MM-dd")!}</div>
		<div style="width: 96%;margin: 0 auto;">
			<img src="${obj.img}" >
			<div id="pp">
			${obj.content}
		</div>
		<br/>	
	</div>
	</div>
</div>
</body>
</html>