<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.HashSet"%>
<%@page import="Bean.Course"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Course View</title>
</head>
<body>
	[
	<a href='searchCourse.jsp'>Go to Search page</a>] [
	<a href="LoginServlet?action=logout">Logout</a>]
<%-- 	<jsp:include page="menu.jsp" /> --%>
	<h3>Courses Added:</h3>
	<!--if there are no course in the set-->
	<%
		HashSet<Course> myCourseSet = (HashSet<Course>) session.getAttribute("myCourseSet");
		if (myCourseSet == null) {
			out.println("<div><p> No Course Added for you.</p></div>");
		} else {
			//else if there are courses, display every course in the set
			for (Course course : myCourseSet) {
				out.println("CRN: " + course.getCrn() + " - Course Name: " + course.getName()
						+ "[<a href='CourseController?action=remove&crn=" + course.getCrn()
						+ "'>Remove Course</a>]<br />");
			}
		}
	%>
</body>
</html>