package com.dao;

import org.hibernate.Transaction;
import java.io.Serializable;
import com.entities.Cart;
import org.hibernate.Session;
import java.util.ArrayList;
import com.entities.SessionProvider;
import com.entities.Order;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository
{
    public List<Order> getOrderHistory(final int uid) {
        try {
            final Session session = SessionProvider.getSession();
            return (List<Order>)session.createCriteria((Class)Order.class).list();
        }
        catch (Exception e) {
            return new ArrayList<Order>();
        }
    }
    
    public Order createOrder(final int uid) {
        final Order order = new Order();
        final Session session = SessionProvider.getSession();
        final Transaction txn = session.beginTransaction();
        final Cart cart = (Cart)session.get((Class)Cart.class, (Serializable)uid);
        order.setProducts(cart.getProducts());
        order.setOrderStatus("Awaiting Payment");
        session.save((Object)order);
        txn.commit();
        session.close();
        return order;
    }
}
