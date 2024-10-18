package com.ecommerce.main;

import com.ecommerce.db.QueryExecutor;
import com.ecommerce.service.InventoryManagement;
import java.util.HashMap;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        QueryExecutor executor = new QueryExecutor();
        
        System.out.println("Top Customers:");
        executor.getTopCustomers();
        
        System.out.println("Total Revenue by Author:");
        executor.getTotalRevenueByAuthor();
        
        System.out.println("Books Ordered More Than 10 Times:");
        executor.getBooksOrderedMoreThanTenTimes();
    }
}
