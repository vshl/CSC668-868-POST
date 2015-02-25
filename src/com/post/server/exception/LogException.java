/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.post.server.exception;

/**
 *
 * @author kumari
 */
public class LogException extends Exception {
    public LogException(String message){
        super(message);
    }
    
    public LogException(String message, Throwable cause){
        super(message, cause);
    }
    
    public LogException(Throwable cause){
        super(cause);
    }
}
