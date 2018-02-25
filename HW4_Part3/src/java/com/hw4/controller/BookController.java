/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hw4.controller;

import com.hw4.dao.BookDAO;
import com.hw4.pojo.Book;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author lvsho
 */
public class BookController extends AbstractController {

    public BookController() {
    }

    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        boolean isAdded = false;
        int number = 0;
        ModelAndView mv = null;
        ArrayList<Book> bookList = new ArrayList<>();
        HttpSession session = request.getSession();
        if (session.getAttribute("number") != null) {
            number = (int) session.getAttribute("number");
        }

        String uri = request.getRequestURI();

        if (uri.endsWith("addinfo.htm")) {
            for (int i = 0; i < number; i++) {
                String isbn = request.getParameter("txtISBN" + i);
                String title = request.getParameter("txtTitle" + i);
                String author = request.getParameter("txtAuthor" + i);
                String price = request.getParameter("txtPrice" + i);
                if (isbn != null && title != null
                        && author != null
                        && price != null) {
                    System.out.println(isbn + "," + title + "," + author + "," + price);
                    Book book = new Book();
                    book.setIsbn(isbn);
                    book.setTitle(title);
                    book.setAuthor(author);
                    book.setPrice(Float.parseFloat(price));
                    bookList.add(book);
                }
            }
            if (bookList.isEmpty()) {
                return new ModelAndView("error", "message", "Please enter details of the books!");
            }
            BookDAO bdao = new BookDAO();
            isAdded = bdao.addMovie(bookList);
            if (isAdded == true) {
                mv = new ModelAndView("addsucess", "number", number);
            } else {
                mv = new ModelAndView("error", "message", "Can not add books!");
            }
        } else if (uri.endsWith("form.htm")) {
            mv = new ModelAndView("addbooks");
        }

        return mv;
    }

}
