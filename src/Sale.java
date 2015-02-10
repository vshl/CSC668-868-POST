/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ryaneshleman
 */
public class Sale {
    private String custName;
    private double  amountDue = 0;
    private double totalCost = 0;
    private double changeDue = 0;
    private double amountTendered = 0;
    private boolean isComplete = false;
    private int     numItems = 0;
    private Date    date;
    
    ArrayList<LineItem> lineItems = new ArrayList<LineItem>();
    
    

    public Sale()
    {
        //this.catalog = catalog;
        //TODO
        
    }        
    
    public boolean initiateSale(String custName, List<LineItem> lineItems)
    {
       this.custName = custName;
       this.date = new Date();
       for(LineItem li : lineItems)
       {
           amountDue += li.getQuantity() * li.getItemUnitCost();
       }
       totalCost += amountDue;
       
       this.lineItems.addAll(lineItems);
       return true;
    }
    /**
     * Incomplete, will build out if required later.
     * @param upc
     * @return 
     */
    public ProductSpecification addItem(int upc)
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
    public boolean makeCreditCardPayment(int cardNumber)
    {
        if(Math.random() >=1)//denied
            return false;
        else
        {
            amountDue = 0;
            isComplete = true;
        }
        
        return isComplete;
    }
    
    /**
     * Completes cash payment, returns amount due
     * throws exception is not enough money
     * @param amountTendered
     * @return
     * @throws Exception 
     */
    public double makeCashPayment(double amountTendered) throws Exception
    {
        // ignoring corner case when amountTendered < amountDue
        if(amountTendered < amountDue)
            throw new Exception("You didn't pay enough, you cheapskate!");
        
        changeDue = amountTendered - amountDue;
        isComplete = true;
        return changeDue;
    }
    
    public String generateInvoice()
    {
        String invoice = "Cornnut Emporium!\n";
        invoice += String.format("Customer Name %20s", this.custName) + this.date + "\n";
        for(LineItem li : lineItems)
        {
            invoice += String.format("%25s %3d @ %4f subtotal: %f",li.getProductDescription(),
                                                                   li.getQuantity(),
                                                                   li.getItemUnitCost(),
                                                                   li.getItemUnitCost() * li.getQuantity())
                                                                   + "\n";
        }
        invoice += "-------";
        
        invoice += "\nTotal Amount:    " + this.totalCost;
        invoice += "\nAmount Tendered: " + this.amountTendered;
        invoice += "\nAmount Returned: " + this.changeDue;
        
        return invoice;
        
        
        
    }



}
