/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.post.controllers;

import com.post.presentation.ProductPanel;
import javax.swing.JPanel;

/**
 *
 * @author ryaneshleman
 */
public class ProductController {
    FrameController mediator;
    ProductPanel panel;
    
    ProductController(FrameController med, ProductPanel productPanel) {
        this.mediator = med;
        this.panel = productPanel;
    }
    
}
