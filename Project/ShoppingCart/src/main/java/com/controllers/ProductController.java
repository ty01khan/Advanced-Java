package com.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dao.ProductRepository;
import com.entities.Product;

@Controller
@RequestMapping("/products")
public class ProductController {
	@Autowired
	ProductRepository productRepo;

	/**
	 * 6.-------------------- Add Product ---------------------
	 */
	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		Product p = productRepo.addProduct(product);
		System.out.println(product.getName() + ", product added");
		System.out.println();

		return new ResponseEntity<Product>(p, HttpStatus.OK);
	}

	/**
	 * 7.-------------------- Modify Product ---------------------
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
		System.out.println("Update product of Product with ID " + product.getProductId());
		System.out.println();
		Product pdt = productRepo.modifyProduct(product);

		if (pdt != null) {
			return new ResponseEntity<Product>(product, HttpStatus.OK);
		}
		return new ResponseEntity<Product>(new Product(), HttpStatus.NOT_FOUND);
	}

	/**
	 * 8.-------------------- Get Product ---------------------
	 */
	@RequestMapping(value = "/getById/{productId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> getProductById(@PathVariable("productId") int productId) {
		System.out.println("Fetching product with id " + productId + "...");
		Product product = productRepo.getProductById(productId);

		if (product != null) {
			System.out.println("Found the product, name = " + product.getName());
			System.out.println();
			return new ResponseEntity<Product>(product, HttpStatus.OK);
		}
		System.out.printf("Don't have such product \n\n");
		return new ResponseEntity<Product>(new Product(), HttpStatus.NOT_FOUND);
	}

	/**
	 * 9.-------------------- Get Products by category ---------------------
	 */
	@RequestMapping(value = "/{category}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Product>> getProductByCategory(@PathVariable("category") String category) {
		System.out.println("Fetching all products whose category is " + category);
		System.out.println();
		List<Product> productList = productRepo.allProductsByCategory(category);
		return new ResponseEntity<List<Product>>(productList, HttpStatus.OK);
	}

	/**
	 * 10.-------------------- Get Products by Search String ---------------------
	 */
	@RequestMapping(value = "/search/{searchString}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Product>> searchByString(@PathVariable("searchString") String string) {
		System.out.println("Fetching all products that contains string " + string);
		System.out.println();
		List<Product> productList = productRepo.getProductBySearching(string);
		return new ResponseEntity<List<Product>>(productList, HttpStatus.OK);
	}

	/**
	 * 11.-------------------- Get Filtered Product by category ---------------------
	 */
	@RequestMapping(value = "/{category}/getFilteredProducts", method = RequestMethod.POST)
	public ResponseEntity<List<Product>> updateFilteredProduct(@RequestBody Map<String, Integer> filterMap,
			@PathVariable("category") String category) {
		System.out.println("Fetching filtered product, Category = " + category);
		List<Product> products = productRepo.getFilteredProduct(category, filterMap.get("minPrice"),
				filterMap.get("maxPrice"));

		System.out.println("Fetched all products of " + category + " category with price in range ["
				+ filterMap.get("minPrice") + ", " + filterMap.get("maxPrice") + "]");
		System.out.println();
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}
}
