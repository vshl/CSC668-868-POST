/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
/**
 *
 * @author ryaneshleman
 * @author ericchu
 */
class ProductReader {

	ArrayList<ProductSpecification> specification = new ArrayList<ProductSpecification>();
	
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
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
    
    ProductSpecification getNextProduct() {
        throw new UnsupportedOperationException("Not yet implemented");
        
        
    }
}
