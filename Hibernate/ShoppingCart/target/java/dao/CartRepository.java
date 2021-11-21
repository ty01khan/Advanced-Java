package com.dao;

import java.util.Iterator;
import java.util.List;
import org.hibernate.Transaction;
import com.entities.CartItem;
import org.hibernate.Session;
import java.io.Serializable;
import com.entities.SessionProvider;
import com.entities.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CartRepository
{
    @Autowired
    ProductRepository productRepo;
    
    public Cart getCartByUserId(final int userId) {
        final Session session = SessionProvider.getSession();
        final Cart cart = (Cart)session.get((Class)Cart.class, (Serializable)userId);
        System.out.println(cart);
        session.close();
        return cart;
    }
    
    public CartItem getCartItem(final int userId, final int itemId) {
        final Session session = SessionProvider.getSession();
        final Cart cart = (Cart)session.get((Class)Cart.class, (Serializable)userId);
        CartItem item = null;
        System.out.println(cart);
        if (cart.getProducts().size() >= userId) {
            item = cart.getProducts().get(userId - 1);
        }
        session.close();
        return item;
    }
    
    public CartItem addCartItem(final int userId, final int pid) {
        final Session session = SessionProvider.getSession();
        final Transaction txn = session.beginTransaction();
        final Cart cart = (Cart)session.get((Class)Cart.class, (Serializable)userId);
        System.out.println(cart);
        final List<CartItem> cartItems = cart.getProducts();
        System.out.println(cartItems);
        for (final CartItem item : cartItems) {
            if (item.getProduct().getProductId() == pid) {
                item.setQuantity(item.getQuantity() + 1);
                session.update((Object)item);
                cart.setProducts(cartItems);
                session.update((Object)cart);
                txn.commit();
                session.close();
                return item;
            }
        }
        CartItem item = new CartItem();
        item.setProduct(this.productRepo.getProductById(pid));
        item.setQuantity(1);
        session.save((Object)item);
        cartItems.add(item);
        System.out.println(cartItems);
        cart.setProducts(cartItems);
        session.saveOrUpdate((Object)cart);
        System.out.println(cart);
        txn.commit();
        session.close();
        return item;
    }
    
    public String removeProduct(final int uid, final int pid) {
        final Session session = SessionProvider.getSession();
        final Transaction txn = session.beginTransaction();
        final Cart cart = (Cart)session.get((Class)Cart.class, (Serializable)uid);
        final List<CartItem> items = cart.getProducts();
        for (final CartItem item : items) {
            if (item.getProduct().getProductId() == pid) {
                final String name = item.getProduct().getName();
                items.remove(item);
                session.update((Object)cart);
                txn.commit();
                session.close();
                return name;
            }
        }
        return null;
    }
    
    public CartItem changeQuantity(final int qty, final int itemId) {
        final Session session = SessionProvider.getSession();
        final Transaction txn = session.beginTransaction();
        final CartItem item = (CartItem)session.get((Class)CartItem.class, (Serializable)itemId);
        item.setQuantity(qty);
        session.update((Object)item);
        txn.commit();
        session.close();
        System.out.println(item);
        return item;
    }
}
