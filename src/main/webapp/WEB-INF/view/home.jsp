<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<h2>Home Page</h2>
	<hr>
	<p>Welcome to Home</p>
	<form:form method="post" action="${pageContext.request.contextPath}/logout">
		<input type="submit" value="Logout"/>
	</form:form>
</body>
</html>