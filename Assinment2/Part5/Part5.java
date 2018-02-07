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
 * Servlet implementation class Part5
 */
@WebServlet("/Part5")
public class Part5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Part5() {
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
		Enumeration<String> form = request.getParameterNames();
		
		out.println("<!DOCTYPE HTML>\n" + "<html>\n" + "<head><title>HW2_part5</title></head>\n" + "<body>\n"
				+ "<h1>Part5 Display Form Data</h1>\n" + "<hr />" +
				"<table> <tr> <th>Form Column</th> <th>Form Data</th> </tr>" 
				);
		while(form.hasMoreElements()) {
			String name = form.nextElement();
			out.println("<tr><td>" + name +"</td><td>" + request.getParameter(name) + "</td></tr>");
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
