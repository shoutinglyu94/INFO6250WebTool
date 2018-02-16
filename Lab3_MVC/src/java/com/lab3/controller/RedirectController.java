/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lab3.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author lvsho
 */
public class RedirectController extends AbstractController {

    public RedirectController() {
    }

    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        if (request.getParameter("action") != null) {
            String action = request.getParameter("action");
            if (action.equals("search")) {
                return new ModelAndView("searchCourse");
            } else if (action.equals("mycourses")) {
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/mycourses.jsp");
                rd.forward(request, response);
            }
        }
        return new ModelAndView("error");

    }

}
