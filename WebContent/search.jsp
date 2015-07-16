<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";%>
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
  <body>
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
    <form method="post" action="/ChatRoom1/servlet/SearchRequestServlet">
	<h1 class="form-signin-heading">请选择活动内容</h1>
    <table border="0">
	<tr  style="height:80">
	<td align="center"><label>活动日期：</label></td>
	<td colspan="4">
	<label for="meeting"></label><input name="date" id="meeting" type="date" value="2014-01-13" style="width:100%" class="form-control"/>
	</td>
	</tr>
    <tr  style="height:80">
    <td align="center"><label>开始时间：</label></td>
    <td align="center">
    <select name="starthour" size=1 style="width:100%" class="form-control">
    <option value="00">00</option>
	<option value="01">01</option>
	<option value="02">02</option>
	<option value="03">03</option>
	<option value="04">04</option>
	<option value="05">05</option>
	<option value="06">06</option>
	<option value="07">07</option>
	<option value="08">08</option>
	<option value="09">09</option>
	<option value="10">10</option>
	<option value="11">11</option>
	<option value="12">12</option>
	<option value="13">13</option>
	<option value="14">14</option>
	<option value="15">15</option>
	<option value="16">16</option>
	<option value="17">17</option>
	<option value="18">18</option>
	<option value="19">19</option>
	<option value="20">20</option>
	<option value="21">21</option>
	<option value="22">22</option>
	<option value="23">23</option>
	</select>
	</td>	
	<td align="center"><label>时
	</label></td>	
	<td align="center">
    <select name="startmin" size=1 style="width:100%" class="form-control">
    <option value="00">00</option>
	<option value="15">15</option>
	<option value="30">30</option>
	<option value="45">45</option>
	</select>
	</td>	
	<td align="center"><label>分
	</label></td>	
    </tr>
    <tr  style="height:80">
    <td align="center"><label>结束时间：</label></td>
    <td align="center">
    <select name="endhour" size=1 style="width:100%" class="form-control">
    <option value="00">00</option>
	<option value="01">01</option>
	<option value="02">02</option>
	<option value="03">03</option>
	<option value="04">04</option>
	<option value="05">05</option>
	<option value="06">06</option>
	<option value="07">07</option>
	<option value="08">08</option>
	<option value="09">09</option>
	<option value="10">10</option>
	<option value="11">11</option>
	<option value="12">12</option>
	<option value="13">13</option>
	<option value="14">14</option>
	<option value="15">15</option>
	<option value="16">16</option>
	<option value="17">17</option>
	<option value="18">18</option>
	<option value="19">19</option>
	<option value="20">20</option>
	<option value="21">21</option>
	<option value="22">22</option>
	<option value="23">23</option>
	</select>
	</td>
	<td align="center"><label>时
	</label></td>
	<td align="center">
    <select name="endmin" size=1 style="width:100%" class="form-control">
    <option value="00">00</option>
	<option value="15">15</option>
	<option value="30">30</option>
	<option value="45">45</option>
	</select>
	</td>
	<td align="center"><label>分
	</label></td>
    </tr>
    <tr style="height:80">
    <td align="center"><label>活动地点：</label></td>
    <td align="center" colspan="5">
    <input name="place" style="width:100%" rows="1" class="form-control"></input>
    </td>
	<td></td>
	<td></td>
	<td></td>
	<td></td>
    </tr>	
    <tr style="height:80">
    <td align="center"><label>活动内容：</label></td>
    <td align="center" colspan="5">
    <input name="activity" style="width:100%" rows="1" class="form-control"></input>
    </td>
	<td></td>
	<td></td>
	<td></td>
	<td></td>
    </tr>	
    <tr>
	<td colspan="5">
    <button type="reset" class="btn btn-lg btn-block">重&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp置</button>
    <button type="submit" class="btn btn-lg btn-block">完&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp成</button>
	</td>
	<td></td>
	<td></td>
	<td></td>
	<td></td>
    </tr>
    </form>
	</div>
  </body>
</html>