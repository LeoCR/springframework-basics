<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<h2>Home Page</h2>
	<hr>
	<!-- Display username and role -->
	<p>User <security:authentication property="principal.username"/></p>
	<br><br>
	Role(s):<security:authentication property="principal.authorities"/>

	<security:authorize access="hasRole('MANAGER')">	
		<hr>
		<!-- Add a link to point to /leaders ... this is for the managers  -->
		<p>
			<a href="${pageContext.request.contextPath }/leaders">Leadership Meetjing</a> (Only for Manager peeps)
		</p>
	</security:authorize>
	<security:authorize access="hasRole('ADMIN')">
		<hr>
		<!-- Add a link to point to /systems ... this is for the admins  -->
		<p>
			<a href="${pageContext.request.contextPath }/systems">IT Systems Meeting</a> (Only for Admin peeps)
		</p>
	</security:authorize>
	
	<p>Welcome to Home</p>
	<form:form method="post" action="${pageContext.request.contextPath}/logout">
		<input type="submit" value="Logout"/>
	</form:form>
</body>
</html>