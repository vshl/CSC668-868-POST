/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.post.controllers;

import com.post.presentation.PaymentPanel;
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
    }
    
}
