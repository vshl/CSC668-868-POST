public class CheckPayment extends Payment {

    private String payType;
    private double  amountDue = 0;
    private double amountTendered = 0;
    private boolean isComplete = false;
    
        public boolean makeCheckPayment()
    {
    	this.amountTendered = amountDue;
        isComplete = true;
    	payType = "CHECK";
    	return isComplete;
    }
        
}
