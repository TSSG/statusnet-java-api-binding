<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page session="false" %>
<html>
	<head>
	</head>
	<body>
		<div>
			<h1>Spring Social Statusnet Sample</h1>
		</div>
		
		<div id="content">
			<tiles:insertAttribute name="content" />
		</div>		
	</body>
</html>
