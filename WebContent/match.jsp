<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>活动信息</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  <h1>活动信息选择</h1>
    <br>
    <form method="post" action="/ChatRoom1/servlet/Search">
    <table border="0">
    <tr>
    <td align="right">年份：</td>
    <td align="left">
    <select name="year" size=1>
	<option value="2015">2015</option>
	<option value="2016">2016</option>
	</select>
	</td>
    </tr>
    <tr>
    <td align="right">月份：</td>
    <td align="left">
    <select name="month" size=1>
    <option value="1">1</option>
	<option value="2">2</option>
	<option value="3">3</option>
	<option value="4">4</option>
	<option value="5">5</option>
	<option value="6">6</option>
	<option value="7">7</option>
	<option value="8">8</option>
	<option value="9">9</option>
	<option value="10">10</option>
	<option value="11">11</option>
	<option value="12">12</option>
	</select>
	</td>
    </tr>
    <tr>
    <td align="right">日期：</td>
    <td align="left">
    <select name="day" size=1>
    <option value="1">1</option>
	<option value="2">2</option>
	<option value="3">3</option>
	<option value="4">4</option>
	<option value="5">5</option>
	<option value="6">6</option>
	<option value="7">7</option>
	<option value="8">8</option>
	<option value="9">9</option>
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
	<option value="24">24</option>
	<option value="25">25</option>
	<option value="26">26</option>
	<option value="27">27</option>
	<option value="28">28</option>
	<option value="29">29</option>
	<option value="30">30</option>
	<option value="31">31</option>
	</select>
	</td>
    </tr>
    <tr>
    <td align="right">开始时间：</td>
    <td align="left">
    <select name="starthour" size=1>
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
	时
    <select name="startmin" size=1>
    <option value="00">00</option>
	<option value="15">15</option>
	<option value="30">30</option>
	<option value="45">45</option>
	</select>
	分
	</td>
    </tr>
    <tr>
    <td align="right">结束时间：</td>
    <td align="left">
    <select name="endhour" size=1>
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
	时
    <select name="endmin" size=1>
    <option value="00">00</option>
	<option value="15">15</option>
	<option value="30">30</option>
	<option value="45">45</option>
	</select>
	分
	</td>
    </tr>
    <tr>
    <td align="right">活动地点：</td>
    <td align="left">
    <textarea name="place" cols="15" rows="2"></textarea>
    </td>
    </tr>
    <tr>
    <td align="right">活动内容：</td>
    <td align="left">
    <textarea name="activity" cols="15" rows="2"></textarea>
    </td>
    </tr>
    <tr>
    <td colspan="2" align="center">
    <input type="reset" value="重置">
    <input type="submit" value="就这么定啦！">
    </td>
    </tr>
    </form>
  </body>
</html>
