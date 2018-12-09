
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>Customer Confirmation Form</title>
</head>
<body>
The Customer is Confirmed ${customer.firstName} ${customer.lastName }
<br>
Free Passes: ${customer.freePasses }
<br>
Postal Code: ${customer.postalCode }
<br>
Course Code: ${customer.courseCode }
</body>
</html>