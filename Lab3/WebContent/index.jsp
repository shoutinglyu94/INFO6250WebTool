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
	<%
		String username = null;
		String password = null;
		if (request.getCookies() != null) {
			for (Cookie c : request.getCookies()) {
				if (c.getName().equals("username")) {
					username = c.getValue();
				} else if (c.getName().equals("password")) {
					password = c.getValue();
				}
			}
		}
	%>

	<div>
		<h1>Login</h1>
		<form name='myForm' method="post" action="LoginServlet?action=login">
			<input type="text" name="username" placeholder="Username"
				value="<%if (username != null)
				out.print(username);%>" /><br /> <br />
			<input type="password" name="password" placeholder="Password"
				value="<%if (password != null)
				out.print(password);%>" /><br /> <br />
			<input type="checkbox" name="rememberMe" value="remember" />
			Remember me <br /> <br /> <input type="submit" value="Log In" />
		</form>
		<a href="LoginServlet?action=ClearCookies">Clear Cookies</a>
	</div>
</body>
</html>
