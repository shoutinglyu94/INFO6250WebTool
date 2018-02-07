<%@ page import"java.util.Enumeration" %>
<!DOCTYPE HTML>
<html> 
	<head><title>Show Request Header</title></head>
<body><B>Request Method: </B> 
	<%= request.getMethod() %> 
	<br />
	<B>Request URL: </B> <%=request.getRequestURI()%> <br /> 
	<B>Request URL: </B> <%=request.getProtocol()%> <br />
	<hr />
	<table border=1 align=\"CENTER\">
		<tr>
			<th>Header Name<th>
			<th>Header Value</th>
		</tr>
	<% Enumeration<String> headerNames = request.getHeaderNames();
		while(headerNames.hasMoreElements()) {
			String headerName = (String)headerNames.nextElement();
			out.println("<tr><td>" + headerName +"</ td>" +
						"<td>" + request.getHeader(headerName)
						+"</td></tr>");
		}
	%>
	</table>
</bodty>
</html>