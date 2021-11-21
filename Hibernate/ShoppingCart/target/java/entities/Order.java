package com.entities;

import javax.persistence.OneToMany;
import java.util.List;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
public class Order
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    @OneToMany(mappedBy = "order")
    private List<CartItem> products;
    private String orderStatus;
    
    public int getOrderId() {
        return this.orderId;
    }
    
    public void setOrderId(final int orderId) {
        this.orderId = orderId;
    }
    
    public List<CartItem> getProducts() {
        return this.products;
    }
    
    public void setProducts(final List<CartItem> products) {
        this.products = products;
    }
    
    public String getOrderStatus() {
        return this.orderStatus;
    }
    
    public void setOrderStatus(final String orderStatus) {
        this.orderStatus = orderStatus;
    }
    
    @Override
    public String toString() {
        return "Order [orderId=" + this.orderId + ", products=" + this.products + ", orderStatus=" + this.orderStatus + "]";
    }
}
