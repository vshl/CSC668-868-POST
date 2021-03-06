package com.post.server;

import com.post.transport.rmi.ProductSpecification;
import java.io.Serializable;
import java.rmi.RemoteException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *  Holds information about the given product.
 * @author ryaneshleman
 */
public class ProductSpecificationImpl implements ProductSpecification, Serializable{
    private String upc;
    private String description;
    private double price;

    /**
     * Constructor initializes all values
     * @param upc
     * @param description
     * @param price 
     */
    public ProductSpecificationImpl(String upc, double price, String description)
    {
        this.upc = upc;
        this.price = price;
        this.description = description;
    }
    
    @Override
    public String getUpc() throws RemoteException {
        return this.upc;
    }

    @Override
    public double getPrice() throws RemoteException {
        return this.price;
    }

    @Override
    public String getDescription() throws RemoteException {
        return this.description;
    }

    @Override
    public String toString() {
        return "ProductImpl{" + "upc=" + upc + ", description=" + description + ", price=" + price + '}';
    }
}
