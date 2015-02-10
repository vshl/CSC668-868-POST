/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.util.HashMap;

/**
 *
 * @author ryaneshleman
 */
public class Catalog {
    private HashMap<Integer,ProductSpecification> products = new HashMap<Integer,ProductSpecification>();
    
    /**
     * constructor builds local hashmap from PRODUCT_SPEC_FILE
     * @param PRODUCT_SPEC_FILE 
     * @throws IOException 
     */
    public Catalog(String PRODUCT_SPEC_FILE) throws IOException
    {
        ProductReader pr = new ProductReader(PRODUCT_SPEC_FILE);
        
        ProductSpecification tmp;
        while(pr.hasNext())
        {
            tmp = pr.getNextProduct();
            
            this.products.put(tmp.getUpc(),tmp);
        }    
        
    }
    
    
    public ProductSpecification getProduct(int upc)
    {
        return products.get(upc);
    }
    
    
    
    public ProductSpecification addItem(ProductSpecification p)
    {
        return products.put(p.getUpc(),p);
    }
    
    
    
    public ProductSpecification removeItem(int upc)
    {
        return products.remove(products.get(upc));
    }
}
