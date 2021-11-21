package com.entities;

import java.util.List;

public class Product {
	private int productId;
	private String name;
	private int price;
	private String details;
	private String category;
	private List<String> subcategory;

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
}
