/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lab3.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author lvsho
 */
public class LoginController extends AbstractController {

    public LoginController() {
    }

    protected ModelAndView processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String action = request.getParameter("action");
        String remember = request.getParameter("rememberMe");
        
        if (action.equals("login")) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            if (username.equals("admin") && password.equals("admin")) {
                session.setAttribute("username", username);
                if (remember != null && remember.equals("remember")) {
                    if (request.getCookies().length < 1) {
                        Cookie cookie = new Cookie("username", username);
                        Cookie cookie1 = new Cookie("password", password);
                        cookie.setMaxAge(7 * 24 * 60 * 60);
                        cookie1.setMaxAge(7 * 24 * 60 * 60);
                        response.addCookie(cookie);
                        response.addCookie(cookie1);
                        System.out.println(remember);
                    }   
                }
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/searchCourse.jsp");
                rd.forward(request, response);
            } else {
                return new ModelAndView("index");
            }
        } else if (action.equals("logout")) {
            session.invalidate();
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/index.jsp");
            rd.forward(request, response);
        } 
        
        return new ModelAndView("index");
    }

    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        return processRequest(request, response);
    }

}
