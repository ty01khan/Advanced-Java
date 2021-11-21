package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.entities.Cart;
import com.entities.CartItem;

@Repository
public class CartRepository {
	@Autowired
	ProductRepository productRepo;
	
	@Autowired
	UserRepository userRepo;
	
	public Cart getCart(int userId) {
		Cart cart = userRepo.getCart(userId);
		return cart;
	}

	public CartItem getCartItem(int userId, int itemId) {
		Cart cart = userRepo.getCart(userId);
		
		for(CartItem item : cart.getProducts()) {
			if(item.getCartItemId() == itemId)
				return item;
		}
		return null;
	}

	public CartItem addCartItem(int userId, int pid) {		
		Cart cart = userRepo.getCart(userId);
		List<CartItem> items = cart.getProducts();
		
		for(CartItem item : items) {
			if(item.getProduct().getProductId() == pid) {
				item.setQuantity(item.getQuantity()+1);
				return item;
			}
		}
		
		CartItem item = new CartItem();
		item.setCartItemId(cart.getProducts().size()+1);
		item.setProduct(productRepo.getProductById(pid));
		item.setQuantity(1);
		items.add(item);
		cart.setProducts(items);
		return item;
	}

	public String removeItemFromCart(int userId, int pid) {		
		Cart cart = userRepo.getCart(userId);
		List<CartItem> items = cart.getProducts();
		
		for(CartItem item : items) {
			if(item.getProduct().getProductId() == pid) {
				String name = item.getProduct().getName();
				items.remove(item);
				cart.setProducts(items);
				return name;
			}
		}
		return null;
	}

	public CartItem changeQuantity(int uid, int pid, int qty) {		
		Cart cart = userRepo.getCart(uid);
		List<CartItem> items = cart.getProducts();
		
		for(CartItem item : items) {
			if(item.getProduct().getProductId() == pid) {
				item.setQuantity(qty);
				cart.setProducts(items);
				return item;
			}
		}
		return null;
	}
}
