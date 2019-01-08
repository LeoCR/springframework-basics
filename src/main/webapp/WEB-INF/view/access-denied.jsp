<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
	<title>Access Denied</title>
</head>
<body>
	<h1>Access Denied</h1>
	<p>Sorry but you can't have acces to this page because you are not Authorized </p>
	<a href="${pageContext.request.contextPath}">Back Home</a>
</body>
</html>