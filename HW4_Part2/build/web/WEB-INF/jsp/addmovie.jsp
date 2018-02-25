<%-- 
    Document   : addmovie
    Created on : Feb 20, 2018, 7:18:19 PM
    Author     : lvsho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Adding Movies</title>
    </head>
    <body>
        <h1>Adding new Movie</h1>
        <h2>Please Enter the details below:</h2>
        <form:form commandName="add">
            Title:<form:input path="title" /><form:errors path="title" /> <br /><br />
            Lead Actor:<form:input path="actor" /><form:errors path="actor" /> <br /><br />
            Lead Actress:<form:input path="actress" /><form:errors path="actress" /> <br /><br />
            Genre:<form:input path="genre" /><form:errors path="genre" /> <br /><br />
            Published Year:<form:input path="year" /><form:errors path="year" /> <br /><br />
            <input type="submit" value="Add"/> 
        </form:form>
    </body>
</html>
