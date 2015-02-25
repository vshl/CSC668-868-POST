/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.post.server;

import com.post.server.exception.LogException;
import com.post.transport.rmi.Sale;

/**
 *
 * @author kumari
 */
public interface LogSale {
    void log(Sale sale) throws LogException;
}
