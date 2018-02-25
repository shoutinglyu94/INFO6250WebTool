/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hw4.controller;

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
public class NumberController extends AbstractController {

    public NumberController() {
    }

    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = null;
        String uri = request.getRequestURI();
        if (uri.endsWith("index.htm")) {
            mv = new ModelAndView("books");
            return mv;
        } else if(uri.endsWith("add.htm")){
            if (request.getParameter("txtNumber") != null) {
                int number = Integer.parseInt(request.getParameter("txtNumber"));
                if (number != 0) {
                    System.out.println(number);
                    HttpSession session = request.getSession();
                    session.setAttribute("number", number);
                    RequestDispatcher rd = request.getRequestDispatcher("/addbooks/form.htm");
                    rd.forward(request, response);
                }else{
                    return new ModelAndView("error","message","Wrong");
                }
            } else {
                mv = new ModelAndView("error", "message", "Please enter the number of books you want to add!");
            }
        }
        return mv;
    }

}
