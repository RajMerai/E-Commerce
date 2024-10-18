package com.ecommerce.service;

import java.util.Map;

public class InventoryManagement {

    // Process orders by reducing stock
    public void processOrders(Map<String, Integer> stockLevels, Map<String, Integer> orders) {
        for (String product : orders.keySet()) {
            int orderQuantity = orders.get(product);
            int currentStock = stockLevels.getOrDefault(product, 0);

            if (currentStock >= orderQuantity) {
                stockLevels.put(product, currentStock - orderQuantity);
                System.out.println("Processed order for " + product + ": " + orderQuantity + " units.");
            } else {
                System.out.println("Insufficient stock for " + product + ". Order could not be processed.");
            }

            // Check if stock is below threshold
            if (stockLevels.get(product) < 10) {
                System.out.println("Stock for " + product + " is below threshold. Restock needed.");
            }
        }
    }

    // Restock items
    public void restockItems(Map<String, Integer> stockLevels, Map<String, Integer> restock) {
        for (String product : restock.keySet()) {
            int restockQuantity = restock.get(product);
            stockLevels.put(product, stockLevels.getOrDefault(product, 0) + restockQuantity);
            System.out.println("Restocked " + product + ": " + restockQuantity + " units.");
        }
    }
}
