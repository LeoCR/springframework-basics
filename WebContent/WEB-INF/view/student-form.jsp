<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>Student Registration Form</title>
</head>
<body>
	<form:form action="processForm" modelAttribute="student">
		First name <form:input path="firstName"/>
		<br><br>
		Last name <form:input path="lastName"/>
		<br><br>
		Country:<form:select path="country">
			<form:options items="${student.countryOptions}"/>
		</form:select>
		<br><br>
		Favorite Languague:
		Java <form:radiobutton path="favoriteLanguague" value="Java"/>
		PHP <form:radiobutton path="favoriteLanguague" value="PHP"/>
		C# <form:radiobutton path="favoriteLanguague" value="C#"/>
		Ruby <form:radiobutton path="favoriteLanguague" value="Ruby"/>
		<br><br>
		Operating Systems:
		Linux<form:checkbox path="operationSystems" value="Linux"/>
		Microsoft Windows<form:checkbox path="operationSystems" value="Microsof Windows"/>
		Mac OSX<form:checkbox path="operationSystems" value="Mac OSX"/>
		<br><br>
		
		<input type="submit" value="submit"/>
	</form:form>
</body>
</html>
