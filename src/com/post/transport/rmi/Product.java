/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.post.transport.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author kumari
 */
public interface Product extends Remote {

    String getUpc() throws RemoteException;
    double getPrice() throws RemoteException;
    String Description() throws RemoteException;

}
