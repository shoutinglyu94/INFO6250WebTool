/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hw4.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lvsho
 */
public class SalesOrder {
    private final String[] attributeArray = {"SalesOrderID","RevisionNumber","OrderDate","DueDate","ShipDate",
    "Status","OnlineOrderFlag","SalesOrderNumber","PurchaseOrderNumber","AccountNumber","CustomerID","SalesPersonID",
    "TerritoryID","BillToAddressID","ShipToAddressID","ShipMethodID","CreditCardID","CreditCardApprovalCode","CurrencyRateID",
    "SubTotal","TaxAmt","Freight","TotalDue","Comment","ModifiedDate"};
    private final List<String> attributeList;
    private String salesOrderID;
    private String orderDate;
    private String dueDate;
    private String shipDate;
    private String modifiedDate;
    private String revisionNumber;
    private String status;
    private String onlineOrderFlag;
    private String salesOrderNumber;
    private String purchaseOrderNumber;
    private String accountNumber;
    private String customerID;
    private String salesPersonID;
    private String territoryID;
    private String billToAddressID;
    private String shipToAddressID;
    private String shipMethodID;
    private String crediCardID;
    private String creditCardApprovalCode;
    private String currencyRateID;
    private String comment;
    private double subTotal;
    private double taxAmt;
    private double freight;
    private double totalDue;
    
    public SalesOrder(){
        attributeList = new ArrayList<>();
        for(int i=0;i<25;i++){
            attributeList.add(this.attributeArray[i]);
        }
    }

    public List<String> getAttributeList() {
        return attributeList;
    }

    
    public String[] getAttributeArray() {
        return attributeArray;
    }

    public String getSalesOrderID() {
        return salesOrderID;
    }

    public void setSalesOrderID(String salesOrderID) {
        this.salesOrderID = salesOrderID;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getShipDate() {
        return shipDate;
    }

    public void setShipDate(String shipDate) {
        this.shipDate = shipDate;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getRevisionNumber() {
        return revisionNumber;
    }

    public void setRevisionNumber(String revisionNumber) {
        this.revisionNumber = revisionNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOnlineOrderFlag() {
        return onlineOrderFlag;
    }

    public void setOnlineOrderFlag(String onlineOrderFlag) {
        this.onlineOrderFlag = onlineOrderFlag;
    }

    public String getSalesOrderNumber() {
        return salesOrderNumber;
    }

    public void setSalesOrderNumber(String salesOrderNumber) {
        this.salesOrderNumber = salesOrderNumber;
    }

    public String getPurchaseOrderNumber() {
        return purchaseOrderNumber;
    }

    public void setPurchaseOrderNumber(String purchaseOrderNumber) {
        this.purchaseOrderNumber = purchaseOrderNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getSalesPersonID() {
        return salesPersonID;
    }

    public void setSalesPersonID(String salesPersonID) {
        this.salesPersonID = salesPersonID;
    }

    public String getTerritoryID() {
        return territoryID;
    }

    public void setTerritoryID(String territoryID) {
        this.territoryID = territoryID;
    }

    public String getBillToAddressID() {
        return billToAddressID;
    }

    public void setBillToAddressID(String billToAddressID) {
        this.billToAddressID = billToAddressID;
    }

    public String getShipToAddressID() {
        return shipToAddressID;
    }

    public void setShipToAddressID(String shipToAddressID) {
        this.shipToAddressID = shipToAddressID;
    }

  
    public String getShipMethodID() {
        return shipMethodID;
    }

    public void setShipMethodID(String shipMethodID) {
        this.shipMethodID = shipMethodID;
    }

    public String getCrediCardID() {
        return crediCardID;
    }

    public void setCrediCardID(String crediCardID) {
        this.crediCardID = crediCardID;
    }

    public String getCreditCardApprovalCode() {
        return creditCardApprovalCode;
    }

    public void setCreditCardApprovalCode(String creditCardApprovalCode) {
        this.creditCardApprovalCode = creditCardApprovalCode;
    }

    public String getCurrencyRateID() {
        return currencyRateID;
    }

    public void setCurrencyRateID(String currencyRateID) {
        this.currencyRateID = currencyRateID;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getTaxAmt() {
        return taxAmt;
    }

    public void setTaxAmt(double taxAmt) {
        this.taxAmt = taxAmt;
    }

    public double getFreight() {
        return freight;
    }

    public void setFreight(double freight) {
        this.freight = freight;
    }

    public double getTotalDue() {
        return totalDue;
    }

    public void setTotalDue(double totalDue) {
        this.totalDue = totalDue;
    }
    
    
}
