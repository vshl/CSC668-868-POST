/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.post.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import com.post.interfaces.CatalogInterface;
/**
 *
 * @author ryaneshleman
 */
public interface StoreInterface extends java.rmi.Remote {

    public CatalogInterface getCatalog() throws java.rmi.RemoteException;
}
