package com.entities;

public class CartItem {
	private int cartItemId;
	private Product product;
	private int quantity;
	
	public int getCartItemId() {
		return cartItemId;
	}
	
	public void setCartItemId(int cartItemId) {
		this.cartItemId = cartItemId;
	}
	
	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
