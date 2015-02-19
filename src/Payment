public class Payment {
    
    private double amountTendered = 0;
    private double amountDue = 0;
    private double changeDue = 0;
    private boolean isComplete = false;
    private String payType;
    private int cardNumber;
    
    public void makePayment()throws Exception{
        if(payType.equals("CASH")){
            makeCashPayment(amountTendered);
        }
        else if(payType.equals("CREDIT")){
            makeCreditCardPayment(cardNumber);
        }
        else if(payType.equals("CHECK")){
            makeCheckPayment();
        }
    }
    
        private double makeCashPayment(double amountTendered) throws Exception
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
        
            private boolean makeCreditCardPayment(int cardNumber)
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
    
    private boolean makeCheckPayment()
    {
    	this.amountTendered = amountDue;
        isComplete = true;
    	payType = "CHECK";
    	return isComplete;
    }
        
}
