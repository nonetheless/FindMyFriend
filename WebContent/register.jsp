<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html = lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Sign in</title>

    <!-- Bootstrap core CSS -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <!--<link href="starter-template.css" rel="stylesheet">-->
    <style>
        body {
            padding-top: 100px;
        }
        .starter-template {
            padding: 40px 15px;
            text-align: center;
        }
        .form-signin {
            max-width: 330px;
            padding: 15px;
            margin: 0 auto;
        }
        .form-signin .form-signin-heading,
        .form-signin .checkbox {
            margin-bottom: 10px;
        }
        .form-signin .checkbox {
            font-weight: normal;
        }
        .form-signin .form-control {
            position: relative;
            height: auto;
            -webkit-box-sizing: border-box;
            -moz-box-sizing: border-box;
            box-sizing: border-box;
            padding: 10px;
            font-size: 16px;
        }
        .form-signin .form-control:focus {
            z-index: 2;
        }
        .form-signin input[type="email"] {
            margin-bottom: -1px;
            border-bottom-right-radius: 0;
            border-bottom-left-radius: 0;
        }
        .form-signin input[type="password"] {
            margin-bottom: 10px;
            border-top-left-radius: 0;
            border-top-right-radius: 0;
        }
    </style>

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="../../assets/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<script language="javascript">
function check(){
	if(form1.username.value==""){
		alert("请输入用户名！");form1.username.focus();return false;	
	}else if(form1.username.value=="\'"){
		alert("请不要输入非法字符！");form1.username.focus();return false;
	}
}
</script>
<body>
<%@ include file="header.jsp" %>
<div class="container">

    <form name="form1" method = "post" action="Messages?action=Register" onSubmit="return check()" class="form-signin">
        <h2 class="form-signin-heading">Please sign up</h2>
                <label for="inputuserID" class="sr-only">UserID</label>
        <input type="text" name="userID" id="userID" class="login form-control" placeholder="用户ID" required autofocus>
        <label for="username" class="sr-only">UserID</label>
        <input type="text" name="username" class="form-control" placeholder="昵称" required>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" name="password" class="form-control" placeholder="密码" required>
        <div class="checkbox">
            <label>
                <input type="checkbox" value="remember-me"> Remember me
            </label>
        </div>
        <button class="btn btn-lg btn-block" type="submit">Sign in</button>		
    </form>

</div>
</body>
</html>
