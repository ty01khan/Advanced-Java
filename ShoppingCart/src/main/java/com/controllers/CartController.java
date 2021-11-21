package com.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import java.util.Map;
import com.entities.CartItem;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.HttpStatus;
import com.entities.Cart;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.dao.CartRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping({ "/cart" })
public class CartController {
	@Autowired
	CartRepository cartRepo;

	@RequestMapping(value = { "/{userId}/getCart" }, method = { RequestMethod.GET }, produces = { "application/json" })
	public ResponseEntity<Cart> getUserCart(@PathVariable("userId") final int userId) {
		System.out.println("Fetching cart of user, userID = " + userId);
		final Cart cart = this.cartRepo.getCartByUserId(userId);
		return new ResponseEntity<Cart>(cart, HttpStatus.OK);
	}

	@RequestMapping(value = { "/{userId}/getCartItem/{cartitemId}" }, method = { RequestMethod.GET }, produces = {
			"application/json" })
	public ResponseEntity<CartItem> getCartItem(@PathVariable("userId") final int userId,
			@PathVariable("cartitemId") final int itemId) {
		System.out.println("Fetching cart item of user, userID = " + userId + " and cartItemID = " + itemId);
		final CartItem cartItem = this.cartRepo.getCartItem(userId, itemId);
		return new ResponseEntity<CartItem>(cartItem, HttpStatus.OK);
	}

	@RequestMapping(value = { "{userId}/add/{productId}" }, method = { RequestMethod.GET }, produces = {
			"application/json" })
	public ResponseEntity<CartItem> addItemToCart(@PathVariable("userId") final int userId,
			@PathVariable("productId") final int pid) {
		System.out.println("Adding item to a user cart, userID = " + userId);
		final CartItem cartItem = this.cartRepo.addCartItem(userId, pid);
		return new ResponseEntity<CartItem>(cartItem, HttpStatus.OK);
	}

	@RequestMapping(value = { "{userId}/remove/{productId}" }, method = { RequestMethod.GET }, produces = {
			"application/json" })
	public ResponseEntity<String> removeProduct(@PathVariable("userId") final int uid,
			@PathVariable("productId") final int pid) {
		System.out.println("Removing product from cart, Product ID = " + pid);
		String product = this.cartRepo.removeProduct(uid, pid);
		product = String.valueOf(product) + " is removed";
		return new ResponseEntity<String>(product, HttpStatus.OK);
	}

	@RequestMapping(value = { "changeQuantity/{cartItemId}" }, method = { RequestMethod.POST }, produces = {
			"application/json" })
	public ResponseEntity<CartItem> changeQuantity(@PathVariable("cartItemId") final int itemId,
			@RequestBody final Map<String, Integer> quantity) {
		System.out.println("Changing quantity of a CartItem, ID = " + itemId);
		final int qty = quantity.get("quantity");
		return new ResponseEntity<CartItem>(cartRepo.changeQuantity(qty, itemId), HttpStatus.OK);
	}
}