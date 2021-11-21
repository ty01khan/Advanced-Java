package com.dao;

import org.hibernate.Transaction;
import com.entities.Cart;
import com.entities.UserDetails;
import java.util.Iterator;
import java.io.Serializable;
import org.hibernate.Session;
import java.util.ArrayList;
import com.entities.SessionProvider;
import com.entities.User;
import java.util.List;
import java.util.regex.Pattern;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository
{
    public static boolean isValidBase64String(final String str) {
        return Pattern.matches("^([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==|[A-Za-z0-9+/]{1}===)?$", str);
    }
    
    public static List<User> getAllData() {
        try {
            final Session session = SessionProvider.getSession();
            return (List<User>)session.createCriteria((Class)User.class).list();
        }
        catch (Exception e) {
            return new ArrayList<User>();
        }
    }
    
    public User findUserById(final int id) {
        final Session session = SessionProvider.getSession();
        final User user = (User)session.get((Class)User.class, (Serializable)id);
        session.close();
        return user;
    }
    
    public boolean isValidLogin(final String email, final String password) {
        if (email.isEmpty() || password.isEmpty()) {
            return false;
        }
        if (email.endsWith("@beehyv.com") && isValidBase64String(password)) {
            final List<User> users = getAllData();
            for (final User user : users) {
                if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
    
    public int isValidSignup(final String name, final String email, final String password) {
        if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
            return 0;
        }
        if (email.endsWith("@beehyv.com") && isValidBase64String(password)) {
            final List<User> users = getAllData();
            for (final User user : users) {
                if (user.getEmail().equals(email)) {
                    return 0;
                }
            }
            final UserDetails user2 = new UserDetails();
            final User user3 = new User();
            user3.setName(name);
            user3.setEmail(email);
            user3.setPassword(password);
            user2.setName(name);
            user2.setEmail(email);
            final Cart cart = new Cart();
            final Session session = SessionProvider.getSession();
            final Transaction txn = session.beginTransaction();
            session.save((Object)cart);
            session.save((Object)user2);
            session.save((Object)user3);
            txn.commit();
            session.close();
            return users.size() + 1;
        }
        return 0;
    }
    
    public UserDetails getProfile(final int id) {
        final Session session = SessionProvider.getSession();
        final UserDetails user = (UserDetails)session.get((Class)UserDetails.class, (Serializable)id);
        session.close();
        return user;
    }
    
    public boolean updateProfile(final UserDetails user) {
        if (user.getName().isEmpty() || user.getEmail().isEmpty() || user.getPhone().isEmpty()) {
            return false;
        }
        if (user.getPhone().length() != 10) {
            return false;
        }
        if (!user.getEmail().endsWith("@beehyv.com")) {
            return false;
        }
        final Session session = SessionProvider.getSession();
        final Transaction txn = session.beginTransaction();
        final UserDetails user2 = (UserDetails)session.get((Class)UserDetails.class, (Serializable)user.getUserID());
        user2.setName(user.getName());
        user2.setEmail(user.getEmail());
        user2.setPhone(user.getPhone());
        user2.setAddress(user.getAddress());
        session.save((Object)user2);
        txn.commit();
        session.close();
        return true;
    }
}
