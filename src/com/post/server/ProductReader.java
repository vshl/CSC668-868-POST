/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.post.server;

import com.post.server.model.Product;

/**
 *
 * @author kumari
 */
public interface ProductReader {
    boolean hasNext();
    Product getNext();
}
