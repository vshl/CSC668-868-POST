/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    private List<Sale> sales = new ArrayList<Sale>();

    /**
     * Main look of the POST
     * It reads and completes transactions from the TRANSACTIONS_FILE
     * It then prints the invoices to console
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, Exception {

        POST post = new POST();
        post.init();

        TransactionReader tr = new TransactionReader(post.getCatalog(), TRANSACTIONS_FILE);

        Sale s;
        while (tr.hasNext()) {
            s = tr.getNextSale();
            printInvoice(s);
            post.addSale(s);

        }

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
     */
    public boolean init() throws IOException {
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
     * adds item to catalog
     *
     * @param itemDesc
     * @return
     */
    public ProductSpecification addToCatalog(ProductSpecification itemDesc) {
        return catalog.addItem(itemDesc);
    }

    /**
     * removes item from catalog
     *
     * @param upc
     * @return
     */
    public ProductSpecification removeFromCatalog(int upc) {
        throw new UnsupportedOperationException("Not yet implemented");
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

  
    
    public Sale initiateSale(String custName, ArrayList<LineItem> lineItems)
    {
        Sale s = new Sale();
        s.initiateSale(custName,lineItems);
        return s;
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
