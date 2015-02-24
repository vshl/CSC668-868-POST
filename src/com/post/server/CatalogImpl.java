/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.post.server;

import com.post.transport.rmi.Catalog;
import com.post.transport.rmi.ProductSpecification;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author kumari
 */
public class CatalogImpl implements Catalog, Serializable {
    
    private Map<String, ProductSpecification> catalogMap;
    
    /**
     * Whoever calls this method need to provide Map.
     * Here this is called by PostManagerImpl in getCatalog().
     * @param map 
     */
    public CatalogImpl(Map<String, ProductSpecification> map){
        catalogMap = map;
    }
   
    public ProductSpecification getProductByUpc(String upc) throws RemoteException {
        return catalogMap.get(upc);
    }

    @Override
    public List<ProductSpecification> getAllProducts() throws RemoteException {
        return new ArrayList<ProductSpecification>(catalogMap.values());
    }
    
}
