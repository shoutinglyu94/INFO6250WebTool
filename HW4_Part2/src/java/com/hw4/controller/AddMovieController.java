/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hw4.controller;

import com.hw4.dao.MovieDAO;
import com.hw4.pojo.Movie;
import com.hw4.validator.MovieValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 *
 * @author lvsho
 */
public class AddMovieController extends SimpleFormController {
    
    public AddMovieController() {
        //Initialize controller properties here or 
        //in the Web Application Context

        setCommandClass(Movie.class);
        setCommandName("add");
        setSuccessView("addsuccess");
        setFormView("addmovie");
        setValidator(new MovieValidator());
    }
    
//    @Override
//    protected void doSubmitAction(Object command) throws Exception {
//        throw new UnsupportedOperationException("Not yet implemented");
//    }

    //Use onSubmit instead of doSubmitAction 
    //when you need access to the Request, Response, or BindException objects
    @Override
    protected ModelAndView onSubmit(
            HttpServletRequest request, 
            HttpServletResponse response, 
            Object command, 
            BindException errors) throws Exception {
        ModelAndView mv = null;
        //Do something...
           Movie movie = (Movie) command;
           System.out.println(movie);
        //LoginDAO ldao = new LoginDAO();
        MovieDAO mdao = (MovieDAO) this.getApplicationContext().getBean("moviedao");
        HttpSession session = request.getSession();
        int row = mdao.addMovie(movie);
        session.setAttribute("addNumber", row);
        if(row == 0){
            mv = new ModelAndView("error","message","Something wrong while adding a new movie");
        }else{
            mv = new ModelAndView(getSuccessView());
        }
        return mv;
    }
    
}
