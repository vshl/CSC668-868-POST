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
    private Item item;
    private int quantity;
    
    public LineItem(Item item, int quantity)
    {
        this.item = item;
        this.quantity = quantity;
    }       
    
    public int getQuantity()
    {
        return quantity;
    }
    
    public double getItemUnitCost()
    {
        return item.getProductSpecs().getPrice();
    }
    
    public String getProductDescription()
    {
        return item.getProductSpecs().getDescription();
    }        
}
