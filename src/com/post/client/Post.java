package com.post.client;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import com.post.transport.rmi.Catalog;
import com.post.transport.rmi.PostManager;
import com.post.transport.rmi.ProductSpecification;
import com.post.transport.rmi.SaleLineItem;
import com.post.transport.rmi.Payment;
import com.post.transport.rmi.Sale;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class holds the main function of the program.  Is the main interface
 * between the
 * @author ryaneshleman
 */
public class Post {

    private final static String PRODUCT_SPEC_FILE = "./products.txt";
    private final static String TRANSACTIONS_FILE = "./transactions.txt";
    private        Catalog catalog;
    private SaleImpl currentSale;

    /**
     * @return the catalog
     */
    public  Catalog getCatalog() {
        return catalog;
    }
    private boolean isReady = false;
    private PostManager store;

    private List<Sale> sales = new ArrayList<Sale>();

    /**
     * Main look of the Post
     * It reads and completes transactions from the TRANSACTIONS_FILE
     * It then prints the invoices to console
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, Exception {

        //Post post = new Post();
        //post.init();
/*
        TransactionReader tr = new TransactionReader(post.getCatalog(), TRANSACTIONS_FILE);

        Sale s;
        while (tr.hasNext()) {
            s = tr.getNextSale();
            printInvoice(s);
            post.addSale(s);

        }
       */
    }
    /**
     * Retrieves invoice from Sale object
     * prints to stdout
     * @param s 
     */
    /*
    private static void printInvoice(Sale s) throws RemoteException {
        System.out.println(s.generateInvoice());
    }
    */
    
    /**
     * The Post constructor is passed a reference to the remote Store object from
     * which it will request the catalog
     * @param store 
     */
    public Post(PostManager store) throws RemoteException
    {
        this.store = store;
        this.catalog = store.getCatalog();
    }        
    /**
     * initializes the Post, builds catalog
     * @return 
     * @throws java.io.IOException
     */
    
    /*  Moved this functionality into the constructor  
    public boolean init() throws IOException {
        
        catalog = new Catalog(PRODUCT_SPEC_FILE);
        isReady = true;
        return true;
        //throw new UnsupportedOperationException("Not yet implemented");
    }
    */
    
    
    public boolean shutDown() {
        isReady = false;
        return isReady;
    }

    /**
     *  *** FUTURE FEATURE****
     * 
     * if the sale is completed s.isCompleted == true, the sale is written in
     * the sales log
     *
     * @param s
     * @return
     */
    public void recordCurrentSale() throws RemoteException {
        this.store.saveSale(currentSale);
    }

    public boolean addLineItem(SaleLineItem lineItem)throws RemoteException
    {
        currentSale.addLineItem(lineItem);
        return true;    
    }
    
    public void initiateSale() throws RemoteException
    {
        SaleImpl s = new SaleImpl();
        //s.initiateSale(custName);
        this.currentSale = s;
    }
    
    /**
     * Passes payment information to the Sale object according to the payment type
     * @param s
     * @param paymentMethod
     * @param amount
     * @param cardNumber
     * @return
     * @throws Exception 
     */
    public void makePayment(Payment payment) throws Exception
    {
        this.currentSale.makePayment(payment);
        this.store.saveSale(currentSale);
            
    }        
    
    /**
     *   FUTURE FEATURE
     * 
     * retreive the sales log from file, print to screen
     * @return 
     */
    public String salesLog() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
    //public Catalog getCatalog() {
    //    return catalog;
    //}

    private void addSale(Sale s) {
        this.sales.add(s);
    }

    /**
     * @return the currentSale
     */
    public Sale getCurrentSale() {
        return currentSale;
    }
    
            
}
