/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.post.controllers;

import com.post.presentation.CustomerPanel;
import javax.swing.JPanel;

/**
 *
 * @author ryaneshleman
 */
public class CustomerController {
    CustomerPanel panel;
    FrameController mediator;
    
    CustomerController(FrameController med,CustomerPanel customerPanel) {
        this.mediator = med;
        this.panel = customerPanel;
    }
    
}
