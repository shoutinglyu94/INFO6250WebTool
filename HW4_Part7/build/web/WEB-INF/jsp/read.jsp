<%-- 
    Document   : choosefile
    Created on : Feb 23, 2018, 2:35:23 PM
    Author     : lvsho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="/WEB-INF/tlds/hw4.tld" prefix="my" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Choose File</title>
    </head>
    <body>
        <c:set var="contextPath" value="${pageContext.request.contextPath}" />

        <c:if test="${firstpage!=null}"> 
            <h1>Please enter the name of the file you want to read:</h1>
            <form method="post" action="${contextPath}/read/viewform.htm">
                <input type="text" name="txtFileName" />
                <input type="submit" name="submit" value="Submit" />
            </form>
        </c:if>

        <c:if test="${error!=null}">
            <h1>Error!</h1>
            ${error}
        </c:if>

        <c:if test="${row!=null}">
            <h1>${row} added into database successfully!</h1>
            <a href="${contextPath}/read/choosefile.htm">Go back to the first page</a>
        </c:if>

        <c:if test="${viewform!=null}">
            <h1>Here are the information of sales order:</h1>
            <form method='post' action='${contextPath}/read/insert.htm'>
                <table>
                    <tr>
                        <c:forEach items="${sessionScope.sample.attributeList}" var="attribute" >
                            <th>${attribute}</th>
                            </c:forEach>  
                    </tr>

                    <my:ReadFile fileName="${fileName}" />
                </table>
                <input type="submit" name="submit2" value="Submit"/> 
            </form>
        </c:if>    

    </body>
</html>
