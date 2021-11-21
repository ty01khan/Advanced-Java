package com.dao;

import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.Session;
import java.util.ArrayList;
import com.helper.SessionProvider;
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
    
    //@SuppressWarnings({ "unchecked", "deprecation" })
	@SuppressWarnings("deprecation")
	public static List<Product> getAllProducts() {
    	System.out.println("Reached ...");
        try {
            Session session = SessionProvider.getSession();
            @SuppressWarnings("unchecked")
			List<Product> products = session.createCriteria(Product.class).list();
            session.close();
            return products;
        }
        catch (Exception e) {
            return new ArrayList<Product>();
        }
 
//    	Session session = SessionProvider.getSession();
//		@SuppressWarnings("unchecked")
//		Query<Product> query = session.createQuery("select p from Product p");
//		List<Product> products = query.list();
//		return products;
    }
    
    public Product addProduct(Product product) {
        Session session = SessionProvider.getSession();
        Transaction txn = session.beginTransaction();
        session.save((Object)product);
        ++ProductRepository.id;
        txn.commit();
        product = session.get(Product.class, ProductRepository.id);
        session.close();
        return product;
    }
    
    public Product updateProduct(Product product) {
        final Session session = SessionProvider.getSession();
        final Transaction txn = session.beginTransaction();
        session.update((Object)product);
        product = session.get(Product.class, product.getProductId());
        txn.commit();
        session.close();
        return product;
    }
    
    public Product getProductById(int id) {
    	//System.out.println("Testing " + getAllProducts());
    	System.out.println("Product list: " + getAllProducts());
    	Session session = SessionProvider.getSession();
    	@SuppressWarnings("unchecked")
		Query<Product> query = session.createQuery("select u from Product u where u.productId=1");
        Product pdt = query.uniqueResult();
//    	List<Product> list = query.uniqueResult();
//    	System.out.println("Testing0 " + getAllProducts().size());
//    	Product pdt = session.get(Product.class, id);
//    	System.out.println("Testing " + getAllProducts().size());
    	session.close();
        return pdt;
    }
    
    public List<Product> getAllProductsByCategory(String category) {
        List<Product> products = getAllProducts();
        List<Product> pdts = new ArrayList<Product>();
        for (Product p : products) {
            if (p.getCategory().equals(category)) {
                pdts.add(p);
            }
        }
        return pdts;
    }
    
    public List<Product> searchProduct(String str) {
        String[] strArray = str.split("\\s+");
        List<Product> products = new ArrayList<Product>();
        List<Product> pdts = getAllProducts();
        for (Product pdt : pdts) {
            int i;
            boolean containsSearchStr;
            for (i = 0, i = 0; i < strArray.length; ++i) {
                containsSearchStr = strArray[i].equalsIgnoreCase(pdt.getSubcategory().toString());
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
    
    public List<Product> getFilteredProduct(String category, int minPrice, int maxPrice) {
        List<Product> pdts = new ArrayList<Product>();
        ProductRepository pr = new ProductRepository();
        List<Product> products = pr.getAllProductsByCategory(category);
        for (Product pdt : products) {
            if (pdt.getPrice() >= minPrice && pdt.getPrice() <= maxPrice) {
                pdts.add(pdt);
            }
        }
        return pdts;
    }
}