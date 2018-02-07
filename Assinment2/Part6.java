package HW2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Part6
 */
@WebServlet("/Part6")
public class Part6 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Part6() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<%@ page language=\"java\" contentType=\"text/html; charset=ISO-8859-1\"\r\n" + 
				"    pageEncoding=\"ISO-8859-1\"%>\r\n" + 
				"<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n" + 
				"<title>Part6</title>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"<div id=\"form0\">\r\n" + 
				"	<form name =\"childrenform\">\r\n" + 
				"	<p>How many children do you have?</p>\r\n" + 
				"	<input type=\"text\" name=\"txtNumber\" id=\"txtNumber\" />\r\n" + 
				"	<input type =\"button\" name = \"button\" value=\"Send\" id=\"query\"/>\r\n" + 
				"	</form>\r\n" + 
				"</div>\r\n" + 
				"	<script>\r\n" + 
				"	document.getElementById(\"query\").onclick = function() {myFunction()};\r\n" + 
				"	function myFunction() {\r\n" + 
				"	    var number = document.getElementById(\"txtNumber\").value;\r\n" + 
				"	    for(var i=0;i<parseInt(number);i++){\r\n" + 
				"	    	document.write(\"<form name=\\\"nameform\\\" method=\\\"post\\\" action=\\\"Part6\\\">\" +\r\n" + 
				"	    			\"Please enter the name of your child:\" + String(i+1) +\"<br />\" +\r\n" + 
				"	    			\"<input type=\\\"text\\\" name=\\\"txtname\" + String(i+1) + \"\\\" /><br />\"  \r\n" + 
				"	    			);\r\n" + 
				"	    }\r\n" + 
				"	    \r\n" + 
				"	    document.write(\"<input type=\\\"hidden\\\" name=\\\"number\\\" value=\\\"\" + parseInt(number) + \r\n" + 
				"	    		\"\\\"><input type=\\\"submit\\\" value=\\\"Send\\\" /></form>\");\r\n" + 
				"	}\r\n" + 
				"	</script>\r\n" + 
				"</body>\r\n" + 
				"</html>");
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n" + 
				"<title>Result</title>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" +  "<p>Your children's name are:</p>");
		String numberStr = request.getParameter("number");
		int number = Integer.parseInt(numberStr);
		for(int i=0;i<number;i++) {
			String name = request.getParameter("txtname" + (i+1));
			out.println(name + "<br />");
		}
		out.println("</body>\r\n" +
				"</html>");
				
		
	}

}
