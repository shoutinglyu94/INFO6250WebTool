package HW2;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Part4
 */
@WebServlet("/Part4")
public class Part4 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Part4() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Map<String, String[]> form = request.getParameterMap();

		String nuid = form.get("txtID")[0];
		String programName = form.get("txtProgram")[0];
		String lastName = form.get("txtlastName")[0];
		String firstName = form.get("txtFirstName")[0];
		String middleName = form.get("txtMiddleName")[0];
		String streetName = form.get("txtStreet")[0];
		String cityName = form.get("txtCity")[0];
		String stateName = form.get("txtState")[0];
		String zipCode = form.get("txtZip")[0];
		String phone = form.get("txtPhone")[0];
		String email =form.get("txtEmail")[0] + "husky.neu.edu";
		String currentDegree = request.getParameter("chkDegree");
		String courseName = form.get("txtCourseName")[0];
		String term = form.get("txtTerm")[0];
		String crn = form.get("txtCrn")[0];
		String courseNumber = form.get("txtCourseNumber")[0];
		String credits = form.get("txtCredits")[0];
		String courseName1 = form.get("txtCourseName1")[0];
		String term1 = form.get("txtTerm1")[0];
		String crn1 = form.get("txtCrn1")[0];
		String courseNumber1 = form.get("txtCourseNumber1")[0];
		String credits1 = form.get("txtCredits1")[0];
		String petitionReason = form.get("txaWhyPetition")[0];
		String signature = form.get("txtDigitalSig")[0];
		String reSig = form.get("txtSig")[0];
		String rePrint = form.get("txtPrintname")[0];
		String reInstru = form.get("txtInstru")[0];
		String reChair = form.get("txtChair")[0];
		String comment = form.get("txtComment")[0];
		String authorization = form.get("txtAuthorization")[0];
		String effectiveterm = form.get("txtEfectiveTerm")[0];
		
		Date authdate = (Date)request.getAttribute("datAuthorization");
		Date reDateChair = (Date)request.getAttribute("datChair");
		Date reDateInstru = (Date)request.getAttribute("datInstru");
		Date dateSig = (Date)request.getAttribute("datInstru");
		
		out.println("<!DOCTYPE HTML>\n" + "<html>\n" + "<head><title>HW2_part4</title></head>\n" + "<body>\n"
				+ "<h1>Part4 Display Form Data</h1>\n" + "<hr />" + "<h2>Student Information:</h2>"
				+ "<table><tr><td>" + "NUID:</td>" + "<td>" + nuid + "</td></tr>"
				+ "<tr><td>Program:</td>" + "<td>" + programName + "</td></tr>" + "<tr><td>Name:</td>" + "<td>"
				+ firstName + " " + middleName + " " + lastName + "</td></tr>" + "<tr><td>Address:</td>" + "<td>"
				+ streetName + ", " + cityName + ", " + stateName + zipCode + "</td></tr>" + "<tr><td>Phone:</td>"
				+ "<td>" + phone + "</td></tr>" + "<tr><td>Email:</td>" + "<td>" + email + "</td></tr>"
				+ "<tr><td>Current Degree:</td>" + "<td>" + currentDegree + "</td></tr>" + "</tr></table>" + "<br /><hr />");
		
		out.println("<h2>Course Inforamtion</h2>" + "<table><tr><td>Issue:</td>" + "<td>");
		if(form.get("chkApply")!=null) {
			for (String issue : form.get("chkApply")) {
				out.println(issue + " ");
			}
		}
		
		out.println("</td></tr>");
		out.println("<tr>\r\n" + "<th>Course Name</th>\r\n" + "<th>Term</th>\r\n" + "<th>CRN #</th>\r\n"
				+ "<th>Course #</th>\r\n" + "<th># Credits</th>\r\n" + "</tr>");
		out.println("<tr><td>" + courseName + "</td>" +
				"<td>" + term + "</td>" +
				"<td>" + crn + "</td>" +
				"<td>" + courseNumber + "</td>" +
				"<td>" + credits + "</td>" +
				"</tr>" 
				);
		out.println("<tr><td>" + courseName1 + "</td>" +
				"<td>" + term1 + "</td>" +
				"<td>" + crn1 + "</td>" +
				"<td>" + courseNumber1 + "</td>" +
				"<td>" + credits1 + "</td>" +
				"</tr></table>" 
				);
		
		out.println("<hr /><h2>Petition Statement:</h2>" +petitionReason +
					"<br /><br />" +"<h3>Digital Signiaure:</h3>" + signature +
					"<br /><br />" +"<h3>Date:</h3>" + dateSig +
					"<hr />");
		
		out.print("<h2>Program Advisor:</h2>" + "Recommendation:");
		if(form.get("radRecommendation")!=null) {
			for(String rad : form.get("radRecommendation")) {
				out.println(rad + " ");
			}
		}
		out.println(
				"<br />Signature & PrintName:" + reSig + "&nbsp;&nbsp;&nbsp;" + rePrint +
				"<br />Advisor's Comments add/or instructions:" + reInstru + "&nbsp;&nbsp;&nbsp;" + reDateInstru +
				"<br />ECE Graduate Committee Chair:" + reChair + "&nbsp;&nbsp;&nbsp;" + reDateChair + 
				 "<hr />");
		
		out.println("<h2>Graduate School:</h2> Recommendation:");
		if(form.get("radClass")!=null) {
			for(String rad : form.get("radClass")) {
				out.println(rad + " ");
			}
		}
		out.println(
				"<br />Comments to student:" + comment +
				"<br />Graduate school authorization:" + authorization +
				"<br />Date:" + authdate +
				"<br />Effective Term:" + effectiveterm);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
