package com.controllers;

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

import com.dao.CartRepository;
import com.entities.Cart;
import com.entities.CartItem;

@Controller
@RequestMapping("/cart")
public class CartController {
	@Autowired
	CartRepository cartRepo;
	
	
	/**
	 * 12.-------------------- Get cart ---------------------
	 */
	@RequestMapping(value = "/{userId}/getCart", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cart> getUserCart(@PathVariable("userId") int userId) {
		System.out.println("Fetching cart of user, userID = " + userId);
		System.out.println();
		Cart cart = cartRepo.getCart(userId);
		return new ResponseEntity<Cart>(cart, HttpStatus.OK);
	}

	
	/**
	 * 13.-------------------- Get cart item ---------------------
	 */
	@RequestMapping(value = "/{userId}/getCartItem/{cartitemId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CartItem> getCartItem(@PathVariable("userId") int userId,
			@PathVariable("cartitemId") int itemId) {
		System.out.println("Fetching cart item of user, userID = " + userId + " and cartItemID = " + itemId);
		System.out.println();
		CartItem cartItem = cartRepo.getCartItem(userId, itemId);
		return new ResponseEntity<CartItem>(cartItem, HttpStatus.OK);
	}
	

	/**
	 * 14.-------------------- Add to cart ---------------------
	 */
	@RequestMapping(value = "/{userId}/add/{productId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CartItem> addItemToCart(@PathVariable("userId") int userId,
			@PathVariable("productId") int pid) {
		System.out.println("Adding item to a user cart, userID = " + userId);
		CartItem cartItem = cartRepo.addCartItem(userId, pid);
		
		System.out.printf("Cart item added to user cart.\n\n");
		return new ResponseEntity<CartItem>(cartItem, HttpStatus.OK);
	}
	

	/**
	 * 15.-------------------- Remove from cart ---------------------
	 */
	@RequestMapping(value = "/{userId}/remove/{productId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> removeItem(@PathVariable("userId") int userId, @PathVariable("productId") int pid) {
		System.out.println("Removing item from cart, userID = " + userId);
		String name = cartRepo.removeItemFromCart(userId, pid);

		System.out.println("Product ID = " + pid + ", removed from the cart.") ;
		System.out.println();
		return new ResponseEntity<String>(name + " removed from cart", HttpStatus.OK);
	}
	

	/**
	 * 16.-------------------- Change Quantity of product ---------------------
	 */
	@RequestMapping(value = "/{userId}/changeQuantity/{productId}", method = RequestMethod.POST)
	public ResponseEntity<CartItem> changeQuantity(@PathVariable("userId") int uid, @PathVariable("productId") int pid,
			@RequestBody Map<String, Integer> qtyMap) {
		System.out.println("Changing quantity of product " + pid);
		System.out.println();
		CartItem cartItem = cartRepo.changeQuantity(uid, pid, qtyMap.get("quantity"));
		return new ResponseEntity<CartItem>(cartItem, HttpStatus.OK);
	}
}
