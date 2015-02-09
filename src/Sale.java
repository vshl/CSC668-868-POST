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
public class Sale {
    private String custName;
    private double  amountDue = 0;
    private boolean isComplete = false;
    private int     numItems = 0;
    
    ArrayList<LineItem> lineItems = new ArrayList<LineItem>();
    

    public Sale()
    {
        //this.catalog = catalog;
        //TODO
    }        
    
    public boolean initiateSale(String custName, List<LineItem> lineItems)
    {
       this.custName = custName;
       for(LineItem li : lineItems)
       {
           amountDue += li.getQuantity() * li.getItemUnitCost();
       }
       return true;
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
