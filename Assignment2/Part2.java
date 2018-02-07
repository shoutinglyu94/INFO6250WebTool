package HW2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Part2
 */
@WebServlet("/Part2")
public class Part2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Part2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String title = "Show Request Header";
		String docType="<!DOCTYPE HTML>\n";
		out.println(docType + 
					"<html>\n" + 
					"<head><title>" + title + "</title></head>\n" +
					"<body>" +"<B>Request Method: </B>" + request.getMethod() + "<br />\n" 
					+ "<B>Request URL: </B>" + request.getRequestURI() + "<br />\n"  
					+ "<B>Request URL: </B>" + request.getProtocol() + "<br />\n"
					+ "<hr />" 
					+ "<table border=1 align=\"CENTER\">\n"
					+"<th>Header Name<th>Header Value");
		Enumeration<String> headerNames = request.getHeaderNames();
		while(headerNames.hasMoreElements()) {
			String headerName = (String)headerNames.nextElement();
			out.println("<tr><td>" + headerName +"</ td>" +
						"<td>" + request.getHeader(headerName)
						+"</td></tr>");
		}
		out.println("</table>\n</bodty>\n</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
