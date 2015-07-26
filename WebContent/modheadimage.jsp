<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>



<head = lang="zh-CN">
    <base href="<%=basePath%>">
    <title>活动信息</title>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">	
	<link rel="icon" href="../../favicon.ico">
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">	
  </head>
  <body background="images/bg6.jpg" style="background-size:cover">
  <script type="text/javascript" language="javascript">
function viewmypic(mypic,imgfile) {        
if (imgfile.value){        
mypic.src=imgfile.value;        
mypic.style.display="";        
mypic.border=1;        
}        
}            
  
  </script>
  <nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">24 oclock</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="#">热门活动</a></li>
                <li><a href="#about">个人中心</a></li>
                <li><a href="#contact">关于我们</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="/ChatRoom1/login_in.jsp" class="active">登陆</a>
                </li>
                <li>
                    <a href="/ChatRoom1/register.jsp">注册</a>
                </li>
            </ul>
        </div>
    </div>
</nav>  
  <div class="container" align="center">
    <br>
	<br>
	<br>
	<br>
    <form name="code" method="post" action="/ChatRoom1/servlet/UpheadServlet" onsubmit="return valicode(this)" enctype="multipart/form-data">
	<h1 class="form-signin-heading">上传头像</h1>
    <table border="0">
	<tr  style="height:80">
	<td>
    <input name="imgfile" type="file" id="imgfile" size="40" onchange="viewmypic(showimg,this.form.imgfile);" />       
    </form> 
	<br/>
    <img name="showimg" id="showimg" src="images/bg3.jpg" style="width:400px;height:200px" alt="预览图片" />           
    </div>       
	
	</td>
	</tr>
	<br/>
    <tr>
	<td>
    <button type="reset" class="btn btn-lg btn-block">重置</button>
    <button type="submit" class="btn btn-lg btn-block">完成</button>
	</td>
    </tr>
    </table>
    </form>
	</div>
  </body>

</html>