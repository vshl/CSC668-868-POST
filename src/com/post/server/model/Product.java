/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.post.server.model;

import com.post.server.ProductSpecificationImpl;
import java.io.Serializable;

/**
 *
 *  This class keeps model object. It will be used  only by server.
 *  Although it looks like similar implementation to transport class but
 *  a separate model class is required. It is done in order to separate responsibilities
 *  between model class and transport interfaces.
 *  This model class may know about transport but not vice versa.
 * 
 * @author kumari
 */
public class Product implements Serializable {
    private String upc;
    private double price;
    private String description;

    public Product(String upc, double price, String description) {
        this.upc = upc;
        this.price = price;
        this.description = description;
    }

    public String getUpc() {
        return upc;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" + "upc=" + upc + ", price=" + price + ", description=" + description + '}';
    }
    
    /**
     * converts model object into transport object
     * @return transport product object
     */
    public com.post.transport.rmi.ProductSpecification convertToTransport(){
        return new ProductSpecificationImpl(this.upc, this.price, this.description);
    }
}
