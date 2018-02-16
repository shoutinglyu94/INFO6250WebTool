<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping</title>
        <style>
#section {
    width:350px;
    float:left;
    padding:10px; 
}
</style>
    </head>
    <body>
        <jsp:include page="menu.jsp" />
        <section id="section"> 
            <h2>Shopping</h2>
            <form action="shopping.htm" method="get">
                <table>
                    <c:if test="${requestScope.selectedProducts!=null}">
                        <c:forEach items="${requestScope.selectedProducts}" var="product">
                            <tr>
                                <td><input type="checkbox" name="chkProduct" value="${product}" /></td>
                                <td>${product.id}</td>
                                <td>${product.name}</td>
                                <td>${product.price}</td>
                            </tr>
                        </c:forEach>
                    </c:if>
                </table>
                <input type="hidden" name="action" value="add">
                <input type="submit" value="Add to cart">
            </form>
        </section>

    </body>
</html>
