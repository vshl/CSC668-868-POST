package com.post.client;

import com.post.server.ProductImpl;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * holts an item and the quantity of that item to be sold
 * 
 * @author ryaneshleman
 */
public class LineItem {
    private final ProductImpl productSpecs;
    private final int quantity;
    
    public LineItem(ProductImpl productSpecs, int quantity)
    {
        this.productSpecs = productSpecs;
        this.quantity = quantity;
    }       
    
    public int getQuantity()
    {
        return quantity;
    }
    
    public double getItemUnitCost()
    {
        return this.productSpecs.getPrice();
    }
    
    public String getProductDescription()
    {
        return this.productSpecs.getDescription();
    }        
}
