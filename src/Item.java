/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Class for an individual item being purchased
 * @author ryaneshleman
 */
public class Item {
    private ProductSpecification productSpecs;
    
    
    public Item(ProductSpecification productSpecs)
    {
        this.productSpecs = productSpecs;
    }

    /**
     * @return the productSpecs
     */
    public ProductSpecification getProductSpecs() {
        return productSpecs;
    }
    
    
    
}
