<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body>

	<p>Welcome, <c:out value="${account.userName}"/>! (<a href="<c:url value="/signout" />">Sign Out</a>)</p>
	<h3>Statusnet Public Timeline</h3>
	<c:if test="${empty statusnet_connected}">
		<p>You are not connected to Statusnet.<br/><a href="connect/statusnet">Connect</a> to see latest messages.</p>
	</c:if>
	
	<c:if test="${not empty statusnet_connected}">
		<c:forEach items="${timeLineMessages}" var="status">
			<div>${status.getText()}</div>
		</c:forEach>	
	</c:if>
</body>
</html>