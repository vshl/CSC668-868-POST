/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ryaneshleman
 */
public class POST {

    private final static String PRODUCT_SPEC_FILE = "./products.txt";
    private final static String TRANSACTIONS_FILE = "./transactions.txt";
    private final static String SALES_LOG_FILE = "./sales_log.txt";
    private static Catalog catalog;

    
    private List<Sale> sales = new ArrayList<Sale>();

    /**
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

        }

    }
    
    private static void printInvoice(Sale s) {
        System.out.println(s.generateInvoice());
    }

    /**
     * initializes the POST, builds
     */
    public boolean init() throws IOException {
        catalog = new Catalog(PRODUCT_SPEC_FILE);
        return true;
        //throw new UnsupportedOperationException("Not yet implemented");
    }

    public boolean shutDown() {
        throw new UnsupportedOperationException("Not yet implemented");
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
     * if the sale is completed ie s.isCompleted == true, the sale is written in
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
    
    public String salesLog() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public Catalog getCatalog() {
        return catalog;
    }
}
