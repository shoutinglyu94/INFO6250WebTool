package com.lab3.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lab3.bean.Course;

/**
 * Servlet implementation class CourseController
 */
@WebServlet("/CourseController")
public class CourseController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	List<Course> courseList;

	@Override
	public void init() {
		// This method will only be call for once
		courseList = new ArrayList<>();
		Course c1 = new Course();
		c1.setCourseDescription("java programming");
		c1.setCrn("36099");
		c1.setInstructor("Khaled M. Bugrara");
		c1.setName("AED");

		Course c2 = new Course();
		c2.setCourseDescription("Course fro learning web technologies used in frint end");
		c2.setCrn("37913");
		c2.setInstructor("YusufOzbek");
		c2.setName("Web Dsign and user exp");

		Course c3 = new Course();
		c3.setCourseDescription("course for learning algorithms");
		c3.setCrn("34267");
		c3.setInstructor("Khaled M. Bugrara");
		c3.setName("Program Structure and Algorithms");

		Course c4 = new Course();
		c4.setCourseDescription("course for learning java EE");
		c4.setCrn("31606");
		c4.setInstructor("YusufOzbek");
		c4.setName("Web Tools");

		courseList.add(c1);
		courseList.add(c2);
		courseList.add(c3);
		courseList.add(c4);

	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// We are using one servlet for multiple things.
		// action is the url parameter to differentiate between different requests
		String action = request.getParameter("action");

		// this session will only be created when the user logs in. Otherwise do not
		// create it.
		HttpSession session = request.getSession(false);
		// set to store courses selected by the user
		Set<Course> myCourses = null;
		if (session.getAttribute("myCourseSet") != null) {
			myCourses = (Set<Course>) session.getAttribute("myCourseSet");
		} else {
			myCourses = new HashSet<Course>();
		}

		if (action.equals("add")) {
			if (request.getParameterValues("crn") != null) {
				String[] crnArray = request.getParameterValues("crn");
				for (String crnNumber : crnArray) {
					for (Course course : courseList) {
						if (course.getCrn().equals(crnNumber)) {
							myCourses.add(course);
						}
					}
				}
				session.setAttribute("myCourseSet", myCourses);
				RequestDispatcher rd = request.getRequestDispatcher("/mycourses.jsp");
				rd.forward(request, response);
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
				rd.forward(request, response);
			}
		} else if (action.equals("search"))

		{
			String query = request.getParameter("query");
			String searchType = request.getParameter("searchType");
			// temporary list to store the search result
			ArrayList<Course> searchResult = new ArrayList<>();
			if (searchType.equals("crn")) {
				for (Course course : courseList) {
					if (course.getCrn().equals(query)) {
						searchResult.add(course);
					}
				}
			} else {
				for (Course course : courseList) {
					if (course.getCourseDescription().contains(query) || course.getInstructor().contains(query)
							|| course.getName().contains(query)) {
						searchResult.add(course);
					}
				}
			}
			request.setAttribute("searchResult", searchResult);
			RequestDispatcher rd = request.getRequestDispatcher("/courseview.jsp");
			rd.forward(request, response);
		} else if (action.equals("remove")) {
			String crn = request.getParameter("crn");
			HashSet<Course> removeCourse = (HashSet<Course>) session.getAttribute("myCourseSet");
			for (Course course : removeCourse) {
				if (course.getCrn().equals(crn)) {
					removeCourse.remove(course);
				}
			}
			RequestDispatcher rd = request.getRequestDispatcher("/mycourses.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CourseController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

}
