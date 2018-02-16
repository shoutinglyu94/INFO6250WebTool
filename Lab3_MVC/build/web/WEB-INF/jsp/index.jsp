<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@ page session="true"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <title>NEU Courses</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <c:out value="${cookie}"></c:out>
    <c:set var="username" value="${cookie.username.value}"></c:set>
    <c:set var="password" value="${cookie.password.value}"></c:set>

    <div>
        <h1>Login</h1>
        <form name='myForm' method="post" action="login.htm?action=login">
            <input type="text" name="username" placeholder="Username"
                   value="${username}" /><br /> <br />
            <input type="password" name="password" placeholder="Password"
                   value="${password}" /><br /> <br />
            <input type="checkbox" name="rememberMe" value="remember" />
            Remember me <br /> <br /> <input type="submit" value="Log In" />
        </form>
    </div>
</body>
</html>
