package com.dao;

import java.util.function.Predicate;
import java.util.Iterator;
import org.hibernate.Transaction;
import java.io.Serializable;
import org.hibernate.Session;
import java.util.ArrayList;
import com.entities.SessionProvider;
import com.entities.Product;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository
{
    private static int id;
    
    static {
        ProductRepository.id = 0;
    }
    
    public static int getProductId() {
        return ProductRepository.id;
    }
    
    public static List<Product> getAllProducts() {
        try {
            final Session session = SessionProvider.getSession();
            return (List<Product>)session.createCriteria((Class)Product.class).list();
        }
        catch (Exception e) {
            return new ArrayList<Product>();
        }
    }
    
    public Product addProduct(Product product) {
        final Session session = SessionProvider.getSession();
        final Transaction txn = session.beginTransaction();
        session.save((Object)product);
        ++ProductRepository.id;
        txn.commit();
        product = (Product)session.get((Class)Product.class, (Serializable)ProductRepository.id);
        session.close();
        return product;
    }
    
    public Product updateProduct(Product product) {
        final Session session = SessionProvider.getSession();
        final Transaction txn = session.beginTransaction();
        session.update((Object)product);
        product = (Product)session.get((Class)Product.class, (Serializable)product.getProductId());
        txn.commit();
        session.close();
        return product;
    }
    
    public Product getProductById(final int id) {
        return getAllProducts().get(id - 1);
    }
    
    public List<Product> getAllProductsByCategory(final String category) {
        final List<Product> products = getAllProducts();
        final List<Product> pdts = new ArrayList<Product>();
        for (final Product p : products) {
            if (p.getCategory().equals(category)) {
                pdts.add(p);
            }
        }
        return pdts;
    }
    
    public List<Product> searchProduct(final String str) {
        final String[] strArray = str.split("\\s+");
        final List<Product> products = new ArrayList<Product>();
        final List<Product> pdts = getAllProducts();
        for (final Product pdt : pdts) {
            int i;
            boolean containsSearchStr;
            for (i = 0, i = 0; i < strArray.length; ++i) {
                containsSearchStr = pdt.getSubcategory().stream().anyMatch((Predicate<? super Object>)strArray[i]::equalsIgnoreCase);
                if (!containsSearchStr) {
                    break;
                }
            }
            if (i == strArray.length) {
                products.add(pdt);
            }
        }
        return products;
    }
    
    public List<Product> getFilteredProduct(final String category, final int minPrice, final int maxPrice) {
        final List<Product> pdts = new ArrayList<Product>();
        final ProductRepository pr = new ProductRepository();
        final List<Product> products = pr.getAllProductsByCategory(category);
        for (final Product pdt : products) {
            if (pdt.getPrice() >= minPrice && pdt.getPrice() <= maxPrice) {
                pdts.add(pdt);
            }
        }
        return pdts;
    }
}
