/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.post.transport.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * This keeps information about type of payment, amount paid and credit card
 * number
 * @author kumari
 */
public interface Payment extends Remote {

    PaymentType getPaymentType() throws RemoteException;
    
    double getAmount() throws RemoteException;
    
    String getCardNumber() throws RemoteException;
}
