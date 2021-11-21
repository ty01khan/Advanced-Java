package com.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.stereotype.Repository;

import com.entities.Cart;
import com.entities.Order;
import com.entities.User;
import com.entities.UserCredentials;

@Repository
public class UserRepository {
	List<UserCredentials> credentials = new ArrayList<UserCredentials>();
	List<User> users = new ArrayList<User>();
	List<Cart> carts = new ArrayList<Cart>();
	Map<Integer, List<Order>> ordersMap = new HashMap<Integer, List<Order>>();
	
	public boolean isValidLogin(String email, String password) {
		String base64 = "^([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==|[A-Za-z0-9+/]{1}===)?$";

		if (email.endsWith("@beehyv.com") && Pattern.matches(base64, password)) {
			for (UserCredentials cred : credentials) {
				if (cred.getEmail().equals(email) && cred.getPassword().equals(password))
					return true;
			}
		}
		return false;
	}

	public int isValidSignup(String name, String email, String password) {
		String base64 = "^([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==|[A-Za-z0-9+/]{1}===)?$";

		if (email.endsWith("@beehyv.com") && Pattern.matches(base64, password) && !name.isEmpty()) {
			UserCredentials cred = new UserCredentials();
			cred.setEmail(email);
			cred.setName(name);
			cred.setPassword(password);
			credentials.add(cred);

			User newUser = new User();
			newUser.setUserID(users.size() + 1);
			newUser.setName(name);
			newUser.setEmail(email);
			users.add(newUser);
			
			Cart cart = new Cart();
			cart.setCartId(carts.size()+1);
			carts.add(cart);
			
			ordersMap.put(users.size(), new ArrayList<Order>());
			
			return users.size();
		}

		return 0;
	}

	public User getUserById(int uid) {
		if (users.size() >= uid) {
			return users.get(uid - 1);
		}
		return null;
	}

	public boolean updateProfile(User user) {
		for (User usr : users) {
			if (usr.getUserID() == user.getUserID()) {
				usr.setName(user.getName());
				usr.setEmail(user.getEmail());
				usr.setAddress(user.getAddress());
				if (user.getPhone().length() == 10) {
					usr.setPhone(user.getPhone());
				} else {
					System.out.println("Phone number is not of 10 digits");
					return false;
				}

				break;
			}
		}

		return true;
	}
	
	public Cart getCart(int id) {
		return carts.get(id-1);
	}
	
	public List<Order> getOrderList(int id) {
		return ordersMap.get(id);
	}
}
