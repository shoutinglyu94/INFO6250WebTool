<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<title>NEU Courses</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="username" value="${cookie['username'].value}"></c:set>
<c:set var="password" value="${cookie['password'].value}"></c:set>

	<div>
		<h1>Login</h1>
		<form name='myForm' method="post" action="LoginServlet?action=login">
			<input type="text" name="username" placeholder="Username"
				value="${username}" /><br /> <br />
			<input type="password" name="password" placeholder="Password"
				value="${password}" /><br /> <br />
			<input type="checkbox" name="rememberMe" value="remember" />
			Remember me <br /> <br /> <input type="submit" value="Log In" />
		</form>
		<a href="LoginServlet?action=ClearCookies">Clear Cookies</a>
	</div>
</body>
</html>
