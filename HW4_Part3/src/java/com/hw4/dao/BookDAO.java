/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hw4.dao;

import com.hw4.pojo.Book;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author lvsho
 */
public class BookDAO {

    public boolean addMovie(ArrayList<Book> bookList) {
        boolean isAdded = false;
        java.sql.Connection connection = null;
        PreparedStatement stmt = null;
        int row = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/booksdb", "root", "846140499");
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException" + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("SQLException" + ex.getMessage());
        }
        try {
            String template = "INSERT INTO books(isbn,title,author,price)values(?,?,?,?);";
            stmt = connection.prepareStatement(template);
            for (Book book : bookList) {
                String title = book.getTitle();
                String author = book.getAuthor();
                String isbn = book.getIsbn();
                float price = book.getPrice();
                stmt.setString(1, isbn);
                stmt.setString(2, title);
                stmt.setString(3, author);
                stmt.setFloat(4, price);
                stmt.execute();
            }
            System.out.println(row+1 + " book added!");
            isAdded = true;
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
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
        return isAdded;
    }

}
