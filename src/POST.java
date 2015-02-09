/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

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
        System.out.println("Hello POST!");
        System.out.println("Hello POST!");
    }
    
    /**
     * initializes the POST, builds 
     */
    public boolean init()
    {
        catalog = new Catalog(PRODUCT_SPEC_FILE);
        throw new UnsupportedOperationException("Not yet implemented");
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
    
}
