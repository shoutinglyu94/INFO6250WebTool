/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hw2.model;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author lvsho
 */
public class ProductCatalog {

    private ArrayList<Product> productList;
    private static ProductCatalog instance = null;
    private ProductCatalog() {
        productList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Random chooser = new Random();
            Product book = new Product();
            book.setId(i);
            book.setName("book" + i);
            book.setPrice((Double) (1.0 + chooser.nextInt(50)));
            book.setType("Books");
            productList.add(book);
        }
        for (int i = 0; i < 10; i++) {
            Random chooser = new Random();
            Product music = new Product();
            music.setId(i);
            music.setName("music" + i);
            music.setPrice((Double) (1.0 + chooser.nextInt(50)));
            music.setType("Music");
            productList.add(music);
        }
        for (int i = 0; i < 10; i++) {
            Random chooser = new Random();
            Product computer = new Product();
            computer.setId(i);
            computer.setName("computer" + i);
            computer.setPrice((Double) (1.0 + chooser.nextInt(50)));
            computer.setType("Computers");
            productList.add(computer);
        }
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }
    
    
    public static ProductCatalog getInstance() {
      if(instance == null) {
         instance = new ProductCatalog();
      }
      return instance;
   }


}
