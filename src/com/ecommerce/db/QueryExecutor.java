package com.ecommerce.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;


public class QueryExecutor {
    
    public void getTopCustomers() {
        String query = "SELECT c.customer_id, c.name, SUM(od.quantity) AS total_books " +
                       "FROM Customers c " +
                       "JOIN Orders o ON c.customer_id = o.customer_id " +
                       "JOIN OrderDetails od ON o.order_id = od.order_id " +
                       "WHERE o.order_date >= DATE_SUB(CURDATE(), INTERVAL 1 YEAR) " +
                       "GROUP BY c.customer_id, c.name " +
                       "ORDER BY total_books DESC " +
                       "LIMIT 5";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                System.out.println("Customer ID: " + resultSet.getInt("customer_id"));
                System.out.println("Name: " + resultSet.getString("name"));
                System.out.println("Total Books: " + resultSet.getInt("total_books"));
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void getTotalRevenueByAuthor() {
        String query = "SELECT b.author, SUM(od.quantity * b.price) AS total_revenue " +
                       "FROM Books b " +
                       "JOIN OrderDetails od ON b.book_id = od.book_id " +
                       "JOIN Orders o ON od.order_id = o.order_id " +
                       "GROUP BY b.author " +
                       "ORDER BY total_revenue DESC";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                System.out.println("Author: " + resultSet.getString("author"));
                System.out.println("Total Revenue: " + resultSet.getDouble("total_revenue"));
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getBooksOrderedMoreThanTenTimes() {
        String query = "SELECT b.book_id, b.title, SUM(od.quantity) AS total_quantity " +
                       "FROM Books b " +
                       "JOIN OrderDetails od ON b.book_id = od.book_id " +
                       "GROUP BY b.book_id, b.title " +
                       "HAVING total_quantity > 10 " +
                       "ORDER BY total_quantity DESC";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                System.out.println("Book ID: " + resultSet.getInt("book_id"));
                System.out.println("Title: " + resultSet.getString("title"));
                System.out.println("Total Quantity: " + resultSet.getInt("total_quantity"));
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
