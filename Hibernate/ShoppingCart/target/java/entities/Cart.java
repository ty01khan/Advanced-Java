package com.entities;

import javax.persistence.OneToMany;
import java.util.List;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
public class Cart
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartId;
    @OneToMany(mappedBy = "cart")
    private List<CartItem> products;
    
    public int getCartId() {
        return this.cartId;
    }
    
    public void setCartId(final int cartId) {
        this.cartId = cartId;
    }
    
    public List<CartItem> getProducts() {
        return this.products;
    }
    
    public void setProducts(final List<CartItem> products) {
        this.products = products;
    }
    
    @Override
    public String toString() {
        return "Cart [cartId=" + this.cartId + ", products=" + this.products + "]";
    }
}
