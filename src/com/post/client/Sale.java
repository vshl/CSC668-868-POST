package com.post.client;



import com.post.transport.rmi.ProductSpecification;
import com.post.transport.rmi.SaleLineItem;
import java.rmi.RemoteException;
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
    
    ArrayList<SaleLineItem> lineItems = new ArrayList<SaleLineItem>();
    
    

    public Sale()
    {
        //this.catalog = catalog;
        //TODO
        
    }
    
    public boolean addLineItem(ProductSpecification productSpecs, int quantity)
    {
        SaleLineItem lineItem = new SaleLineItemImpl(productSpecs, quantity);
        this.lineItems.add(lineItem);
        return true;
    }
    
    public boolean initiateSale(String custName, ArrayList<SaleLineItem> lineItems) throws RemoteException
    {
       this.custName = custName;
       this.lineItems = lineItems;
       this.date = new Date();
       for(SaleLineItem li : lineItems)
       {
           amountDue += li.getSubTotal();
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
    
    public String generateInvoice() throws RemoteException
    {
        String invoice = "Welcome To Cornnut Emporium!\n\n";
        invoice += String.format("Customer Name: %10s %5s %s\n", this.custName, ' ', this.date);
        for(SaleLineItem li : lineItems)
        {
            invoice += String.format("Item: %-20s %3d @ %8.2f subtotal:  %8.2f",li.getProduct(),
                                                                   li.getItemCount(),
                                                                   li.getProduct().getPrice(),
                                                                   li.getSubTotal())
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

    void makeCashPayment(double amount) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    void makeCheckPayment() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    void makeCreditCardPayment(int cardNumber) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

}
