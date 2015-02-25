/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.post.client;

import com.post.transport.rmi.ProductSpecification;
import com.post.transport.rmi.SaleLineItem;
import java.io.Serializable;
import java.rmi.RemoteException;

/**
 *
 * @author kumari
 */
public class SaleLineItemImpl implements SaleLineItem,Serializable {
    private final ProductSpecification product;
    private final int itemCount;
    
    public SaleLineItemImpl(ProductSpecification product, int itemCount) {
        this.product = product;
        this.itemCount = itemCount;
    }
    
    @Override
    public ProductSpecification getProduct() throws RemoteException {
        return this.product;
    }
    
    @Override
    public int getItemCount() throws RemoteException {
        return this.itemCount;
    }

    @Override
    public double getSubTotal() throws RemoteException {
        return this.product.getPrice() * this.itemCount;
    }

    @Override
    public String toString() {
        return "SaleLineItemImpl{" + "product=" + product + ", ItemCount=" + itemCount + '}';
    }
}
