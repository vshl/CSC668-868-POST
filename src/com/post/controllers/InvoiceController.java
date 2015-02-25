/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.post.controllers;

import com.post.presentation.InvoicePanel;
import com.post.transport.rmi.Sale;
import com.post.transport.rmi.SaleLineItem;
import java.rmi.RemoteException;
import java.text.DecimalFormat;

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
        this.panel.setTotal("0");
    }

    void addLineItem(SaleLineItem lineItem) throws RemoteException {
        double price = lineItem.getProduct().getPrice();
        double extendedPrice = formatDouble(lineItem.getSubTotal());
        String[] row = { lineItem.getProduct().getDescription(), Integer.toString(lineItem.getItemCount()),
            Double.toString(price), Double.toString(extendedPrice)
        };
        panel.writeToTable(row);
        panel.updateTotal(extendedPrice);
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
                break;
            default :
                throw new Exception("Problem with printing invoice details");
        
        }
            
        
        panel.writeToTextArea("Amount Due: " + formatDouble(amountDue) + "\n");
        panel.writeToTextArea(paymentTypeOutput+"\n");
        panel.writeToTextArea("Amount Returned: " + formatDouble(amountReturned) +"\n");
        panel.writeToTextArea("Thank you for shopping " + currentSale.getCustomerName()+"!\n");
    }
    
    public double getTotal()
    {
        return panel.getTotal();
    }
    
    public void resetInvoice()
    {
        panel.resetInvoice();
    }        
    
    // helper method to format double
    double formatDouble(double value)
    {
        DecimalFormat df = new DecimalFormat("#.00");
        return Double.valueOf(df.format(value));
    }
}
