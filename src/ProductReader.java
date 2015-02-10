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
 * @author eric chu
 */
class ProductReader {

	ArrayList<ProductSpecification> specification = new ArrayList<ProductSpecification>();
	int currentIteratorIndex = 0;
	
    ProductReader(String PRODUCT_SPEC_FILE) throws IOException {
        //throw new UnsupportedOperationException("Not yet implemented");
    
    	ProductSpecification tempSpecification;
    	int tempUPC;
    	String tempText;
    	double tempAmount;
    	
    	BufferedReader br = null;
    	
    	try 
    	{
    		
    		String line;
			br = new BufferedReader(new FileReader(PRODUCT_SPEC_FILE));
			
			while((line = br.readLine()) != null)
			{
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
			try
			{
				br.close();
			}
			catch (Exception e)
			{
			}
		}
    }

    boolean hasNext() {
        
    	return currentIteratorIndex<specification.size();
    }
    
    
    ProductSpecification getNextProduct() {
        
        ProductSpecification ps = specification.get(currentIteratorIndex);
        currentIteratorIndex++;
        return ps;
        
    }
}
