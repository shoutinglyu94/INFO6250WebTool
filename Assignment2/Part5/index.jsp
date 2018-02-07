<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>

<body>
	<h1>Petition Form</h1>
	<form action="Part4" method="get">
		<fieldset>
			<legend>
				<em>Student Information</em>
			</legend>
			<br>
			<table align="left"
				style="border-collapse: separate; border-spacing: 10px">
				<tr>
					<td><label style="margin: 10px 5px" for="txtid">NU ID:</label></td>
					<td><input type="text" name="txtID" id="txtid" size="30" /></td>
				</tr>
				<tr>
					<td><label style="margin: 10px 5px" for="txtprgram">Current
							Program/Concentration:</label></td>
					<td><input type="text" name="txtProgram" id="txtrogram"
						size="30" /></td>
				</tr>
				<tr>
					<td><label style="margin: 10px 5px" for="txtlast">Name:</label></td>
					<td><input type="text" name="txtlastName" value="Last Name"
						size="30" /></td>
					<td><input type="text" name="txtFirstName" value="First Name"
						size="30" /></td>
					<td><input type="text" name="txtMiddleName"
						value="Middle Name" size="30" /></td>
				</tr>
				<tr>
					<td><label style="margin: 10px 5px">LocalAddress:</label></td>
					<td><input type="text" name="txtStreet" size="30" /></td>
					<td><input type="text" name="txtCity" size="20" /></td>
					<td><input type="text" name="txtState" size="10"> <input
						type="text" name="txtZip" size="10" /></td>
				</tr>
				<tr>
					<td><label style="margin: 10px 5px">Phone:</label></td>
					<td><input type="text" name="txtPhone" size="30" /></td>
				</tr>
				<tr>
					<td><label style="margin: 10px 5px">Husky Email:</label></td>
					<td><input type="text" name="txtEmail" size="30" /></td>
					<td>@husky.neu.edu</td>
				</tr>
				<tr>
					<td><label style="margin: 10px 5px">Current Degree
							Level:</label></td>
					<td><input type="checkbox" name="chkDegree"
						style="margin: 10px 5px">MS <input type="checkbox"
						name="chkDegree" style="margin: 10px 5px">PHD <input
						type="checkbox" name="chkDegree" style="margin: 10px 5px">Certificate
						Only</td>
					<td><input type="checkbox" name="chkDegree"
						style="margin: 10px 5px">Special Student</td>
					<td><input type="checkbox" name="chkDegree"
						style="margin: 10px 5px">International <input
						type="checkbox" name="chkDegree" style="margin: 10px 5px">Domestic
					</td>
				</tr>
			</table>
		</fieldset>
		<br />
		<hr />
		<p>
			<b>Course Information</b>
		</p>
		<br /> 1. Check Apply <br /> <input type="checkbox" name="chkApply"
			style="margin: 10px 5px">Elective outside core curriculum <input
			type="checkbox" name="chkApply" style="margin: 10px 5px">Core
		course wavie<input type="checkbox" name="chkApply"
			style="margin: 10px 5px">Change in status <br /> <input
			type="checkbox" name="chkApply" style="margin: 10px 5px">Course
		repeat/official substitution <input type="checkbox" name="chkApply"
			style="margin: 10px 5px">Extension of time limit to program
		completion <input type="checkbox" name="chkApply"
			style="margin: 10px 5px"> Other(specify): <input type="text"
			name="txtother" size="40" style="margin: 10px 5px"> <br />
		2. For each course concerned, please provide the information below: <br />
		<table border="2" cellpadding="1" cellspacing="1">
			<tr>
				<th>Course Name</th>
				<th>Term</th>
				<th>CRN #</th>
				<th>Course #</th>
				<th># Credits</th>
			</tr>
			<tr>
				<td><input type="text" name="txtCourseName"></td>
				<td><input type="text" name="txtTerm"></td>
				<td><input type="text" name="txtCrn"></td>
				<td><input type="text" name="txtCourseNumber"></td>
				<td><input type="text" name="txtCredits"></td>
			</tr>
			<tr>
				<td><input type="text" name="txtCourseName1"></td>
				<td><input type="text" name="txtTerm1"></td>
				<td><input type="text" name="txtCrn1"></td>
				<td><input type="text" name="txtCourseNumber1"></td>
				<td><input type="text" name="txtCredits1"></td>
			</tr>
		</table>

		<br /> 3. What are you petitioning? Please explain(attach separate
		sheet if necessary): <br />
		<textarea name="txaWhyPetition" rows="10" cols="100"></textarea>
		<br />
		<br /> Digital Signature: <br />
		<br /> <input type="text" name="txtDigitalSig" size="30"
			style="margin-left: 20"> <br /> <br /> <label>Date:</label>
		<input type="Date" name="datSig"> <br />
		<hr />
		<p>
			<b>Program Advisor:</b>
		</p>
		<label>Recommendation:</label> <input type="radio" name="radRecommendation" value="Approved" />
		Approved <input type="radio" name="radRecommendation" value ="Denied"/> Denied <br />
		<table>
			<tr>
				<th>Signature:</th>
				<td><input type="text" name="txtSig"></td>
				<td><input type="text" name="txtPrintname"></td>
			</tr>
			<tr>
				<th>Advisor's Comments add/or instructions:</th>
				<td><input type="text" name="txtInstru"></td>
				<td>Date:<input type="Date" name="datInstru"></td>
			</tr>
			<tr>
				<th>ECE Graduate Committee Chair:</th>
				<td><input type="text" name="txtChair"></td>
				<td>Date:<input type="Date" name="datChair"></td>
			</tr>
		</table>
		<br /> 
		<br />
		<hr />
		<p>
			<b>Graduate School:</b>
		</p>
		<label>Recommendation:</label> <input type="radio" name="radclass" />
		Approved <input type="radio" name="radClass" value="Approved"/>Denied <input
			type="radio" name="radClass" value ="Denied"/> No Action <input type="radio"
			name="radClass" value="No Action" /> Returned for additional information <input
			type="radio" name="radClass" value="Returned for additional information"/> ASC Report field <br />
		<br /> <label>Comments to student:</label> <input type="text"
			name="txtComment" size="100" style="margin-left: 10" /> <br />
		<br /> <label>Graduate school authorization:</label> <input
			type="text" name="txtAuthorization" size="40"
			style="margin-left: 10; margin-right: 10"> <label>Date:</label>
		<input type="Date" name="datAuthorization"> <label>Effective
			Term:</label> <input type="text" name="txtEfectiveTerm" size="20"
			style="margin-left: 10"> <br />
		<br /> <input type="submit" name="submitbutton" value="Send" />
	</form>

	<!-- 		<hr />
		<b>Other Information</b>
		<br />
		<p>
			<b>THE GRADUATE SCHOOL OFFICE WILL EMAIL YOU A COPY OF THIS FORM AFTER A DECISION IS MADE.</b>
			<br />
			SUBMIT YOUR PETITION WITH ALL REQUESTED SUPPORTING DOCUMENTATION TO YOUR PROGRAM ADVISOR. YOUR PROGRAM ADVISOR WILL FORWARD IT TO THE GRADUATE SCHOOL OF ENGINEERING.NOTE THAT PETITIONS MAY TAKE UP TO 2 WEEKS TO PROCESS, SO PLEASE PLAN ACCORDINGLY.</p>
		<br />

		<p>
			<b>ELECTIVE OUTSIDE APPROVED LIST OF COURSES FOR PROGRAM OF STUDY</b>
			<br />
			If the course you wish to take is not listed in the approved curriculum in the University Graduate Catalog for your year of entry into the program OR in the current year Catalog, you must request permission from your academic advisor to take the course BEFORE registering for the course. Failure to obtain permission to take the course may result in the course not counting toward your graduate degree.
		</p>
		<br />
		<p>
			<b>CORE COURSE WAIVER</b>
			<br />
			A student may petition to waive any core, or required, course when he or she has completed equivalent or similar course work elsewhere. The student must submit a completed petition form, along with a course description and official transcript from the institution where he or she completed the course.
			<br />
			Note: Course waivers do not decrease the number of required semester hours in any program of study.
		</p>
		<br />
		<p>
			<b>CHANGE IN STATUS</b>
			<br />
			FULL-TIME TO PART-TIME: Students who hold an F-1 or J-1 visa, have an assistantship, or are on Co-op are not eligible.
			<br />
			PART-TIME TO FULL-TIME: Minimum 3.000 QPA after 8 SH have been completed while a part-time student.Students who hold an H-1 visa are not eligible.
		</p>
		<br />
		<p><b>COURSE REPEAT/SUBSTITUTION</b>
			<br />
			The Graduate School of Engineering allows students to repeat up to 8 semester hours of course work beyond stated minimum degree requirements in order to attain the required 3.000 GPA for graduation. In some cases, it may not be possible to repeat a course if a student wishes to do so. In certain, unusual circumstances, students may petition to substitute one course for another they have already taken, as long as the subject matter of both courses is substantially alike. Within the above limitations for extra or repeated courses, a student must repeat any required core course in which he or she earns below a grade of C.
			<br />
			Students must obtain approval from their program advisor and the Graduate School of Engineering prior to repeating a course.
		</p>
		<br />
		<p>
			<b>EXTENSION OF TIME LIMIT TO COMPLETE PROGRAM</b>
			<br />
			In the case of the Doctor of Philosophy degree, after the establishment of degree candidacy, a maximum of five years is allowed for the completion of degree requirements. All master’s degree course credits earned in a program of graduate study, or accepted by transfer, are valid for a maximum of seven years. To request an extension, include the reason(s) for your request, an intended course of action, and length of time needed to complete degree requirements.

		</p>
	 -->
</body>
</html>