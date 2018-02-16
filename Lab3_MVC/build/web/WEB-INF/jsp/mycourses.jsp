<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@page import="com.lab3.model.Course" %>
<%@page import="java.util.HashSet" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Course View</title>
    </head>
    <body>
        <jsp:include page="menu.jsp" />
        <h3>Courses Added:</h3>
        <!--if there are no course in the set-->
    <c:if test="${empty sessionScope.myCourseSet}" >
        <h4><c:out value="Sorry, no course added for you."> </c:out> </h4>
    </c:if>
    <c:if test="${sessionScope.myCourseSet!=null}" >
        <table>
            <c:forEach items="${sessionScope.myCourseSet}" var="course">
                <tr>
                    <td>${course.crn}</td>
                    <td>${course.name}</td>
                    <td>${course.instructor}</td>
                    <td><a href="course.htm?action=remove&crn=${course.crn}">Remove Course</a><br/></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</body>
</html>