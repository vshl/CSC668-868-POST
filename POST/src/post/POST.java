/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package post;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ryaneshleman
 */
public class POST {
    private final String PRODUCT_SPEC_FILE = "./products.txt";
    private final String TRANSACTIONS_FILE = "./transactions.txt";
    private final String SALES_LOG_FILE = "./sales_log.txt";
    
    private Catalog    catalog;
    private List<Sale> sales = new ArrayList<Sale>();
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    /**
     * initializes the POST, builds 
     */
    public boolean init()
    {
        catalog = new Catalog(PRODUCT_SPEC_FILE);
    }
    
    
    public boolean shutDown()
    {
        //TODO
    }
    
    /**
     * adds item to catalog
     * @param itemDesc
     * @return 
     */
    public ProductSpecification addToCatalog(ProductSpecification itemDesc)
    {
        //TODO
    }
    
    /**
     * removes item from catalog
     * @param upc
     * @return 
     */
    public ProductSpecification removeFromCatalog(int upc)
    {
        //TODO
    }  
    
    /**
     * if the sale is completed ie s.isCompleted == true, the sale is written
     * in the sales log
     * @param s
     * @return 
     */
    public boolean recordSale(Sale s)
    {
        //TODO
    }
    
    /**
     * returns the contents of the sales log 
     * @return 
     */
    public String salesLog()
    {
        //TODO
    }        
    
}
