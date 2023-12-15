package com.example.springproject.model;

public class Sales {
    private Salesman[] salesmen;
    private Product[] products;

    public Sales (){}

    public Sales(Salesman[] salesmen, Product[] products) {
        this.salesmen = salesmen;
        this.products = products;
    }

    public Salesman[] getSalesmen() {
        return salesmen;
    }

    public void setSalesmen(Salesman[] salesmen) {
        this.salesmen = salesmen;
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }

}

