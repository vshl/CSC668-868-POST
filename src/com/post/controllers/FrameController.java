/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.post.controllers;

import com.post.client.Post;
import com.post.interfaces.StoreInterface;
import com.post.presentation.CustomerPanel;
import com.post.presentation.InvoicePanel;
import com.post.presentation.PaymentPanel;
import com.post.presentation.ProductPanel;
import javax.swing.JPanel;

/**
 *
 * @author ryaneshleman
 */
public class FrameController {
        private StoreInterface store;
        private CustomerController customerController;
        private DateController dateController;
        private PaymentController paymentController;
        private ProductController productController;
        private InvoiceController invoiceController;
        private Post post;
    
    public FrameController(Post post)
    {
        this.post = post;
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

    public void registerProductController(ProductPanel productPanel) {
        productController = new ProductController(this,productPanel);
        productPanel.registerController(productController);
    }
    
    
    
}
