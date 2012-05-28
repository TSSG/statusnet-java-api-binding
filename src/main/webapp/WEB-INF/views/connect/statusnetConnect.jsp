<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<h3>Connect to Statusnet</h3>

<form action="<c:url value="/connect/statusnet" />" method="POST">
	<div class="formInfo">
		<p>Click the button to connect to your Statusnet account.</p>
	</div>
	<p><button type="submit">Connect to Statusnet</button></p>
</form>

<p><a href="<s:url value="/" />">Return to home page</a></p>

