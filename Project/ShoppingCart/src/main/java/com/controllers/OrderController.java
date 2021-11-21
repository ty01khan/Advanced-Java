package com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dao.OrderRepository;
import com.entities.Order;

@Controller
@RequestMapping("/order")
public class OrderController {
	@Autowired
	OrderRepository orderRepo;
	
	
	/**
	 * 17.-------------------- Get order history ---------------------
	 */
	@RequestMapping(value = "/{userId}/getOrders", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Order>> getOrders(@PathVariable("userId") int uid) {
		System.out.println("Fetching order history of user, userID = " + uid);
		System.out.println();
		List<Order> orders = orderRepo.getOrderHistory(uid);
		return new ResponseEntity<List<Order>>(orders, HttpStatus.OK);
	}
	
	
	/**
	 * 18.-------------------- Create Order ---------------------
	 */
	@RequestMapping(value = "/{userId}/createOrder", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Order> createOrders(@PathVariable("userId") int uid) {
		System.out.println("Creating order of user, userID = " + uid);
		System.out.println();
		Order order = orderRepo.createOrder(uid);
		return new ResponseEntity<Order>(order, HttpStatus.OK);
	}
}
