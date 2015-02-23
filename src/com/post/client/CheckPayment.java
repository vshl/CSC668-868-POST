package com.post.client;

import com.post.transport.rmi.Payment;
import com.post.transport.rmi.PaymentType;
import java.rmi.RemoteException;

public class CheckPayment implements Payment {
    double amount;

    public CheckPayment(double amount) {
        this.amount = amount;
    }

    @Override
    public PaymentType getPaymentType() throws RemoteException {
        return PaymentType.CHECK;
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
        return "CheckPayment{" + "amount=" + amount + '}';
    }
    
}
