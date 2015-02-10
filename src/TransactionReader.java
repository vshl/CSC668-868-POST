
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ryaneshleman
 */
public class TransactionReader {
    
    ArrayList<Sale> transactions = new ArrayList<Sale>();
    int currentIteratorIndex = 1;
    
    public TransactionReader(Catalog c, String TRANSACTION_FILE) throws FileNotFoundException, Exception
    {
        Scanner sc = new Scanner(new File(TRANSACTION_FILE));
        String custName;
        String nextLine;
        int upc,quantity;
        ArrayList<LineItem> items;
        Item item;
        Sale s;
        double tender;
        int creditCardNumber;
        
        while(sc.hasNext())
        {
            custName = sc.nextLine();
            items = new ArrayList<LineItem>();
            s = new Sale();
            
            nextLine = sc.nextLine();
            while(!nextLine.startsWith("<"))
            {
                upc = Integer.parseInt(nextLine.substring(0,4));
                item = new Item(c.getProduct(upc));
                
                //check if quantity is specificed
                if(nextLine.length() > 5)
                {
                    quantity = Integer.parseInt(nextLine.substring(9));
                }
                else
                    quantity = 1;
                    
                
                items.add(new LineItem(item, quantity));
            }
            
            s.initiateSale(custName, items);
            
            // determine whether processing credit card or cash/check
            if(nextLine.contains("<CASH/CHECK"))
            {
                tender = Double.parseDouble(nextLine.substring(13).replace(">",""));
                s.makeCashPayment(tender);
            }    
            else //process credit card
            {
                creditCardNumber = Integer.parseInt(nextLine.substring(8,13));
                s.makeCreditCardPayment(creditCardNumber);
            }
            transactions.add(s);
            sc.nextLine();
        
        }    
    }
    
    
    
    /**
     * returns true if there are more transactions to read
     * @return 
     */
    public boolean hasNext()
    {
        return currentIteratorIndex<transactions.size();
    }
    
    public Sale getNextSale()
    {
        Sale s = transactions.get(currentIteratorIndex);
        currentIteratorIndex++;
        return s;
        
    }        
}
