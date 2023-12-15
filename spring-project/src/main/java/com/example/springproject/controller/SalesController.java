package com.example.springproject.controller;
import com.example.springproject.aop.TrackExecutionTime;
import com.example.springproject.model.Product;
import com.example.springproject.model.Sales;
import com.example.springproject.model.SalesCommission;
import com.example.springproject.model.Salesman;
import com.example.springproject.repository.SalesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@CrossOrigin("*")

@RestController

@Slf4j

public class SalesController {
    private SalesRepository salesRepository;

    public SalesController() {
        salesRepository = new SalesRepository();
    }
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostMapping("/sales")
   public ResponseEntity<String>  createSales(@RequestBody Sales sales)
   {

           for (Product product : sales.getProducts()) {
               double commission = product.getQuantity() * product.getMrp_per_unit() * getCommissionRate(sales.getSalesmen(), product.getSalesman_id());
               int sale_amount = product.getQuantity() * product.getMrp_per_unit();
               String salesman_name = getSalesmanName(sales.getSalesmen(), product.getSalesman_id());
               double salesman_commission_rate = getCommissionRate(sales.getSalesmen(), product.getSalesman_id());
               String salesman_arae = getSalesmanArea(sales.getSalesmen(), product.getSalesman_id());
               salesRepository.saveProductCommission(product.getSalesman_id(), product.getProduct(), product.getQuantity(), sale_amount, salesman_name, salesman_commission_rate, salesman_arae, commission, java.time.LocalDate.now());

           }
           return ResponseEntity.ok("File uploaded successfully");
       }

    private double getCommissionRate(Salesman[] salesmen, int salesmanId) {
        for (Salesman salesman : salesmen) {
            if (salesman.getSalesman_id() == salesmanId) {
                return salesman.getCommission_rate();
            }
        }

        return 0.0;
    }

    private String getSalesmanName(Salesman[] salesmen, int salesmanId) {
        for (Salesman salesman : salesmen) {
            if (salesman.getSalesman_id() == salesmanId) {
                return salesman.getSalesman_name();
            }
        }

        return "";
    }

    private String getSalesmanArea(Salesman[] salesmen, int salesmanId) {
        for (Salesman salesman : salesmen) {
            if (salesman.getSalesman_id() == salesmanId) {
                return salesman.getSalesman_area();
            }
        }

        return "";
    }

    @GetMapping("/sales/commission")
    @TrackExecutionTime
    public ResponseEntity<List<SalesCommission>> getSalesCommission(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {


        String sql = "SELECT product, salesman_name, product_quantity, sale_amount, salesman_area, salesman_commission " +
                "FROM sales_commision " +
                "WHERE created_data = ?";

        List<SalesCommission> salesCommissions = jdbcTemplate.query(sql, new Object[]{date}, (resultSet, rowNum) -> {
            SalesCommission salesCommission = new SalesCommission();
            salesCommission.setProduct(resultSet.getString("product"));
            salesCommission.setSalesmanName(resultSet.getString("salesman_name"));
            salesCommission.setProductQuantity(resultSet.getInt("product_quantity"));
            salesCommission.setSalesAmount(resultSet.getDouble("sale_amount"));
            salesCommission.setSalesmanArea(resultSet.getString("salesman_area"));
            salesCommission.setSalesmanCommission(resultSet.getDouble("salesman_commission"));
            return salesCommission;
        });


        return ResponseEntity.ok().body(salesCommissions);
    }

    @GetMapping("/getsales/commission")
    @TrackExecutionTime
    public ResponseEntity<List<SalesCommission>> getSales() {


        String sql = "SELECT product, salesman_name, product_quantity, sale_amount, salesman_area, salesman_commission " +
                "FROM sales_commision " ;


        List<SalesCommission> salesCommissions = jdbcTemplate.query(sql,  (resultSet, rowNum) -> {
            SalesCommission salesCommission = new SalesCommission();
            salesCommission.setProduct(resultSet.getString("product"));
            salesCommission.setSalesmanName(resultSet.getString("salesman_name"));
            salesCommission.setProductQuantity(resultSet.getInt("product_quantity"));
            salesCommission.setSalesAmount(resultSet.getDouble("sale_amount"));
            salesCommission.setSalesmanArea(resultSet.getString("salesman_area"));
            salesCommission.setSalesmanCommission(resultSet.getDouble("salesman_commission"));
            return salesCommission;
        });


        return ResponseEntity.ok().body(salesCommissions);
    }



}


