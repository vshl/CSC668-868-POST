/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.post.client;

import com.post.transport.rmi.Payment;
import com.post.transport.rmi.Sale;
import com.post.transport.rmi.SaleLineItem;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author kumari
 */
public class SaleImpl implements Sale {
    private final String customerName;
    private final List<SaleLineItem> saleLineItems;
    private final Payment payment;
    
    
    public SaleImpl(String customerName,
            List<SaleLineItem> saleLineItems,
            Payment payment) {
        this.customerName = customerName;
        this.saleLineItems = saleLineItems;
         this.payment = payment;
    }

    @Override
    public Payment getPayment() throws RemoteException {
        return this.payment;
    }

    @Override
    public List<SaleLineItem> getSaleItems() throws RemoteException {
        return this.saleLineItems;
    }

    @Override
    public String getCustomerName() throws RemoteException {
        return this.customerName;
    }

    @Override
    public double getTotalAmount() throws RemoteException {
        double totalAmount = 0;
        
        for(SaleLineItem item : this.saleLineItems){
            totalAmount += item.getSubTotal();
        }
        
        return totalAmount;
    }

    @Override
    public String toString() {
        return "SaleImpl{" + "customerName=" + customerName + ", saleLineItems=" + saleLineItems + ", payment=" + payment + '}';
    }
}
