package com.post.server.store;

import com.post.server.model.Product;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author kumari
 */
public interface ProductStore {
    public void addProduct(Product product);
    public void deleteProduct(Product product);
    public List<Product> getAllProduct();    
}
