/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ryaneshleman
 */
public class LineItem {
    Item item;
    int quantity;
    
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
        return item.productSpecs.getPrice();
    }        
}
