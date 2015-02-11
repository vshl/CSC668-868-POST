/*
 * ProductReader class builds a list of product specifications to be cataloged. It
 * takes in the UPC number, item description, and price of item from products.txt.
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * @author Eric Chu
 */

class ProductReader {

	private ArrayList<ProductSpecification> specification = new ArrayList<ProductSpecification>();
	private int currentIteratorIndex = 0;
	
	/**
	 * Default constructor for the ProductReader class. It takes in a text file from the POST
	 * class and reads it. It then extracts all the data from the text file and assigns 
	 * specific parts to its respective variables such as UPC, description and price.
	 * 
	 * @param PRODUCT_SPEC_FILE
	 * @throws IOException
	 */
    ProductReader(String PRODUCT_SPEC_FILE) throws IOException {
    
    	ProductSpecification tempSpecification;
    	int tempUPC;
    	String tempText;
    	double tempAmount;
    	
    	BufferedReader br = null;
    	
    	try 
    	{
    		//reads in the products.txt from POST class
    		String line;
			br = new BufferedReader(new FileReader(PRODUCT_SPEC_FILE));
			
			//goes line by line to extract the data
			while((line = br.readLine()) != null)
			{
				//3 columns in each line represents the UPC, description, and price per item
				tempUPC = Integer.parseInt(line.substring(0,4));
				tempText = line.substring(9,28);
				tempAmount = Double.parseDouble(line.substring(34));
			
				tempSpecification = new ProductSpecification(tempUPC, tempText, tempAmount);
				specification.add(tempSpecification);
			}
		}
    	catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		finally
		{
			//closing out the file
			try
			{
				br.close();
			}
			catch (Exception e)
			{
			}
		}
    }

    /**
     * Returns true or false depending on whether or not there are anymore products
     * to be read.
     * @return boolean
     */
    boolean hasNext() {
        
    	return currentIteratorIndex<specification.size();
    }
    
    
    /**
     * Returns the next product in the list of products.
     * @return
     */
    ProductSpecification getNextProduct() {
        
        ProductSpecification ps = specification.get(currentIteratorIndex);
        currentIteratorIndex++;
        return ps;
        
    }
}
