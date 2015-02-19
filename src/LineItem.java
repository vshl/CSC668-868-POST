/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * holts an item and the quantity of that item to be sold
 * 
 * @author ryaneshleman
 */
public class LineItem {
    private final ProductSpecification productSpecs;
    private final int quantity;
    
    public LineItem(ProductSpecification productSpecs, int quantity)
    {
        this.productSpecs = productSpecs;
        this.quantity = quantity;
    }       
    
    public int getQuantity()
    {
        return quantity;
    }
    
    public double getItemUnitCost()
    {
        return this.productSpecs.getPrice();
    }
    
    public String getProductDescription()
    {
        return this.productSpecs.getDescription();
    }        
}
