/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hw4.controller;

import com.hw4.dao.MovieDAO;
import com.hw4.pojo.Movie;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author lvsho
 */
public class SearchMovieController extends AbstractController {
    
    public SearchMovieController() {
    }
    
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        String uri = request.getRequestURI();
        ArrayList<Movie> movieList = null;
        if(uri.endsWith("search.htm")){
            if(request.getParameter("txtQuery")!=null&&request.getParameter("rad")!=null){
                String keyword = request.getParameter("txtQuery");
                String colName = request.getParameter("rad");
                movieList = new MovieDAO().searchMovie(keyword,colName);           
            }
            return new ModelAndView("searchresult","movieList",movieList);
        }
        
        
        
        return null;
    }
    
}
