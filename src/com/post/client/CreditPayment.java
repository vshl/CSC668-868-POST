
public class CreditPayment extends Payment {

    private String payType;
    private double  amountDue = 0;
    private double changeDue = 0;
    private double amountTendered = 0;
    private boolean isComplete = false;
    
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
    
}
