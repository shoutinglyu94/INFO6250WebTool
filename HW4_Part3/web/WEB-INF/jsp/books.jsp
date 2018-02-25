<%-- 
    Document   : books
    Created on : Feb 21, 2018, 10:29:27 PM
    Author     : lvsho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Books</title>
    </head>
    <body>
        <c:set var="contextPath" value="${pageContext.request.contextPath}" />
        <h1>How many books do you want to add?</h1>
        <form method="post" action="${contextPath}\books\add.htm">
            <input type="text" name="txtNumber" />
            <input type="submit" name="submit" value="Submit" />
        </form>
    </body>
</html>
