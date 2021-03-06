package com.post.client;

import com.post.transport.rmi.Payment;
import com.post.transport.rmi.PaymentType;
import java.io.Serializable;
import java.rmi.RemoteException;

public class CreditPayment implements Payment,Serializable {
    double amount;
    String cardNumber;
    boolean authorized;

    public CreditPayment(double amount, String cardNumber) {
        this.amount = amount;
        this.cardNumber = cardNumber;
    }

    @Override
    public PaymentType getPaymentType() throws RemoteException {
        return PaymentType.CREDIT;
    }

    @Override
    public double getAmount() throws RemoteException {
        return this.amount;
    }

    @Override
    public String getCardNumber() throws RemoteException {
        return this.cardNumber;
        
    }

    @Override
    public String toString() {
        return "CreditPayment{" + "amount=" + amount + ", cardNumber=" + cardNumber + '}';
    }

}