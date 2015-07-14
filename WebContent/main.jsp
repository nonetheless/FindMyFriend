<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="safe.jsp"%>
<html>
<head>
<title>聊天室</title>
    <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css">    
    <link rel="stylesheet" type="text/css" href="bootstrap/css/style.css">    
    <link rel="stylesheet" type="text/css" href="bootstrap/css/jquery.mobile.flatui.css" />
<script language="javascript" src="JS/AjaxRequest.js"></script>
<script language="javascript">
window.setInterval("showContent();",1000);
window.setInterval("showOnline();",10000);
var sysBBS="<span style='font-size:14px; line-height:30px;'>欢迎光临心之语聊天室，请遵守聊天室规则，不要使用不文明用语。</span><br><span style='line-height:22px;'>";
//此处需要加?nocache="+new Date().getTime()，否则将出现在线人员列表不更新的情况
function showOnline(){
	var loader=new net.AjaxRequest("online.jsp?nocache="+new Date().getTime(),deal_online,onerror,"GET");
}
function showContent(){
	var loader1=new net.AjaxRequest("Messages?action=Get&nocache="+new Date().getTime(),deal_content,onerror,"GET");
}
function onerror(){
	//alert("很抱歉，服务器出现错误，当前窗口将关闭！");
	window.opener=null;
	window.close();
}
function deal_online(){
	online.innerHTML=this.req.responseText;
}
function deal_content(){
	var returnValue=this.req.responseText;		//获取Ajax处理页的返回值
	var h=returnValue.replace(/\s/g,"");	//去除字符串中的Unicode空白符
	if(h=="error"){
		//alert("您的账户已经过期，请重新登录！");
		Exit();
	}else{
		content.innerHTML=sysBBS+returnValue+"</span>";
		document.getElementById('content').scrollTop = document.getElementById('content').scrollHeight*2;	//当聊天信息超过一屏时，设置最先发送的聊天信息不显示
	}
}

window.onload=function(){
	showContent();						//当页面载入后显示聊天内容
	showOnline();						//当页面载入后显示在线人员列表
}

window.onbeforeunload=function(){    		//当用户单击浏览器中的关闭按钮时执行退出操作
    if(event.clientY<0 && event.clientX>document.body.scrollWidth){  
         Exit();                    		//执行退出操作
    }
}
</script>
<script language="javascript">
<!--
	function send(){	//验证聊天信息并发送

		if(form1.content1.value==""){
			alert("发送信息不可以为空！");form1.content1.focus();return false;
		}
		var param="from="+form1.from.value+"&content="+	form1.content1.value;
        var loader=new net.AjaxRequest("Messages?action=Send",deal_send,onerror,"POST",param);
        var el=document.getElementById("content1");
        el.value="";
	}
function deal_send(){
content.innerHTML=sysBBS+this.req.responseText+"</span>";
}
-->
</script>
<script type="text/javascript">
	function checkScrollScreen(){
    if(!form1.scrollScreen.checked){
        document.getElementById("content").style.overflow='scroll';
    }else{
        document.getElementById("content").style.overflow='hidden';
        //当聊天信息超过一屏时，设置最先发送的聊天信息不显示
        document.getElementById('content').scrollTop = document.getElementById('content').scrollHeight*2;    
    }
    setTimeout('checkScrollScreen()',500);
}
	
</script>
	
</head>
<body>
<div data-role="page">

    <div class="header linear-g">
        <a href="#panel-left" data-iconpos="notext" class="glyphicon glyphicon-th-large col-xs-2 text-right"> </a>
        <a id="1" class="text-center col-xs-8">smwell.com</a>
        <a href="#panel-right" data-iconpos="notext" class="glyphicon glyphicon-user col-xs-2 text-left"> </a>
    </div>

    <div data-role="panel" data-position="left" data-display="push" class="list-group shortcut_menu dn linear-g" id="panel-left">
	<p class="text-center lead" id="online"> &nbsp;用户列表</p>
    </div>
    
    <div data-role="panel" data-position="right" data-display="push" class="user_box text-center dn linear-g" id="panel-right">
        <div class="u_info">
            <img class="avatar" src="images/avatar.png" alt="头像">
            <span class="username">李任我行</span>
        </div>
        <ul class="user_menu">
          <li class="menu"><a href="#"><span class="glyphicon glyphicon-cog"> </span> &nbsp;基本设置</a></li>
          <li class="menu"><a href="#"><span class="glyphicon glyphicon-lock"> </span> &nbsp;修改密码</a></li>
          <li class="menu"><a href="#"><span class="glyphicon glyphicon-picture"> </span> &nbsp;上传头像</a></li>
          <li class="menu"><a href="#"><span class="glyphicon glyphicon-off"> </span> &nbsp;安全退出</a></li>
        </ul>
    </div>
    

    <div data-role="content" class="container" role="main">
      <table height="100">
      <tr>
        <td>
	    <div style="height:290px; overflow:hidden" id="content">聊天内容</div>
	    </td>     
	  </tr>
      </table>
    </div>

<table width="778" height="95" border="0" align="center" cellpadding="0" cellspacing="0" bordercolor="#D6D3CE">
<form action="" name="form1" method="post" >
  <tr>
    <td height="37" align="left"><input name="from" type="hidden" value="${username}">
    <td width="549" align="left">
    
    <textarea name="content1"  id="content1" style="resize:none;width:500px" onKeyDown="if(event.keyCode==13 && event.ctrlKey){send();}"></textarea>
    </td>
    <td>
      <button name="Submit2" type="button" class="btn btn-lg btn-block" onClick="send()">发送</button>
      </td>>
    <td align="center">&nbsp;</td>
  </tr>
  <tr>
    <td height="30" align="left">&nbsp;</td>
    <td colspan="2" align="center" class="word_dark">&nbsp;</td>
    <td align="center">&nbsp;</td>
  </tr>
</form>
</table>
</div>

<script type="text/javascript" src="bootstrap/css/jquery.min.js"></script>
<script type="text/javascript" src="bootstrap/css/JS/jquery.mobile-1.4.0-rc.1.js"></script>
<script type="text/javascript">
	$(function(){
		/* 
		** 不同页面切换转场效果
		** $.mobile.changePage ('/test.html', 'slide/pop/fade/slideup/slidedown/flip/none', false, false);
		*/
		$('.list-group-item,.menu a').click(function(){
			$.mobile.changePage($(this).attr('href'), {
				transition : 'flip', //转场效果
				reverse : true       //默认为false,设置为true时将导致一个反方向的转场
			});	
		});
	});
</script>

</body>
</html>
