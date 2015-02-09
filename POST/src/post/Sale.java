/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package post;

import java.util.List;

/**
 *
 * @author ryaneshleman
 */
public class Sale {
    private double  amountDue = 0;
    private boolean isComplete = false;
    private int     numItems = 0;
    
    private Catalog catalog;
    
    
    public Sale(Catalog catalog)
    {
        this.catalog = catalog;
        //TODO
    }        
    
    public boolean initiateSale(String custName, List<Integer> upcList)
    {
       throw new UnsupportedOperationException("Not yet implemented");
    }
    
    public ProductSpecification addItem(int upc)
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
    public boolean makeCreditCardPayment(int cardNumber)
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
    public double makeCashPayment(double amount)
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
    public String generateReceipt()
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }


}
