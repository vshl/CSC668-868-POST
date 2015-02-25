/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.post.server;

import com.post.transport.rmi.Invoice;
import com.post.transport.rmi.Sale;
import java.io.Serializable;
import java.rmi.RemoteException;

/**
 *
 * @author kumari
 */
public class InvoiceImpl implements Invoice, Serializable {
    private String id;
    private Sale sale;
    
    public InvoiceImpl(String id, Sale sale) {
        this.id = id;
        this.sale = sale;
    }

    @Override
    public String getInvoiceId() throws RemoteException {
        return this.id;
    }
    
    @Override
    public Sale getSale() throws RemoteException {
        return this.sale;
    }
}
