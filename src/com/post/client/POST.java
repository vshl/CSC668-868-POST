package com.post.client;

import com.post.server.Catalog;
import com.post.server.ProductSpecification;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.FileNotFoundException;

/**
 * This class holds the main function of the program.  Is the main interface
 * between the
 * @author ryaneshleman
 */
public class POST {

    private final static String PRODUCT_SPEC_FILE = "./products.txt";
    private final static String TRANSACTIONS_FILE = "./transactions.txt";
    private static       Catalog catalog;
    private boolean isReady = false;

    private Sale s = new Sale();
    private ArrayList<LineItem> lineItems = new ArrayList<LineItem>();
    private List<Sale> sales = new ArrayList<Sale>();

    /**
     * Main look of the POST
     * It reads and completes transactions from the TRANSACTIONS_FILE
     * It then prints the invoices to console
     * 
     * @param args the command line arguments
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        POST post = new POST();
        post.init();
    }

    /**
     * Retrieves invoice from Sale object
     * prints to stdout
     * @param s 
     */
    private static void printInvoice(Sale s) {
        System.out.println(s.generateInvoice());
    }

    /**
     * initializes the POST, builds catalog
     * @return 
     * @throws java.io.IOException
     */
    public boolean init() throws IOException, FileNotFoundException {
        catalog = new Catalog(PRODUCT_SPEC_FILE);
        isReady = true;
        return true;
        //throw new UnsupportedOperationException("Not yet implemented");
    }

    public boolean shutDown() {
        isReady = false;
        return isReady;
    }

    /**
     * initiates the sale
     * @param  custName  
     * @param  lineItems
     * @return
     */
    public Sale initiateSale(String custName)
    {
        s.initiateSale(custName);
        return s;
    }
    
    public boolean addLineItem(ProductSpecification productSpecs, int quantity)
    {
        LineItem li;
        li = s.addLineItem(productSpecs, quantity);
        this.lineItems.add(li);
        return true;
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
    public boolean recordSale(Sale s) {
        throw new UnsupportedOperationException("Not yet implemented");
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
    public Sale makePayment(Sale s, String paymentMethod, double amount, int cardNumber) throws Exception
    {
        if(paymentMethod.equals("CASH"))
            s.makeCashPayment(amount);
        else if(paymentMethod.equals("CHECK"))
            s.makeCheckPayment();
        else 
            s.makeCreditCardPayment(cardNumber);
        return s;
        
            
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
    
    public Catalog getCatalog() {
        return catalog;
    }

    private void addSale(Sale s) {
        this.sales.add(s);
    }
}
