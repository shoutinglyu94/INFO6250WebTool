<%-- 
    Document   : movie
    Created on : Feb 20, 2018, 5:41:05 PM
    Author     : lvsho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Movie theater</title>
    </head>
    <body>
        <c:set var="contextPath" value="${pageContext.request.contextPath}" />
        <h1>Welcome to our Movie Store</h1>
        <h2>Please make the selection below:</h2>
        <form method="get" action="${contextPath}\selection.htm">
            <select name="selection">
                <option selected="selected" value="browse">Browse Movies</option>
                <option value="addmovie">Add new Movie to database</option>
            </select>
            <input type="submit" name="submit" value="Send" />
        </form>
    </body>
</html>
