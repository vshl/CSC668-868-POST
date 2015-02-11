/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *  Holds information about the given product.
 * @author ryaneshleman
 */
public class ProductSpecification {
    private int upc;
    private String description;
    private double price;

    /**
     * Constructor initializes all values
     * @param upc
     * @param description
     * @param price 
     */
    public ProductSpecification(int upc, String description, double price)
    {
        this.upc = upc;
        this.description = description;
        this.price = price;
    }
    
    /**
     * @return the upc
     */
    public int getUpc() {
        return upc;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }
    
    
}
