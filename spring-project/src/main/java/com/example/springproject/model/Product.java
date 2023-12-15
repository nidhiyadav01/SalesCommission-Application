package com.example.springproject.model;



public class Product {
    private String product;
    private int quantity;

    public Product(String product, int quantity, int mrp_per_unit, int salesman_id) {
        this.product = product;
        this.quantity = quantity;
        this.mrp_per_unit = mrp_per_unit;
        this.salesman_id = salesman_id;
    }

    private int mrp_per_unit;
    private int salesman_id;

    // getters and setters

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public int getMrp_per_unit() {
        return mrp_per_unit;
    }

    public void setMrp_per_unit(int mrp_per_unit) {
        this.mrp_per_unit = mrp_per_unit;
    }

    public int getSalesman_id() {
        return salesman_id;
    }

    public void setSalesman_id(int salesman_id) {
        this.salesman_id = salesman_id;
    }
}
