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
 *
 * @author kumari
 */
public interface PostManager extends Remote {
    
    List<Product> getCatalog() throws RemoteException; // list of products or catalog
    boolean isAuthorized(Payment payment) throws RemoteException; // payment aauthorization	
    Invoice saveSale(Sale sale) throws RemoteException; // generating invoice
    
}
