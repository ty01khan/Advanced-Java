package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.entities.Product;

@Repository
public class ProductRepository {
	List<Product> products = new ArrayList<Product>();

	public Product addProduct(Product product) {
		product.setProductId(products.size() + 1);
		products.add(product);
		return product;
	}

	public Product modifyProduct(Product product) {
		for (Product p : products) {
			if (p.getProductId() == product.getProductId()) {
				p.setName(product.getName());
				p.setPrice(product.getPrice());
				p.setDetails(product.getDetails());
				p.setCategory(product.getCategory());
				p.setSubcategory(product.getSubcategory());

				return product;
			}
		}

		System.out.println("Didn't find such poduct.");
		return null;
	}

	public Product getProductById(int productId) {
		for(Product p : products) {
			if(p.getProductId() == productId)
				return p;
		}
		return null;
	}

	public List<Product> allProductsByCategory(String category) {
		List<Product> pdts = new ArrayList<Product>();
		for(Product p : products) {
			if(p.getCategory().equals(category))
				pdts.add(p);
		}
		return pdts;
	}

	public List<Product> getProductBySearching(String str) {
		String[] strArray = str.split("\\s+");
		List<Product> pdts = new ArrayList<Product>();
		
		for(Product pdt : products) {
			int i = 0;
			for(i = 0; i < strArray.length; i++) {
				boolean containsSearchStr = pdt.getSubcategory().stream().anyMatch(strArray[i]::equalsIgnoreCase);
				if(!containsSearchStr) {
					break;
				}
			}
			
			if(i == strArray.length)
				pdts.add(pdt);
		}
		return pdts;
	}

	public List<Product> getFilteredProduct(String category, int minp, int maxp) {
		List<Product> pdts = new ArrayList<Product>();
		
		for(Product p : products) {
			if(p.getCategory().equals(category))
				if(p.getPrice() >= minp && p.getPrice() <= maxp)
					pdts.add(p);
		}
		return pdts;
	}

}
