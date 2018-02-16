<%@page import="com.lab3.bean.Course"%>
<%@page import="java.util.ArrayList"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Available Courses are:</title>
    </head>
    <body>
    	<jsp:include page="menu.jsp" />
        <form method='post' action='CourseController'>
            <h2> Results found </h2>
            <table>
            <tr>
            <th>Check</th>
            <th>Crn</th>
            <th>Name</th>
            <th>Instructor</th>
            <th></th>
            </tr>
 			<c:forEach items="${requestScope.searchResult}" var="course">
            <tr>
            <td><input type="checkbox" name="crn" value="${course.crn}" /></td>
            <td>${course.crn}</td>
            <td>${course.name}</td>
            <td>${course.instructor}</td>
           	<td><a href="CourseController?action=add&crn=${course.crn}">Add Course</a><br/></td>
            </tr>
            </c:forEach>
            </table>
            <input type='hidden' name='action' value='add'/>
            <input type='submit' value='Add selected courses'>
        </form>
    </body>
</html>