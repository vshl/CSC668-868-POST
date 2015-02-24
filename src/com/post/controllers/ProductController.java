/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.post.controllers;

import com.post.presentation.ProductPanel;
import java.rmi.RemoteException;
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

    public void addLineItem(String upc, Integer quantity) throws RemoteException {
        mediator.addLineItem(upc,quantity);
    }
    
}
