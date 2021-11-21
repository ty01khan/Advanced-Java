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

import com.dao.UserRepository;
import com.entities.User;

@Controller
public class UserController {
	@Autowired
	UserRepository userRepo;
	
	
	/**
	 * 1.-------------------- Login ---------------------
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<String> validateLogin(@RequestBody Map<String, String> loginMap) {
		System.out.println("Login authentication checking...");

		String email = loginMap.get("email");
		String password = loginMap.get("password");

		if (userRepo.isValidLogin(email, password)) {
			System.out.printf("User successfully logged in. \n\n");
			return new ResponseEntity<String>("{'result':'Success'}  200 Ok",HttpStatus.OK);
		}

		System.out.printf("User's log in failed. \n\n");
		return new ResponseEntity<String>("{'result':'failure'}  401", HttpStatus.UNAUTHORIZED);
	}
	
	
	/**
	 * 2.-------------------- SignUp ---------------------
	 */
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ResponseEntity<String> validateSignUp(@RequestBody Map<String, String> signupMap) {
		System.out.println("SignUp details checking...");

		String name = signupMap.get("name");
		String email = signupMap.get("email");
		String password = signupMap.get("password");

		int signupVal = userRepo.isValidSignup(name, email, password);
		if (signupVal != 0) {
			System.out.println(name + ", a new user added.");
			System.out.println();
			String result = String.format("{'userId':%d}  200 Ok", signupVal);
			return new ResponseEntity<String>(result, HttpStatus.OK);
		}
		
		System.out.println(name + ", sign up failed.");
		System.out.println();
		return new ResponseEntity<String>("{'result':'failure'}  401", HttpStatus.UNAUTHORIZED);
	}
	
	
	/**
	 * 3.-------------------- LogOut ---------------------
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public ResponseEntity<String> logout(@RequestBody Map<String, Integer> logoutMap) {
		System.out.println("Log out processing..., User ID = " + logoutMap.get("userID"));
		if (userRepo.getUserById(logoutMap.get("userID")) != null) {
			System.out.println("User ID = " + logoutMap.get("userID") + ", logged out successfully.");
			System.out.println();
			return new ResponseEntity<String>("{'result':'Success'}  200 Ok", HttpStatus.OK);
		}

		System.out.println("User ID = " + logoutMap.get("userID") + ", logging out failed.");
		System.out.println();
		return new ResponseEntity<String>("{'result':'failure'}  401", HttpStatus.UNAUTHORIZED);
	}
	
	
	/**
	 * 4.-------------------- Get Profile ---------------------
	 */
	@RequestMapping(value = "/getprofile/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getProfileById(@PathVariable("userId") int userId) {
		System.out.println("Fetching user with id " + userId + "...");
		User user = userRepo.getUserById(userId);
		
		if(user == null) {
			System.out.println("User with id " + userId + " not found.");
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	
	/**
	 * 5.-------------------- Update Profile ---------------------
	 */
	@RequestMapping(value = "/updateProfile", method = RequestMethod.POST)
	public ResponseEntity<String> updateProfile(@RequestBody User user) {
		System.out.println("Update profile of User with ID " + user.getUserID());

		if (userRepo.getUserById(user.getUserID()) == null) {
			System.out.printf("Profile updation failed. \n\n");
			return new ResponseEntity<String>("{'result':'failure'}  401", HttpStatus.UNAUTHORIZED);
		}
		else {
			boolean result = userRepo.updateProfile(user);
			if(result) {
				System.out.printf("Profile updated. \n\n");
				return new ResponseEntity<String>("{'result':'Success'}  200 Ok", HttpStatus.OK);
			}
			else {
				System.out.printf("Profile updation failed. \n\n");
				return new ResponseEntity<String>("{'result':'failure'}  401", HttpStatus.UNAUTHORIZED);
			}
		}
	}
}
