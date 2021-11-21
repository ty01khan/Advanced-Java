package com.controllers;

import com.entities.UserCredentials;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import com.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import com.dao.UserRepository;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
	@Autowired
	UserRepository userRepo;

	@RequestMapping(value = { "/login" }, method = { RequestMethod.POST })
	public ResponseEntity<String> login(@RequestBody final UserCredentials loginCred) {
		System.out.println("Login authentication checking...");
		final String email = loginCred.getEmail();
		final String password = loginCred.getPassword();
		if (this.userRepo.isValidLogin(email, password)) {
			System.out.println("Login successfully");
			return new ResponseEntity<String>("{'result':'Success'}  200 Ok", HttpStatus.OK);
		}
		System.out.println("Wrong credentials entered, login failed.");
		return new ResponseEntity<String>("{'result':'failure'}  401", HttpStatus.UNAUTHORIZED);
	}

	@RequestMapping(value = { "/signup" }, method = { RequestMethod.POST })
	public ResponseEntity<String> signup(@RequestBody final UserCredentials signupCred) {
		System.out.println("Signing up...");
		final String name = signupCred.getName();
		final String email = signupCred.getEmail();
		final String password = signupCred.getPassword();
		final int signupVal = userRepo.isValidSignup(name, email, password);
		if (signupVal != 0) {
			System.out.println("Signed Up successfully");
			final String result = String.format("{'userId':%d}  200 Ok", signupVal);
			return new ResponseEntity<String>(result, HttpStatus.OK);
		}
		System.out.println("Sign Up failed");
		return new ResponseEntity<String>("{'result':'failure'}  401", HttpStatus.UNAUTHORIZED);
	}

	@RequestMapping(value = { "/logout" }, method = { RequestMethod.POST })
	public ResponseEntity<String> logout(@RequestBody final User user) {
		System.out.println("Logging out user, User ID = " + user.getUserID());
		final int userId = user.getUserID();
		if (this.userRepo.findUserById(userId) != null) {
			return new ResponseEntity<String>("{'result':'Success'}  200 Ok", HttpStatus.OK);
		}
		return new ResponseEntity<String>("{'result':'failure'}  401", HttpStatus.UNAUTHORIZED);
	}

	@RequestMapping(value = { "/getprofile/{userId}" }, method = { RequestMethod.GET }, produces = {
			"application/json" })
	public ResponseEntity<User> getProfile(@PathVariable("userId") final int userId) {
		System.out.println("Getting profile of user, User ID = " + userId);
		return new ResponseEntity<User>(this.userRepo.getProfile(userId), HttpStatus.OK);
	}

	@RequestMapping(value = { "/updateProfile" }, method = { RequestMethod.POST })
	public ResponseEntity<String> updateProfile(@RequestBody final User user) {
		System.out.println("Logging out user, User ID = " + user.getUserID());
		final int userId = user.getUserID();
		if (this.userRepo.findUserById(userId) != null && this.userRepo.updateProfile(user)) {
			return new ResponseEntity<String>("{'result':'Success'}  200 Ok", HttpStatus.OK);
		}
		return new ResponseEntity<String>("{'result':'failure'}  401", HttpStatus.UNAUTHORIZED);
	}
}