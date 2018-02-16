<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>My Shopping Cart</title>
        <style>
            #myCart {
                width:350px;
                float:left;
                padding:10px; 
            }
        </style>
    </head>
    <body>
        <jsp:include page="menu.jsp" />
    <header id="header">
        <h1>My Shopping Cart</h1>
    </header>
    <section id="myCart">
        <table>
            <tr>
                <th>Product Id</th>
                <th>Product Name</th>
                <th>Product Price</th>
            </tr>
            <c:if test="${sessionScope.myCart!=null}">
                <c:forEach items="${sessionScope.myCart}" var="product">
                    <tr>
                        <td>${product.id}</td>
                        <td>${product.name}</td>
                        <td>${product.price}</td>
                    </tr>
                </c:forEach>
            </c:if>
        </table>
    </section>

</body>
</html>