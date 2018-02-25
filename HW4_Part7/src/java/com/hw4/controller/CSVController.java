/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hw4.controller;


import com.hw4.dao.CSVDAO;
import com.hw4.pojo.SalesOrder;
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
public class CSVController extends AbstractController {
    
    public CSVController() {
    }
    
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv=null;
        int affectedRow = 0;
        HttpSession session = request.getSession(true);
        String uri = request.getRequestURI();
        CSVDAO cdao = new CSVDAO();
        if(uri.endsWith("choosefile.htm")){
            mv = new ModelAndView("read","firstpage","firstpage");
        }else if(uri.endsWith("viewform.htm")){
            if(request.getParameter("txtFileName").equalsIgnoreCase("salesorder")){
                String fileName = request.getParameter("txtFileName");
                session.setAttribute("fileName",fileName);
                
                SalesOrder sample = new SalesOrder();
                session.setAttribute("sample",sample);
                
                mv = new ModelAndView("read","viewform","viewform");
            }else{
                mv = new ModelAndView("read","error","File doesn't exists!");
            }
        }else if(uri.endsWith("insert.htm")){
            String filename =(String) session.getAttribute("fileName");
            System.out.println(filename);
            ArrayList<SalesOrder> salesOrderList = cdao.readCSV(filename);
            System.out.println(salesOrderList.size());
            affectedRow = cdao.insertData(salesOrderList);
            if(affectedRow==0){
                mv = new ModelAndView("read","error","Data can not insert into database!");
            }
            else{
                mv = new ModelAndView("read","row",affectedRow);
            }
        }
        
        return mv;
    }
    
}
