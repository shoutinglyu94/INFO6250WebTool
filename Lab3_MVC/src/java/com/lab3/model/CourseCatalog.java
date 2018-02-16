/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lab3.model;

import java.util.ArrayList;

/**
 *
 * @author lvsho
 */
public class CourseCatalog {
    
    private ArrayList<Course> courses; 
    private static CourseCatalog instance = null;
    private CourseCatalog() {
        courses = new ArrayList<>();
        Course c1 = new Course();
        c1.setCourseDescription("java programming");
        c1.setCrn("36099");
        c1.setInstructor("Khaled M. Bugrara");
        c1.setName("AED");

        Course c2 = new Course();
        c2.setCourseDescription("Course fro learning web technologies used in frint end");
        c2.setCrn("37913");
        c2.setInstructor("YusufOzbek");
        c2.setName("Web Dsign and user exp");

        Course c3 = new Course();
        c3.setCourseDescription("course for learning algorithms");
        c3.setCrn("34267");
        c3.setInstructor("Khaled M. Bugrara");
        c3.setName("Program Structure and Algorithms");

        Course c4 = new Course();
        c4.setCourseDescription("course for learning java EE");
        c4.setCrn("31606");
        c4.setInstructor("YusufOzbek");
        c4.setName("Web Tools");

        courses.add(c1);
        courses.add(c2);
        courses.add(c3);
        courses.add(c4);
    }
        
    public static CourseCatalog getInstance() {
      if(instance == null) {
         instance = new CourseCatalog();
      }
      return instance;
   }

    public ArrayList<Course> getCourses() {
        return courses;
    }
   
   
        
}
