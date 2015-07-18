<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">
    <style>
        body{
            padding-top: 50px;
        }
    </style>
    
    <title>所有房间</title>

    <link href="<%=request.getContextPath() %>/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/css/starter-template.css" rel="stylesheet">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/css/font-awesome.min.css">
    <script src="../../assets/js/ie-emulation-modes-warning.js"></script>
</head>

<body>
<%@ include file="header.jsp" %>

<div class="container">
	<div class="jumbotron">
        <h1>24点团队</h1>
        <p>生命的复杂，就在于不可预期，不容解释，不能厘清。好像走在迷雾里，看不见任何方向，没有人可以判别前面是否断崖或绝路。生命只能持续走下去，直到雾散了，答案才终得明白。from 《谁在暗中眨眼睛》</p>
        <p>
          <a class="btn btn-lg btn-primary" href="match.jsp?action=transparams&kindName=CreateRoom" role="button">创建房间 &raquo;</a>
          <a class="btn btn-lg btn-primary" href="match.jsp?action=transparams&kindName=SearchRoom" role="button">搜索房间 &raquo;</a>
        </p>
      </div>
	
<c:choose>
<c:when test="${list==111}">
<c:forEach var="record1" items="${wantroom}">

    <div class="starter-template jumbotron">
        <h2>${record1.activity}</h2>
        <p class="lead">小伙伴快来${record1.location}一起${record1.activity}<br> 活动时间：${record1.startTime}到${record1.endTime},一起来吧</p>
		 <p><a class="btn btn-lg btn-primary btn-shadow" href="/ChatRoom1/servlet/OnlineServlet?roomID=${record1.roomID}" role="button">进群聊聊</a></p>
    </div>
</c:forEach>
</c:when>
<c:otherwise>
<c:forEach var="record1" items="${allRoom}">

    <div class="starter-template jumbotron">
        <h2>${record1.activity}</h2>
        <p class="lead">小伙伴快来${record1.location}一起${record1.activity}<br> 活动时间：${record1.startTime}到${record1.endTime},一起来吧</p>
		 <p><a class="btn btn-lg btn-primary btn-shadow" href="/ChatRoom1/servlet/OnlineServlet?roomID=${record1.roomID}" role="button">进群聊聊</a></p>
    </div>
</c:forEach>
</c:otherwise>
</c:choose>
	<nav class="pagination">
        <a class="btn btn-default" href="#">&larr; 上一页</a>
		<span class="page-number">第 1 页/共 1 页</span>
        <a class="btn btn-default" href="#">下一页 &rarr;</a>
	</nav>
</div><!-- /.container -->

<!-- Bootstrap core JavaScript
================================================== -->
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>

