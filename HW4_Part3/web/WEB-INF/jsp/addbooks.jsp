<%-- 
    Document   : addbooks
    Created on : Feb 21, 2018, 11:06:18 PM
    Author     : lvsho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:set var="end" value="${sessionScope.number-1}" />
         <c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
        <h1>Please fill the details of the books:</h1>
        <form method="post" action="${contextPath}/addbooks/addinfo.htm">
            <table>
            <tr>
                <th>ISBN</th>
                <th>Book Title</th>
                <th>Author</th>
                <th>Price</th>
            </tr>
            <c:forEach var ="i" begin="0" end="${end}">
                <tr>
                    <td><input type="text" name="txtISBN${i}" /></td>
                    <td><input type="text" name="txtTitle${i}" /></td>
                    <td><input type="text" name="txtAuthor${i}" /></td>
                    <td><input type="text" name="txtPrice${i}" /></td>
                </tr>
            </c:forEach>
        </table>
           
            <input type="submit" name="submit" value="Submit" />
        </form>

    </body>
</html>
