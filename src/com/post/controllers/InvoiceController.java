/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.post.controllers;

import com.post.presentation.InvoicePanel;
import com.post.transport.rmi.Sale;
import com.post.transport.rmi.SaleLineItem;
import java.rmi.RemoteException;

/**
 *
 * @author ryaneshleman
 */
public class InvoiceController {
    FrameController mediator;
    InvoicePanel panel;
    
    InvoiceController(FrameController med,InvoicePanel invoicePanel) {
        this.mediator = med;
        this.panel = invoicePanel;
    }

    void addLineItem(SaleLineItem lineItem) throws RemoteException {
        double price = lineItem.getProduct().getPrice();
        double extendedPrice = lineItem.getSubTotal();
        String[] row = { lineItem.getProduct().getDescription(), Integer.toString(lineItem.getItemCount()),
            Double.toString(price), Double.toString(extendedPrice)
        };
        panel.writeToTable(row);
    }

    void printSaleDetails(Sale currentSale) throws RemoteException, Exception {
        double amountDue = currentSale.getTotalAmount();
        double amountReturned = 0;
        String paymentTypeOutput;
        
         
        switch(currentSale.getPayment().getPaymentType()){
            case CASH:
                paymentTypeOutput = "Amount Tendered:  "+ currentSale.getPayment().getAmount();
                amountReturned = currentSale.getPayment().getAmount() - amountDue;
                break;
            case CREDIT:
                paymentTypeOutput = "Paid By Creditcard";
                break;
            case CHECK:
                paymentTypeOutput = "Paid by Check";
            default :
                throw new Exception("Problem with printing invoice details");
        
        }
            
        
        panel.writeToTextArea("Amount Due: " + amountDue + "\n");
        panel.writeToTextArea(paymentTypeOutput+"\n");
        panel.writeToTextArea("Amount Returned: " + amountReturned+"\n");
    }
    
}
