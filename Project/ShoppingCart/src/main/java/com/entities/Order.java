package com.entities;

import java.util.List;

public class Order {
	private int orderId;
	private List<CartItem> products;
	private String orderStatus;
	
	public int getOrderId() {
		return orderId;
	}
	
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	public List<CartItem> getProducts() {
		return products;
	}
	
	public void setProducts(List<CartItem> products) {
		this.products = products;
	}
	
	public String getOrderStatus() {
		return orderStatus;
	}
	
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
}
