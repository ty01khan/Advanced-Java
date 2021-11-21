package com.entities;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private int cartId;
	private List<CartItem> products;
	
	public int getCartId() {
		return cartId;
	}
	
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	
	public List<CartItem> getProducts() {
		if(products == null)
			return new ArrayList<CartItem>();
		return products;
	}
	
	public void setProducts(List<CartItem> products) {
		this.products = products;
	}	
}
