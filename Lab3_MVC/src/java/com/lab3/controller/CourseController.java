/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lab3.controller;

import com.lab3.model.Course;
import com.lab3.model.CourseCatalog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author lvsho
 */
public class CourseController extends AbstractController {

    public CourseController() {
    }

    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        CourseCatalog sc = CourseCatalog.getInstance();
        ArrayList<Course> courses = sc.getCourses();
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
                    for (Course course : courses) {
                        if (course.getCrn().equals(crnNumber)) {
                            myCourses.add(course);
                        }
                    }
                }
                session.setAttribute("myCourseSet", myCourses);
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/mycourses.jsp");
                rd.forward(request, response);
            } else {
                return new ModelAndView("error");
            }
        } else if (action.equals("search")) {
            String query = request.getParameter("query");
            String searchType = request.getParameter("searchType");
            // temporary list to store the search result
            ArrayList<Course> searchResult = new ArrayList<>();
            if (searchType.equals("crn")) {
                for (Course course : courses) {
                    if (course.getCrn().equals(query)) {
                        searchResult.add(course);
                    }
                }
            } else {
                for (Course course : courses) {
                    if (course.getCourseDescription().contains(query) || course.getInstructor().contains(query)
                            || course.getName().contains(query)) {
                        searchResult.add(course);
                    }
                }
            }
            return new ModelAndView("courseview", "searchResult", searchResult);
        } else if (action.equals("remove")) {
            String crn = request.getParameter("crn");
            HashSet<Course> removeCourse = (HashSet<Course>) session.getAttribute("myCourseSet");
            Iterator it = removeCourse.iterator();
            while(it.hasNext()){
                Course removing = (Course)it.next();
                if(removing.getCrn().equals(crn)){
                    it.remove();
                }
            }
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/mycourses.jsp");
            rd.forward(request, response);
        }
        return new ModelAndView("error");

    }

}
