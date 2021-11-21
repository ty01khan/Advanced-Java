package com.controllers;

import java.util.Map;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import com.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import com.dao.ProductRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping({ "/products" })
public class ProductController
{
    @Autowired
    ProductRepository productRepo;
    
    @RequestMapping(value = { "/addProduct" }, method = { RequestMethod.POST })
    public ResponseEntity<Product> addProduct(@RequestBody final Product product) {
        System.out.println("Adding product, name = " + product.getName());
        return (ResponseEntity<Product>)new ResponseEntity((Object)this.productRepo.addProduct(product), HttpStatus.OK);
    }
    
    @RequestMapping(value = { "/update" }, method = { RequestMethod.POST })
    public ResponseEntity<Product> modifyProduct(@RequestBody final Product product) {
        return (ResponseEntity<Product>)new ResponseEntity((Object)this.productRepo.updateProduct(product), HttpStatus.OK);
    }
    
    @RequestMapping(value = { "/getById/{productId}" }, method = { RequestMethod.GET }, produces = { "application/json" })
    public ResponseEntity<Product> getProductById(@PathVariable("productId") final int pid) {
        System.out.println("Fetching product, Product ID = " + pid);
        return (ResponseEntity<Product>)new ResponseEntity((Object)this.productRepo.getProductById(pid), HttpStatus.OK);
    }
    
    @RequestMapping(value = { "/{category}" }, method = { RequestMethod.GET }, produces = { "application/json" })
    public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable("category") final String category) {
        System.out.println("Fetching all products of category " + category);
        return (ResponseEntity<List<Product>>)new ResponseEntity((Object)this.productRepo.getAllProductsByCategory(category), HttpStatus.OK);
    }
    
    @RequestMapping(value = { "/search/{searchString}" }, method = { RequestMethod.GET }, produces = { "application/json" })
    public ResponseEntity<List<Product>> searchByString(@PathVariable("searchString") final String string) {
        System.out.println("Fetching all products that contains string " + string);
        final List<Product> productList = (List<Product>)this.productRepo.searchProduct(string);
        return (ResponseEntity<List<Product>>)new ResponseEntity((Object)productList, HttpStatus.OK);
    }
    
    @RequestMapping(value = { "/{category}/getFilteredProducts" }, method = { RequestMethod.POST })
    public ResponseEntity<List<Product>> updateFilteredProduct(@RequestBody final Map<String, Integer> filter, @PathVariable("category") final String category) {
        System.out.println("Fetching filtered product, Category = " + category);
        System.out.println(filter.get("minPrice"));
        final List<Product> products = (List<Product>)this.productRepo.getFilteredProduct(category, (int)filter.get("minPrice"), (int)filter.get("maxPrice"));
        return (ResponseEntity<List<Product>>)new ResponseEntity((Object)products, HttpStatus.OK);
    }
}
