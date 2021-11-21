package com.entities;

import javax.persistence.OneToMany;
import java.util.List;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartId;
	
	@OneToMany(mappedBy = "cart")
	private List<CartItem> products;

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public List<CartItem> getProducts() {
		return products;
	}

	public void setProducts(List<CartItem> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", products=" + products + "]";
	}
}