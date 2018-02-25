/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hw4.tag;

import com.hw4.pojo.SalesOrder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;

import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author lvsho
 */
public class ReadFile extends SimpleTagSupport {

    private String fileName;

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        
        try {
             int count =0;
            ArrayList<SalesOrder> salesOrderList = new ArrayList<>();
            salesOrderList = readData();
            for(SalesOrder so :salesOrderList){
                out.println("<tr>" + "<td>" +so.getSalesOrderID() +"</td>" +
                        "<td>" +so.getSalesOrderID() +"</td>" +
                        "<td>" +so.getRevisionNumber()+"</td>" +
                        "<td>" +so.getOrderDate() +"</td>" +
                        "<td>" +so.getDueDate() +"</td>" +
                        "<td>" +so.getShipDate() +"</td>" +
                        "<td>" +so.getStatus() +"</td>" +
                        "<td>" +so.getOnlineOrderFlag() +"</td>" +
                        "<td>" +so.getSalesOrderNumber() +"</td>" +
                        "<td>" +so.getPurchaseOrderNumber() +"</td>" +
                        "<td>" +so.getAccountNumber()+"</td>" +
                        "<td>" +so.getCustomerID()+"</td>" +
                        "<td>" +so.getSalesPersonID() +"</td>" +
                        "<td>" +so.getTerritoryID() +"</td>" +
                        "<td>" +so.getBillToAddressID() +"</td>" +
                        "<td>" +so.getShipToAddressID() +"</td>" +
                        "<td>" +so.getCreditCardID()+"</td>" +
                        "<td>" +so.getCreditCardApprovalCode() +"</td>" +
                        "<td>" +so.getCurrencyRateID()+"</td>" +
                        "<td>" +so.getSubTotal() +"</td>" +
                        "<td>" +so.getTaxAmt()+"</td>" +
                        "<td>" +so.getFreight() +"</td>" +
                        "<td>" +so.getTotalDue() +"</td>" +
                        "<td>" +so.getComment() +"</td>" +
                        "<td>" +so.getModifiedDate()+"</td>" +"</tr>"
                        );
                count++;
                System.out.println(count);
            }
        } catch (Exception ex) {
            throw new JspException("Error in ReadFile tag", ex);
        }
    }
      
    private ArrayList<SalesOrder> readData(){
         ArrayList<SalesOrder> salesOrderList = new ArrayList<>();
        Statement stmt=null;
        Connection connection=null;
        try{
            String filePath = "D:\\WebTool\\HW4_Part7\\";
            Class.forName("org.relique.jdbc.csv.CsvDriver");
            connection =DriverManager.getConnection("jdbc:relique:csv:" + filePath);
            String query  = "SELECT * FROM " + this.fileName;
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            System.out.println("connect successfully!");
            int count =0;
            while(rs.next()){
                SalesOrder so = new SalesOrder();
                so.setAccountNumber(rs.getString("AccountNumber"));
                so.setBillToAddressID(rs.getString("BillToAddressID"));
                so.setComment(rs.getString("Comment"));
                so.setCreditCardID(rs.getString("CreditCardID"));
                so.setCreditCardApprovalCode(rs.getString("CreditCardApprovalCode"));
                so.setCurrencyRateID(rs.getString("CurrencyRateID"));
                so.setCustomerID(rs.getString("CustomerID"));
                so.setDueDate(rs.getString("DueDate"));
                so.setFreight(rs.getDouble("Freight"));
                so.setModifiedDate(rs.getString("ModifiedDate"));
                so.setOnlineOrderFlag(rs.getString("OnlineOrderFlag"));
                so.setOrderDate(rs.getString("OrderDate"));
                so.setPurchaseOrderNumber(rs.getString("PurchaseOrderNumber"));
                so.setRevisionNumber(rs.getString("RevisionNumber"));
                so.setSalesOrderID(rs.getString("SalesOrderID"));
                so.setSalesOrderNumber(rs.getString("SalesOrderNumber"));
                so.setSalesPersonID(rs.getString("SalesPersonID"));
                so.setShipDate(rs.getString("ShipDate"));
                so.setShipMethodID(rs.getString("ShipMethodID"));
                so.setShipToAddressID(rs.getString("ShipToAddressID"));
                so.setStatus(rs.getString("Status"));
                so.setSubTotal(rs.getDouble("SubTotal"));
                so.setTaxAmt(rs.getDouble("TaxAmt"));
                so.setTerritoryID(rs.getString("TerritoryID"));
                so.setTotalDue(rs.getDouble("TotalDue"));
                salesOrderList.add(so);
                count++;
            }
        }catch(Exception e){
            System.out.println(e);
        }finally{
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
       
        return salesOrderList;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
}
