package com.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.HttpStatus;
import com.entities.Order;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.dao.OrderRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping({ "/order" })
public class OrderController {
	@Autowired
	OrderRepository orderRepo;

	@RequestMapping(value = { "/{userId}/getOrders" }, method = { RequestMethod.GET }, produces = {
			"application/json" })
	public ResponseEntity<List<Order>> getOrders(@PathVariable("userId") final int uid) {
		System.out.println("Fetching order history of user, userID = " + uid);
		final List<Order> orders = (List<Order>) this.orderRepo.getOrderHistory(uid);
		return new ResponseEntity<List<Order>>(orders, HttpStatus.OK);
	}

	@RequestMapping(value = { "/{userId}/createOrder" }, method = { RequestMethod.GET }, produces = {
			"application/json" })
	public ResponseEntity<Order> createOrders(@PathVariable("userId") final int uid) {
		System.out.println("Creating order of user, userID = " + uid);
		final Order order = this.orderRepo.createOrder(uid);
		return new ResponseEntity<Order>(order, HttpStatus.OK);
	}
}