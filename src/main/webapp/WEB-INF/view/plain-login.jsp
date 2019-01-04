<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>Login Form</title>
	<style type="text/css">
	.failed{
		color:darkred;
	}
	</style>
</head>
<body>
	<h3>Login Page</h3>
	<form:form action="${pageContext.request.contextPath}/authenticateTheUser" 
	method="post">
		<p>
			User Name: <input type="text" name="username"/>
			
		</p>
		<p>
			Password: <input type="password" name="password"/>
		</p>
		<i class="failed">
				<c:if test="${param.error!=null }">
					Sorry You entered invalid username/password
				</c:if>
		</i>
		<br><br>
		<input type="submit" value="Login"/>
	</form:form>
</body>
</html>