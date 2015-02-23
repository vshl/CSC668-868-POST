/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.post.transport.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author kumari
 */
public interface SaleLineItem extends Remote {

    Product getProduct() throws RemoteException;
    int getItemCount() throws RemoteException;
    double getSubTotal() throws RemoteException;
    
}
