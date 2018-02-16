/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hw2.controller;

import com.hw2.model.Product;
import com.hw2.model.ProductCatalog;
import java.util.ArrayList;
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
public class ShoppingController extends AbstractController {

    public ShoppingController() {
    }

    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ArrayList<Product> productList = ProductCatalog.getInstance().getProductList();
        HttpSession session = request.getSession(false);
        //Navigating to Showing Product
        if (request.getParameter("type") != null) {
            ArrayList<Product> selectedList = new ArrayList<>();
            for (Product product : productList) {
                if (product.getType().equals(request.getParameter("type"))) {
                    selectedList.add(product);
                    session.setAttribute("selectedProducts", selectedList);
                }
            }
            return new ModelAndView("shopping", "selectedProducts", selectedList);
        }

        //Retrieve Shopping Cart From Session
        ArrayList<Product> myCart = (ArrayList<Product>) session.getAttribute("myCart");
        if (myCart == null) {
            myCart = new ArrayList<>();
        }
        //Navigating to MyCart
        if (request.getParameter("nav") != null) {
            if (request.getParameter("nav").equals("myCart")) {
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/myCart.jsp");
                rd.forward(request, response);
            }
        };

        //Adding Product into myCart
        if (request.getParameter("action") != null) {
            String action = request.getParameter("action");
            if (action.equals("add")) {
                if (request.getParameter("chkProduct") != null) {
                    String[] strlist = request.getParameterValues("chkProduct");
                    for (Product product : productList) {
                        for (String proStr : strlist) {
                            if (product.toString().equals(proStr)) {
                                myCart.add(product);
                            }
                        }
                    }
                    session.setAttribute("myCart", myCart);
                    System.out.println(session.getAttribute("myCart"));
                    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/addResult.jsp");
                    rd.forward(request, response);
                }
            }
        }

        return new ModelAndView();
    }

}
