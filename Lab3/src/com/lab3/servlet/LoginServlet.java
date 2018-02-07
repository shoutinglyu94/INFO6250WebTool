package com.lab3.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String action = request.getParameter("action");
        String remember = request.getParameter("rememberMe");
       
        if(action.equals("login")) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            if (username.equals("admin") && password.equals("admin")) {
                session.setAttribute("username", username);
                if(remember!=null&&remember.equals("remember")) {
                	Cookie cookie = new Cookie("username",username);
                	Cookie cookie1 = new Cookie("password",password);
                	cookie.setMaxAge(7*24*60*60);
                	cookie1.setMaxAge(7*24*60*60);
                	response.addCookie(cookie);
                	response.addCookie(cookie1);
                }
                response.sendRedirect("searchCourse.jsp");
            } else {
                response.sendRedirect("index.jsp");
                //username/password not correct, send user to error-page or login page
            }
        } else if (action.equals("logout")) {
            //invalidate() removes all the objects from the session
        	
            session.invalidate();
            response.sendRedirect("index.jsp");
        } else if(action.equals("ClearCookies")) {
        	Cookie cookie = new Cookie("username",null);
        	Cookie cookie1 = new Cookie("password",null);
        	cookie.setMaxAge(0);
        	cookie1.setMaxAge(0);
        	response.addCookie(cookie);
        	response.addCookie(cookie1);
    		response.sendRedirect("index.jsp");
        }

    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}


}
