/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.post.server;

import com.post.server.store.ProductStore;
import com.post.server.store.ProductStoreHashImpl;
import com.post.transport.rmi.Catalog;
import com.post.transport.rmi.Invoice;
import com.post.transport.rmi.Payment;
import com.post.transport.rmi.PostManager;
import com.post.transport.rmi.ProductSpecification;
import com.post.transport.rmi.Sale;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 *
 * @author kumari
 */
public class PostManagerImpl implements PostManager {
    // this productStore stores product of model class
    private ProductStore productStore;
    

    public PostManagerImpl() {
        productStore = new ProductStoreHashImpl();
    }
    /**
     * This method should be called just after constructor to populate the catalog
     * @param productReader 
     */
    public void populateStore(ProductReader productReader){
        while (productReader.hasNext()){
            productStore.addProduct(productReader.getNext());
        }
    }
    
    @Override
    public Catalog getCatalog() throws RemoteException {
        Map<String, ProductSpecification> hmap = new HashMap<String, ProductSpecification>();
        /*
         productStore returns model objects. But transport objects are needed 
         for generating catalog. So converting each of them to transport objects.
         Then storing them in hashmap with upc as key.
        */
         List<com.post.server.model.Product> prodList = productStore.getAllProduct();
         for(com.post.server.model.Product prod : prodList){
             ProductSpecification prodspec = prod.convertToTransport();
             hmap.put(prodspec.getUpc(), prodspec);
         }
         
         Catalog catalog = new CatalogImpl(hmap);
         return catalog;
        
    }

    @Override
    public boolean isAuthorized(Payment payment) throws RemoteException {
        if(Math.random() > 0.1) {
        //Authorize the request
            return true;
        } else {
           return false;
        }
    }

    @Override
    public Invoice saveSale(Sale sale) throws RemoteException {
        // generates random alpha numeric string for invoice id
        String uuid = UUID.randomUUID().toString();
        Invoice in = new InvoiceImpl(uuid , sale);
        return in;
        
    }
}
