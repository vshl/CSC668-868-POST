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
        //TODO
    }
    
    public ProductSpecification addItem(int upc)
    {
        //TODO
    }
    
    public boolean makeCreditCardPayment(int cardNumber)
    {
        //TODO
    }
    
    public double makeCashPayment(double amount)
    {
        //TODO
    }
    
    public String generateReceipt()
    {
        //TODO
    }


}
