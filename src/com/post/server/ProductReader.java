/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.post.server;

import com.post.server.model.Product;

/**
 * This is responsible for reading the product specification from datasource.
 * Datasource can be a plain text file, or database etc.
 * @author kumari
 */
public interface ProductReader {
    boolean hasNext();
    Product getNext();
}
