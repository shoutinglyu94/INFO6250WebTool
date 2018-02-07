<%@page import="Bean.Course"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Available Courses are:</title>
    </head>
    <body>
        <form method='post' action='CourseController'>
            <h2> Results found </h2>
            <%
              ArrayList<Course> searchResult =(ArrayList<Course>)request.getAttribute("searchResult");
              for(Course course:searchResult){
                  String crn = course.getCrn();
                  String description = course.getCourseDescription();
                  String name = course.getName();
                  String intructor = course.getInstructor();
                  out.println("<input type='checkbox' name='crn' value='" + crn + "'/>" + crn + " - " 
                          + name + " [<a href='CourseController?action=add&crn=" + crn + "'>Add Course</a>]<br/>");
              }
            %>
            <input type='hidden' name='action' value='add'/>
            <input type='submit' value='Add selected courses'>
        </form>
    </body>
</html>