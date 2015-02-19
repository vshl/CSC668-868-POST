package com.post.server;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.util.HashMap;

/**
 * Main data structure to do UPC - ProductSpecification mappings
 * @author ryaneshleman
 */
public class Catalog {
    private HashMap<Integer,ProductSpecification> products = new HashMap<Integer,ProductSpecification>();
    
    /**
     * constructor builds local hashmap from PRODUCT_SPEC_FILE
     * @param PRODUCT_SPEC_FILE 
     * @throws IOException 
     */
    public Catalog(String PRODUCT_SPEC_FILE) throws IOException
    {
        ProductReader pr = new ProductReader(PRODUCT_SPEC_FILE);
        
        ProductSpecification tmp;
        while(pr.hasNext())
        {
            tmp = pr.getNextProduct();
            addItem(tmp);
        }    
        
    }
    
    /**
     * returns the ProductSpecification from a given UPC
     * @param upc
     * @return 
     */
    public ProductSpecification getProduct(int upc)
    {
        return products.get(upc);
    }
    
    
    /**
     * adds a ProductSpecifcation to the mapping
     * @param p
     * @return 
     */
    public ProductSpecification addItem(ProductSpecification p)
    {
        return products.put(p.getUpc(),p);
    }
    
    
    /**
     * Removes an item from the Catalog based on its UPC
     * @param upc
     * @return 
     */
    public ProductSpecification removeItem(int upc)
    {
        return products.remove(products.get(upc));
    }
}
