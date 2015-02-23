/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.post.registry;

import com.post.server.PostManagerImpl;
import com.post.server.ProductReaderImpl;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author kumari
 */

public class ServerReg  {
    
    private final static String PRODUCT_SPEC_FILE = "./products.txt";
    
    public static void main(String args[]){
        String productFileName = PRODUCT_SPEC_FILE;
        
        if (args.length > 0){
            productFileName = args[0];
        } else {
            System.out.println("Filename is not provided. Using default one: " + PRODUCT_SPEC_FILE);
        }
    
        if(System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            PostManagerImpl postManager = new PostManagerImpl();
            //populates product catalog
            postManager.populateStore(new ProductReaderImpl(productFileName));
            
            Registry registry = LocateRegistry.getRegistry();
            // "postManagerServer" is the key used by client to fetch postManager
            registry.rebind("postManagerServer",postManager);
            System.out.println("StoreImp object bound to 'store' name in registry");
            
        } catch(RemoteException e) {
            System.out.println("Couldnt bind PostManagerImpl: " + e);
            e.printStackTrace();
        } catch (IOException ex) {
            System.err.println("couldn't read file : " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}

