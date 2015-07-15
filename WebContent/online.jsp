<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <p>用户列表</p>
    <a href="#" class="list-group-item" onclick="set('所有人')"><span class="glyphicon glyphicon-home"> 所有人</span> </a>  
<c:forEach var="record" items="${allUser}">
<a href="#" class="list-group-item" onclick="set(${record.value})"><span class="glyphicon glyphicon-home">${record.value}</span></a>
</c:forEach>
</table>