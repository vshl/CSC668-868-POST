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
    
    private static Catalog    catalog;
    private List<Sale> sales = new ArrayList<Sale>();
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, Exception {

        POST post = new POST();
        post.init();
        
        
        TransactionReader tr = new TransactionReader(post.getCatalog(),TRANSACTIONS_FILE);
        
        Sale s;
        while(tr.hasNext())
        {
            s = tr.getNextSale();
            System.out.println(s.generateInvoice());
        }    
        
    }
    
    /**
     * initializes the POST, builds 
     */
    public boolean init() throws IOException
    {
        catalog = new Catalog(PRODUCT_SPEC_FILE);
        return true;
        //throw new UnsupportedOperationException("Not yet implemented");
    }
    
    
    public boolean shutDown()
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
    /**
     * adds item to catalog
     * @param itemDesc
     * @return 
     */
    public ProductSpecification addToCatalog(ProductSpecification itemDesc)
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
    /**
     * removes item from catalog
     * @param upc
     * @return 
     */
    public ProductSpecification removeFromCatalog(int upc)
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }  
    
    /**
     * if the sale is completed ie s.isCompleted == true, the sale is written
     * in the sales log
     * @param s
     * @return 
     */
    public boolean recordSale(Sale s)
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
    /**
     * returns the contents of the sales log 
     * @return 
     */
    public String salesLog()
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
    public Catalog getCatalog()
    {
        return catalog;
    }        
    
}
