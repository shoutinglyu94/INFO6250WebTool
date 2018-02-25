/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hw4.dao;

import com.hw4.pojo.SalesOrder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author lvsho
 */
public class CSVDAO {
    public ArrayList<SalesOrder> readCSV(String fileName){
        ArrayList<SalesOrder> salesOrderList = new ArrayList<>();
        Statement stmt=null;
        Connection connection=null;
        try{
            String filePath = "D:\\WebTool\\HW4_Part6\\";
            Class.forName("org.relique.jdbc.csv.CsvDriver");
            connection =DriverManager.getConnection("jdbc:relique:csv:" + filePath);
            String query  = "SELECT * FROM " + fileName;
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
    
    public int insertData(ArrayList<SalesOrder> salesOrderList){
        java.sql.Connection connection = null;
        PreparedStatement stmt = null;
        int row = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sales_orderdb", "root", "846140499");
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException" + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("SQLException" + ex.getMessage());
        }
        try {
            String template = "INSERT INTO salesorder(salesOrderID,revisionNumber,orderDate,dueDate,shipDate," +
"    order_status,onlineOrderFlag,salesOrderNumber,purchaseOrderNumber,accountNumber,customerID,salesPersonID," +
"    territoryID,billToAddressID,shipToAddressID,shipMethodID,creditCardID,creditCardApprovalCode,currencyRateID," +
"    subTotal,taxAmt,freight,totalDue,order_comment,modifiedDate)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
            stmt = connection.prepareStatement(template);
            for (SalesOrder so: salesOrderList){
                stmt.setString(1, so.getSalesOrderID());
                stmt.setString(2, so.getRevisionNumber());
                stmt.setString(3, so.getOrderDate());
                stmt.setString(4, so.getDueDate());
                stmt.setString(5, so.getShipDate());
                stmt.setString(6, so.getStatus());
                stmt.setString(7, so.getOnlineOrderFlag());
                stmt.setString(8, so.getSalesOrderNumber());
                stmt.setString(9, so.getPurchaseOrderNumber());
                stmt.setString(10, so.getAccountNumber());
                stmt.setString(11, so.getCustomerID());
                stmt.setString(12, so.getSalesPersonID());
                stmt.setString(13, so.getTerritoryID());
                stmt.setString(14, so.getBillToAddressID());
                stmt.setString(15, so.getShipToAddressID());
                stmt.setString(16, so.getShipMethodID());
                stmt.setString(17, so.getCreditCardID());
                stmt.setString(18, so.getCreditCardApprovalCode());
                stmt.setString(19, so.getCurrencyRateID());
                stmt.setDouble(20, so.getSubTotal());
                stmt.setDouble(21, so.getTaxAmt());
                stmt.setDouble(22, so.getFreight());
                stmt.setDouble(23, so.getTotalDue());
                stmt.setString(24, so.getComment());
                stmt.setString(25, so.getModifiedDate());
                stmt.execute();
                row++;
                System.out.println(row);
            }
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
        return row;
    }
}
