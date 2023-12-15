package com.example.springproject.model;


import com.example.springproject.aop.TrackExecutionTime;

public class SalesCommission {
    private String product;
    private String salesmanName;
    private int productQuantity;
    private double salesAmount;
    private String salesmanArea;
    public SalesCommission(){

    }

    public SalesCommission(String product, String salesmanName, int productQuantity, double salesAmount, String salesmanArea, double salesmanCommission) {
        this.product = product;
        this.salesmanName = salesmanName;
        this.productQuantity = productQuantity;
        this.salesAmount = salesAmount;
        this.salesmanArea = salesmanArea;
        this.salesmanCommission = salesmanCommission;
    }

    private double salesmanCommission;

    // Getter and setter methods
    public String getProduct() {
        return product;
    }
    @TrackExecutionTime
    public void setProduct(String product) {
        this.product = product;
    }
    public String getSalesmanName() {
        return salesmanName;
    }
    @TrackExecutionTime
    public void setSalesmanName(String salesmanName) {
        this.salesmanName = salesmanName;
    }
    public int getProductQuantity() {
        return productQuantity;
    }
    @TrackExecutionTime
    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }
    public double getSalesAmount() {
        return salesAmount;
    }
    @TrackExecutionTime
    public void setSalesAmount(double salesAmount) {
        this.salesAmount = salesAmount;
    }

    public String getSalesmanArea() {
        return salesmanArea;
    }
    @TrackExecutionTime
    public void setSalesmanArea(String salesmanArea) {
        this.salesmanArea = salesmanArea;
    }
    public double getSalesmanCommission() {
        return salesmanCommission;
    }
    @TrackExecutionTime
    public void setSalesmanCommission(double salesmanCommission) {
        this.salesmanCommission = salesmanCommission;
    }
}
