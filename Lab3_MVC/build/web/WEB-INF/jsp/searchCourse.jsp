<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<%@page session="true" %>
<html>
    <head>
        <title>Select Courses</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
        <meta http-equiv="Pragma" content="no-cache" />
        <meta http-equiv="Expires" content="0" />
    </head>
    <body>
        <div>
            <h2> Search Courses</h2>
            <jsp:include page="menu.jsp" />
            <form id="form" action="course.htm" method="post" >
                <br />
                <br />                 
                Search Query <input type="text" name="query"/> <br/><br/>
                <input type="radio" name="searchType" value="crn" checked=""/> Search By CRN
                <input type="radio" name="searchType" value="title"/> Search By Instructor or Title
                <input type="hidden" name="action" value="search" />
                <br/><input type="submit" value="SEARCH"/>
            </form>
        </div>
    </body>
</html>
