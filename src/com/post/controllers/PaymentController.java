/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.post.controllers;

import com.post.client.CashPayment;
import com.post.client.CheckPayment;
import com.post.client.CreditPayment;
import com.post.presentation.PaymentPanel;
import com.post.transport.rmi.Payment;
import com.post.transport.rmi.PaymentType;
import javax.swing.JPanel;

/**
 *
 * @author ryaneshleman
 */
public class PaymentController {
    FrameController mediator;
    PaymentPanel panel;
    
    PaymentController(FrameController med,PaymentPanel paymentPanel) {
        this.mediator = med;
        this.panel = paymentPanel;
        
        
        //initialize pay types with values of PaymentType enum
        paymentPanel.initPaymentTypes(PaymentType.values());
        
    }

    public void payButtonPressed(Object selectedItem, String text) throws Exception {
        PaymentType pt = (PaymentType)selectedItem;
        Payment payment;
        double amount = Double.parseDouble(text);
        
        switch(pt){
            case CASH:
                payment = new CashPayment(amount);
                break;
            case CREDIT:
                
                throw new Exception("Havent implemented this yet!");
                
            case CHECK:
                payment = new CheckPayment(amount);
                break;
            default:
                throw new Exception("Uh Oh! Something went wrong");
        
        }
        
        mediator.submitPayment(payment);
    }
    
	public void payTypeChanged(Object payment) {
		PaymentType type = (PaymentType) payment;
		switch(type) {
			case CREDIT:
				panel.setPaymentLabel("Card number:");
				break;
			default:
				panel.setPaymentLabel("Amount:");
		}
	}
	
}
