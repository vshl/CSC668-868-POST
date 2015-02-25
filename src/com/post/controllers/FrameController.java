/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.post.controllers;

import com.post.client.Post;
import com.post.client.SaleLineItemImpl;
import com.post.presentation.CustomerPanel;
import com.post.presentation.DatePanel;
import com.post.presentation.InvoicePanel;
import com.post.presentation.PaymentPanel;
import com.post.presentation.ProductPanel;
import com.post.transport.rmi.Payment;
import com.post.transport.rmi.PaymentType;
import com.post.transport.rmi.PostManager;
import com.post.transport.rmi.ProductSpecification;
import com.post.transport.rmi.SaleLineItem;
import static java.lang.Thread.sleep;
import java.rmi.RemoteException;
import javax.swing.JPanel;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author ryaneshleman
 */
public class FrameController {
        private PostManager store;
        private CustomerController customerController;
        private DateController dateController;
        private PaymentController paymentController;
        private ProductController productController;
        private InvoiceController invoiceController;
        private Post post;
    
    public FrameController(Post post) throws RemoteException
    {
        this.post = post;
        if(post != null)
            post.initiateSale();
    }
    
    public void registerCustomerController(CustomerPanel customerPanel) {
        customerController = new CustomerController(this,customerPanel);
        customerPanel.registerController(customerController);
    }

    public void registerInvoiceController(InvoicePanel invoicePanel) {
        invoiceController = new InvoiceController(this,invoicePanel);
        invoicePanel.registerController(invoiceController);
    }

    public void registerPaymentController(PaymentPanel paymentPanel) {
        paymentController = new PaymentController(this,paymentPanel);
        paymentPanel.registerController(paymentController);
    }
    
    public void registerDateController(DatePanel datePanel) {
        dateController = new DateController(this,datePanel);
        datePanel.registerController(dateController);
        dateController.refreshTime();
    }

    public void registerProductController(ProductPanel productPanel) throws RemoteException {
        productController = new ProductController(this,productPanel);
        productPanel.registerController(productController);
        productPanel.populateUpc(post.getCatalog().getAllProducts());
    }

    
    void addLineItem(String upc, Integer quantity) throws RemoteException {
        ProductSpecification ps = post.getCatalog().getProductByUpc(upc);
        SaleLineItem lineItem = new SaleLineItemImpl(ps,quantity);
        
        post.addLineItem(lineItem);
        invoiceController.addLineItem(lineItem);
    }

    void submitPayment(Payment payment) throws Exception {
        Timer timer = new Timer();
        
        
        String custName = customerController.getCustName();
        //post.getCurrentSale().setCustomerName(custName);
        post.makePayment(payment);
        invoiceController.printSaleDetails(post.getCurrentSale());
        
        
        timer.schedule(new Tasker(),3000);
        
    }
    
    double getTotal() {
		return invoiceController.getTotal();
	}
    
    class Tasker extends TimerTask {
    @Override
    public void run() {
        invoiceController.resetInvoice(); // For example take cards 
    }

    // More functions if they are needed
}
    
    
}
