package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.entities.Cart;
import com.entities.CartItem;
import com.entities.Order;

@Repository
public class OrderRepository {	
	@Autowired
	UserRepository userRepo;
	
	public List<Order> getOrderHistory(int uid) {	
		return userRepo.getOrderList(uid);
	}

	public Order createOrder(int uid) {
		List<Order> orders = userRepo.getOrderList(uid);
		Cart cart = userRepo.getCart(uid);
		List<CartItem> items = cart.getProducts();
				
		if(items.size() == 0) {
			System.out.printf("Cart is empty.\n\n");
			return new Order();
		}
		
		Order order = new Order();
		order.setOrderId(orders.size()+1);
		order.setOrderStatus("Awaiting Payment");
		order.setProducts(items);
		orders.add(order);
		
		cart.setProducts(new ArrayList<CartItem>());
		return order;
	}
}
