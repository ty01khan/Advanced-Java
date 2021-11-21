package com.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
public class CartItem
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartItemId;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "productId")
    private Product product;
    private int quantity;
    @ManyToOne
    @JsonIgnore
    private Cart cart;
    @ManyToOne
    @JsonIgnore
    private Order order;
    
    public int getCartItemId() {
        return this.cartItemId;
    }
    
    public void setCartItemId(final int cartItemId) {
        this.cartItemId = cartItemId;
    }
    
    public Product getProduct() {
        return this.product;
    }
    
    public void setProduct(final Product product) {
        this.product = product;
    }
    
    public int getQuantity() {
        return this.quantity;
    }
    
    public void setQuantity(final int quantity) {
        this.quantity = quantity;
    }
    
    public Cart getCart() {
        return this.cart;
    }
    
    public void setCart(final Cart cart) {
        this.cart = cart;
    }
    
    @Override
    public String toString() {
        return "CartItem [cartItemId=" + this.cartItemId + ", product=" + this.product + ", quantity=" + this.quantity + "]";
    }
}
