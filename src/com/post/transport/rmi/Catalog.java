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
 * This is read only interface for client because client need not update
 * or make any changes to catalog 
 * @author kumari
 */
public interface Catalog extends Remote {
    /**
     * This returns product based on upc.
     * @param upc
     * @return
     * @throws RemoteException 
     */
    public ProductSpecification getProductByUpc(String upc) throws RemoteException;
    
    
    /**
     * This returns list of products
     * @return
     * @throws RemoteException 
     */
    public List<ProductSpecification> getAllProducts() throws RemoteException;
}
