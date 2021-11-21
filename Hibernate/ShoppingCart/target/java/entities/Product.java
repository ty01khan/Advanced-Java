package com.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.OneToOne;
import javax.persistence.ElementCollection;
import java.util.List;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Entity
@Embeddable
public class Product
{
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
        return this.productId;
    }
    
    public void setProductId(final int productId) {
        this.productId = productId;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(final String name) {
        this.name = name;
    }
    
    public int getPrice() {
        return this.price;
    }
    
    public void setPrice(final int price) {
        this.price = price;
    }
    
    public String getDetails() {
        return this.details;
    }
    
    public void setDetails(final String details) {
        this.details = details;
    }
    
    public String getCategory() {
        return this.category;
    }
    
    public void setCategory(final String category) {
        this.category = category;
    }
    
    public List<String> getSubcategory() {
        return this.subcategory;
    }
    
    public void setSubcategory(final List<String> subcategory) {
        this.subcategory = subcategory;
    }
    
    public CartItem getCartItem() {
        return this.cartItem;
    }
    
    public void setCartItem(final CartItem cartItem) {
        this.cartItem = cartItem;
    }
    
    @Override
    public String toString() {
        return "Product [productId=" + this.productId + ", name=" + this.name + "]";
    }
}
