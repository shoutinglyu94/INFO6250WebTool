/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hw4.dao;

import com.hw4.pojo.Movie;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author lvsho
 */
public class MovieDAO {
    public ArrayList<Movie> searchMovie(String keyword,String colName){
        java.sql.Connection connection = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/webhw4", "root", "846140499");
//            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/moviedb?user=root&password=846140499");
            stmt = connection.createStatement();
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException" + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("SQLException" + ex.getMessage());
        } 

        ArrayList<Movie> movieList = new ArrayList<>();
        try {
            String query = "SELECT * FROM webhw4.movies where " + colName + " like" + "'%" + keyword  + "%'";
//            String query = "SELECT * FROM webhw4.movies";
            ResultSet rs = stmt.executeQuery(query);
     
            while(rs.next()){
                Movie movie = new Movie();
                movie.setTitle(rs.getString("title"));
                movie.setActor(rs.getString("actor"));
                movie.setActress(rs.getString("actress"));
                movie.setGenre(rs.getString("genre"));
                movie.setYear(rs.getInt("publish_year"));
                movieList.add(movie);
            }
        } catch (SQLException ex) {
               System.out.println(ex);
        }finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                System.out.println("SQLException" + ex.getMessage());
            }
        }
        
        return movieList;
    }
    
    public int addMovie(Movie movie){
        java.sql.Connection connection = null;
        Statement stmt = null;
        int row =0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/webhw4", "root", "846140499");
//            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/moviedb?user=root&password=846140499");
            stmt = connection.createStatement();
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException" + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("SQLException" + ex.getMessage());
        } 
        try {
            String title = movie.getTitle();
            String actor = movie.getActor();
            String actress = movie.getActress();
            String genre = movie.getGenre();
            int year = movie.getYear();
            String query = "insert into movies(title, actor,actress, genre, publish_year) \n" +
"values('" + title +"','" + actor + "','" + actress+ "','" +genre +"', " + year +");";
//            String query = "SELECT * FROM webhw4.movies";
            row = stmt.executeUpdate(query);
            System.out.println(row + " movie added!");
        } catch (SQLException ex) {
               System.out.println(ex);
        }finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                System.out.println("SQLException" + ex.getMessage());
            }
        }
        return row;
    }
    
}
