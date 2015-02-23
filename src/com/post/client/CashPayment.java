/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor
 */

public class CashPayment extends Payment{

    private String payType;
    private double  amountDue = 0;
    private double changeDue = 0;
    private double amountTendered = 0;
    private boolean isComplete = false;
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
    
}