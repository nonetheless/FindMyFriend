<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <base href="<%=basePath%>">
    <title>活动信息</title>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=device-width, initial-scale=1">	
	<link rel="icon" href="../../favicon.ico">
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="bootstrap/css/bootstrap-theme.css" rel="stylesheet">
	<link href="bootstrap/css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
<style>
  body {
  padding-top: 20px;
  padding-bottom: 20px;
  }
  .find{
      max-width: 700px;
      padding: 15px;
      margin: 0 auto;
  }

/* Everything but the jumbotron gets side spacing for mobile first views */
.jumbotron {
  text-align: center;
  border-bottom: 1px solid #e5e5e5;
}
.jumbotron .btn {
  padding: 14px 24px;
  font-size: 21px;
}

  .jumbotron {
    border-bottom: 0;
  }
}
    </style>
  </head>
  <body>
  <%@ include file="header.jsp" %>
  <div class="jumbotron">
        <h1>${param.kindName}</h1>
        <p class="lead">最美的不是下雨天，是曾与你躲过雨的屋檐,和我们一起去看雨后的彩虹。</p>
        <p><a class="btn btn-lg btn-success" href="/ChatRoom1/register.jsp" role="button">Sign up today</a></p>
  </div>
  <div class="container" align="center">
    <form method="post" action="/ChatRoom1/servlet/GetRequestServlet?kind=${param.kindName}" class="find">
            <div class="form-group">
                <label class="col-md-2 control-label">start</label>
                <div class="input-group date form_datetime col-md-5" data-date="2015-07-20T05:25:07Z" data-date-format="dd MM yyyy - HH:ii p" data-link-field="dtp_input1">
                    <input id="start" name="start" class="form-control" size="16" type="text" value="" readonly>
                    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
					<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                </div>
				<input type="hidden" id="dtp_input1" value="" /><br/>
            </div>
            <div class="form-group">
                <label class="col-md-2 control-label">end</label>
                <div class="input-group date form_datetime col-md-5" data-date="2015-07-20T05:25:07Z" data-date-format="dd MM yyyy - HH:ii p" data-link-field="dtp_input1">
                    <input id = "end" name="end" class="form-control" size="16" type="text" value="" readonly>
                    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
					<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                </div>
				<input type="hidden" id="dtp_input1" value="" /><br/>
            </div>      
     <div class="form-group">      
     <label for="inputplace" class="sr-only">活动地点</label>
    <input type="text" name="place" id="place" class="form-control" placeholder="活动地点" required autofocus></input>
    <br>
    <label for="inputactivity" class="sr-only">活动内容</label>
    <input type="text" name="activity" class="form-control" placeholder="活动内容" required autofocus></input>
    </div>
    <div class="form-group">   
    <button type="reset" class="btn btn-lg btn-block">重置</button>
    <br>
    <button type="submit" class="btn btn-lg btn-block">完成</button>
    </div>
    </form>
	</div>
<script type="text/javascript" src="bootstrap/js/jquery.min.js" charset="UTF-8"></script>
<script type="text/javascript" src="bootstrap/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script type="text/javascript" src="bootstrap/js/locales/bootstrap-datetimepicker.fr.js" charset="UTF-8"></script>
<script type="text/javascript">
    $('.form_datetime').datetimepicker({
        //language:  'fr',
        format: 'yyyy-mm-dd;hh:ii', 
        weekStart: 1,
        todayBtn:  1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 2,
		forceParse: 0,
        showMeridian: 1
    });
</script>
  </body>
</html>