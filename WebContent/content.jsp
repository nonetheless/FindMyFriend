<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:forEach var="record" items="${record }">
${record.time}
${record.speaker }：${record.content }<br/>
</c:forEach>
