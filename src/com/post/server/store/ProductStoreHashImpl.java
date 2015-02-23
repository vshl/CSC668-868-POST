/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.post.server.store;

import com.post.server.model.Product;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author kumari
 */
public class ProductStoreHashImpl implements ProductStore {
    
    Map<String, Product> prodMap;

    public ProductStoreHashImpl() {
        this.prodMap = new HashMap<String, Product>();
    }
    
    /*
    Add product to hashmap
    */
    @Override
    public void addProduct(Product product) {
        prodMap.put(product.getUpc(), product);
    }

     /*
    Removes product from hashmap
    */
    @Override
    public void deleteProduct(Product product) {
        prodMap.remove(product.getUpc());
    }
    
    /*
    Returns list of products
    */
    @Override
    public List<Product> getAllProduct() {
         return new ArrayList<Product>(prodMap.values());
    }
}
