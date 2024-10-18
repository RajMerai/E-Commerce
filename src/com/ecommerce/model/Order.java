package com.ecommerce.model;

import java.util.List;

public class Order {
	
	 private int orderId;
	 private User user;
	 private List<Product> productList;
	 private String status;
	 
	public Order(int orderId, User user, List<Product> productList, String status) {
		super();
		this.orderId = orderId;
		this.user = user;
		this.productList = productList;
		this.status = status;
	}
	
	
	 // Method to add product to the order
    public void addProduct(Product product) {
        productList.add(product);
    }

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	 
	
	 

}
