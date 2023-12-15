package com.example.springproject.model;


public class Salesman {
    private int salesman_id;
    private String salesman_name;
    private String salesman_area;
    private double commission_rate;

    public Salesman(int salesman_id, String salesman_name, String salesman_area, double commission_rate) {
        this.salesman_id = salesman_id;
        this.salesman_name = salesman_name;
        this.salesman_area = salesman_area;
        this.commission_rate = commission_rate;
    }
// getters and setters

    public int getSalesman_id() {
        return salesman_id;
    }

    public void setSalesman_id(int salesman_id) {
        this.salesman_id = salesman_id;
    }

    public String getSalesman_name() {
        return salesman_name;
    }

    public void setSalesman_name(String salesman_name) {
        this.salesman_name = salesman_name;
    }

    public String getSalesman_area() {
        return salesman_area;
    }

    public void setSalesman_area(String salesman_area) {
        this.salesman_area = salesman_area;
    }

    public double getCommission_rate() {
        return commission_rate;
    }

    public void setCommission_rate(double commission_rate) {
        this.commission_rate = commission_rate;
    }
}
