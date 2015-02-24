/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.post.transport.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * This would be implemented by client side
 * @author kumari
 */
public interface Sale extends Remote {

    Payment getPayment() throws RemoteException;

    List<SaleLineItem> getSaleItems() throws RemoteException;
    
    String getCustomerName() throws RemoteException;
    
    double getTotalAmount() throws RemoteException;
    
    void addLineItem(SaleLineItem li);
    
    void makePayment(Payment payment);
}
