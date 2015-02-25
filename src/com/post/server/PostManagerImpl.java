/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.post.server;

import com.post.client.CheckPayment;
import com.post.client.SaleImpl;
import com.post.client.SaleLineItemImpl;
import com.post.server.exception.LogException;
import com.post.server.store.ProductStore;
import com.post.server.store.ProductStoreHashImpl;
import com.post.transport.rmi.Catalog;
import com.post.transport.rmi.Invoice;
import com.post.transport.rmi.Payment;
import com.post.transport.rmi.PaymentType;
import com.post.transport.rmi.PostManager;
import com.post.transport.rmi.ProductSpecification;
import com.post.transport.rmi.Sale;
import com.post.transport.rmi.SaleLineItem;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 *
 * @author kumari
 */
public class PostManagerImpl extends UnicastRemoteObject implements PostManager {

    // this productStore stores product of model class
    private final ProductStore productStore;
    private LogSale logSale;

    public PostManagerImpl() throws RemoteException {
        productStore = new ProductStoreHashImpl();
        try {
        logSale = new LogSaleImpl();
        } catch(Exception ex){
            throw new RemoteException(ex.getMessage());
        }
    }

    /**
     * This method should be called just after constructor to populate the
     * catalog
     *
     * @param productReader
     */
    public void populateStore(ProductReader productReader) {
        while (productReader.hasNext()) {
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
        for (com.post.server.model.Product prod : prodList) {
            ProductSpecification prodspec = prod.convertToTransport();
            hmap.put(prodspec.getUpc(), prodspec);
        }

        Catalog catalog = new CatalogImpl(hmap);
        return catalog;

    }

    @Override
    public boolean isAuthorized(Payment payment) throws RemoteException {

        if (payment.getPaymentType().equals(PaymentType.CREDIT)
                && Math.random() <= 0.1) {
            // Decline the payment request if the payment type is credit card
            // and it falls in 10% bucket.
            return false;
        }
        return true;
    }

    @Override
    public Invoice saveSale(Sale sale) throws RemoteException {
        Invoice in = null;
        try {
            // generates random alpha numeric string for invoice id
            String uuid = UUID.randomUUID().toString();
            in = new InvoiceImpl(uuid, sale);

            logSale.log(sale);

        } catch (LogException ex) {
            System.err.println(ex.getMessage());
            System.err.print(ex);
        } catch (Exception ex) {
            throw new RemoteException(ex.getMessage());
        }
        return in;
    }
    
//    public static void main(String args[]) throws RemoteException  {
//        PostManager postManager = new PostManagerImpl();
//        Payment payment = new CheckPayment(100.0);
//        ProductSpecification ps1 = new ProductSpecificationImpl("SWEE", 23.5, "Sweet candie");
//        ProductSpecification ps2 = new ProductSpecificationImpl("VEGI", 33.5, "Green Vegie");
//        SaleLineItem item1 = new SaleLineItemImpl(ps1, 1);
//        SaleLineItem item2 = new SaleLineItemImpl(ps2, 4);
//        
//        List<SaleLineItem> saleLineItems = new ArrayList<SaleLineItem>();
//        saleLineItems.add(item1);
//        saleLineItems.add(item2);
//        
//        Sale sale = new SaleImpl("Kumari Sweta", saleLineItems,payment);
//        
//        System.out.println(postManager.saveSale(sale));
//        
//    }
}
