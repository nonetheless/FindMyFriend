<%@page import="java.util.LinkedHashMap"%>
<%@page import="Dao.Record"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Dao.Request"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
	String roomID = (String)request.getSession().getAttribute("roomID");
	ArrayList<Record> allrecord = ((LinkedHashMap<String,ArrayList<Record>>)request.getAttribute("record")).get(roomID);
	request.setAttribute("allrecord",allrecord);
 %>
<c:forEach var="record" items="${allrecord }">
<!--左右-->
<c:if test="${record.speaker.equals(username)}">
<li class="odd" > <a class="user" href="#"><img class="img-responsive avatar_" src="images/avatar-1.png" alt=""><span class="user-name">${record.speaker}</span></a><div class="reply-content-box"><span class="reply-time">${record.time}</span> <div class="reply-content pr"><span class="arrow">&nbsp;</span>${record.content }</div></div></li>
</c:if>
<c:if test="${!record.speaker.equals(username)}">
<li class="even" > <a class="user" href="#"><img class="img-responsive avatar_" src="images/avatar-1.png" alt=""><span class="user-name">${record.speaker}</span></a><div class="reply-content-box"><span class="reply-time">${record.time}</span> <div class="reply-content pr"><span class="arrow">&nbsp;</span>${record.content }</div></div></li>
</c:if>
</c:forEach>

