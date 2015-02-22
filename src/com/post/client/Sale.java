package com.post.client;



import com.post.server.ProductSpecification;
import com.post.client.LineItem;
import com.post.interfaces.ProductSpecificationInterface;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ryaneshleman
 */
public class Sale {
    private String custName;
    private String payType;
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
    
    public boolean addLineItem(ProductSpecificationInterface productSpecs, int quantity)
    {
        LineItem lineItem = new LineItem(productSpecs, quantity);
        this.lineItems.add(lineItem);
        return true;
    }
    
    public boolean initiateSale(String custName, ArrayList<LineItem> lineItems)
    {
       this.custName = custName;
       this.lineItems = lineItems;
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
    
    public String generateInvoice()
    {
        String invoice = "Welcome To Cornnut Emporium!\n\n";
        invoice += String.format("Customer Name: %10s %5s %s\n", this.custName, ' ', this.date);
        for(LineItem li : lineItems)
        {
            invoice += String.format("Item: %-20s %3d @ %8.2f subtotal:  %8.2f",li.getProductDescription(),
                                                                   li.getQuantity(),
                                                                   li.getItemUnitCost(),
                                                                   li.getItemUnitCost() * li.getQuantity())
                                                                   + "\n";
        }
        invoice += "-------";
        
        invoice += "\nTotal Amount     :    $" + formatDouble(this.totalCost);
        invoice += "\nAmount Tendered  :    $" + formatDouble(this.amountTendered);
        invoice += "\nAmount Returned  :    $" + formatDouble(this.changeDue);
        invoice += "\nPayment Type     :    " + this.payType + "\n";
        invoice += "END TRANSACTION\n";
        
        return invoice;
        
        
        
    }

    /**
    * Helper method: formats doubles to 2 decimal places
    * @param double value
    * @return formatted double value
    */
    private double formatDouble(double value)
    {
        DecimalFormat df = new DecimalFormat("#.00");
        return Double.valueOf(df.format(value));
    }

}
