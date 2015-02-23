package com.post.server.store;

import com.post.server.model.Product;
import java.util.List;



/**
 * This stores product object of model class
 * @author kumari
 */
public interface ProductStore {
    
    public void addProduct(Product product);
    
    public void deleteProduct(Product product);
    
    public List<Product> getAllProduct();    
}
