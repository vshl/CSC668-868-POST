package com.post.server;

import com.post.transport.rmi.Product;
import java.rmi.RemoteException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *  Holds information about the given product.
 * @author ryaneshleman
 */
public class ProductImpl implements Product{
    private String upc;
    private String description;
    private double price;

    /**
     * Constructor initializes all values
     * @param upc
     * @param description
     * @param price 
     */
    public ProductImpl(String upc, double price, String description)
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
    public String Description() throws RemoteException {
        return this.description;
    }

    @Override
    public String toString() {
        return "ProductImpl{" + "upc=" + upc + ", description=" + description + ", price=" + price + '}';
    }
}
