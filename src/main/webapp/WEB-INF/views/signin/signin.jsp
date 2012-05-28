<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Sign In</title>
	</head>
	<body>
		<form id="signin" action="<c:url value="/signin/authenticate" />" method="post">
			<div>
  				<c:if test="${signinError}">
  				<div>
  					Your sign in information was incorrect.
  				</div>
 	 			</c:if>
			</div>
		
			<fieldset>
				<label for="login">Username</label>
				<input id="login" name="j_username" type="text" size="25" 
						<c:if test="${not empty signinErrorMessage}">
							value="${SPRING_SECURITY_LAST_USERNAME}"
						</c:if> />
				<label for="password">Password</label>
				<input id="password" name="j_password" type="password" size="25" />	
				<button type="submit">Sign In</button>
			</fieldset>

		</form>
	</body>
</html>