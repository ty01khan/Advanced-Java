package com.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.OneToOne;
import javax.persistence.ElementCollection;
import java.util.List;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
	private String name;
	private int price;
	private String details;
	private String category;
	
	@ElementCollection
	private List<String> subcategory;
	
	@OneToOne(mappedBy = "product")
	@JsonIgnore
	private CartItem cartItem;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<String> getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(List<String> subcategory) {
		this.subcategory = subcategory;
	}

	public CartItem getCartItem() {
		return cartItem;
	}

	public void setCartItem(CartItem cartItem) {
		this.cartItem = cartItem;
	}

	@Override
	public String toString() {
		return "Product [productId=" + this.productId + ", name=" + this.name + "]";
	}
}