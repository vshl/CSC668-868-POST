/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.post.controllers;

import com.post.presentation.InvoicePanel;
import javax.swing.JPanel;

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
    
}
