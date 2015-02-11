
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
    int currentIteratorIndex = 0;
    
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
        LineItem li;
        
        while(sc.hasNext())
        {
            custName = sc.nextLine();
            items = new ArrayList<LineItem>();
            
            s = new Sale();

            nextLine = sc.nextLine();
            // Extact Line ITems
            while(!nextLine.startsWith("<"))
            {
                li = extractLineItem(nextLine,c);
                nextLine = sc.nextLine();
            }
            
            s.initiateSale(custName, items);
            
            // determine whether processing credit card or cash/check
            if(nextLine.contains("CASH"))
            {
                tender = Double.parseDouble(nextLine.substring(7).replace(">",""));
                s.makeCashPayment(tender);
            }
            else if(nextLine.contains("CHECK"))
            {
                 s.makeCheckPayment();
            }        
            else //process credit card
            {
                creditCardNumber = Integer.parseInt(nextLine.substring(8,13));
                s.makeCreditCardPayment(creditCardNumber);
            }
            transactions.add(s);
            //System.out.println(s.generateInvoice());
            
            if(!sc.hasNext())
                break;
            
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

    private LineItem extractLineItem(String nextLine, Catalog c) {
            
        int upc, quantity;
        Item item;
        upc = Integer.parseInt(nextLine.substring(0,4));
        item = new Item(c.getProduct(upc));
                
        //check if quantity is specificed
        if(nextLine.length() > 5)
        {
              quantity = Integer.parseInt(nextLine.substring(9));
        }
        else
            quantity = 1;
                    
                
        return new LineItem(item, quantity);
    }
}
