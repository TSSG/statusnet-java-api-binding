<%@ page session="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<h3>Connected to Statusnet</h3>

<form id="disconnect" method="post">
	<div class="formInfo">
		<p>This application is already connected to your Statusnet account.</p>		
	</div>

	<button type="submit">Disconnect</button>	
	<input type="hidden" name="_method" value="delete" />
</form>

<p><a href="<s:url value="/" />">Return to home page</a></p>

</body>
</html>
