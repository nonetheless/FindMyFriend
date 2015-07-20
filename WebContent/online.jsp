<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ServletController.OnlineServlet"%>
<%@page import="DataBase.DataServiceimpl"%>
<%@page import="DataBase.DataService"%>
<%@page import="DataBase.DatabaseController"%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <p>用户列表</p>
    <a href="#" class="list-group-item" onclick="set('所有人')"><span class="glyphicon glyphicon-home"> 所有人</span> </a>  
<%!ArrayList<String> all = new ArrayList<String>();
	HashMap<String,String> map = new HashMap<String,String>();
 %>
<%
	DataService service = new DataServiceimpl();
	if(OnlineServlet.newcome){
		ArrayList<String> all = service.searchRoomUser((String)session.getAttribute("roonID"));
		for(String one:all){
			String ID = one.split("//")[0];
			String username = one.split("//")[1];
			map.put(ID, username);
		}
		request.setAttribute("allUser", map);
	}else
		return;
 %>
<c:forEach var="record" items="${allUser }">
<a href="#" class="list-group-item" onclick="${record.value}"><span class="glyphicon glyphicon-home">${record.value }</span></a>
</c:forEach>
</table>