/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.post.server;

import com.post.server.exception.LogException;
import com.post.transport.rmi.Payment;
import com.post.transport.rmi.PaymentType;
import com.post.transport.rmi.Sale;
import com.post.transport.rmi.SaleLineItem;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author kumari
 */
public class LogSaleImpl implements LogSale {

    private static final String LOG_FILE = "sales_log.txt";
    private BufferedWriter writer;

    public LogSaleImpl() throws LogException {
        this(LOG_FILE);
    }

    public LogSaleImpl(String logFile) throws LogException {
        try {
            writer = new BufferedWriter(new FileWriter(logFile, true));
        } catch (IOException ex) {
            throw new LogException(ex);
        }
    }

    @Override
    public void log(Sale sale) throws LogException {
        try {
           
            writer.write(getSaleString(sale));
            writer.flush();
        } catch (Exception ex) {
            throw new LogException(ex);
        }
    }

    /**
     * This is a helper method to convert the Sale object into string
     * representation.
     *
     * @param sale
     * @return
     * @throws RemoteException
     */
    private String getSaleString(Sale sale) throws RemoteException {
        StringBuilder sb = new StringBuilder();
        List<SaleLineItem> saleLineItems = sale.getSaleItems();

        sb.append(String.format("Identifying information: %s", sale.getCustomerName()));
        sb.append("\n");
        for (SaleLineItem s : saleLineItems) {
            sb.append(String.format("Item:  %s %d @ %f %f",
                    s.getProduct().getDescription(),
                    s.getItemCount(),
                    s.getProduct().getPrice(),
                    s.getSubTotal()));
            sb.append("\n");
        }
        sb.append("\n");
        sb.append(String.format("Total: %s", sale.getTotalAmount()));
        sb.append("\n");

        sb.append(String.format("Amount Tendered %s", sale.getPayment().getAmount()));

        if (PaymentType.CHECK.equals(sale.getPayment().getPaymentType())) {
            sb.append(" Paid by Check");
        } else if (PaymentType.CREDIT.equals(sale.getPayment().getPaymentType())) {
            sb.append(String.format("Credit Card # %s",
                    sale.getPayment().getCardNumber()));
        }
        sb.append("\n");
        return sb.toString();
    }
}
