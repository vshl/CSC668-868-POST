/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.post.transport.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *This is responsible for generating catalog, checking authorization and 
 * generating invoice
 * @author kumari
 */
public interface PostManager extends Remote {
    /**
     * Returns product catalog which consists of product information
     * @return
     * @throws RemoteException 
     */
    Catalog getCatalog() throws RemoteException; 
    
    /**
     * Checks payment authorization and return result to client
     * @param payment
     * @return
     * @throws RemoteException 
     */
    boolean isAuthorized(Payment payment) throws RemoteException;
    
    /**
     * Generates invoice with all sale details
     * @param sale
     * @return
     * @throws RemoteException 
     */
    Invoice saveSale(Sale sale) throws RemoteException; 
    
}
