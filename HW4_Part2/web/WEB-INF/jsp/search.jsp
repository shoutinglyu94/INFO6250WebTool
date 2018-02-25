<%-- 
    Document   : search
    Created on : Feb 20, 2018, 6:24:10 PM
    Author     : lvsho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Movie Store</title>
    </head>
    <body>
        <c:set var="contextPath" value="${pageContext.request.contextPath}" />
        <h1>Searching Movies</h1>
        <h2>Keyword:</h2>
        <form method="post" action="${contextPath}\search.htm">
            <input type="text" name="txtQuery" value="" /><br/>
            <input type="radio" name="rad" value="title" /> Search By Title<br/>
            <input type="radio" name="rad" value="actor" /> Search By Actor<br/>
            <input type="radio" name="rad" value="year" /> Search By Year<br/>
            <input type="submit" name="submit" value="Search Movies" />            
        </form>   
    </body>
</html>
