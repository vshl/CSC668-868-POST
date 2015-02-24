/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.post.controllers;

import com.post.presentation.DatePanel;
import java.util.Date;

/**
 *
 * @author ryaneshleman
 */
public class DateController {
    DatePanel panel;
    FrameController mediator;
    
    DateController(FrameController med,DatePanel customerPanel) {
        this.mediator = med;
        this.panel = customerPanel;
    }
    
    public void refreshTime()
    {
        Date date = new Date();
        panel.setTime(date.toString());
    }        
}
