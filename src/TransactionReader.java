
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
    
    private ArrayList<Sale> transactions = new ArrayList<Sale>();
    private int currentIteratorIndex = 0;
    
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
        
        // main read loop, initializes Sales objects, makes makes payments, then
        // stores in transactions list
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
                items.add(li);
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
            
            if(!sc.hasNext())  //reached end of file
                break;
            
            sc.nextLine();
        }
    sc.close();    
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
    /**
     * takes a string as input and a reference to the catalog,
     * initializes and returns a LineItem from the information extracted
     * from the string;
     * @param nextLine
     * @param c
     * @return 
     */
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
