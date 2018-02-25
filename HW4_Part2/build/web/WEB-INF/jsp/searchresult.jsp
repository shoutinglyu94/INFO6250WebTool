<%-- 
    Document   : searchresult
    Created on : Feb 20, 2018, 6:25:01 PM
    Author     : lvsho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Result</title>
    </head>
    <body>
        <c:set var="contextPath" value="${pageContext.request.contextPath}" />
        <h1>Searching Result</h1>
        <h2>You searched for :</h2>
        <h2>search details:</h2>
        <table>
            <tr>
            <th>Movie Title:</th>
            <th>Lead Actor:</th>
            <th>Lead Actress:</th>
            <th>Genre:</th>
            <th>Published Year:</th>
            </tr>
            <c:forEach items="${movieList}" var="movie">
                <tr>
                <td>${movie.title}</td>
                <td>${movie.actor}</td>
                <td>${movie.actress}</td>
                <td>${movie.genre}</td>
                <td>${movie.year}</td> 
                </tr>
            </c:forEach>
        </table>
        <a href="http://localhost:8084/HW4_Part2/movie.htm">Click here to go back to the main page</a>
    </body>
</html>
