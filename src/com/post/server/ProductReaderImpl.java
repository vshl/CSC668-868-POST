package com.post.server;

/*
 * ProductReader class builds a list of product specifications to be cataloged. It
 * takes in the UPC number, item description, and price of item from products.txt.
 */
import com.post.server.model.Product;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * @author Eric Chu
 */
public class ProductReaderImpl implements ProductReader {
    // this product belongs to model class
    private List<Product> products;
    private int currentIteratorIndex;

    /**
     * Default constructor for the ProductReader class. It takes in a text file
     * from the POST class and reads it. It then extracts all the data from the
     * text file and assigns specific parts to its respective variables such as
     * UPC, description and price.
     *
     * @param productsFile
     * @throws IOException
     */
    public ProductReaderImpl(String productsFile) throws IOException {

        products = new ArrayList<Product>();
        currentIteratorIndex = 0;

        Product product;
        String upc;
        String desc;
        double amount;

        BufferedReader br = null;
        //TODO: implementation should never be in constructor. While loop logic  
        //should be in getNextProduct().
        try {
            //reads in the products.txt from POST class
            String line;
            br = new BufferedReader(new FileReader(productsFile));

            //goes line by line to extract the data
            while ((line = br.readLine()) != null) {
                //3 columns in each line represents the UPC, description, and price per item
                upc = line.substring(0, 4);
                desc = line.substring(9, 28);
                amount = Double.parseDouble(line.substring(34));

                products.add(new Product(upc, amount, desc));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            //closing out the file
            try {
                br.close();
            } catch (Exception e) {
            }
        }
    }

    /**
     * Returns true or false depending on whether or not there are anymore
     * products to be read.
     *
     * @return boolean
     */
    @Override
    public boolean hasNext() {

        return currentIteratorIndex < products.size();
    }

    /**
     * Returns the next product in the list of products.
     *
     * @return
     */
    @Override
    public Product getNext() {

        Product ps = products.get(currentIteratorIndex);
        currentIteratorIndex++;
        return ps;

    }
}