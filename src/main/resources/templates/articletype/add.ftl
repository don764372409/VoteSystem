<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="http://libs.useso.com/js/html5shiv/3.7/html5shiv.min.js"></script>
<script type="text/javascript" src="http://libs.useso.com/js/respond.js/1.4.2/respond.min.js"></script>
<script type="text/javascript" src="http://cdn.bootcss.com/css3pie/2.0beta1/PIE_IE678.js"></script>
<![endif]-->
<link type="text/css" rel="stylesheet" href="css/H-ui.css"/>
<link type="text/css" rel="stylesheet" href="css/H-ui.admin.css"/>
<link type="text/css" rel="stylesheet" href="font/font-awesome.min.css"/>
<!--[if IE 7]>
<link href="http://www.bootcss.com/p/font-awesome/assets/css/font-awesome-ie7.min.css" rel="stylesheet" type="text/css" />
<![endif]-->
<title>�������</title>
</head>
<body>
<nav class="Hui-breadcrumb"><i class="icon-home"></i> ��ҳ <span class="c-gray en">&gt;</span> ��Ѷ���� <span class="c-gray en">&gt;</span> ������� <a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="ˢ��" ><i class="icon-refresh"></i></a></nav>
<div class="pd-20 text-c">
  <form class="Huiform" action="/" method="post">
    �ϼ���Ŀ��
    <select class="select" id="sel_Sub" name="sel_Sub" onchange="SetSubID(this);">
      <option value="0">��������</option>
      <option value="100">����һ��</option>
      <option value="101">&nbsp;&nbsp;�� �������</option>
      <option value="102">&nbsp;&nbsp;�� �������</option>
      <option value="201">����һ��</option>
      <option value="101">&nbsp;&nbsp;�� �������</option>
    </select>
    <input type="hidden" id="hid_ccid" value="">
    <input class="input-text" style="width:250px" type="text" value="" placeholder="�������" id="article-class-val"><button type="button" class="btn btn-success" id="" name="" onClick="article_class_add(this);"><i class="icon-plus"></i> ���</button>
  </form>
  <div class="article-class-list cl mt-20">
    <table class="table table-border table-bordered table-hover table-bg">
      <thead>
        <tr class="text-c">
          <th width="25"><input type="checkbox" name="" value=""></th>
          <th width="80">ID</th>
          <th width="80">����</th>
          <th>��������</th>
          <th width="70">����</th>
        </tr>
      </thead>
      <tbody>
        <tr class="text-c">
          <td><input type="checkbox" name="" value=""></td>
          <td>1</td>
          <td>1</td>
          <td class="text-l">һ������</td>
          <td class="f-14"><a title="�༭" href="javascript:;" onclick="article_class_edit('1','620','160','����༭','article-class-edit.html')" style="text-decoration:none"><i class="icon-edit"></i></a> <a title="ɾ��" href="javascript:;" onclick="article_class_del(this,'1')" class="ml-5" style="text-decoration:none"><i class="icon-trash"></i></a></td>
        </tr>
        <tr class="text-c">
          <td><input type="checkbox" name="" value=""></td>
          <td>2</td>
          <td>2</td>
          <td class="text-l">&nbsp;&nbsp;��&nbsp;��������</td>
          <td class="f-14"><a title="�༭" href="javascript:;" onclick="article_class_edit('2','620','160','����༭','article-class-edit.html')" style="text-decoration:none"><i class="icon-edit"></i></a> <a title="ɾ��" href="javascript:;" onclick="article_class_del(this,'2')" class="ml-5" style="text-decoration:none"><i class="icon-trash"></i></a></td>
        </tr>
        <tr class="text-c">
          <td><input type="checkbox" name="" value=""></td>
          <td>3</td>
          <td>3</td>
          <td class="text-l">&nbsp;&nbsp;��&nbsp;��������</td>
          <td class="f-14"><a title="�༭" href="javascript:;" onclick="article_class_edit('3','620','160','����༭','article-class-edit.html')" style="text-decoration:none"><i class="icon-edit"></i></a> <a title="ɾ��" href="javascript:;" onclick="article_class_del(this,'3')" class="ml-5" style="text-decoration:none"><i class="icon-trash"></i></a></td>
        </tr>
      </tbody>
    </table>
  </div>
</div>
<script type="text/javascript" src="http://cdn.bootcss.com/jquery/2.1.3/jquery.min.js"></script>
<script type="text/javascript" src="js/H-ui.js"></script> 
<script type="text/javascript" src="js/H-ui.admin.js"></script>
<script>
var _hmt = _hmt || [];
(function() {
  var hm = document.createElement("script");
  hm.src = "//hm.baidu.com/hm.js?080836300300be57b7f34f4b3e97d911";
  var s = document.getElementsByTagName("script")[0]; 
  s.parentNode.insertBefore(hm, s);
})();
var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");
document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3F080836300300be57b7f34f4b3e97d911' type='text/javascript'%3E%3C/script%3E"));
</script>
</body>
</html>