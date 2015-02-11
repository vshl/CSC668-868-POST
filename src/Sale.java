

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
        {
        	payType = "CREDIT DENIED";
            return false;
        }
        else
        {
            this.amountTendered = amountDue;
            amountDue = 0;
            isComplete = true;
            payType = "CREDIT";
        }
        
        
        
        return isComplete;
    }
    
    public boolean makeCheckPayment()
    {
    	this.amountTendered = amountDue;
        isComplete = true;
    	payType = "CHECK";
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
        this.amountTendered = amountTendered;
        // ignoring corner case when amountTendered < amountDue
        if(amountTendered < amountDue)
            throw new Exception("You didn't pay enough, you cheapskate!");
        
        changeDue = amountTendered - amountDue;
        isComplete = true;
        payType = "CASH";
        return changeDue;
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
    double formatDouble(double value)
    {
        DecimalFormat df = new DecimalFormat("#.00");
        return Double.valueOf(df.format(value));
    }

}
