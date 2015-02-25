package com.post.client;

import com.post.transport.rmi.Payment;
import com.post.transport.rmi.PaymentType;
import java.io.Serializable;
import java.rmi.RemoteException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor
 */

public class CashPayment implements Payment, Serializable{
    private double amount;

    public CashPayment(double amount) {
        this.amount = amount;
    }

    @Override
    public PaymentType getPaymentType() throws RemoteException {
        return PaymentType.CASH;
        
    }

    @Override
    public double getAmount() throws RemoteException {
        return this.amount;
    }

    @Override
    public String getCardNumber() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "CashPayment{" + "amount=" + amount + '}';
    }
    
}