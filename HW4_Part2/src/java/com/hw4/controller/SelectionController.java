/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hw4.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author lvsho
 */
public class SelectionController extends AbstractController {

    public SelectionController() {
    }

    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        String uri = request.getRequestURI();
        if (uri.endsWith("movie.htm")) {
            return new ModelAndView("movie");
        }
        if (uri.endsWith("selection.htm")) {
            if (request.getParameter("selection") != null) {
                String selection = request.getParameter("selection");
                System.out.println(selection);
                if (selection.equals("browse")) {
                    return new ModelAndView("search");
                } else if (selection.equals("addmovie")) {
                    RequestDispatcher rd = request.getRequestDispatcher("/add.htm");
                    rd.forward(request, response);
                }

            }

        }
        return null;
    }

}
