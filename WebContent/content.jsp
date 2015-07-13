<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="record" value="${twentyrecord }" scope="request" />
${record.time }<br/>
${record.speaker }说：${record.content }<br/>
