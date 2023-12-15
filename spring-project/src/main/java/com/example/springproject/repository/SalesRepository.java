package com.example.springproject.repository;

import java.sql.SQLException;
import java.time.LocalDate;


import java.sql.*;

public class SalesRepository {
    private Connection connection;

    public SalesRepository() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring", "root", "Accolite@3344");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveProductCommission(int id, String productName, int quantity, int sale_amount, String salesman_name, double salesman_commission_rate, String area, double commission, LocalDate created_data) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO sales_commision (id,product, product_quantity, sale_amount, salesman_name, salesman_commission, salesman_area,commission,created_data) VALUES (?, ?,?,?,?,?,?,?,?)");
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, productName);
            preparedStatement.setInt(3, quantity);
            preparedStatement.setInt(4, sale_amount);
            preparedStatement.setString(5, salesman_name);
            preparedStatement.setDouble(6, salesman_commission_rate);
            preparedStatement.setString(7, area);
            preparedStatement.setDouble(8, commission);
            preparedStatement.setDate(9, Date.valueOf(created_data));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
